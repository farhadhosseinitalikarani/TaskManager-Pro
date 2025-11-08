import java.time.LocalDate;

public class SimpleTask extends Task {

    public SimpleTask(String title, String description, LocalDate duedate, TaskPriority priority) {
        super(title, description, duedate, priority);
    }

    public void displydetials() {
        System.out.println("┌──────────────────────────────┐");
        System.out.println("│         TASK DETAILS         │");
        System.out.println("└──────────────────────────────┘");
        System.out.println(" Title: " + title);
        System.out.println(" Description: " + description);
        System.out.println(" Priority: " + priority);
        System.out.println(" Due Date: " + duedate);
        System.out.println(" Status: " + status);
        System.out.println(" Created: " + created);

        if (isoverdue()) {
            System.out.println(" WARNING: This task is overdue!");
        }
        System.out.println("--------------------------------");
    }

    public void startTask() {
        if (status == TaskStatus.PENDING) {
            status = TaskStatus.IN_PROGRES;
        } else if (status == TaskStatus.IN_PROGRES) {
            System.out.println("Task is already in progress");
        } else {
            System.out.println("Task is already complected");
        }

    }

    @Override
    public void displysummary() {
        System.out.println("title" + super.title + "| priority = " + super.priority + "| status = " + status
                + "| Due = " + super.duedate + "\n");
    }

}