import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String complaintFile = "complaint.txt";

        while (true) {
            System.out.println("\n1.Add Complaint");
            System.out.println("2.View Complaints");
            System.out.println("3.Delete Complaint");
            System.out.println("4.Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); 

            if (choice == 1) {
                System.out.print("Enter Student ID: ");
                String id = sc.nextLine();
                System.out.print("Enter Student Name: ");
                String name = sc.nextLine();
                System.out.print("Enter Complaint: ");
                String complaintText = sc.nextLine();

                Student s = new Student(id, name);
                Complaint c = new Complaint(s.getId(), s.getName(), complaintText);

                File file = new File(complaintFile);
                if (!file.exists()) file.createNewFile();

                FileWriter fw = new FileWriter(file, true);
                fw.write(c.getStudentId() + "," + c.getStudentName() + "," + c.getComplaintText() + "\n");
                fw.close();
                System.out.println("Complaint added!");

            } else if (choice == 2) {
                File file = new File(complaintFile);
                if (!file.exists()) {
                    System.out.println("No complaints found.");
                    continue;
                }

                BufferedReader br = new BufferedReader(new FileReader(file));
                String line;
                System.out.println("StudentID\tName\tComplaint");
                while ((line = br.readLine()) != null) {
                    System.out.println(line.replace(",", "\t"));
                }
                br.close();

            } else if (choice == 3) {
                System.out.print("Enter Student ID to delete complaint: ");
                String id = sc.nextLine();

                File file = new File(complaintFile);
                if (!file.exists()) continue;

                BufferedReader br = new BufferedReader(new FileReader(file));
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    if (!line.startsWith(id + ",")) sb.append(line).append("\n");
                }
                br.close();

                FileWriter fw = new FileWriter(file);
                fw.write(sb.toString());
                fw.close();
                System.out.println("Complaint deleted if student ID existed.");

            } else if (choice == 4) {
                System.out.println("Exiting...");
                break;

            } else {
                System.out.println("Invalid choice!");
            }
        }
    }
}
