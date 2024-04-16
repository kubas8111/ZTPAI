import {Container, Nav, Navbar} from "react-bootstrap";
import React from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import "./CustomNavbarStyles.css";

const CustomNavbar = () => {
    return (
        <Navbar collapseOnSelect expand="lg" className="custom-navbar">
            <Container fluid>
                <Navbar.Brand onClick={() => {window.location.href = "/home"}}>LOGO</Navbar.Brand>
                <Navbar.Toggle aria-controls="responsive-navbar-nav" />
                <Navbar.Collapse id="responsive-navbar-nav">
                    <Nav className="w-100">
                        <Nav.Link onClick={() => {window.location.href = "/addAnnouncement"}} className="ml-auto">DODAJ OGŁOSZENIE</Nav.Link>
                        <Nav.Link onClick={() => {window.location.href = "/login"}}>LOGOWANIE/REJESTRACJA</Nav.Link>
                    </Nav>
                </Navbar.Collapse>
            </Container>
        </Navbar>
    );
};

export default CustomNavbar;