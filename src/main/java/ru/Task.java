package ru;

import java.util.*;

public class Task {
    private String taskTarget;
    private Worker worker;
    private static ArrayList<Task> taskList = new ArrayList<>();

    public Task(String taskTarget,Worker worker) {
        this.taskTarget = taskTarget;
        this.worker = worker;
        addTaskInList(this);
    }

    private static void addTaskInList(Task task) {
        taskList.add(task);
    }

    public static ArrayList<Task> getTaskList() {
        return taskList;
    }

    @Override
    public String toString() {
        String result = "\n" + worker.getSurname() + " " + worker.getName() + " " + worker.getMiddleName() + " ==> ";
        result += taskTarget;

        return result;
    }
}
