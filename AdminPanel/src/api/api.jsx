import axios from 'axios';

const API_BASE_URL = 'http://localhost:8080/api';

export const fetchProducts = () => axios.get(`${API_BASE_URL}/products`);
export const createProduct = (product) => axios.post(`${API_BASE_URL}/products`, product);
export const updateProduct = (product) => axios.put(`${API_BASE_URL}/products/${product.id}`, product);
export const deleteProduct = (productId) => axios.delete(`${API_BASE_URL}/products/${productId}`);

export const fetchDeliveryPersons = () => axios.get(`${API_BASE_URL}/delivery-persons`);
export const createDeliveryPerson = (deliveryPerson) => axios.post(`${API_BASE_URL}/delivery-persons`, deliveryPerson);
export const updateDeliveryPerson = (deliveryPerson) => axios.put(`${API_BASE_URL}/delivery-persons/${deliveryPerson.id}`, deliveryPerson);
export const deleteDeliveryPerson = (deliveryPersonId) => axios.delete(`${API_BASE_URL}/delivery-persons/${deliveryPersonId}`);

export const fetchOrders = () => axios.get(`${API_BASE_URL}/orders`);
export const updateOrderStatus = (orderId, status) => axios.put(`${API_BASE_URL}/orders/${orderId}/status`, { status });
