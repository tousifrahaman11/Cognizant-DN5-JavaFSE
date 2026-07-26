import { useState } from "react";
import UserProfile from "./UserProfile";
import ErrorBoundary from "./ErrorBoundary";
import BuggyComponent from "./BuggyComponent";
import "./App.css";

function App() {
  const [showProfile, setShowProfile] = useState(true);
  const [triggerError, setTriggerError] = useState(false);

  return (
    <div className="App">
      <h2>React Lifecycle Hooks Demo</h2>
      <button onClick={() => setShowProfile(!showProfile)}>
        {showProfile ? "Unmount UserProfile" : "Mount UserProfile"}
      </button>
      {showProfile && <UserProfile />}

      <hr />
      <button onClick={() => setTriggerError(true)}>Trigger Error</button>
      <ErrorBoundary>
        {triggerError ? <BuggyComponent /> : <p>No error yet.</p>}
      </ErrorBoundary>
    </div>
  );
}

export default App;