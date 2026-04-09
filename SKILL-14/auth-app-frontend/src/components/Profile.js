import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { api, getNetworkErrorMessage } from "../api";
import Navbar from "./Navbar";

function Profile() {
  const [data, setData] = useState({});
  const navigate = useNavigate();

  useEffect(() => {
    const storedUser = localStorage.getItem("user");

    if (!storedUser) {
      navigate("/");
      return;
    }

    const user = JSON.parse(storedUser);

    api
      .get(`/user/${user.username}`)
      .then((res) => setData(res.data))
      .catch((error) => {
        alert(getNetworkErrorMessage(error));
      });
  }, [navigate]);

  return (
    <div>
      <Navbar />
      <h2>Profile</h2>
      <p>ID: {data.id}</p>
      <p>Username: {data.username}</p>
    </div>
  );
}

export default Profile;