import java.time.LocalDate;

public class RecurringTask extends Task {

    private int repeatintervaldays;

    public RecurringTask(String title, String description, LocalDate duedate, TaskPriority priority,
            int repeatintervaldays) {
        super(title, description, duedate, priority);
        this.repeatintervaldays = repeatintervaldays;
    }

    @Override
    public void displydetials() {
        System.out.println("┌────────────────────────────────┐");
        System.out.println("│        RECURRING TASK          │");
        System.out.println("└────────────────────────────────┘");
        System.out.println(" Title: " + title);
        System.out.println(" Description: " + description);
        System.out.println(" Priority: " + priority);
        System.out.println(" Due Date: " + duedate);
        System.out.println(" Repeat Every: " + repeatintervaldays + " days");
        System.out.println(" Status: " + status);
        System.out.println(" Created: " + created);

        if (isoverdue()) {
            System.out.println(" WARNING: This task is overdue!");
        }
        System.out.println("--------------------------------");
    }

    @Override
    public void markascomplete() {
        if (status == TaskStatus.COMPLETED) {
            System.out.println("Task alredy marked complete!");
        }
        super.markascomplete();

        duedate = duedate.plusDays(repeatintervaldays);
        status = TaskStatus.PENDING;
        System.out.println("Task reschedule for next occurence on : " + duedate);

    }

}