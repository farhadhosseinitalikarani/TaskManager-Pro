import java.util.*;

public class Project {
    private String name;
    private String description;
    private ArrayList<Task> tasks;

    public Project(String name, String des) {
        this.name = name;
        this.description = des;
        this.tasks = new ArrayList<Task>();
    }

    public void addTask(Task task) {
        if (task == null) {
            System.out.println("cannot add a null task");
            return;
        }
        tasks.add(task);
        System.out.println("add to project");

    }

    public void removeTask(String title) {
        if (title == null) {
            System.out.println("Invalid task title");
            return;
        }

        String target = title.trim();
        boolean f = false;

        for (int i = 0; i < tasks.size(); i++) {
            Task t = tasks.get(i);

            if (t.gettitle().equalsIgnoreCase(target)) {
                f = true;
                tasks.remove(i);
                System.out.println("task " + target + " removed successfully");
                break;
            }
        }
        if (!f) {
            System.out.println("Task not found");
        }
    }

    public double getcompletionrate() {
        if (tasks.isEmpty()) {
            return 0;
        }

        int c = 0;
        for (Task t : tasks) {
            if (t.getstatus() == TaskStatus.COMPLETED) {
                c++;
            }
        }

        return c * 100 / tasks.size();
    }

    public void displayprojectdetails() {
        System.out.println(" Project: " + name);
        System.out.println(" Description: " + description);
        System.out.println(" Completion: " + String.format("%.1f", getcompletionrate()) + "%");
        System.out.println(" Total Tasks: " + tasks.size());
        System.out.println("--------------------------------------");
    }

    public void showallTask() {
        if (tasks.isEmpty()) {
            System.out.println(" No tasks in this project yet.");
            return;
        }

        System.out.println(" All tasks for project: " + name);
        System.out.println("--------------------------------------");
        for (Task task : tasks) {
            task.displysummary();
        }
        System.out.println("--------------------------------------");
    }

    public String getname() {
        return this.name;
    }

    public ArrayList<Task> getTask() {
        return tasks;
    }

}