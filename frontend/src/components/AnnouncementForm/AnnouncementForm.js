import React, { useState, useEffect } from "react";
import { Container, Form, Button, Row, Col } from "react-bootstrap";
import { useHistory } from "react-router-dom";
import { api } from "../../api/axios";
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
    const [userId, setUserId] = useState("");

    const history = useHistory();

    useEffect(() => {
        const fetchData = async () => {
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

        fetchData();

        const accessToken = localStorage.getItem("accessToken");
        if (accessToken) {
            const decodedToken = parseJwt(accessToken);
            setUserId(decodedToken.id);
        }
    }, []);

    const parseJwt = (token) => {
        try {
            return JSON.parse(atob(token.split(".")[1]));
        } catch (error) {
            return null;
        }
    };

    const handleSubmit = async (event) => {
        event.preventDefault();
        try {
            const data = {
                profileId: { profileId: userId },
                categoryId: { categoryId: Number.parseInt(selectedCategory) },
                regionId: { regionId: Number.parseInt(selectedRegion) },
                tagId: { tagId: Number.parseInt(selectedTag) },
                title: title,
                price: price,
                description: description,
                contactName: contactName,
                contactEmail: contactEmail,
                contactPhone: contactPhone
            };

            const response = await api.post("announcements", data, {
                headers: {
                    Authorization: `Bearer ${localStorage.getItem("accessToken")}`,
                },
            });

            const newAnnouncementId = response.data.announcementId;
            history.push(`/announcement/${newAnnouncementId}`);
        } catch (error) {
            console.error("Error adding announcement:", error);
        }
    };

    const handleImageChange = (event) => {
        // Obsługa zmiany zdjęcia
    };

    console.log(userId);

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
                            <Form.Control
                                as="select"
                                value={selectedCategory}
                                onChange={(e) => setSelectedCategory(e.target.value)}
                            >
                                <option value="">Wybierz kategorię</option>

                                {categoryOptions.map((category) => (
                                    <option key={category.categoryId} value={category.categoryId}>
                                        {category.name}
                                    </option>
                                ))}
                            </Form.Control>
                        </Form.Group>

                        <Form.Group controlId="formBasicRegion">
                            <Form.Label>Region</Form.Label>
                            <Form.Control
                                as="select"
                                value={selectedRegion}
                                onChange={(e) => setSelectedRegion(e.target.value)}
                            >
                                <option value="">Wybierz region</option>
                                {regionOptions.map((region) => (
                                    <option key={region.regionId} value={region.regionId}>
                                        {region.name}
                                    </option>
                                ))}
                            </Form.Control>
                        </Form.Group>

                        <Form.Group controlId="formBasicTag">
                            <Form.Label>Tag</Form.Label>
                            <Form.Control
                                as="select"
                                value={selectedTag}
                                onChange={(e) => setSelectedTag(e.target.value)}
                            >
                                <option value="">Wybierz tag</option>
                                {tagOptions.map((tag) => (
                                    <option key={tag.tagId} value={tag.tagId}>
                                        {tag.name}
                                    </option>
                                ))}
                            </Form.Control>
                        </Form.Group>

                        <Form.Group controlId="formBasicImage">
                            <Form.Label>Zdjęcie</Form.Label>
                            <Form.Control type="file" onChange={handleImageChange} />
                        </Form.Group>

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
