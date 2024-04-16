import React from "react";
import { Col, Row } from "react-bootstrap";
import "bootstrap/dist/css/bootstrap.min.css";
import "./FooterStyles.css";

const Footer = () => {
    return (
        <Row className="fixed-bottom">
            <Col>
                <div className="footer">
                    Mleb
                </div>
            </Col>
        </Row>
    );
};

export default Footer;