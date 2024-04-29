import React from "react";
import { Row, Col } from "react-bootstrap";
import "./CommentStyles.css";

const CommentItem = ({ author, date, text }) => {
    return (
        <div className="comment-item">
            <Row>
                <Col sm={6} className="comment-author">{author}</Col>
                <Col sm={6} className="comment-date text-right">{date}</Col>
            </Row>
            <Row>
                <Col>{text}</Col>
            </Row>
        </div>
    );
};

export default CommentItem;