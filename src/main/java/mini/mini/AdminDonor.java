package mini.mini;

// AdminDonor class represents information about a donor from an administrative perspective
public class AdminDonor {

    // Fields to store donor information
    String name; // Name of the donor
    String dob; // Date of birth of the donor

    String bloodgroup; // Blood group of the donor
    String phone_number; // Phone number of the donor
    String email_id; // Email ID of the donor

    String address; // Address of the donor

    byte[] report; // Medical report of the donor

    String request_date; // Date of the donation request

    // Constructor to initialize the AdminDonor object with the provided information
    public AdminDonor(String name, String dob, String bloodgroup, String phone_number,String email_id, String address, byte[] report, String request_date) {
        this.name = name;
        this.dob = dob;
        this.bloodgroup = bloodgroup;
        this.phone_number = phone_number;
        this.email_id = email_id;
        this.address = address;
        this.report = report;
        this.request_date = request_date;
    }

    // Getter method for the donor's name
    public String getName() {
        return name;
    }

    // Setter method for the donor's name
    public void setName(String name) {
        this.name = name;
    }

    // Getter method for the donor's date of birth
    public String getDob() {
        return dob;
    }

    // Setter method for the donor's date of birth
    public void setDob(String dob) {
        this.dob = dob;
    }

    // Getter method for the donor's blood group
    public String getBloodgroup() {
        return bloodgroup;
    }

    // Setter method for the donor's blood group
    public void setBloodgroup(String bloodgroup) {
        this.bloodgroup = bloodgroup;
    }

    // Getter method for the donor's phone number
    public String getPhone_number() {
        return phone_number;
    }

    // Setter method for the donor's phone number
    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    // Getter method for the donor's email ID
    public String getEmail_id() {
        return email_id;
    }

    // Setter method for the donor's email ID
    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    // Getter method for the donor's address
    public String getAddress() {
        return address;
    }

    // Setter method for the donor's address
    public void setAddress(String address) {
        this.address = address;
    }

    // Getter method for the donor's medical report
    public byte[] getReport() {
        return report;
    }

    // Setter method for the donor's medical report
    public void setReport(byte[] report) {
        this.report = report;
    }

    // Getter method for the date of the donation request
    public String getRequest_date() {
        return request_date;
    }

    // Setter method for the date of the donation request
    public void setRequest_date(String request_date) {
        this.request_date = request_date;
    }
}
