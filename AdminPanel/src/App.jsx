import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Sidebar from './components/Sidebar';
import Header from './components/Header';
import Products from './pages/Products';
import Orders from './pages/Orders';
import { Container } from '@mui/material';
import DeliveryPersons from './pages/DeliveryPersons';

function App() {
    return (
        <Router>
            <Header />
            <Sidebar />
            <Container style={{ marginLeft: 240, marginTop: 64 }}>
                <Routes>
                    <Route path="/products" element={<Products />} />
                    <Route path="/delivery-persons" element={<DeliveryPersons />} />
                    <Route path="/orders" element={<Orders />} />
                </Routes>
            </Container>
        </Router>
    );
}

export default App;
