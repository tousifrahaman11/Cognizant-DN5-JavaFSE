import { Component } from "react";

class UserProfile extends Component {
  constructor(props) {
    super(props);
    this.state = { user: null, loading: true };
    console.log("1. constructor: component is being initialized");
  }

  componentDidMount() {
    console.log("3. componentDidMount: fetching user data");
    setTimeout(() => {
      this.setState({
        user: { name: "Tousif Rahaman", role: "Java FSE Trainee" },
        loading: false,
      });
    }, 1000);
  }

  componentDidUpdate(prevProps, prevState) {
    if (prevState.loading !== this.state.loading) {
      console.log("4. componentDidUpdate: state changed, user data loaded");
    }
  }

  componentWillUnmount() {
    console.log("5. componentWillUnmount: cleanup before component is removed");
  }

  render() {
    console.log("2. render: painting the UI");
    if (this.state.loading) return <p>Loading user...</p>;
    return (
      <div>
        <h3>{this.state.user.name}</h3>
        <p>{this.state.user.role}</p>
      </div>
    );
  }
}

export default UserProfile;