import React, { useState } from "react";
import { Container, Form, Button, Row, Col } from "react-bootstrap";
import { useHistory } from "react-router-dom";
import "./AnnouncementFormStyles.css";

const AnnouncementForm = () => {
    const [title, setTitle] = useState("");
    const [price, setPrice] = useState("");
    const [description, setDescription] = useState("");
    const [contactName, setContactName] = useState("");
    const [contactEmail, setContactEmail] = useState("");
    const [contactPhone, setContactPhone] = useState("");
    const [category, setCategory] = useState("");
    const [region, setRegion] = useState("");
    const [tag, setTag] = useState("");
    const [image, setImage] = useState(null);
    const history = useHistory();

    const handleSubmit = (event) => {
        event.preventDefault();

        const formData = {
            title: title,
            price: price,
            description: description,
            contactName: contactName,
            contactEmail: contactEmail,
            contactPhone: contactPhone,
            category: category,
            region: region,
            tag: tag,
            image: image
        };

        console.log(formData);

        history.push("/home");
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
                            <Form.Control as="select" value={category} onChange={(e) => setCategory(e.target.value)}>
                                <option value="">Wybierz kategorię</option>
                                <option value="1">Kategoria 1</option>
                                <option value="2">Kategoria 2</option>
                                <option value="3">Kategoria 3</option>
                                {/* Dodaj więcej opcji, jeśli jest taka potrzeba */}
                            </Form.Control>
                        </Form.Group>

                        <Form.Group controlId="formBasicRegion">
                            <Form.Label>Region</Form.Label>
                            <Form.Control as="select" value={region} onChange={(e) => setRegion(e.target.value)}>
                                <option value="">Wybierz region</option>
                                <option value="1">Region 1</option>
                                <option value="2">Region 2</option>
                                <option value="3">Region 3</option>
                                {/* Dodaj więcej opcji, jeśli jest taka potrzeba */}
                            </Form.Control>
                        </Form.Group>

                        <Form.Group controlId="formBasicTag">
                            <Form.Label>Tag</Form.Label>
                            <Form.Control as="select" value={tag} onChange={(e) => setTag(e.target.value)}>
                                <option value="">Wybierz tag</option>
                                <option value="1">Tag 1</option>
                                <option value="2">Tag 2</option>
                                <option value="3">Tag 3</option>
                                {/* Dodaj więcej opcji, jeśli jest taka potrzeba */}
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