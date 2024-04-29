import React, { useState } from "react";
import { Container, Form, Button, Row, Col } from "react-bootstrap";
import { useHistory } from "react-router-dom";
import {api} from "../../api/axios";
import "./LoginFormStyles.css";

const LoginForm = () => {
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const history = useHistory();

    const handleSubmit = async (event) => {
        event.preventDefault();

        const formData = {
            email: email,
            password: password
        };

        try {
            const response = await api.post("auth/login", formData)
                .then(response => {
                    console.log(response.data);
                });
            history.push("/home");
        } catch (error) {
            console.error('Błąd podczas logowania:', error);
        }
    };

    return (
        <Container className="login-container">
            <Row className="justify-content-center">
                <Col md={6}>
                    <h2 className="text-center mb-4">Logowanie</h2>
                    <Form onSubmit={handleSubmit}>
                        <Form.Group controlId="formBasicEmail">
                            <Form.Label>Email</Form.Label>
                            <Form.Control type="email" placeholder="Twój email" value={email} onChange={(e) => setEmail(e.target.value)} />
                        </Form.Group>

                        <Form.Group controlId="formBasicPassword">
                            <Form.Label>Hasło</Form.Label>
                            <Form.Control type="password" placeholder="Twoje hasło" value={password} onChange={(e) => setPassword(e.target.value)} />
                        </Form.Group>

                        <Button variant="primary" type="submit" className="btn-block">
                            Zaloguj się
                        </Button>
                    </Form>
                    <div className="mt-3 text-center">
                        Nie masz jeszcze konta? <a href="/register">Zarejestruj się</a>
                    </div>
                </Col>
            </Row>
        </Container>
    );
};

export default LoginForm;