import { useEffect } from "react";
import { useNavigate } from "react-router-dom";
import Navbar from "./Navbar";

function Home() {
  const navigate = useNavigate();

  useEffect(() => {
    const user = localStorage.getItem("user");

    if (!user) {
      navigate("/");
    }
  }, [navigate]);

  const user = JSON.parse(localStorage.getItem("user"));

  return (
    <div>
      <Navbar />
      <h2>Welcome {user?.username}</h2>
    </div>
  );
}

export default Home;