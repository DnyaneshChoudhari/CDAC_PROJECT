// src/components/RegisterForm.js
import React, { useState } from 'react';
import { TextField, Button, Box, Typography } from '@mui/material';
import { useDispatch } from 'react-redux';
import { setUser } from '../features/user/UserSlice';
import { useNavigate } from 'react-router-dom';

const RegisterForm = () => {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [confirmPassword, setConfirmPassword] = useState('');
    const dispatch = useDispatch();
    const navigate = useNavigate();

    const handleRegister = () => {
        if (password !== confirmPassword) {
            alert('Passwords do not match');
            return;
        }

        // Dummy registration
        dispatch(setUser({ email }));
        navigate('/');
    };

    return (
        <Box sx={{ maxWidth: 400, margin: 'auto', textAlign: 'center' }}>
            <Typography variant="h4" gutterBottom>Register</Typography>
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
            <TextField
                label="Confirm Password"
                type="password"
                fullWidth
                margin="normal"
                value={confirmPassword}
                onChange={(e) => setConfirmPassword(e.target.value)}
            />
            <Button variant="contained" color="primary" fullWidth onClick={handleRegister}>
                Register
            </Button>
        </Box>
    );
};

export default RegisterForm;
