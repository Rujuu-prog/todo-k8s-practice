<template>
  <v-container style="max-width: 500px">
    <v-text-field
      v-model="newTask"
      label="What are you working on?"
      variant="solo"
      @keydown.enter="create"
    >
      <template v-slot:append-inner>
        <v-fade-transition>
          <v-btn
            v-show="newTask"
            icon="mdi-plus-circle"
            variant="text"
            @click="create"
          ></v-btn>
        </v-fade-transition>
      </template>
    </v-text-field>

    <h2 class="text-h4 text-success ps-4">
      Tasks: <span :key="`tasks-${tasks.length}`">{{ tasks.length }}</span>
    </h2>

    <v-divider class="mt-4"></v-divider>

    <v-row align="center" class="my-1">
      <strong class="mx-4 text-info-darken-2">
        Remaining: {{ remainingTasks }}
      </strong>

      <v-divider vertical></v-divider>

      <strong class="mx-4 text-success-darken-2">
        Completed: {{ completedTasks }}
      </strong>

      <v-spacer></v-spacer>

      <v-progress-circular
        v-model="progress"
        class="me-2"
      ></v-progress-circular>
    </v-row>

    <v-divider class="mb-4"></v-divider>

    <v-card v-if="tasks.length > 0">
      <v-slide-y-transition class="py-0" tag="v-list" group>
        <template v-for="(task, index) in tasks" :key="`task-${index}`">
          <v-divider v-if="index !== 0"></v-divider>
          <v-list-item @click="toggleTaskCompletion(task)">
            <template v-slot:prepend>
              <v-checkbox-btn
                v-model="task.done"
                color="green"
              ></v-checkbox-btn>
            </template>

            <v-list-item-title>
              <span :class="task.done ? 'text-grey' : 'text-primary'">{{
                task.content
              }}</span>
            </v-list-item-title>

            <template v-slot:append>
              <v-expand-x-transition>
                <v-icon
                  icon="mdi-check"
                  color="success"
                  v-show="task.done"
                  aria-hidden="false"
                ></v-icon>
              </v-expand-x-transition>
            </template>
          </v-list-item>
        </template>
      </v-slide-y-transition>
    </v-card>
  </v-container>
</template>

<script lang="ts" setup>
import { ref, computed, onMounted } from "vue";
import getTodos from "../lib/getTodos";
import { Todo } from "../types/todo";

const tasks = ref<Todo[]>([]);
const newTask = ref<string>("");

onMounted(async () => {
  try {
    const todos = await getTodos();
    tasks.value = todos;
  } catch (error) {
    console.error("Todosの取得に失敗しました。", error);
  }
});

const completedTasks = computed(
  () => tasks.value.filter((task) => task.done).length
);
const remainingTasks = computed(
  () => tasks.value.length - completedTasks.value
);
const progress = computed(
  () => (completedTasks.value / tasks.value.length) * 100
);

function create() {
  if (newTask.value) {
    const newTodoId =
      tasks.value.reduce((acc, task) => Math.max(acc, task.todoId), 0) + 1;
    tasks.value.push({
      todoId: newTodoId,
      content: newTask.value,
      done: false,
    });
    newTask.value = "";
  }
}

function toggleTaskCompletion(task: Todo) {
  task.done = !task.done;
}
</script>

<style scoped></style>
