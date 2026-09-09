import { useEffect, useState } from "react";

function App() {

  const [deployments, setDeployments] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8080/deployments")
      .then((response) => response.json())
      .then((data) => setDeployments(data));
  }, []);

  return (
    <div style={{ padding: "20px" }}>
      <h1>🚀 Internship DevOps Dashboard</h1>

      <table border="1" cellPadding="10">
        <thead>
          <tr>
            <th>ID</th>
            <th>Project Name</th>
            <th>Status</th>
            <th>Deployment Time</th>
          </tr>
        </thead>

        <tbody>
          {deployments.map((item) => (
            <tr key={item.id}>
              <td>{item.id}</td>
              <td>{item.projectName}</td>
              <td>{item.status}</td>
              <td>{item.deploymentTime}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default App;