import React from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import CustomNavbar from "../components/CustomNavbar/CustomNavbar";
import SearchBar from "../components/SearchBar/SearchBar";
import UserInfo from "../components/UserInfo/UserInfo";
import CommentForm from "../components/CommentForm/CommentForm";
import CommentList from "../components/CommentList/CommentList";
import ListingsGrid from "../components/Listing/ListingsGrid";
import { Container, Row, Col } from "react-bootstrap";

const ProfilePage = () => {
    return (
        <>
            <CustomNavbar />
            <Container className="mt-3">
                <SearchBar />
                <Row>
                    <Col md={8}>
                        <ListingsGrid />
                        <CommentForm />
                        <CommentList />
                    </Col>
                    <Col md={4}>
                        <UserInfo />
                    </Col>
                </Row>
            </Container>
        </>
    );
};

export default ProfilePage;