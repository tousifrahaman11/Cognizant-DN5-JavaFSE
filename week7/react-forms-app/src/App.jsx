import { useState } from "react";
import "./App.css";

function App() {
  const [form, setForm] = useState({ name: "", email: "", message: "" });
  const [errors, setErrors] = useState({});
  const [submitted, setSubmitted] = useState(false);

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const validate = () => {
    const newErrors = {};
    if (!form.name.trim()) newErrors.name = "Name is required";
    if (!/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(form.email))
      newErrors.email = "Enter a valid email";
    if (form.message.length < 10)
      newErrors.message = "Message must be at least 10 characters";
    return newErrors;
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    const validationErrors = validate();
    setErrors(validationErrors);
    if (Object.keys(validationErrors).length === 0) {
      setSubmitted(true);
    }
  };

  return (
    <div className="App">
      <h2>Contact Form (Controlled Inputs)</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label>Name</label>
          <input name="name" value={form.name} onChange={handleChange} />
          {errors.name && <p className="error">{errors.name}</p>}
        </div>
        <div>
          <label>Email</label>
          <input name="email" value={form.email} onChange={handleChange} />
          {errors.email && <p className="error">{errors.email}</p>}
        </div>
        <div>
          <label>Message</label>
          <textarea
            name="message"
            value={form.message}
            onChange={handleChange}
          />
          {errors.message && <p className="error">{errors.message}</p>}
        </div>
        <button type="submit">Submit</button>
      </form>
      {submitted && <p className="success">Form submitted successfully!</p>}
    </div>
  );
}

export default App;