import React, { useEffect, useState } from "react";
import { Card } from "react-bootstrap";
import "./AnnouncementDetailsStyles.css";

const AnnouncementDetails = ({ announcement, image }) => {
    const [imageUrl, setImageUrl] = useState(null);

    useEffect(() => {
        if (image) {
            const objectUrl = URL.createObjectURL(image);
            setImageUrl(objectUrl);

            // Clean up the object URL to avoid memory leaks
            return () => URL.revokeObjectURL(objectUrl);
        }
    }, [image]);

    return (
        <Card className="announcement-card">
            {imageUrl ? (
                <Card.Img variant="top" src={imageUrl} alt="Announcement" className="announcement-card-img" />
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
