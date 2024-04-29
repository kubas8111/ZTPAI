import React from "react";
import { Card } from "react-bootstrap";
import "./AnnouncementDetailsStyles.css";

const AnnouncementDetails = () => {
    return (
        <Card>
            <Card.Img variant="top" src="mariusz.jpg" />
            <Card.Body>
                <Card.Title>Tytuł ogłoszenia</Card.Title>
                <Card.Text>
                    Opis ogłoszenia Lorem ipsum dolor sit amet, consectetur adipiscing
                    elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
                </Card.Text>
            </Card.Body>
        </Card>
    );
};

export default AnnouncementDetails;