import React, { useState } from "react";
import { Container, Form, Button } from "react-bootstrap";
import axios from "axios";
import "./CommentFormStyles.css";

const CommentForm = ({ userId }) => {
    const [author, setAuthor] = useState("");
    const [content, setContent] = useState("");

    const handleSubmit = async (event) => {
        event.preventDefault();
        try {
            const response = await axios.post("/api/comments", {
                author: author,
                content: content,
                commentedProfile: { profileId: userId }
            }, {
                headers: {
                    Authorization: `Bearer ${localStorage.getItem("token")}`
                }
            });
            console.log("Comment added:", response.data);
            setAuthor("");
            setContent("");
        } catch (error) {
            console.error("Error adding comment:", error);
        }
    };

    return (
        <Container className="comment-form-container mt-3">
            <Form onSubmit={handleSubmit}>
                <Form.Group controlId="author">
                    <Form.Label className="comment-form-label">Nazwa autora</Form.Label>
                    <Form.Control
                        type="text"
                        value={author}
                        onChange={(e) => setAuthor(e.target.value)}
                        className="comment-form-textarea"
                    />
                </Form.Group>
                <Form.Group controlId="commentForm">
                    <Form.Label className="comment-form-label">Dodaj komentarz</Form.Label>
                    <Form.Control
                        as="textarea"
                        rows={3}
                        value={content}
                        onChange={(e) => setContent(e.target.value)}
                        className="comment-form-textarea"
                    />
                </Form.Group>
                <Button variant="primary" type="submit" className="comment-form-button">
                    Dodaj
                </Button>
            </Form>
        </Container>
    );
};

export default CommentForm;
