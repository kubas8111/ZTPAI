import React from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import { Container } from "react-bootstrap";
import CustomNavbar from "../components/CustomNavbar/CustomNavbar";
import SearchBar from "../components/SearchBar/SearchBar";
import Filters from "../components/Filters/Filters";
import ListingsGrid from "../components/Listing/ListingsGrid";
import Footer from "../components/Footer/Footer";

const SearchPage = () => {
    return (
        <>
            <CustomNavbar />
            <Container className="mt-3">
                <SearchBar />
                <Filters />
                <ListingsGrid />
            </Container>
            <Footer />
        </>
    );
};

export default SearchPage;