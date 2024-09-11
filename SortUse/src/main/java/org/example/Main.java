package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        normalAscendingSort();
        normalDescendingSort();
        comparatorSorting();
    }

    private static void comparatorSorting() {
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("Design UI", 3));
        tasks.add(new Task("Write Tests", 2));
        tasks.add(new Task("Implement Feature", 1));

        // Sorting tasks by title (alphabetically)
        Collections.sort(tasks, new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                return o1.getTitle().compareTo(o2.getTitle());
            }
        });

        System.out.println("Sorting tasks by title (alphabetically) order sort:  ");
        System.out.println(tasks);

        // Sorting tasks by priority (ascending order)
        Collections.sort(tasks, new Comparator<Task>() {
            @Override
            public int compare(Task t1, Task t2) {
                return Integer.compare(t1.getPriority(), t2.getPriority());
            }
        });
        System.out.println("Sorting tasks by priority (ascending order) order sort:  ");
        System.out.println(tasks);
    }

    private static void normalDescendingSort() {
        List<Integer> l1 = Arrays.asList(5, 3, 9, 1, 7);
        Collections.sort(l1, Collections.reverseOrder());
        System.out.println("Descending order sort:  ");
        System.out.println(l1);
    }

    private static void normalAscendingSort() {
        List<Integer> l1 = Arrays.asList(5, 3, 9, 1, 7);
        Collections.sort(l1);
        System.out.println("Ascending order sort:  ");
        System.out.println(l1);
    }
}