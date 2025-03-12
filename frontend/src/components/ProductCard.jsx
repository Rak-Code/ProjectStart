import React from "react";
import { Card } from "react-bootstrap";
import { useNavigate } from "react-router-dom";

const ProductCard = ({ product }) => {
  const navigate = useNavigate();

  return (
    <Card className="h-100 border shadow-sm" onClick={() => navigate(`/product/${product.id}`)}> {/* Added border and shadow to the card */}
      <Card.Img
        variant="top"
        src={product.imageUrl}
        alt={product.name}
        style={{ height: "220px", objectFit: "cover" }} /* Increased image height to 220px */
      />
      <Card.Body className="text-center py-3"> {/* Added more padding to the card body */}
        <Card.Title className="fs-6 mb-2">{product.name}</Card.Title>
        <Card.Text className="text-muted">${product.price}</Card.Text>
      </Card.Body>
    </Card>
  );
};

export default ProductCard;