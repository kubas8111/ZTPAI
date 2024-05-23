import React, { useState } from "react";
import { Container, Form, Button, Alert } from "react-bootstrap";
import { api } from "../../api/axios";
import "./CommentFormStyles.css";

const CommentForm = ({ userId }) => {
    const [comment, setComment] = useState("");
    const [error, setError] = useState(null);
    const [success, setSuccess] = useState(null);

    const handleSubmit = async (e) => {
        e.preventDefault();

        try {
            const newComment = {
                content: comment,
                commentedProfile: { profileId: userId }
            };

            await api.post("/comments", newComment);
            setSuccess("Komentarz został dodany.");
            setComment("");
            setError(null);
        } catch (err) {
            setError("Wystąpił błąd podczas dodawania komentarza.");
            setSuccess(null);
        }
    };

    return (
        <Container className="comment-form-container mt-3">
            <Form onSubmit={handleSubmit}>
                <Form.Group controlId="commentForm">
                    <Form.Label className="comment-form-label">Dodaj komentarz</Form.Label>
                    <Form.Control
                        as="textarea"
                        rows={3}
                        className="comment-form-textarea"
                        value={comment}
                        onChange={(e) => setComment(e.target.value)}
                    />
                </Form.Group>
                <Button variant="primary" type="submit" className="comment-form-button">
                    Dodaj
                </Button>
                {success && <Alert variant="success" className="mt-3">{success}</Alert>}
                {error && <Alert variant="danger" className="mt-3">{error}</Alert>}
            </Form>
        </Container>
    );
};

export default CommentForm;
