package org.example;

import java.util.*;

class Task {
    private String title;
    private int priority;

    public Task(String title, int priority) {
        this.title = title;
        this.priority = priority;
    }

    public String getTitle() {
        return title;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "Task{" + "title='" + title + "', priority=" + priority + '}';
    }
}

