package edu.ufp.inf.lp2._05_bt;

import edu.ufp.inf.lp2._01_intro.Date;

public abstract class PenaltyFee implements Offence,Comparable<PenaltyFee>{

    private String motive;

    private String local;

    private static final float MIN_VALUE = 0;

    private static final int MIN_PUNISHMENT = 0;

    private Date date;

    public PenaltyFee(String m, String l, Date d, Driver dr, Vehicle v) {

    }
}
