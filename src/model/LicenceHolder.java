package model;


public class LicenceHolder
{
    private int id;

    private String regNumber;

    private String firstName;

    private String lastName;

    private int penaltyPoint;

    public LicenceHolder() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPenaltyPoint() {
        return penaltyPoint;
    }

    public void setPenaltyPoint(int penaltyPoint) {
        this.penaltyPoint = penaltyPoint;
    }
}
