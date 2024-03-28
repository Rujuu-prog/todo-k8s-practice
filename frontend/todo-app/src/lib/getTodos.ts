import axios from "axios";

export default function getTodos() {
  const url = "/api/todo/todos";
  const todos = axios.get(url).catch((error) => {
    console.error(error);
  });
  return todos;
}
