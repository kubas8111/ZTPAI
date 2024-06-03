import React, { useEffect, useState } from "react";
import { Col, Row, Button } from "react-bootstrap";
import { useHistory } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";
import "./ListingStyles.css";
import { api } from "../../api/axios";

const ListingItem = ({ announcementId, title, description, regionId }) => {
    const history = useHistory();
    const [imageUrl, setImageUrl] = useState(null);
    const [error, setError] = useState(null);
    const [isAdmin, setIsAdmin] = useState(false);

    useEffect(() => {
        const fetchImage = async () => {
            try {
                const response = await api.get(`images/${announcementId}`, { responseType: 'blob' });
                const objectUrl = URL.createObjectURL(response.data);
                setImageUrl(objectUrl);

                return () => URL.revokeObjectURL(objectUrl);
            } catch (error) {
                setError(error.message);
            }
        };

        fetchImage();

        const accessToken = localStorage.getItem("accessToken");
        if (accessToken) {
            const decodedToken = parseJwt(accessToken);
            if (decodedToken && decodedToken.role === "admin") {
                setIsAdmin(true);
            }
        }
    }, [announcementId]);

    const parseJwt = (token) => {
        try {
            return JSON.parse(atob(token.split(".")[1]));
        } catch (error) {
            return null;
        }
    };

    const handleListingClick = () => {
        history.push(`/announcement/${announcementId}`);
    };

    const handleDeleteListing = async (event) => {
        event.stopPropagation();
        try {
            await api.delete(`announcements/${announcementId}`);
            window.location.reload();
        } catch (error) {
            console.error("Error deleting listing:", error);
        }
    };

    return (
        <Row className="listing-item" onClick={handleListingClick}>
            <Col xs={12} md={3} className="listing-image">
                {imageUrl ? (
                    <img src={imageUrl} alt="Listing" className="listing-img" />
                ) : (
                    <p>No Image</p>
                )}
                {error && <p>Error loading image</p>}
            </Col>
            <Col xs={12} md={6} className="listing-details">
                <h5>{title}</h5>
                <p>{description}</p>
                <p className="text-muted">{regionId.name}</p>
            </Col>
            {isAdmin && ( // Render the delete button only if the user is admin
                <Col xs={12} md={3} className="listing-delete">
                    <Button variant="danger" onClick={handleDeleteListing}>Usuń</Button>
                </Col>
            )}
        </Row>
    );
};

export default ListingItem;
