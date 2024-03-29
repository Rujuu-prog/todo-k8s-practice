import axios from "axios";
import { Todo } from "../types/todo";

export default async function getTodos(): Promise<Todo[]> {
  const url = "/api/todo/todos";
  try {
    const res = await axios.get<Todo[]>(url);
    return res.data;
  } catch (error) {
    console.error(error);
    return [];
  }
}
