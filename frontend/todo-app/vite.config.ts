import { defineConfig } from "vite";
import vue from "@vitejs/plugin-vue";

export default defineConfig({
  plugins: [vue()],
  server: {
    host: true,
    proxy: {
      "/api/todo": {
        target: "http://todo-deployment-app:8080",
        changeOrigin: true,
        rewrite: (path) => path.replace(/^\/api\/todo/, ""),
      },
    },
  },
});
