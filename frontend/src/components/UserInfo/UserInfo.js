import React from "react";
import { Card } from "react-bootstrap";
import "./UserInfoStyles.css";
import {useHistory} from "react-router-dom";

const UserInfo = ({ announcement }) => {
    const { contactName, contactEmail, contactPhone, profileId } = announcement;

    const history = useHistory();

    const handleListingClick = () => {
        history.push(`/profile/${profileId.profileId}`);
    };

    return (
        <Card onClick={handleListingClick}>
            <Card.Body>
                <Card.Title>{contactName}</Card.Title>
                <Card.Text>
                    Telefon: {contactPhone}
                </Card.Text>
                <Card.Text>
                    Email: {contactEmail}
                </Card.Text>
            </Card.Body>
        </Card>
    );
};

export default UserInfo;