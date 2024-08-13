// import React, { useState, useEffect } from 'react';
// import axios from 'axios';

// const useAuth = () => {
//   const [user, setUser] = useState(null);

//   useEffect(() => {
//     // Check if the user is authenticated on mount
//     const token = localStorage.getItem('token');
//     if (token) {
//       axios.defaults.headers.common['Authorization'] = `Bearer ${token}`;
//       // Optionally, fetch user data using the token
//     }
//   }, []);

//   const login = async (credentials) => {
//     const response = await axios.post('http://localhost:8080/authenticate', credentials);
//     const { token, user } = response.data;
//     localStorage.setItem('token', token);
//     axios.defaults.headers.common['Authorization'] = `Bearer ${token}`;
//     // Optionally, fetch user data and set it
//     setUser(user);
//   };

//   const logout = () => {
//     localStorage.removeItem('token');
//     delete axios.defaults.headers.common['Authorization'];
//     setUser(null);
//   };

//   return { user, login, logout };
// };

// export default useAuth;
import { useSelector } from "react-redux";

export const useAuth = () => {
  const { email, token, id, name } = useSelector((state) => state.user);

  return {
    isAuth: !!email,
    email,
    token,
    id,
    name,
  };
};
