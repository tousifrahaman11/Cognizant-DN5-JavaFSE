function App() {

  const companyName = "Cognizant Office Spaces";
  const pricePerSqFt = 85;

  const headerStyle = {
    backgroundColor: '#1a237e',
    color: 'white',
    padding: '20px',
    textAlign: 'center'
  };

  const cardStyle = {
    border: '1px solid #ddd',
    borderRadius: '8px',
    padding: '15px',
    margin: '10px',
    display: 'inline-block',
    width: '200px',
    verticalAlign: 'top'
  };

  const offices = [
    { id: 1, name: 'Suite A', size: 500, floor: 2 },
    { id: 2, name: 'Suite B', size: 750, floor: 3 },
    { id: 3, name: 'Suite C', size: 1000, floor: 5 },
  ];

  return (
    <div>
      <div style={headerStyle}>
        <h1>{companyName}</h1>
        <p>Price: ₹{pricePerSqFt}/sq.ft</p>
      </div>

      <div style={{ padding: '20px' }}>
        <h2>Available Office Spaces</h2>
        {offices.map(office => (
          <div key={office.id} style={cardStyle}>
            <h3>{office.name}</h3>
            <p>Size: {office.size} sq.ft</p>
            <p>Floor: {office.floor}</p>
            <p>Price: ₹{office.size * pricePerSqFt}/month</p>
            <button style={{
              backgroundColor: '#1a237e', color: 'white',
              border: 'none', padding: '8px 16px', cursor: 'pointer'
            }}>
              Book Now
            </button>
          </div>
        ))}
      </div>
    </div>
  );
}

export default App;