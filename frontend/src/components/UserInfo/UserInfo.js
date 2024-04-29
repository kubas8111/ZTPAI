import React from "react";
import { Card } from "react-bootstrap";
import "./UserInfoStyles.css";

const UserInfo = () => {
    return (
        <Card onClick={() => {window.location.href = "/profile"}}>
            <Card.Body>
                <Card.Title>Imię i nazwisko</Card.Title>
                <Card.Text>
                    Telefon: 123-456-789
                </Card.Text>
                <Card.Text>
                    Email: example@example.com
                </Card.Text>
            </Card.Body>
        </Card>
    );
};

export default UserInfo;
