import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.StreamSupport;


public class Main {
    private static ArrayList<JobApplication> applicationsList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static int nextId = 0;
    private static FileManager fileManager = new FileManager();

    public static void main(String[] args) {
        boolean running = true;
        fileManager.loadApplications(applicationsList);
        updateIds();
        nextId = applicationsList.size(); // anpassen dass nächster Index richtig ist

        while (running) {
            showMenu();

            String choice = scanner.nextLine();
            int choiceInt = -1;
            try{
                choiceInt = Integer.parseInt(choice);
            } catch (NumberFormatException e) {

            }
            if (choiceInt < 1 || choiceInt > 7){
                System.out.println("Invalid choice, please try again!");
                showMenu();
            }
            switch (choiceInt) {
                case 1 -> addApplication();
                case 2 -> viewAllApplications();
                case 3 -> updateApplicationStatus();
                case 4 -> editApplication();
                case 5 -> deleteApplication();
                case 6 -> viewStatistics();
                case 7 -> {
                    fileManager.saveApplications(applicationsList);
                    running = false;
                }
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
        System.out.println("----------------------------");
        System.out.println("          STATISTICS        ");
        System.out.println("----------------------------");

        if(applicationsList.isEmpty()){
            System.out.println("No applications found.");
            showMenu();
        }

        System.out.println("Total applications: " + applicationsList.size());
        System.out.println("Saved: " + getSaved());
        System.out.println("Applied: " + getApplied());
        System.out.println("Interview: " + getInterview());
        System.out.println("Rejected: " + getRejected());
        System.out.println("Offer: " + getOffers());


    }

    private static int getOffers() {
        int counter = 0;
        for (JobApplication application : applicationsList) {
            if(application.getStatus().equals("Offer")){
                counter++;
            }
        }
        return counter;
    }

    private static int getRejected() {
        int counter = 0;
        for (JobApplication application : applicationsList) {
            if(application.getStatus().equals("Rejected")){
                counter++;
            }
        }
        return counter;
    }

    private static int getInterview() {
        int counter = 0;
        for (JobApplication application : applicationsList) {
            if(application.getStatus().equals("Interview")){
                counter++;
            }
        }
        return counter;
    }

    private static int getApplied() {
        int counter = 0;
        for (JobApplication application : applicationsList) {
            if(application.getStatus().equals("Applied")){
                counter++;
            }
        }
        return counter;
    }

    private static int getSaved() {
        int counter = 0;
        for (JobApplication application : applicationsList) {
            if(application.getStatus().equals("Saved")){
                counter++;
            }
        }
        return counter;
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
        System.out.println("Please enter the id of the application you want to delete!");
        String idToDelete = scanner.nextLine();
        int idDelete = -1;
        try {
            idDelete = Integer.parseInt(idToDelete);
        } catch (NumberFormatException e) {

        }
        if(idDelete == -1 || idDelete >= applicationsList.size()){
            System.out.println("Invalid Input please try again!");
            return;
        }
        System.out.println("Are you sure you want to delete id: " + idToDelete + "? Y/N");
        String input = scanner.nextLine().toUpperCase(Locale.ROOT);
        if(input.equals("Y")){
            applicationsList.remove(idDelete);
            System.out.println("Application with the id: " + idToDelete + " successfully deleted!");
        } else if (input.equals("N")) {
            System.out.println("Deletion of application with id: " + idToDelete + " cancelled.");
        } else {
            System.out.println("Invalid Input please try again!");
        }
        updateIds();
        nextId = applicationsList.size();

    }

    private static void updateIds() {
        for (int i = 0; i < applicationsList.size(); i++) {
            applicationsList.get(i).setId(i);
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
        String idToEdit = scanner.nextLine();
        int idEdit = -1;
        try {
            idEdit = Integer.parseInt(idToEdit);
        } catch (NumberFormatException e) {
        }
        if(idEdit == -1 || idEdit >= applicationsList.size()){
            System.out.println("Invalid choice, please try again!");
            return;
        }

        JobApplication job = applicationsList.get(idEdit);

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
        String option = scanner.nextLine();
        int optionInt = -1;
        try {
            optionInt = Integer.parseInt(option);
        } catch (NumberFormatException e) {

        }

        if(optionInt < 1 || optionInt > 7){
            System.out.println("Invalid choice, please try again!");
            return;
        }

        if(optionInt == 6) {
            updateApplicationStatus();
            return;
        }

        System.out.println();
        System.out.println("Please enter the updated version: ");
        String update = scanner.nextLine();

        switch (optionInt){
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
        String idToEdit = scanner.nextLine();
        int idEditInt = -1;
        try {
            idEditInt = Integer.parseInt(idToEdit);
        } catch (NumberFormatException e){

        }
        if(idEditInt < 0 || idEditInt >= applicationsList.size()){
            System.out.println("Invalid choice, please try again!");
            return;
        }

        JobApplication job = applicationsList.get(idEditInt);

        System.out.println();
        System.out.println("Enter the new status: ");
        System.out.println("[1] Saved");
        System.out.println("[2] Applied");
        System.out.println("[3] Interview");
        System.out.println("[4] Rejected");
        System.out.println("[5] Offer");
        String newStatus = scanner.nextLine();
        int newStatusInt = -1;
        try {
            newStatusInt = Integer.parseInt(newStatus);
        } catch (NumberFormatException e) {

        }
        if(newStatusInt < 1 || newStatusInt > 5){
            System.out.println("Invalid choice, please try again!");
            return;
        }

        switch (newStatusInt){
            case 1 -> job.setStatus("Saved");
            case 2 -> job.setStatus("Applied");
            case 3 -> job.setStatus("Interview");
            case 4 -> job.setStatus("Rejected");
            case 5 -> job.setStatus("Offer");
            default -> System.out.println("Invalid choice, please try again!");
        }

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
        System.out.println("[1] Saved");
        System.out.println("[2] Applied");
        System.out.println("[3] Interview");
        System.out.println("[4] Rejected");
        System.out.println("[5] Offer");
        String newStatus = scanner.nextLine();
        String status = "";
        int newStatusInt = -1;
        try {
            newStatusInt = Integer.parseInt(newStatus);
        } catch (NumberFormatException e) {

        }
        if(newStatusInt < 1 || newStatusInt > 5){
            System.out.println("Invalid choice, please try again!");
            return;
        }

        switch (newStatusInt){
            case 1 -> status = "Saved";
            case 2 -> status = "Applied";
            case 3 -> status = "Interview";
            case 4 -> status = "Rejected";
            case 5 -> status = "Offer";
            default -> System.out.println("Invalid choice, please try again!");
        }

        System.out.println("Notes: ");
        String notes = scanner.nextLine();

        JobApplication newJobApplication = new JobApplication(nextId,company,position,location,jobLink,applicationDate,status,notes);
        applicationsList.add(newJobApplication);
        nextId++;

        System.out.println("Application added successfully!");

    }
}