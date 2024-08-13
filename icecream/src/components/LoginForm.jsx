// src/components/LoginForm.js
import React, { useState } from 'react';
import { TextField, Button, Box, Typography } from '@mui/material';
import { useDispatch } from 'react-redux';
import { setUser } from '../features/user/UserSlice';
import { useNavigate } from 'react-router-dom';

const LoginForm = () => {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const dispatch = useDispatch();
    const navigate = useNavigate();

    const handleLogin = () => {
        // Dummy authentication
        if (email === 'test@example.com' && password === 'password') {
            dispatch(setUser({ email }));
            navigate('/');
        } else {
            alert('Invalid credentials');
        }
    };

    return (
        <Box sx={{ maxWidth: 400, margin: 'auto', textAlign: 'center' }}>
            <Typography variant="h4" gutterBottom>Login</Typography>
            <TextField
                label="Email"
                type="email"
                fullWidth
                margin="normal"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
            />
            <TextField
                label="Password"
                type="password"
                fullWidth
                margin="normal"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
            />
            <Button variant="contained" color="primary" fullWidth onClick={handleLogin}>
                Login
            </Button>
        </Box>
    );
};

export default LoginForm;
