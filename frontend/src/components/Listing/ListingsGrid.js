import React from "react";
import { Container } from "react-bootstrap";
import "bootstrap/dist/css/bootstrap.min.css";
import "./ListingStyles.css";
import ListingItem from "./ListingItem";

const ListingsGrid = ({ listings }) => {
    return (
        <Container className="listings-grid">
            <h3>Pasujące ogłoszenia</h3>
            {listings.map((listing, index) => (
                <ListingItem key={index} {...listing} />
            ))}
        </Container>
    );
};

export default ListingsGrid;
