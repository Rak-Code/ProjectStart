import React from "react";
import { NavLink } from "react-router-dom";
import { Navbar, Nav, Form, FormControl, Button, Container } from "react-bootstrap";
import { FaShoppingCart, FaUser } from "react-icons/fa";
import "bootstrap/dist/css/bootstrap.min.css";

const NavigationBar = () => {
  return (
    <Navbar bg="light" expand="lg" className="shadow-sm">
      <Container>
        {/* Brand Logo */}
        <Navbar.Brand as={NavLink} to="/" className="fw-bold fs-4">
          Athena
        </Navbar.Brand>

        <Navbar.Toggle aria-controls="navbar-nav" />
        <Navbar.Collapse id="navbar-nav">
          <Nav className="mx-auto">
            {/* Search Bar */}
            <Form className="d-flex" style={{ width: '500px' }}> {/* Increased width */}
              <FormControl
                type="search"
                placeholder="Search..."
                className="me-2 rounded-pill border-0 shadow-sm" // Added rounded-pill and shadow
                style={{ backgroundColor: '#f8f9fa' }} // Light background
              />
              <Button variant="outline-dark" className="rounded-pill">Search</Button> {/* Rounded button */}
            </Form>
          </Nav>

          <Nav>
            {/* Cart Icon */}
            <Nav.Link as={NavLink} to="/cart" className="d-flex align-items-center">
              <FaShoppingCart size={20} className="me-1" /> Cart
            </Nav.Link>

            {/* Login/Register Button */}
            <Nav.Link as={NavLink} to="/login" className="d-flex align-items-center">
              <FaUser size={20} className="me-1" /> Login / Register
            </Nav.Link>
          </Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
};

export default NavigationBar;
