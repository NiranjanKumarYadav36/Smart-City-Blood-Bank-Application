package mini.mini;

import java.net.URL;
import java.time.LocalDate;
public class Refresh {

    String name;
    String dob;
    String bloodgroup;

//    URL report;

    public Refresh(String name, String dob, String bloodgroup) {
        this.name = name;
        this.dob = dob;
        this.bloodgroup = bloodgroup;

    }

//    public Refresh() {
//
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getBloodgroup() {
        return bloodgroup;
    }

    public void setBloodgroup(String bloodgroup) {
        this.bloodgroup = bloodgroup;
    }


}
