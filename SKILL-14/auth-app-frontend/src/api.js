import axios from "axios";

export const api = axios.create({
  baseURL: "http://localhost:8080",
});

export const getNetworkErrorMessage = (error) => {
  return error?.response?.data?.message || "Server Error";
};