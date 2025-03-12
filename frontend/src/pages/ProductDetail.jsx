import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";

const ProductDetails = () => {
  const { id } = useParams();
  const [product, setProduct] = useState(null);
  const [loading, setLoading] = useState(true);
  const [selectedSize, setSelectedSize] = useState("");
  const [selectedColor, setSelectedColor] = useState("");

  useEffect(() => {
    fetch(`http://localhost:8080/api/products/${id}`)
      .then((response) => {
        if (!response.ok) {
          throw new Error("Product not found");
        }
        return response.json();
      })
      .then((data) => {
        setProduct(data);
        setLoading(false);
      })
      .catch((error) => {
        console.error("Error fetching product:", error);
        setProduct(null);
        setLoading(false);
      });
  }, [id]);

  if (loading) return <p className="text-center text-gray-500">Loading...</p>;

  return (
    <div className="container mx-auto px-4 py-8">
      {product ? (
        <div className="grid grid-cols-1 md:grid-cols-2 gap-8 items-center">
          {/* Product Image */}
          <div className="flex justify-center">
            <img
              src={product.imageUrl}
              alt={product.name}
              className="w-3/4 rounded-lg shadow-md"
            />
          </div>

          {/* Product Info */}
          <div>
            <h1 className="text-3xl font-bold mb-4">{product.name}</h1>
            <p className="text-xl text-gray-700 font-semibold mb-4">Price: ₹{product.price}</p>
            <p className="text-gray-600 mb-6">{product.description}</p>

            {/* Size Selection */}
            <div className="mb-4">
              <label className="block text-gray-700 font-medium mb-2">Size:</label>
              <select
                className="w-full p-2 border rounded"
                value={selectedSize}
                onChange={(e) => setSelectedSize(e.target.value)}
              >
                <option value="">Select Size</option>
                <option value="S">S</option>
                <option value="M">M</option>
                <option value="L">L</option>
                <option value="XL">XL</option>
              </select>
            </div>

            {/* Color Selection */}
            <div className="mb-6">
              <label className="block text-gray-700 font-medium mb-2">Color:</label>
              <select
                className="w-full p-2 border rounded"
                value={selectedColor}
                onChange={(e) => setSelectedColor(e.target.value)}
              >
                <option value="">Select Color</option>
                <option value="Red">Red</option>
                <option value="Blue">Blue</option>
                <option value="Black">Black</option>
                <option value="White">White</option>
              </select>
            </div>

            {/* Buttons */}
            <div className="flex gap-4">
              <button className="bg-blue-600 text-white px-6 py-3 rounded-lg hover:bg-blue-700 transition">
                Add to Cart
              </button>
              <button className="bg-green-600 text-white px-6 py-3 rounded-lg hover:bg-green-700 transition">
                Buy Now
              </button>
            </div>
          </div>
        </div>
      ) : (
        <p className="text-center text-red-500">Product not found!</p>
      )}
    </div>
  );
};

export default ProductDetails;