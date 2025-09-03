public class Complaint {
    private String studentId;
    private String studentName;
    private String complaintText;

    public Complaint(String studentId, String studentName, String complaintText) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.complaintText = complaintText;
    }


    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getComplaintText() {
        return complaintText;
    }

    public void setComplaintText(String complaintText) {
        this.complaintText = complaintText;
    }
}
