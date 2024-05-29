import React from "react";
import { Card } from "react-bootstrap";
import "./AnnouncementDetailsStyles.css";

const AnnouncementDetails = ({ announcement }) => {
    const isValidImage = announcement.image && announcement.image.type && announcement.image.type.startsWith("image/");

    let imageUrl;
    if (isValidImage) {
        try {
            imageUrl = URL.createObjectURL(announcement.image);
        } catch (error) {
            console.error("Error creating object URL:", error);
            imageUrl = null;
        }
    }

    return (
        <Card className="announcement-card">
            {isValidImage && imageUrl ? (
                <Card.Img variant="top" src={imageUrl} alt="Announcement" />
            ) : (
                <div className="no-image-placeholder">No Image Available</div>
            )}
            <Card.Body>
                <Card.Title>{announcement.title}</Card.Title>
                <Card.Text>{announcement.description}</Card.Text>
            </Card.Body>
        </Card>
    );
};

export default AnnouncementDetails;
