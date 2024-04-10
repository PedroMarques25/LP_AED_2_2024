package edu.ufp.inf.lp2._05_bt;

import edu.ufp.inf.lp2._01_intro.Date;

public class SeverePenaltyFee extends PenaltyFee{
    public static String PARKING_VIOLATION;

    public String PROIBITION_ON_OVERTAKE;

    public SeverePenaltyFee(String m, String l, Date d, Driver dr, Vehicle v) {
        super(m,l,d,dr,v);
        if(m.equals(PARKING_VIOLATION)|| m.equals(PROIBITION_ON_OVERTAKE)){
            throw new InvalidPenaltyFeeReasonException("MOTIVE NOT CORRECT!");
        }
    }

    @Override
    public float value() {
        return 0;
    }

    @Override
    public int punishment() {
        return 0;
    }

    @Override
    public int compareTo(PenaltyFee o) {
        return 0;
    }
}
