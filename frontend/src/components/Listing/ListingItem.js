import React, { useState } from "react";
import { Col, Row, Button } from "react-bootstrap";
import { useHistory } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";
import "./ListingStyles.css";
import { api } from "../../api/axios";

const ListingItem = ({ announcementId, title, description, regionId, image }) => {
    const history = useHistory();
    const [isAdmin, setIsAdmin] = useState(localStorage.getItem("role") === "admin");

    const handleListingClick = () => {
        history.push(`/announcement/${announcementId}`);
    };

    const handleDeleteListing = async () => {
        try {
            await api.delete(`announcements/${announcementId}`);
        } catch (error) {
            console.error("Error deleting listing:", error);
        }
    };

    if (!image || !image.type.startsWith("image/")) {
        return (
            <Row className="listing-item" onClick={handleListingClick}>
                <Col xs={12} md={9} className="listing-details">
                    <h5>{title}</h5>
                    <p>{description}</p>
                    <p className="text-muted">{regionId.name}</p>
                </Col>
                {isAdmin && (
                    <Col xs={12} md={3} className="listing-delete">
                        <Button variant="danger" onClick={handleDeleteListing}>Usuń</Button>
                    </Col>
                )}
            </Row>
        );
    }

    let imageUrl;
    try {
        imageUrl = URL.createObjectURL(image);
    } catch (error) {
        console.error("Error creating object URL:", error);
        return null;
    }

    return (
        <Row className="listing-item" onClick={handleListingClick}>
            <Col xs={12} md={9} className="listing-details">
                <h5>{title}</h5>
                <p>{description}</p>
                <p className="text-muted">{regionId.name}</p>
            </Col>
            <Col xs={12} md={3} className="listing-image">
                <img src={imageUrl} alt="Listing" />
            </Col>
            {isAdmin && (
                <Col xs={12} className="listing-delete">
                    <Button variant="danger" onClick={handleDeleteListing}>Usuń</Button>
                </Col>
            )}
        </Row>
    );
};

export default ListingItem;
