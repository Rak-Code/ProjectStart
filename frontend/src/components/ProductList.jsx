import React, { useEffect, useState } from "react";
import axios from "axios";
import { Container, Row, Col } from "react-bootstrap";
import ProductCard from "./ProductCard";

const ProductList = () => {
  const [products, setProducts] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    setLoading(true);
    axios.get("http://localhost:8080/api/products")
      .then(response => {
        setProducts(response.data);
        setLoading(false);
      })
      .catch(error => {
        console.error("Error fetching products:", error);
        setLoading(false);
      });
  }, []);

  return (
    <Container className="py-5">
      <h2 className="text-center mb-4 fw-bold">Trendy Outfits</h2>
      
      {loading ? (
        <p className="text-center">Loading products...</p>
      ) : (
        <Row xs={2} md={4} className="g-4">
          {products && products.length > 0 ? (
            products.map((product, index) => (
              <Col key={index}>
                <ProductCard product={product} />
              </Col>
            ))
          ) : (
            <Col xs={12}>
              <p className="text-center">No products available.</p>
            </Col>
          )}
        </Row>
      )}
    </Container>
  );
};

export default ProductList;