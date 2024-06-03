import React, { useEffect, useState } from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import { Container } from "react-bootstrap";
import CustomNavbar from "../components/CustomNavbar/CustomNavbar";
import SearchBar from "../components/SearchBar/SearchBar";
import Filters from "../components/Filters/Filters";
import ListingsGrid from "../components/Listing/ListingsGrid";
import Footer from "../components/Footer/Footer";
import { api } from "../api/axios";

const SearchPage = () => {
    const [listings, setListings] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        const fetchListings = async () => {
            try {
                const response = await api.get("announcements");
                setListings(response.data);
            } catch (error) {
                setError(error.message);
            } finally {
                setLoading(false);
            }
        };

        fetchListings();
    }, []);

    return (
        <>
            <CustomNavbar />
            <Container className="mt-3">
                <SearchBar />
                <Filters />
                {loading && <p>Loading...</p>}
                {/*{error && <p>Error: {error}</p>}*/}
                <ListingsGrid listings={listings} />
            </Container>
            <Footer />
        </>
    );
};

export default SearchPage;
