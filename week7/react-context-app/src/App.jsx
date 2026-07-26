import { useContext } from "react";
import { ThemeContext, ThemeProvider } from "./ThemeContext";
import "./App.css";

function ThemedBox() {
  const { theme, toggleTheme } = useContext(ThemeContext);
  return (
    <div className={theme === "light" ? "box-light" : "box-dark"}>
      <p>Current theme: {theme}</p>
      <button onClick={toggleTheme}>Toggle Theme</button>
    </div>
  );
}

function App() {
  return (
    <ThemeProvider>
      <h2>React Context API Demo</h2>
      <ThemedBox />
    </ThemeProvider>
  );
}

export default App;