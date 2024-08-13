import React from "react";
import { Link } from "react-router-dom";
import { Container, Typography, Paper, Divider } from "@mui/material";
import Login from "../components/LoginForm";
import { PageContainer } from "../styles/page/containers";
import { Colors } from "../styles/theme/theme";
import LoginForm from "../components/LoginForm";

const LoginPage = () => {
  return (
    <PageContainer>
      <Paper
        elevation={3}
        sx={{ width: "20rem", margin: "0 auto", padding: "1.5rem 1rem" }}
      >
        <Typography variant="h4" mb="1rem">
          Login
        </Typography>
        <LoginForm />
        <Divider textAlign="center" />
        <Typography variant="subtitle1" mt="2rem">
          Don't have an account?{" "}
          <Link to="/register" sx={{ color: Colors.secondary }}>
            Sign up
          </Link>
        </Typography>
      </Paper>
    </PageContainer>
  );
};

export default LoginPage;
