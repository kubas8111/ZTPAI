import { Col, Row } from "react-bootstrap";
import { useHistory } from "react-router-dom";
import React from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import "./ListingStyles.css";

const ListingItem = ({ announcementId, title, description, regionId, imageUrl }) => {
    const history = useHistory();

    const handleListingClick = () => {
        history.push(`/announcement/${announcementId}`);
    };

    return (
        <Row className="listing-item" onClick={handleListingClick}>
            <Col xs={12} md={3} className="listing-image">
                <img src={imageUrl} alt="Listing" />
            </Col>
            <Col xs={12} md={9} className="listing-details">
                <h5>{title}</h5>
                <p>{description}</p>
                <p className="text-muted">{regionId.name}</p>
            </Col>
        </Row>
    );
};

export default ListingItem;
