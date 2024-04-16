import {Col, Container, Row} from "react-bootstrap";
import React from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import "./CategorySectionStyles.css";

const CategorySection = () => {
    return (
        <Container className="category-section">
            <Row>
                {[...Array(8)].map((_, index) => (
                    <Col key={index} xs={12} sm={6} md={3} className="mb-4">
                        <div className="category-box">KATEGORIA</div>
                    </Col>
                ))}
            </Row>
        </Container>
    );
};

export default CategorySection;