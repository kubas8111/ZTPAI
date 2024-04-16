import {Col, Form, Row} from "react-bootstrap";
import React from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import "./FiltersStyles.css";

const Filters = () => {
    return (
        <Row className="filters">
            <Col xs={12} md={4}>
                <Form.Control as="select" className="my-1">
                    <option>Kategoria</option>
                </Form.Control>
            </Col>
            <Col xs={12} md={4}>
                <Form.Control as="select" className="my-1">
                    <option>Lokalizacja</option>
                </Form.Control>
            </Col>
            <Col xs={12} md={4}>
                <Form.Control as="select" className="my-1">
                    <option>Tag</option>
                </Form.Control>
            </Col>
        </Row>
    );
};

export default Filters;