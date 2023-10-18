import Leaf from '../resources/CarbonLeaves.avif' 
import Header from '../Header';

function Blog() {

  const hardcodedBlogPosts = [
    {
      title: "Sample Blog Post 1",
      author: "John Doe",
      date: "October 18, 2023",
      content: "This is the content of the first blog post.",
    },
    {
      title: "Sample Blog Post 2",
      author: "Jane Smith",
      date: "October 19, 2023",
      content: "This is the content of the second blog post.",
    },
    {
          title: "Sample Blog Post 1",
          author: "John Doe",
          date: "October 18, 2023",
          content: "This is the content of the first blog post.",
        },
        {
          title: "Sample Blog Post 2",
          author: "Jane Smith",
          date: "October 19, 2023",
          content: "This is the content of the second blog post.",
        },
        {
              title: "Sample Blog Post 1",
              author: "John Doe",
              date: "October 18, 2023",
              content: "This is the content of the first blog post.",
            },
            {
              title: "Sample Blog Post 2",
              author: "Jane Smith",
              date: "October 19, 2023",
              content: "This is the content of the second blog post.",
            },
            {
                  title: "Sample Blog Post 1",
                  author: "John Doe",
                  date: "October 18, 2023",
                  content: "This is the content of the first blog post.",
                },
                {
                  title: "Sample Blog Post 2",
                  author: "Jane Smith",
                  date: "October 19, 2023",
                  content: "This is the content of the second blog post.",
                },
                {
                      title: "Sample Blog Post 1",
                      author: "John Doe",
                      date: "October 18, 2023",
                      content: "This is the content of the first blog post.",
                    },
                    {
                      title: "Sample Blog Post 2",
                      author: "Jane Smith",
                      date: "October 19, 2023",
                      content: "This is the content of the second blog post.",
                    },
                    {
                          title: "Sample Blog Post 1",
                          author: "John Doe",
                          date: "October 18, 2023",
                          content: "This is the content of the first blog post.",
                        },
                        {
                          title: "Sample Blog Post 2",
                          author: "Jane Smith",
                          date: "October 19, 2023",
                          content: "This is the content of the second blog post.",
                        },
                          {
                              title: "Sample Blog Post 1",
                              author: "John Doe",
                              date: "October 18, 2023",
                              content: "This is the content of the first blog post.",
                            },
                            {
                              title: "Sample Blog Post 2",
                              author: "Jane Smith",
                              date: "October 19, 2023",
                              content: "This is the content of the second blog post.",
                            },
                            {
                                  title: "Sample Blog Post 1",
                                  author: "John Doe",
                                  date: "October 18, 2023",
                                  content: "This is the content of the first blog post.",
                                },
                                {
                                  title: "Sample Blog Post 2",
                                  author: "Jane Smith",
                                  date: "October 19, 2023",
                                  content: "This is the content of the second blog post.",
                                },
                                {
                                      title: "Sample Blog Post 1",
                                      author: "John Doe",
                                      date: "October 18, 2023",
                                      content: "This is the content of the first blog post.",
                                    },
                                    {
                                      title: "Sample Blog Post 2",
                                      author: "Jane Smith",
                                      date: "October 19, 2023",
                                      content: "This is the content of the second blog post.",
                                    },
                                    {
                                          title: "Sample Blog Post 1",
                                          author: "John Doe",
                                          date: "October 18, 2023",
                                          content: "This is the content of the first blog post.",
                                        },
                                        {
                                          title: "Sample Blog Post 2",
                                          author: "Jane Smith",
                                          date: "October 19, 2023",
                                          content: "This is the content of the second blog post.",
                                        },
                                        {
                                              title: "Sample Blog Post 1",
                                              author: "John Doe",
                                              date: "October 18, 2023",
                                              content: "This is the content of the first blog post.",
                                            },
                                            {
                                              title: "Sample Blog Post 2",
                                              author: "Jane Smith",
                                              date: "October 19, 2023",
                                              content: "This is the content of the second blog post.",
                                            },
                                            {
                                                  title: "Sample Blog Post 1",
                                                  author: "John Doe",
                                                  date: "October 18, 2023",
                                                  content: "This is the content of the first blog post.",
                                                },
                                                {
                                                  title: "Sample Blog Post 2",
                                                  author: "Jane Smith",
                                                  date: "October 19, 2023",
                                                  content: "This is the content of the second blog post.",
                                                },
  ];


  return (
  <div style={{paddingTop: "90px"}} className='container'>

  <div className="row">
    <Header></Header>
  </div>
    <div className="row">
                  {hardcodedBlogPosts.map((post, index) => (
                    <div key={index} className="col-md-6">
                      <div className="card mb-4 bg-dark text-light">
                        <div className="card-body">
                          <h5 className="card-title">{post.title}</h5>
                          <h6 className="card-subtitle mb-2">By {post.author}</h6>
                          <p className="card-text">{post.content}</p>
                        </div>
                        <div className="card-footer text-muted">{post.date}</div>
                      </div>
                    </div>
                  ))}
                </div>
                </div>

  );
}

export default Blog;
