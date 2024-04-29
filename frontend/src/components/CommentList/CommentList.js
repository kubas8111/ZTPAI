import React from "react";
import { Container, ListGroup } from "react-bootstrap";
import "./CommentStyles.css";
import CommentItem from "./CommentItem";

const CommentList = () => {
    const comments = [
        { author: "Autor 1", date: "01-01-2024", text: "Treść komentarza 1Treść komentarza 1Treść komentarza 1Treść komentarza 1Treść komentarza 1Treść komenta" },
        { author: "Autor 2", date: "02-01-2024", text: "Treść komentarza 2" },
        { author: "Autor 3", date: "03-01-2024", text: "Treść komentarza 3" },
    ];

    return (
        <Container className="comment-container mt-3">
            <h5 className="comment-title">Ostatnie komentarze</h5>
            <ListGroup>
                {comments.map((comment, index) => (
                    <CommentItem
                        key={index}
                        author={comment.author}
                        date={comment.date}
                        text={comment.text}
                        className="comment-item"
                    />
                ))}
            </ListGroup>
        </Container>
    );
};

export default CommentList;