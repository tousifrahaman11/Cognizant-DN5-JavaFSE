import { Component } from 'react';
import GuestPage from './GuestPage';
import UserPage from './UserPage';

class App extends Component {

  constructor(props) {
    super(props);
    this.state = { isLoggedIn: false };
  }

  handleLogin = () => {
    this.setState({ isLoggedIn: true });
  }

  handleLogout = () => {
    this.setState({ isLoggedIn: false });
  }

  render() {
    const { isLoggedIn } = this.state;

    return (
      <div style={{ fontFamily: 'Arial, sans-serif' }}>
        <div style={{
          backgroundColor: '#1a237e', color: 'white',
          padding: '15px', display: 'flex',
          justifyContent: 'space-between', alignItems: 'center'
        }}>
          <h1 style={{ margin: 0 }}>Ticket Booking App</h1>
          {isLoggedIn ? (
            <button onClick={this.handleLogout} style={{
              padding: '8px 20px', backgroundColor: 'red',
              color: 'white', border: 'none', cursor: 'pointer'
            }}>
              Logout
            </button>
          ) : (
            <button onClick={this.handleLogin} style={{
              padding: '8px 20px', backgroundColor: 'green',
              color: 'white', border: 'none', cursor: 'pointer'
            }}>
              Login
            </button>
          )}
        </div>
        <div style={{ padding: '20px' }}>
          {isLoggedIn ? <UserPage /> : <GuestPage />}
        </div>
      </div>
    );
  }
}

export default App;