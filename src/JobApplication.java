public class JobApplication {
    private int id;
    private String company;
    private String position;
    private String location;
    private String jobLink;
    private String applicationDate;
    private String status;
    private String notes;


    public JobApplication(int id, String company, String position, String location, String jobLink, String applicationDate, String status, String notes) {
        this.id = id;
        this.company = company;
        this.position = position;
        this.location = location;
        this.jobLink = jobLink;
        this.applicationDate = applicationDate;
        this.status = status;
        this.notes = notes;
    }

    public void displayApplication() {
        System.out.println("------------------------");
        System.out.println("ID: " + id);
        System.out.println("Company: " + company);
        System.out.println("Position: " + position);
        System.out.println("Location: " + location);
        System.out.println("Job Link: " + jobLink);
        System.out.println("Application Date: " + applicationDate);
        System.out.println("Status: " + status);
        System.out.println("Notes: " + notes);
        System.out.println("------------------------");

    }

    public String getCompany() {
        return company;
    }

    public String getPosition() {
        return position;
    }

    public String getLocation() {
        return location;
    }

    public String getJobLink() {
        return jobLink;
    }

    public String getApplicationDate() {
        return applicationDate;
    }

    public String getStatus() {
        return status;
    }

    public String getNotes() {
        return notes;
    }

    public int getId() {
        return id;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void displayReduced() {
        System.out.println("------------------------");
        System.out.print("Id: " + id);
        System.out.print(" Company: " + company);
        System.out.print(" Position: " + position);
        System.out.print(" Current status: " + status);
        System.out.println("------------------------");
    }
}
