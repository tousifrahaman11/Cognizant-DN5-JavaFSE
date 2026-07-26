import { useState } from "react";
import "./App.css";

const players = [
  { id: 1, name: "Virat Kohli", score: 82 },
  { id: 2, name: "Rohit Sharma", score: 65 },
  { id: 3, name: "Shubman Gill", score: 45 },
  { id: 4, name: "KL Rahul", score: 90 },
];

function App() {
  const [showAll, setShowAll] = useState(true);
  const visiblePlayers = showAll ? players : players.filter((p) => p.score >= 70);

  return (
    <div className="App">
      <h2>Cricket Scoreboard</h2>
      <button onClick={() => setShowAll(!showAll)}>
        {showAll ? "Show only scores >= 70" : "Show all players"}
      </button>
      <ul>
        {visiblePlayers.map((p) => (
          <li key={p.id}>
            {p.name} — {p.score}
            {p.score >= 70 && <span className="badge"> ⭐ Top Scorer</span>}
          </li>
        ))}
      </ul>
      {visiblePlayers.length === 0 && <p>No players match this filter.</p>}
    </div>
  );
}

export default App;