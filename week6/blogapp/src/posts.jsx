import { Component } from 'react';
import Post from './Post';

class Posts extends Component {

  constructor(props) {
    super(props);
    this.state = {
      posts: []
    };
  }

  loadPosts() {
    fetch('https://jsonplaceholder.typicode.com/posts')
      .then(response => response.json())
      .then(data => {
        this.setState({ posts: data.slice(0, 10) });
      })
      .catch(error => {
        console.error('Error loading posts:', error);
      });
  }

  componentDidMount() {
    this.loadPosts();
  }

  render() {
    return (
      <div>
        <h2>Blog Posts</h2>
        {this.state.posts.length === 0 ? (
          <p>Loading posts...</p>
        ) : (
          this.state.posts.map(post => (
            <Post
              key={post.id}
              id={post.id}
              title={post.title}
              body={post.body}
            />
          ))
        )}
      </div>
    );
  }
}

export default Posts;