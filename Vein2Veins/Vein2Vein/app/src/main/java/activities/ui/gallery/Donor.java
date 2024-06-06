package activities.ui.gallery;

import android.widget.EditText;

public class Donor {

    String donorId;
    String donorName;
    String donorSurname;
    String donorDOB;
    String donorGender;
    String donorEmail;
    String donorMobile;
    String donorBloodGroup;
    String donorAddress;
    String donorLastDate;

    public Donor(String donorId, String donorName, String donorSurname, String donorDOB, String donorGender, String donorEmail, String donorMobile, String donorBloodGroup, String donorAddress, String donorLastDate)
    {
        this.donorId = donorId;
        this.donorName = donorName;
        this.donorSurname = donorSurname;
        this.donorDOB = donorDOB;
        this.donorGender = donorGender;
        this.donorEmail = donorEmail;
        this.donorMobile = donorMobile;
        this.donorBloodGroup = donorBloodGroup;
        this.donorAddress = donorAddress;
        this.donorLastDate = donorLastDate;
    }

    public String getDonorId() {
        return donorId;
    }

    public String getDonorName() {
        return donorName;
    }

    public String getDonorSurname() {
        return donorSurname;
    }

    public String getDonorDOB() {
        return donorDOB;
    }

    public String getDonorGender() {
        return donorGender;
    }

    public String getDonorEmail() {
        return donorEmail;
    }

    public String getDonorMobile() {
        return donorMobile;
    }

    public String getDonorBloodGroup() {
        return donorBloodGroup;
    }

    public String getDonorAddress() {
        return donorAddress;
    }

    public String getDonorLastDate() {
        return donorLastDate;
    }
}
