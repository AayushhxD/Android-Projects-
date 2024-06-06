package activities.ui.slideshow;

public class Donee {

    String doneeId;
    String doneeName;
    String doneeSurname;
    String doneeDOB;
    String doneeGender;
    String doneeBloodGroup;
    String doneeUnits;
    String doneeLocation;
    String doneeRequiredDate;
    String doneeMobile;
    String doneeHospital;
    String doneeAdditionalNote;

    public Donee(String doneeId, String doneeName, String doneeSurname, String doneeDOB, String doneeGender, String doneeBloodGroup, String doneeUnits, String doneeLocation, String doneeRequiredDate, String doneeMobile, String doneeHospital, String doneeAdditionalNote)
    {
        this.doneeId = doneeId;
        this.doneeName = doneeName;
        this.doneeSurname = doneeSurname;
        this.doneeDOB = doneeDOB;
        this.doneeGender = doneeGender;
        this.doneeBloodGroup = doneeBloodGroup;
        this.doneeUnits = doneeUnits;
        this.doneeLocation = doneeLocation;
        this.doneeRequiredDate = doneeRequiredDate;
        this.doneeMobile = doneeMobile;
        this.doneeHospital = doneeHospital;
        this.doneeAdditionalNote = doneeAdditionalNote;
    }

    public String getDoneeId() {
        return doneeId;
    }

    public String getDoneeName() {
        return doneeName;
    }

    public String getDoneeSurname() {
        return doneeSurname;
    }

    public String getDoneeDOB() {return doneeDOB; }

    public String getDoneeGender() {return doneeGender; }

    public String getDoneeBloodGroup() {return doneeBloodGroup; }

    public String getDoneeUnits() {return doneeUnits; }

    public String getDoneeLocation() {return doneeLocation; }

    public String getDoneeRequiredDate() {return doneeRequiredDate; }

    public String getDoneeMobile() {return doneeMobile; }

    public String getDoneeHospital() {return doneeHospital; }

    public String getDoneeAdditionalNote() {return doneeAdditionalNote; }
}
