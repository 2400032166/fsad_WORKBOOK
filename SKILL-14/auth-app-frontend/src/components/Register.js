import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { api, getNetworkErrorMessage } from "../api";

function Register() {
  const [user, setUser] = useState({ username: "", password: "" });
  const navigate = useNavigate();

  const handleChange = (e) => {
    setUser({ ...user, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    if (!user.username || !user.password) {
      alert("All fields are required");
      return;
    }

    try {
      await api.post("/register", user);
      alert("Registered Successfully");
      navigate("/");
    } catch (error) {
      alert(getNetworkErrorMessage(error));
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <h2>Register</h2>
      <input name="username" placeholder="Username" onChange={handleChange} />
      <input name="password" type="password" placeholder="Password" onChange={handleChange} />
      <button type="submit">Register</button>
    </form>
  );
}

export default Register;