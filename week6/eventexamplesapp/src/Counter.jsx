import { Component } from 'react';

class Counter extends Component {

  constructor(props) {
    super(props);
    this.state = { count: 0 };
    this.decrement = this.decrement.bind(this);
  }

  increment() {
    this.setState({ count: this.state.count + 1 });
  }

  logIncrement() {
    console.log('Counter incremented. New value will be:', this.state.count + 1);
  }

  handleIncrement = () => {
    this.logIncrement();
    this.increment();
  }

  decrement() {
    if (this.state.count > 0) {
      this.setState({ count: this.state.count - 1 });
    }
  }

  render() {
    return (
      <div style={{ textAlign: 'center', marginTop: '50px' }}>
        <h2>Counter: {this.state.count}</h2>
        <button
          onClick={this.handleIncrement}
          style={{
            margin: '10px', padding: '10px 20px',
            backgroundColor: 'green', color: 'white',
            fontSize: '16px', cursor: 'pointer', border: 'none'
          }}>
          Increment
        </button>
        <button
          onClick={this.decrement}
          style={{
            margin: '10px', padding: '10px 20px',
            backgroundColor: 'red', color: 'white',
            fontSize: '16px', cursor: 'pointer', border: 'none'
          }}>
          Decrement
        </button>
      </div>
    );
  }
}

export default Counter;