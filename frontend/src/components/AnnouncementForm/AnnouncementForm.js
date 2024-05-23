import React, { useState, useEffect } from "react";
import { Container, Form, Button, Row, Col } from "react-bootstrap";
import { useHistory } from "react-router-dom";
import axios from "axios";
import "./AnnouncementFormStyles.css";

const AnnouncementForm = () => {
    const [title, setTitle] = useState("");
    const [price, setPrice] = useState("");
    const [description, setDescription] = useState("");
    const [contactName, setContactName] = useState("");
    const [contactEmail, setContactEmail] = useState("");
    const [contactPhone, setContactPhone] = useState("");
    const [categoryOptions, setCategoryOptions] = useState([]);
    const [regionOptions, setRegionOptions] = useState([]);
    const [tagOptions, setTagOptions] = useState([]);
    const [selectedCategory, setSelectedCategory] = useState("");
    const [selectedRegion, setSelectedRegion] = useState("");
    const [selectedTag, setSelectedTag] = useState("");
    const [image, setImage] = useState(null);
    const history = useHistory();

    useEffect(() => {
        const fetchOptions = async () => {
            try {
                const categoryResponse = await axios.get("http://localhost:8080/api/categories");
                const regionResponse = await axios.get("http://localhost:8080/api/regions");
                const tagResponse = await axios.get("http://localhost:8080/api/tags");

                setCategoryOptions(categoryResponse.data);
                setRegionOptions(regionResponse.data);
                setTagOptions(tagResponse.data);
            } catch (error) {
                console.error("Error fetching options:", error);
            }
        };

        fetchOptions();
    }, []);

    const handleSubmit = (event) => {
        event.preventDefault();
    };

    const handleImageChange = (event) => {
        setImage(event.target.files[0]);
    };

    return (
        <Container className="add-announcement-container">
            <Row className="justify-content-center">
                <Col md={6}>
                    <h2 className="text-center mb-4">Dodaj ogłoszenie</h2>
                    <Form onSubmit={handleSubmit}>
                        <Form.Group controlId="formBasicTitle">
                            <Form.Label>Tytuł</Form.Label>
                            <Form.Control type="text" placeholder="Tytuł ogłoszenia" value={title} onChange={(e) => setTitle(e.target.value)} />
                        </Form.Group>

                        <Form.Group controlId="formBasicPrice">
                            <Form.Label>Cena</Form.Label>
                            <Form.Control type="text" placeholder="Cena" value={price} onChange={(e) => setPrice(e.target.value)} />
                        </Form.Group>

                        <Form.Group controlId="formBasicDescription">
                            <Form.Label>Opis</Form.Label>
                            <Form.Control as="textarea" rows={3} placeholder="Opis ogłoszenia" value={description} onChange={(e) => setDescription(e.target.value)} />
                        </Form.Group>

                        <Form.Group controlId="formBasicContactName">
                            <Form.Label>Imię i nazwisko kontaktowe</Form.Label>
                            <Form.Control type="text" placeholder="Imię i nazwisko" value={contactName} onChange={(e) => setContactName(e.target.value)} />
                        </Form.Group>

                        <Form.Group controlId="formBasicContactEmail">
                            <Form.Label>Email kontaktowy</Form.Label>
                            <Form.Control type="email" placeholder="Email" value={contactEmail} onChange={(e) => setContactEmail(e.target.value)} />
                        </Form.Group>

                        <Form.Group controlId="formBasicContactPhone">
                            <Form.Label>Telefon kontaktowy</Form.Label>
                            <Form.Control type="text" placeholder="Telefon" value={contactPhone} onChange={(e) => setContactPhone(e.target.value)} />
                        </Form.Group>

                        <Form.Group controlId="formBasicCategory">
                            <Form.Label>Kategoria</Form.Label>
                            <Form.Control as="select" value={selectedCategory} onChange={(e) => setSelectedCategory(e.target.value)}>
                                <option value="">Wybierz kategorię</option>
                                {categoryOptions.map((category) => (
                                    <option key={category.id} value={category.id}>{category.name}</option>
                                ))}
                            </Form.Control>
                        </Form.Group>

                        <Form.Group controlId="formBasicRegion">
                            <Form.Label>Region</Form.Label>
                            <Form.Control as="select" value={selectedRegion} onChange={(e) => setSelectedRegion(e.target.value)}>
                                <option value="">Wybierz region</option>
                                {regionOptions.map((region) => (
                                    <option key={region.id} value={region.id}>{region.name}</option>
                                ))}
                            </Form.Control>
                        </Form.Group>

                        <Form.Group controlId="formBasicTag">
                            <Form.Label>Tag</Form.Label>
                            <Form.Control as="select" value={selectedTag} onChange={(e) => setSelectedTag(e.target.value)}>
                                <option value="">Wybierz tag</option>
                                {tagOptions.map((tag) => (
                                    <option key={tag.id} value={tag.id}>{tag.name}</option>
                                ))}
                            </Form.Control>
                        </Form.Group>

                        {/* Pole wyboru zdjęcia */}
                        <Form.Group controlId="formBasicImage">
                            <Form.Label>Zdjęcie</Form.Label>
                            <Form.Control type="file" onChange={handleImageChange} />
                        </Form.Group>

                        {/* Przycisk submit */}
                        <Button variant="primary" type="submit" className="btn-block">
                            Dodaj ogłoszenie
                        </Button>
                    </Form>
                </Col>
            </Row>
        </Container>
    );
};

export default AnnouncementForm;