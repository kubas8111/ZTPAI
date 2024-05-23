import React from "react";
import { Container, ListGroup } from "react-bootstrap";
import "./CommentStyles.css";
import CommentItem from "./CommentItem";

const CommentList = ({ comments }) => {
    return (
        <Container className="comment-container mt-3">
            <h5 className="comment-title">Ostatnie komentarze</h5>
            <ListGroup>
                {comments.map((comment, index) => (
                    <CommentItem
                        key={index}
                        author={comment.author.firstName}
                        date={comment.createdAt}
                        text={comment.content}
                        className="comment-item"
                    />
                ))}
            </ListGroup>
        </Container>
    );
};

export default CommentList;
