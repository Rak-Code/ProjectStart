import React from "react";
import { Container, Form, Button, Card } from "react-bootstrap";
import { Link } from "react-router-dom";

const Login = () => {
  return (
    <Container className="d-flex justify-content-center align-items-center" style={{ minHeight: "90vh" }}>
      <Card className="p-4 shadow-sm w-100" style={{ maxWidth: "400px", backgroundColor: "#f8f9fa" }}>
        <h2 className="text-center mb-4">Login</h2>
        <Form>
          <Form.Group controlId="formBasicEmail" className="mb-3">
            <Form.Label>Email address</Form.Label>
            <Form.Control type="email" placeholder="Enter email" className="rounded-pill border-0 shadow-sm" />
          </Form.Group>

          <Form.Group controlId="formBasicPassword" className="mb-3">
            <Form.Label>Password</Form.Label>
            <Form.Control type="password" placeholder="Password" className="rounded-pill border-0 shadow-sm" />
          </Form.Group>

          <Button variant="dark" className="w-100 rounded-pill shadow-sm" type="submit">
            Login
          </Button>
        </Form>

        <p className="text-center mt-3">
          Don't have an account? <Link to="/register">Register</Link>
        </p>
      </Card>
    </Container>
  );
};

export default Login;
