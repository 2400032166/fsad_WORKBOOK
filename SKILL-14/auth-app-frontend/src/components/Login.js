import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { api, getNetworkErrorMessage } from "../api";

function Login() {
  const [user, setUser] = useState({ username: "", password: "" });
  const navigate = useNavigate();

  const handleChange = (e) => {
    setUser({ ...user, [e.target.name]: e.target.value });
  };

  const handleLogin = async (e) => {
    e.preventDefault();

    if (!user.username || !user.password) {
      alert("All fields are required");
      return;
    }

    try {
      const res = await api.post("/login", user);

      if (res.data) {
        // ✅ store full user
        localStorage.setItem("user", JSON.stringify(res.data));
        navigate("/home");
      } else {
        alert("Invalid Credentials");
      }
    } catch (error) {
      alert(getNetworkErrorMessage(error));
    }
  };

  return (
    <form onSubmit={handleLogin}>
      <h2>Login</h2>
      <input name="username" onChange={handleChange} placeholder="Username" />
      <input name="password" type="password" onChange={handleChange} placeholder="Password" />
      <button type="submit">Login</button>
    </form>
  );
}

export default Login;