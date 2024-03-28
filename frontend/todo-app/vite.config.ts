import { defineConfig } from "vite";
import vue from "@vitejs/plugin-vue";

// MinikubeのIPアドレスと、Ingressによって設定されたパス
const target = "http://127.0.0.1/";

export default defineConfig({
  plugins: [vue()],
  server: {
    host: true,
    proxy: {
      "/springboot": {
        target,
        changeOrigin: true,
        rewrite: (path) => path.replace(/^\/springboot/, ""),
      },
    },
  },
});
