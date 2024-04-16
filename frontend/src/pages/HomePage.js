import React from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import CustomNavbar from "../components/CustomNavbar/CustomNavbar";
import SearchBar from "../components/SearchBar/SearchBar";
import CategorySection from "../components/CategorySection/CategorySection";
import Footer from "../components/Footer/Footer";
import {Container} from "react-bootstrap";

const HomePage = () => {
    return (
        <>
            <CustomNavbar />
            <Container className="mt-3">
                <SearchBar />
                <CategorySection />
            </Container>
            <Footer />
        </>
    );
};

export default HomePage;