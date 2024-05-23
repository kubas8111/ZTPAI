import {Col, Container, Row} from "react-bootstrap";
import React, { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import { api } from "../../api/axios";
import "bootstrap/dist/css/bootstrap.min.css";
import "./CategorySectionStyles.css";

const CategorySection = () => {
    const [categories, setCategories] = useState([]);

    useEffect(() => {
        const fetchCategories = async () => {
            try {
                const response = await api.get("categories");
                setCategories(response.data);
            } catch (error) {
                console.error("Błąd podczas pobierania kategorii:", error);
            }
        };

        fetchCategories();
    }, []);

    return (
        <Container className="category-section">
            <Row>
                {categories.map((category, index) => (
                    <Col key={category.categoryId} xs={12} sm={6} md={3} className="mb-4">
                        <Link to={`/search?categoryId=${category.categoryId}`} className="category-link">
                            <div className="category-box">{category.name}</div>
                        </Link>
                    </Col>
                ))}
            </Row>
        </Container>
    );
};

export default CategorySection;