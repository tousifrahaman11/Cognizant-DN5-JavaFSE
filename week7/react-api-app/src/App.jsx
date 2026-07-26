import { useEffect, useState } from "react";
import axios from "axios";
import "./App.css";

function App() {
  const [usersFetch, setUsersFetch] = useState([]);
  const [usersAxios, setUsersAxios] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  // Using native Fetch API
  useEffect(() => {
    fetch("https://jsonplaceholder.typicode.com/users")
      .then((res) => {
        if (!res.ok) throw new Error("Fetch failed: " + res.status);
        return res.json();
      })
      .then((data) => setUsersFetch(data))
      .catch((err) => setError(err.message));
  }, []);

  // Using Axios
  useEffect(() => {
    axios
      .get("https://jsonplaceholder.typicode.com/users")
      .then((res) => setUsersAxios(res.data))
      .catch((err) => setError(err.message))
      .finally(() => setLoading(false));
  }, []);

  if (loading) return <p>Loading...</p>;
  if (error) return <p className="error">Error: {error}</p>;

  return (
    <div className="App">
      <h2>Users via Fetch API ({usersFetch.length})</h2>
      <ul>
        {usersFetch.map((u) => (
          <li key={u.id}>{u.name} — {u.email}</li>
        ))}
      </ul>

      <h2>Users via Axios ({usersAxios.length})</h2>
      <ul>
        {usersAxios.map((u) => (
          <li key={u.id}>{u.name} — {u.company.name}</li>
        ))}
      </ul>
    </div>
  );
}

export default App;