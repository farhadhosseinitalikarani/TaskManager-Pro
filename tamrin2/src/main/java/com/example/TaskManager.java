import java.util.*;
import java.time.*;

public class TaskManager {
    private ArrayList<Project> projects;
    private Scanner input;

    public TaskManager() {
        projects = new ArrayList<Project>();
        input = new Scanner(System.in);
    }

    public void addProject() {
        System.out.println("enter your project name :");
        String name = input.nextLine();
        System.out.println("enter your project description :");
        String des = input.nextLine();

        Project p = new Project(name, des);
        projects.add(p);
    }

    public Project findproject(String name) {
        for (Project p : projects) {
            if (p.getname().equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }

    public void removeproject() {
        System.out.println("enter name for removeproject");
        String name = input.nextLine();
        Project find = findproject(name);

        if (find != null) {
            projects.remove(find);
            System.out.println("successfully remove..");
        } else {
            System.out.println("not found..");
        }
    }

    public void showallprojects() {
        if (projects.isEmpty()) {
            System.out.println(" No projects yet!");
            return;
        }

        System.out.println("\n All Projects:");
        for (Project p : projects) {
            p.displayprojectdetails();
        }
    }

}