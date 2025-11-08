import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== Task Manager ====");
            System.out.println("1. Add Project");
            System.out.println("2. Show All Projects");
            System.out.println("3. Remove Project");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");

            int choice;
            try {
                choice = Integer.parseInt(input.nextLine().trim());
            } catch (Exception e) {
                System.out.println("Invalid input. Try again.");
                continue;
            }

            switch (choice) {
                case 1:
                    manager.addProject();
                    break;
                case 2:
                    manager.showallprojects();
                    break;
                case 3:
                    manager.removeproject();
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
