import React, { useState, useEffect } from 'react';
import { List, ListItem, ListItemText, Button } from '@mui/material';
import { fetchOrders, updateOrderStatus } from '../api/api';

const OrderList = () => {
    const [orders, setOrders] = useState([]);

    useEffect(() => {
        const fetchData = async () => {
            const result = await fetchOrders();
            setOrders(result.data);
        };
        fetchData();
    }, []);

    const handleUpdateStatus = async (orderId, status) => {
        await updateOrderStatus(orderId, status);
        setOrders(orders.map(order => order.id === orderId ? { ...order, status } : order));
    };

    return (
        <List>
            {orders.map(order => (
                <ListItem key={order.id}>
                    <ListItemText primary={`Order ${order.id}`} secondary={`Status: ${order.status}`} />
                    <Button
                        variant="contained"
                        color="primary"
                        onClick={() => handleUpdateStatus(order.id, 'Delivered')}
                    >
                        Mark as Delivered
                    </Button>
                </ListItem>
            ))}
        </List>
    );
};

export default OrderList;
