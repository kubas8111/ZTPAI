import {Button, Container, Form, FormControl} from "react-bootstrap";
import React from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import "./SearchBarStyles.css";

const SearchBar = () => {
    return (
        <Container className="search-bar">
            <Form className="search-form d-flex">
                <FormControl
                    type="search"
                    placeholder="Napisz czego szukasz"
                    className="search-input"
                    aria-label="Search"
                />
                <Button onClick={() => {window.location.href = "/search"}} className="search-button">SZUKAJ</Button>
            </Form>
        </Container>
    );
};

export default SearchBar;