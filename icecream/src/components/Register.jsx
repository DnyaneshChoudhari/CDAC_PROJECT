import Form from "./Form";
import { useAuth } from "../hooks/useAuth";
import { useDispatch } from "react-redux";
import { useNavigate } from "react-router-dom";
import { setUser } from "../features/user/UserSlice";
// import { getAuth, createUserWithEmailAndPassword } from "firebase/auth";

import React, { useState } from "react";

const Register = () => {

  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const { register } = useAuth();

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await register(username, password);
      alert("Registration successful! Please log in.");
    } catch (error) {
      console.error("Failed to register", error);
    }
  };

  return (
    <>
      {/* <Form title="SIGN UP" handleClick={handleRegister} /> */}
      <Form title="SIGN UP" handleClick={handleSubmit} />
    </>
  );
};

export default Register;
