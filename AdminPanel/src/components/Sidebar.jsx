import React from 'react';
import { List, ListItem, ListItemIcon, ListItemText, Drawer } from '@mui/material';
import { ShoppingCart, Person, Assignment } from '@mui/icons-material';
import { Link } from 'react-router-dom';

const Sidebar = () => {
    return (
        <Drawer variant="permanent" anchor="left">
            <List>
                <ListItem button component={Link} to="/products">
                    <ListItemIcon><ShoppingCart /></ListItemIcon>
                    <ListItemText primary="Products" />
                </ListItem>
                <ListItem button component={Link} to="/delivery-persons">
                    <ListItemIcon><Person /></ListItemIcon>
                    <ListItemText primary="Delivery Persons" />
                </ListItem>
                <ListItem button component={Link} to="/orders">
                    <ListItemIcon><Assignment /></ListItemIcon>
                    <ListItemText primary="Orders" />
                </ListItem>
            </List>
        </Drawer>
    );
};

export default Sidebar;
