import axios from "axios";

export default function getTodos() {
  // const url = "http://todo-deployment-app.default.svc.cluster.local:8080/todos";
  const url = "/springboot/todos";
  const todos = axios.get(url).catch((error) => {
    console.error(error);
  });
  return todos;
}
