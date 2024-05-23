import React, { useEffect, useState } from "react";
import CustomNavbar from "../components/CustomNavbar/CustomNavbar";
import SearchBar from "../components/SearchBar/SearchBar";
import Footer from "../components/Footer/Footer";
import { Container, Row, Col } from "react-bootstrap";
import AnnouncementDetails from "../components/AnnouncementDetails/AnnouncementDetails";
import UserInfo from "../components/UserInfo/UserInfo";
import { useParams } from "react-router-dom";
import { api } from "../api/axios";

const AnnouncementPage = () => {
    const { id } = useParams();
    const [announcement, setAnnouncement] = useState(null);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        const fetchAnnouncement = async () => {
            try {
                const response = await api.get(`full-announcements/${id}`);
                setAnnouncement(response.data);
            } catch (error) {
                setError(error.message);
            } finally {
                setLoading(false);
            }
        };

        console.log(id);

        fetchAnnouncement();
    }, [id]);

    return (
        <>
            <CustomNavbar />
            <Container className="mt-3">
                <SearchBar />
                {loading && <p>Loading...</p>}
                {error && <p>Error: {error}</p>}
                {announcement && (
                    <Row>
                        <Col md={8}>
                            <AnnouncementDetails announcement={announcement} />
                        </Col>
                        <Col md={4}>
                            <UserInfo announcement={announcement} />
                        </Col>
                    </Row>
                )}
            </Container>
            <Footer />
        </>
    );
};

export default AnnouncementPage;