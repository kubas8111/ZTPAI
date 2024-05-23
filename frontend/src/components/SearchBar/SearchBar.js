import React, { useState } from "react";
import { Button, Container, Form, FormControl } from "react-bootstrap";
import { useHistory } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";
import "./SearchBarStyles.css";

const SearchBar = () => {
    const [searchQuery, setSearchQuery] = useState("");
    const history = useHistory();

    const handleSearch = () => {
        const searchPath = `/search?query=${searchQuery}`;
        history.push(searchPath);
    };

    return (
        <Container className="search-bar">
            <Form className="search-form d-flex">
                <FormControl
                    type="search"
                    placeholder="Napisz czego szukasz"
                    className="search-input"
                    aria-label="Search"
                    value={searchQuery}
                    onChange={(e) => setSearchQuery(e.target.value)}
                />
                <Button onClick={handleSearch} className="search-button">SZUKAJ</Button>
            </Form>
        </Container>
    );
};

export default SearchBar;
