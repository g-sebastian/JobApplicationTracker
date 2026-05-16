public class JobApplication {
    private String company;
    private String position;
    private String location;
    private String jobLink;
    private String applicationDate;
    private String status;
    private String notes;


    public JobApplication(String company, String position, String location, String jobLink, String applicationDate, String status, String notes) {
        this.company = company;
        this.position = position;
        this.location = location;
        this.jobLink = jobLink;
        this.applicationDate = applicationDate;
        this.status = status;
        this.notes = notes;
    }
}
