import React, { useState } from 'react';
import { TextField, Button, Container } from '@mui/material';
import { createProduct, updateProduct } from '../api/api';

const ProductForm = ({ selectedProduct, refreshProducts }) => {
    const [product, setProduct] = useState(selectedProduct || { name: '', price: '' });

    const handleChange = (e) => {
        setProduct({ ...product, [e.target.name]: e.target.value });
    };

    const handleSubmit = async () => {
        if (product.id) {
            await updateProduct(product);
        } else {
            await createProduct(product);
        }
        refreshProducts();
    };

    return (
        <Container>
            <TextField
                label="Product Name"
                name="name"
                value={product.name}
                onChange={handleChange}
                fullWidth
                margin="normal"
            />
            <TextField
                label="Price"
                name="price"
                value={product.price}
                onChange={handleChange}
                fullWidth
                margin="normal"
            />
            <Button variant="contained" color="primary" onClick={handleSubmit}>
                {product.id ? 'Update Product' : 'Save Product'}
            </Button>
        </Container>
    );
};

export default ProductForm;
