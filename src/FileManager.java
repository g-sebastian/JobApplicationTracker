import java.io.*;
import java.util.List;

public class FileManager {
    private final String filename = "applications.csv";


    public void saveApplications(List<JobApplication> applicationList) {
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(filename);
            printWriter.println("id;company;position;location;jobLink;applicationDate;status;notes");
            for (JobApplication application : applicationList) {
                String line = "";
                line += application.getId();
                line += ";";
                line += application.getCompany();
                line += ";";
                line += application.getPosition();
                line += ";";
                line += application.getLocation();
                line += ";";
                line += application.getJobLink();
                line += ";";
                line += application.getApplicationDate();
                line += ";";
                line += application.getStatus();
                line += ";";
                line += application.getNotes();
                printWriter.println(line);
            }
            printWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error occurred while trying to save. Could not save applications.");
        }

    }

    public void loadApplications(List<JobApplication> applicationList) {
        try {
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            bufferedReader.readLine(); // header Zeile überspringen

            while(bufferedReader.ready()){
                String line = bufferedReader.readLine();
                String[] splittedLine = line.split(";");
                if(splittedLine.length == 8){
                    // hat alle Elemente
                    JobApplication jobApplication =
                            new JobApplication(Integer.parseInt(splittedLine[0]), splittedLine[1], splittedLine[2], splittedLine[3], splittedLine[4], splittedLine[5], splittedLine[6], splittedLine[7]);
                    applicationList.add(jobApplication);
                } else {
                    System.out.println("Skipped invalid line!");
                }
            }
            bufferedReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error occured while trying to read the applications.csv file.");
        } catch (IOException e) {
            System.out.println("Error occured while trying to read the applications.csv file.");
        }
    }
}
