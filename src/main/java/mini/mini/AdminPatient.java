package mini.mini;

// AdminPatient class represents information about a patient from an administrative perspective
public class AdminPatient  {

    private int patient_id; // Unique identifier for the patient

    // Fields to store patient information
    String name; // Name of the patient
    String dob; // Date of birth of the patient

    String bloodgroup; // Blood group of the patient
    String phone_number; // Phone number of the patient

    String email_id; // Email ID of the patient
    String address; // Address of the patient

    byte[] report; // Medical report of the patient

    String request_date; // Date of the patient's request

    private boolean reportOpened; // Flag indicating if the medical report has been opened

    // Getter method for the reportOpened flag
    public boolean isReportOpened() {
        return reportOpened;
    }

    // Setter method for the reportOpened flag
    public void setReportOpened(boolean reportOpened) {
        this.reportOpened = reportOpened;
    }

    // Constructor to initialize the AdminPatient object with the provided information
    public AdminPatient(int patient_id,String name, String dob, String bloodgroup, String phone_number,String email_id, String address, byte[] report, String request_date) {
        this.name = name;
        this.dob = dob;
        this.bloodgroup = bloodgroup;
        this.phone_number = phone_number;
        this.email_id = email_id;
        this.address = address;
        this.report = report;
        this.patient_id=patient_id;
        this.reportOpened=reportOpened;
        this.request_date=request_date;
    }

    // Getter method for the patient's ID
    public int getId() {
        return patient_id;
    }

    // Setter method for the patient's ID
    public void setId(int id) {
        this.patient_id = id;
    }

    // Getter method for the patient's name
    public String getName() {
        return name;
    }

    // Setter method for the patient's name
    public void setName(String name) {
        this.name = name;
    }

    // Getter method for the patient's date of birth
    public String getDob() {
        return dob;
    }

    // Setter method for the patient's date of birth
    public void setDob(String dob) {
        this.dob = dob;
    }

    // Getter method for the patient's blood group
    public String getBloodgroup() {
        return bloodgroup;
    }

    // Setter method for the patient's blood group
    public void setBloodgroup(String bloodgroup) {
        this.bloodgroup = bloodgroup;
    }

    // Getter method for the patient's phone number
    public String getPhone_number() {
        return phone_number;
    }

    // Setter method for the patient's phone number
    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    // Getter method for the patient's email ID
    public String getEmail_id() {
        return email_id;
    }

    // Setter method for the patient's email ID
    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    // Getter method for the patient's address
    public String getAddress() {
        return address;
    }

    // Setter method for the patient's address
    public void setAddress(String address) {
        this.address = address;
    }

    // Getter method for the patient's medical report
    public byte[] getReport() {
        return report;
    }

    // Setter method for the patient's medical report
    public void setReport(byte[] report) {
        this.report = report;
    }

    // Getter method for the patient's ID
    public int getPatient_id() {
        return patient_id;
    }

    // Setter method for the patient's ID
    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    // Getter method for the date of the patient's request
    public String getRequest_date() {
        return request_date;
    }

    // Setter method for the date of the patient's request
    public void setRequest_date(String request_date) {
        this.request_date = request_date;
    }
}
