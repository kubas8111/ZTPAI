import React, { useState } from "react";
import { Container, Form, Button, Row, Col } from "react-bootstrap";
import { useHistory } from "react-router-dom";
import "./RegisterFormStyles.css";
import {api} from "../../api/axios";

const RegisterForm = () => {
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [firstName, setFirstName] = useState("");
    const [lastName, setLastName] = useState("");
    const [phone, setPhone] = useState("");
    const [isAdmin, setIsAdmin] = useState(false);
    const history = useHistory();

    const handleSubmit = async (event) => {
        event.preventDefault();

        const formData = {
            email: email,
            password: password,
            firstName: firstName,
            lastName: lastName,
            phone: phone,
            isAdmin: isAdmin
        };

        try {
            const response = await api.post("register", formData)
                .then(response => {
                    console.log(response.data);
                });
            history.push("/login");
        } catch (error) {
            console.error('Błąd podczas rejestracji:', error);
        }
    };

    return (
        <Container className="register-container">
            <Row className="justify-content-center">
                <Col md={6}>
                    <h2 className="text-center mb-4">Rejestracja</h2>
                    <Form onSubmit={handleSubmit}>
                        <Form.Group controlId="formBasicEmail">
                            <Form.Label>Email</Form.Label>
                            <Form.Control type="email" placeholder="Twój email" value={email} onChange={(e) => setEmail(e.target.value)} />
                        </Form.Group>

                        <Form.Group controlId="formBasicPassword">
                            <Form.Label>Hasło</Form.Label>
                            <Form.Control type="password" placeholder="Twoje hasło" value={password} onChange={(e) => setPassword(e.target.value)} />
                        </Form.Group>

                        <Form.Group controlId="formBasicFirstName">
                            <Form.Label>Imię</Form.Label>
                            <Form.Control type="text" placeholder="Twoje imię" value={firstName} onChange={(e) => setFirstName(e.target.value)} />
                        </Form.Group>

                        <Form.Group controlId="formBasicLastName">
                            <Form.Label>Nazwisko</Form.Label>
                            <Form.Control type="text" placeholder="Twoje nazwisko" value={lastName} onChange={(e) => setLastName(e.target.value)} />
                        </Form.Group>

                        <Form.Group controlId="formBasicPhone">
                            <Form.Label>Telefon</Form.Label>
                            <Form.Control type="text" placeholder="Twój numer telefonu" value={phone} onChange={(e) => setPhone(e.target.value)} />
                        </Form.Group>

                        <Button variant="primary" type="submit" className="btn-block">
                            Zarejestruj się
                        </Button>
                    </Form>
                    <div className="mt-3 text-center">
                        Masz już konto? <a href="/login">Zaloguj się</a>
                    </div>
                </Col>
            </Row>
        </Container>
    );
};

export default RegisterForm;
