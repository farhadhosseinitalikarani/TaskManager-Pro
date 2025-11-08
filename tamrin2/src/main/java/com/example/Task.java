import java.time.*;

public abstract class Task {
    protected String title;
    protected String description;
    protected LocalDate duedate;
    protected TaskPriority priority;
    protected TaskStatus status;
    protected LocalDateTime created;

    public Task(String title, String description, LocalDate duedate, TaskPriority priority) {
        this.title = title;
        this.description = description;
        this.duedate = duedate;
        this.priority = priority;
        this.status = TaskStatus.PENDING;
        this.created = LocalDateTime.now();
    }

    public abstract void displydetials();

    public void markascomplete() {
        this.status = TaskStatus.COMPLETED;

    }

    public boolean isoverdue() {

        if (duedate == null) {
            return false;
        }

        return LocalDate.now().isAfter(duedate) && status != TaskStatus.COMPLETED;
    }

    public void edit(String newtitle, String newdescription, LocalDate newduedate, TaskPriority newpriority) {
        this.title = newtitle;
        this.description = newdescription;
        this.duedate = newduedate;
        this.priority = newpriority;
    }

    public void displysummary() {
        System.out.println(
                "title" + title + "| priority = " + priority + "| status = " + status + "| Due = " + duedate + "\n");

    }

    TaskStatus getstatus() {
        return this.status;
    }

    public String gettitle() {
        return this.title;
    }

}