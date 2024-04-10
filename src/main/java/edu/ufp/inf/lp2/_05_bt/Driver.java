package edu.ufp.inf.lp2._05_bt;

public class Driver {

    private String name;
    private int numPenalties;
    private String driversLicense;
    private boolean isLicenseApprenhended;

    private int points;

    public Driver(String name, int numPenalties, String driversLicense, boolean isLicenseApprenhended, int points){
        this.name = name;
        this.numPenalties = numPenalties;
        this.driversLicense = driversLicense;
        this.isLicenseApprenhended = isLicenseApprenhended;
        this.points = points;
    }

    private Driver(String name, String licenseNumber){

        this.name = name;
    }

    private void addPoints(int points){

    }

}
