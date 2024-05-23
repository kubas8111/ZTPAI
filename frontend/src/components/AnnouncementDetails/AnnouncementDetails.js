import React from "react";
import { Card } from "react-bootstrap";
import "./AnnouncementDetailsStyles.css";

const AnnouncementDetails = ({ announcement }) => {
    return (
        <Card>
            <Card.Img variant="top" src={announcement.imageUrl} />
            <Card.Body>
                <Card.Title>{announcement.title}</Card.Title>
                <Card.Text>{announcement.description}</Card.Text>
            </Card.Body>
        </Card>
    );
};

export default AnnouncementDetails;