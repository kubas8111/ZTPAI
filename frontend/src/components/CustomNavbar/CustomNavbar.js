import { Container, Nav, Navbar } from "react-bootstrap";
import React from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import "./CustomNavbarStyles.css";

const handleLogout = () => {
    localStorage.removeItem("accessToken");
    localStorage.removeItem("refreshToken");
    window.location.href = "/home";
};

const CustomNavbar = () => {
    const isLoggedIn = !!localStorage.getItem("accessToken");

    const parseJwt = (token) => {
        try {
            return JSON.parse(atob(token.split(".")[1]));
        } catch (error) {
            return null;
        }
    };

    const getUserRole = () => {
        const accessToken = localStorage.getItem("accessToken");
        if (accessToken) {
            const decodedToken = parseJwt(accessToken);
            return decodedToken.role;
        }
        return null;
    };

    const getUserId = () => {
        const accessToken = localStorage.getItem("accessToken");
        if (accessToken) {
            const decodedToken = parseJwt(accessToken);
            return decodedToken.id;
        }
        return null;
    };

    const isAdmin = getUserRole() === "admin";

    return (
        <Navbar collapseOnSelect expand="lg" className="custom-navbar">
            <Container fluid>
                <Navbar.Brand onClick={() => { window.location.href = "/home" }}>LOGO</Navbar.Brand>
                <Navbar.Toggle aria-controls="responsive-navbar-nav" />
                <Navbar.Collapse id="responsive-navbar-nav">
                    <Nav className="w-100">
                        {isLoggedIn ? (
                            <>
                                {isAdmin ? (
                                    <Nav.Link onClick={() => { window.location.href = "/moderate" }} className="ml-auto">Moderuj ogłoszenia</Nav.Link>
                                ) : (
                                    <Nav.Link onClick={() => { window.location.href = "/addAnnouncement" }} className="ml-auto">Dodaj ogłoszenie</Nav.Link>
                                )}
                                <div className="ml-auto">
                                    <Nav.Link onClick={() => { window.location.href = `/profile/${getUserId()}` }}>KONTO</Nav.Link>
                                    <Nav.Link onClick={handleLogout}>Wyloguj</Nav.Link>
                                </div>
                            </>
                        ) : (
                            <>
                                <Nav.Link onClick={() => { window.location.href = "/login" }} className="ml-auto">DODAJ OGŁOSZENIE</Nav.Link>
                                <div className="ml-auto">
                                    <Nav.Link onClick={() => { window.location.href = "/login" }}>LOGOWANIE/REJESTRACJA</Nav.Link>
                                </div>
                            </>
                        )}
                    </Nav>
                </Navbar.Collapse>
            </Container>
        </Navbar>
    );
};

export default CustomNavbar;
