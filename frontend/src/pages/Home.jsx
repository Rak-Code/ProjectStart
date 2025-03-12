import React from "react";
import { Container } from "react-bootstrap";
import CarouselComponent from "../components/CarouselComponent";
import ProductList from "../components/ProductList"; // Import the ProductList component

const Home = () => {
  return (
    <Container className="mt-4">
      {/* Carousel Component */}
      <CarouselComponent />

      {/* Product Listings */}
      <h2 className="text-center my-4">New Arrivals</h2>
      <ProductList />  {/* Product list component added */}
    </Container>
  );
};

export default Home;
