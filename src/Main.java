import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;


public class Main {
    private static ArrayList<JobApplication> applicationsList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static int nextId = 0;
    private static FileManager fileManager = new FileManager();

    public static void main(String[] args) {
        boolean running = true;
        fileManager.loadApplications(applicationsList);

        while (running) {
            showMenu();

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addApplication();
                case 2 -> viewAllApplications();
                case 3 -> updateApplicationStatus();
                case 4 -> editApplication();
                case 5 -> deleteApplication();
                case 6 -> viewStatistics();
                case 7 -> fileManager.saveApplications(applicationsList);
                default -> System.out.println("Invalid option. Please try again.");

            }
        }
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

    private static void viewStatistics() {
    }

    private static void deleteApplication() {
        System.out.println("----------------------------");
        System.out.println("     DELETE APPLICATION     ");
        System.out.println("----------------------------");

        if(applicationsList.isEmpty()){
            System.out.println("No applications found.");
        } else {
            for (JobApplication application : applicationsList){
                application.displayReduced();
            }
        }
        System.out.println("Please enter the id of the application you want to edit!");
        int idToDelete = scanner.nextInt();
        System.out.println("Are you sure you want to delete id: " + idToDelete + "? Y/N");
        String input = scanner.nextLine().toUpperCase(Locale.ROOT);
        if(input.equals("Y")){
            applicationsList.remove(idToDelete);
            System.out.println("Application with the id: " + idToDelete + " successfully deleted!");
        } else if (input.equals("N")) {
            System.out.println("Deletion of application with id: " + idToDelete + " cancelled.");
        } else {
            System.out.println("Invalid Input please try again!");
        }

    }

    private static void editApplication() {
        System.out.println("----------------------------");
        System.out.println("      EDIT APPLICATION      ");
        System.out.println("----------------------------");

        if(applicationsList.isEmpty()){
            System.out.println("No applications found.");
        } else {
            for (JobApplication application : applicationsList){
                application.displayReduced();
            }
        }
        System.out.println("Please enter the id of the application you want to edit!");
        int idToEdit = scanner.nextInt();

        JobApplication job = applicationsList.get(idToEdit);

        System.out.println();
        System.out.println("What do you want to edit?");
        System.out.println("[1] Company name");
        System.out.println("[2] Position title");
        System.out.println("[3] Location");
        System.out.println("[4] Job link");
        System.out.println("[5] Application Date");
        System.out.println("[6] Status");
        System.out.println("[7] Notes");
        System.out.println();
        System.out.println("Please enter the option you want to edit: ");
        int option = scanner.nextInt();

        System.out.println();
        System.out.println("Please enter the updated version: ");
        String update = scanner.nextLine();

        switch (option){
            case 1 -> job.setCompany(update);
            case 2 -> job.setPosition(update);
            case 3 -> job.setLocation(update);
            case 4 -> job.setJobLink(update);
            case 5 -> job.setApplicationDate(update);
            case 6 -> job.setStatus(update);
            case 7 -> job.setNotes(update);
            default -> System.out.println("Invalid choice, please try again!");
        }
    }

    private static void updateApplicationStatus() {
        System.out.println("----------------------------");
        System.out.println(" UPDATE APPLICATION STATUS  ");
        System.out.println("----------------------------");

        if(applicationsList.isEmpty()){
            System.out.println("No applications found.");
        } else {
            for (JobApplication application : applicationsList){
                application.displayReduced();
            }
        }
        System.out.println("Please enter the id of the application status you want to edit!");
        int idToEdit = scanner.nextInt();

        JobApplication job = applicationsList.get(idToEdit);

        System.out.println();
        System.out.println("Enter the new status: ");
        String newStatus = scanner.nextLine();

        job.setStatus(newStatus);

        System.out.println();
        System.out.println("Status successfully changed to: " + newStatus);
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
}