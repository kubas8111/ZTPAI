import React, { useState, useEffect } from "react";
import { Col, Form, Row } from "react-bootstrap";
import "bootstrap/dist/css/bootstrap.min.css";
import "./FiltersStyles.css";
import { api } from "../../api/axios";

const Filters = () => {
    const [categoryOptions, setCategoryOptions] = useState([]);
    const [regionOptions, setRegionOptions] = useState([]);
    const [tagOptions, setTagOptions] = useState([]);

    useEffect(() => {
        const fetchOptions = async () => {
            try {
                const categoryResponse = await api.get("categories");
                const regionResponse = await api.get("regions");
                const tagResponse = await api.get("tags");

                setCategoryOptions(categoryResponse.data);
                setRegionOptions(regionResponse.data);
                setTagOptions(tagResponse.data);
            } catch (error) {
                console.error("Error fetching options:", error);
            }
        };

        fetchOptions();
    }, []);

    return (
        <Row className="filters">
            <Col xs={12} md={4}>
                <Form.Control as="select" className="my-1">
                    <option>Kategoria</option>
                    {categoryOptions.map((category) => (
                        <option key={category.id} value={category.id}>
                            {category.name}
                        </option>
                    ))}
                </Form.Control>
            </Col>
            <Col xs={12} md={4}>
                <Form.Control as="select" className="my-1">
                    <option>Lokalizacja</option>
                    {regionOptions.map((region) => (
                        <option key={region.id} value={region.id}>
                            {region.name}
                        </option>
                    ))}
                </Form.Control>
            </Col>
            <Col xs={12} md={4}>
                <Form.Control as="select" className="my-1">
                    <option>Tag</option>
                    {tagOptions.map((tag) => (
                        <option key={tag.id} value={tag.id}>
                            {tag.name}
                        </option>
                    ))}
                </Form.Control>
            </Col>
        </Row>
    );
};

export default Filters;
