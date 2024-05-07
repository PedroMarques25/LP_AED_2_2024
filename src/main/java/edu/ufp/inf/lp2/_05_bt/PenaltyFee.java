package edu.ufp.inf.lp2._05_bt;

import edu.ufp.inf.lp2._01_intro.Date;

public abstract class PenaltyFee implements Offence,Comparable<PenaltyFee>{

    private final Driver driver;
    private final Vehicle vehicle;
    private String motive;

    private String local;

    private static final float MIN_VALUE = 0;

    private static final int MIN_PUNISHMENT = 0;

    private Date date;

    public PenaltyFee(String m, String l, Date d, Driver dr, Vehicle v, Driver driver, Vehicle vehicle) {

        this.driver = driver;
        this.vehicle = vehicle;
    }

    public PenaltyFee(java.util.Date d3, String l, String porto, Driver c1, Vehicle v1) {
        this.date = new Date(d3);
        this.local = l;
        this.motive = porto;
        this.driver = c1;
        this.vehicle = v1;
    }

    public PenaltyFee(Date d3, String l, String porto, Driver c1, Vehicle v1, Driver driver, Vehicle vehicle) {

        this.driver = driver;
        this.vehicle = vehicle;
    }

    public PenaltyFee(Date d3, String l, String porto, Driver c1, Vehicle v1) {

        vehicle = null;
        driver = null;
    }

    public PenaltyFee(String m, String l, Date d, Driver dr, Vehicle v) {
        this.driver = dr;
        this.vehicle = v;
        this.motive = m;
        this.local = l;
        this.date = d;
    }

    public boolean getReason() {
        return false;
    }
}
