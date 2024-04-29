import React from "react";
import { Container, Form, Button } from "react-bootstrap";
import "./CommentFormStyles.css";

const CommentForm = () => {
    return (
        <Container className="comment-form-container mt-3">
            <Form>
                <Form.Group controlId="commentForm">
                    <Form.Label className="comment-form-label">Dodaj komentarz</Form.Label>
                    <Form.Control as="textarea" rows={3} className="comment-form-textarea" />
                </Form.Group>
                <Button variant="primary" type="submit" className="comment-form-button">
                    Dodaj
                </Button>
            </Form>
        </Container>
    );
};

export default CommentForm;