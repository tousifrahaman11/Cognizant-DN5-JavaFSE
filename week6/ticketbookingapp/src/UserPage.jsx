function UserPage() {
  const flights = [
    { id: 1, from: 'Mumbai', to: 'Delhi', time: '08:00', price: 3500 },
    { id: 2, from: 'Chennai', to: 'Bangalore', time: '10:30', price: 2800 },
    { id: 3, from: 'Hyderabad', to: 'Kolkata', time: '14:00', price: 4200 },
  ];

  return (
    <div>
      <h2>Book Your Tickets</h2>
      <p style={{ color: 'green' }}>Welcome! You can now book tickets.</p>
      <table border="1" style={{ borderCollapse: 'collapse', width: '100%' }}>
        <thead style={{ backgroundColor: '#1a237e', color: 'white' }}>
          <tr>
            <th style={{ padding: '10px' }}>Flight</th>
            <th style={{ padding: '10px' }}>From</th>
            <th style={{ padding: '10px' }}>To</th>
            <th style={{ padding: '10px' }}>Time</th>
            <th style={{ padding: '10px' }}>Price (₹)</th>
            <th style={{ padding: '10px' }}>Action</th>
          </tr>
        </thead>
        <tbody>
          {flights.map(flight => (
            <tr key={flight.id}>
              <td style={{ padding: '10px' }}>FL-{flight.id}00{flight.id}</td>
              <td style={{ padding: '10px' }}>{flight.from}</td>
              <td style={{ padding: '10px' }}>{flight.to}</td>
              <td style={{ padding: '10px' }}>{flight.time}</td>
              <td style={{ padding: '10px' }}>{flight.price}</td>
              <td style={{ padding: '10px' }}>
                <button
                  onClick={() => alert(`Booked: ${flight.from} → ${flight.to}`)}
                  style={{
                    backgroundColor: 'green', color: 'white',
                    border: 'none', padding: '5px 10px', cursor: 'pointer'
                  }}>
                  Book
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default UserPage;