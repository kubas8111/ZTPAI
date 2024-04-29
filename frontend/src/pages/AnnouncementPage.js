import React from "react";
import CustomNavbar from "../components/CustomNavbar/CustomNavbar";
import SearchBar from "../components/SearchBar/SearchBar";
import Footer from "../components/Footer/Footer";
import { Container, Row, Col } from "react-bootstrap";
import AnnouncementDetails from "../components/AnnouncementDetails/AnnouncementDetails";
import UserInfo from "../components/UserInfo/UserInfo";

const AnnouncementPage = () => {
    return (
        <>
            <CustomNavbar />
            <Container className="mt-3">
                <SearchBar />
                <Row>
                    <Col md={8}>
                        <AnnouncementDetails />
                    </Col>
                    <Col md={4}>
                        <UserInfo />
                    </Col>
                </Row>
            </Container>
            <Footer />
        </>
    );
};

export default AnnouncementPage;