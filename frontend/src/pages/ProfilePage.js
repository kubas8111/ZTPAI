import React, { useEffect, useState } from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import CustomNavbar from "../components/CustomNavbar/CustomNavbar";
import SearchBar from "../components/SearchBar/SearchBar";
import ProfileInfo from "../components/UserInfo/ProfileInfo";
import CommentForm from "../components/CommentForm/CommentForm";
import CommentList from "../components/CommentList/CommentList";
import ListingsGrid from "../components/Listing/ListingsGrid";
import { Container, Row, Col } from "react-bootstrap";
import { useParams } from "react-router-dom";
import { api } from "../api/axios";

const ProfilePage = () => {
    const { id } = useParams();
    const [user, setUser] = useState(null);
    const [announcements, setAnnouncements] = useState([]);
    const [comments, setComments] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        const fetchUserData = async () => {
            try {
                const [userResponse, announcementsResponse, commentsResponse] = await Promise.all([
                    api.get(`/profiles/${id}`),
                    api.get(`/full-announcements/user/${id}`),
                    api.get(`/comments/user/${id}`)
                ]);
                setUser(userResponse.data);
                setAnnouncements(announcementsResponse.data);
                setComments(commentsResponse.data);
            } catch (error) {
                setError(error.message);
            } finally {
                setLoading(false);
            }
        };

        fetchUserData();
    }, [id]);

    return (
        <>
            <CustomNavbar />
            <Container className="mt-3">
                <SearchBar />
                {loading && <p>Loading...</p>}
                {error && <p>Error: {error}</p>}
                {!loading && !error && (
                    <Row>
                        <Col md={8}>
                            <h3>Ogłoszenia użytkownika</h3>
                            <ListingsGrid listings={announcements} />
                            <CommentForm userId={id} />
                            <CommentList comments={comments} />
                        </Col>
                        <Col md={4}>
                            {user && <ProfileInfo user={user} />}
                        </Col>
                    </Row>
                )}
            </Container>
        </>
    );
};

export default ProfilePage;
