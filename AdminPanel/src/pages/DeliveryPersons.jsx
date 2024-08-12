import React, { useState, useEffect } from 'react';
import DeliveryPersonForm from '../components/DeliveryPersonForm';
import { fetchDeliveryPersons, deleteDeliveryPerson } from '../api/api';
import { List, ListItem, ListItemText, Button, Container } from '@mui/material';

const DeliveryPersons = () => {
    const [deliveryPersons, setDeliveryPersons] = useState([]);
    const [selectedDeliveryPerson, setSelectedDeliveryPerson] = useState(null);

    useEffect(() => {
        refreshDeliveryPersons();
    }, []);

    const refreshDeliveryPersons = async () => {
        const result = await fetchDeliveryPersons();
        setDeliveryPersons(result.data);
    };

    const handleDelete = async (deliveryPersonId) => {
        await deleteDeliveryPerson(deliveryPersonId);
        refreshDeliveryPersons();
    };

    const handleEdit = (deliveryPerson) => {
        setSelectedDeliveryPerson(deliveryPerson);
    };

    return (
        <Container>
            <h2>Manage Delivery Persons</h2>
            <DeliveryPersonForm selectedDeliveryPerson={selectedDeliveryPerson} refreshDeliveryPersons={refreshDeliveryPersons} />
            <List>
                {deliveryPersons.map(deliveryPerson => (
                    <ListItem key={deliveryPerson.id}>
                        <ListItemText primary={deliveryPerson.name} secondary={`Phone: ${deliveryPerson.phone}`} />
                        <Button variant="contained" color="secondary" onClick={() => handleEdit(deliveryPerson)}>
                            Edit
                        </Button>
                        <Button variant="contained" color="error" onClick={() => handleDelete(deliveryPerson.id)}>
                            Delete
                        </Button>
                    </ListItem>
                ))}
            </List>
        </Container>
    );
};

export default DeliveryPersons;
