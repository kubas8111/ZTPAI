import React, { useState } from "react";
import { Col, Row, Button } from "react-bootstrap";
import { useHistory } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";
import "./ListingStyles.css";
import { api } from "../../api/axios";

const ListingItem = ({ announcementId, title, description, regionId, image }) => {
    const history = useHistory();
    const [deleting, setDeleting] = useState(false);

    const handleListingClick = () => {
        history.push(`/announcement/${announcementId}`);
    };

    const handleDeleteListing = async (event) => {
        event.stopPropagation();
        try {
            await api.delete(`announcements/${announcementId}`);
            // Po usunięciu ogłoszenia odśwież stronę
            window.location.reload();
        } catch (error) {
            console.error("Error deleting listing:", error);
        }
    };

    let imageUrl;
    try {
        imageUrl = image ? URL.createObjectURL(image) : null;
    } catch (error) {
        console.error("Error creating object URL:", error);
        imageUrl = null;
    }

    return (
        <Row className="listing-item" onClick={handleListingClick}>
            <Col xs={12} md={3} className="listing-image">
                {imageUrl ? (
                    <img src={imageUrl} alt="Listing" />
                ) : (
                    <p>No Image</p>
                )}
            </Col>
            <Col xs={12} md={6} className="listing-details">
                <h5>{title}</h5>
                <p>{description}</p>
                <p className="text-muted">{regionId.name}</p>
            </Col>
            <Col xs={12} md={3} className="listing-delete">
                <Button variant="danger" onClick={handleDeleteListing}>Usuń</Button>
            </Col>
        </Row>
    );
};

export default ListingItem;
