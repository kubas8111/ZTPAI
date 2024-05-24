import React from "react";
import { Card } from "react-bootstrap";
import "./UserInfoStyles.css";
import { useHistory } from "react-router-dom";

const ProfileInfo = ({ user }) => {
    const { firstName, lastName, email, phone, profileId } = user;

    const history = useHistory();

    const handleListingClick = () => {
        history.push(`/profile/${profileId}`);
    };

    return (
        <Card onClick={handleListingClick}>
            <Card.Body>
                <Card.Title>{firstName}</Card.Title>
                <Card.Text>
                    Telefon: {phone}
                </Card.Text>
                <Card.Text>
                    Email: {email}
                </Card.Text>
            </Card.Body>
        </Card>
    );
};

export default ProfileInfo;