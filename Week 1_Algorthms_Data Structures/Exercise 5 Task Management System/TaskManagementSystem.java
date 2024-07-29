import java.util.Scanner;

public class TaskManagementSystem {

    // Task class to represent each task
    static class Task {
        private int taskId;
        private String taskName;
        private String status;

        public Task(int taskId, String taskName, String status) {
            this.taskId = taskId;
            this.taskName = taskName;
            this.status = status;
        }

        public int getTaskId() {
            return taskId;
        }

        public String getTaskName() {
            return taskName;
        }

        public String getStatus() {
            return status;
        }

        @Override
        public String toString() {
            return "Task{" +
                    "taskId=" + taskId +
                    ", taskName='" + taskName + '\'' +
                    ", status='" + status + '\'' +
                    '}';
        }
    }

    // Node class to represent each node in the linked list
    static class Node {
        Task task;
        Node next;

        Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    // SinglyLinkedList class to manage the list of tasks
    static class SinglyLinkedList {
        private Node head;

        public SinglyLinkedList() {
            this.head = null;
        }

        // Add a task to the end of the list
        public void addTask(Task task) {
            Node newNode = new Node(task);
            if (head == null) {
                head = newNode;
            } else {
                Node temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = newNode;
            }
        }

        // Search for a task by taskId
        public Task searchTask(int taskId) {
            Node temp = head;
            while (temp != null) {
                if (temp.task.getTaskId() == taskId) {
                    return temp.task;
                }
                temp = temp.next;
            }
            return null; // Task not found
        }

        // Traverse and display all tasks
        public void traverseTasks() {
            Node temp = head;
            if (temp == null) {
                System.out.println("No tasks to display.");
            } else {
                while (temp != null) {
                    System.out.println(temp.task);
                    temp = temp.next;
                }
            }
        }

        // Delete a task by taskId
        public void deleteTask(int taskId) {
            if (head == null) {
                System.out.println("No tasks to delete.");
                return;
            }
            if (head.task.getTaskId() == taskId) {
                head = head.next;
                System.out.println("Task deleted.");
                return;
            }
            Node prev = null;
            Node current = head;
            while (current != null && current.task.getTaskId() != taskId) {
                prev = current;
                current = current.next;
            }
            if (current != null) {
                prev.next = current.next;
                System.out.println("Task deleted.");
            } else {
                System.out.println("Task not found.");
            }
        }
    }

    // Main method to run the Task Management System
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SinglyLinkedList taskList = new SinglyLinkedList();

        while (true) {
            System.out.println("1. Add task");
            System.out.println("2. Search task");
            System.out.println("3. Display all tasks");
            System.out.println("4. Delete task");
            System.out.println("-1 to exit");
            System.out.print("Your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter task ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter task name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter task status: ");
                    String status = scanner.nextLine();
                    Task task = new Task(id, name, status);
                    taskList.addTask(task);
                    System.out.println("Task added.");
                    break;

                case 2:
                    System.out.print("Enter task ID to search: ");
                    int searchId = scanner.nextInt();
                    Task result = taskList.searchTask(searchId);
                    if (result != null) {
                        System.out.println("Task found: " + result);
                    } else {
                        System.out.println("Task not found.");
                    }
                    break;

                case 3:
                    System.out.println("Tasks:");
                    taskList.traverseTasks();
                    break;

                case 4:
                    System.out.print("Enter task ID to delete: ");
                    int deleteId = scanner.nextInt();
                    taskList.deleteTask(deleteId);
                    break;

                case -1:
                    System.out.println("Thank you.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Incorrect choice. Please try again.");
                    break;
            }
        }
    }
}