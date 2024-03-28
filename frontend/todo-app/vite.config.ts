import { defineConfig } from "vite";
import vue from "@vitejs/plugin-vue";

export default defineConfig({
  server: {
    // 外部からアクセスできるようにするため追加
    host: true,
  },
  plugins: [vue()],
});
