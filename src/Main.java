import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    private static ArrayList<JobApplication> applicationsList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static int nextId = 0;

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            showMenu();

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addApplication();
                case 2 -> viewAllApplications();
                case 3 -> System.out.println("noch nicht implementiert");
                case 4 -> System.out.println("noch nicht implementiert");
                case 5 -> System.out.println("noch nicht implementiert");
                case 6 -> System.out.println("noch nicht implementiert");
                case 7 -> System.out.println("noch nicht implementiert");
                default -> System.out.println("Invalid option. Please try again.");

            }
        }
    }

    private static void viewAllApplications() {
        System.out.println("----------------------------");
        System.out.println("     ALL APPLICATIONS       ");
        System.out.println("----------------------------");

        if(applicationsList.isEmpty()){
            System.out.println("No applications found.");
        } else {
            for (JobApplication application : applicationsList){
                application.displayApplication();
            }
        }
    }

    private static void addApplication() {
        System.out.println("-------------------------------------------------");
        System.out.println("               ADD NEW APPLICATION");
        System.out.println("-------------------------------------------------");

        System.out.println("Company name: ");
        String company = scanner.nextLine();

        System.out.println("Position title: ");
        String position = scanner.nextLine();

        System.out.println("Location: ");
        String location = scanner.nextLine();

        System.out.println("Job link: ");
        String jobLink = scanner.nextLine();

        System.out.println("Application Date: ");
        String applicationDate = scanner.nextLine();

        System.out.println("Status: ");
        String status = scanner.nextLine();

        System.out.println("Notes: ");
        String notes = scanner.nextLine();

        JobApplication newJobApplication = new JobApplication(nextId,company,position,location,jobLink,applicationDate,status,notes);
        applicationsList.add(newJobApplication);
        nextId++;

        System.out.println("Application added successfully!");

    }

    public static void showMenu() {
        System.out.println("====================================================");
        System.out.println("              JOB APPLICATION TRACKER               ");
        System.out.println("====================================================");
        System.out.println();
        System.out.println();
        System.out.println("[1] Add new application");
        System.out.println("[2] View all applications");
        System.out.println("[3] Update application status");
        System.out.println("[4] Edit application");
        System.out.println("[5] Delete application");
        System.out.println("[6] View statistics");
        System.out.println("[7] Save and exit");

        System.out.println();
        System.out.println();
        System.out.println("Please choose an option:");
    }
}