import {Col, Row} from "react-bootstrap";
import React from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import "./ListingStyles.css";

const ListingItem = ({ title, description, location }) => {
    return (
        <Row className="listing-item">
            <Col xs={12} md={3} className="listing-image">
                <div>Zdjęcie</div>
            </Col>
            <Col xs={12} md={9} className="listing-details">
                <h5>{title}</h5>
                <p>{description}</p>
                <p className="text-muted">{location}</p>
            </Col>
        </Row>
    );
};

export default ListingItem;