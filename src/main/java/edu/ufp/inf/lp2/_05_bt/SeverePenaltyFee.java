package edu.ufp.inf.lp2._05_bt;

import edu.ufp.inf.lp2._01_intro.Date;

public class SeverePenaltyFee extends PenaltyFee{
    public static String PARKING_VIOLATION;

    public String PROIBITION_ON_OVERTAKE;

    public SeverePenaltyFee(String m, String l, Date d, Driver dr, Vehicle v) throws InvalidPenaltyFeeReasonException {
        super(m,l,d,dr,v);
        if(m.equals(PARKING_VIOLATION)){
            throw new InvalidPenaltyFeeReasonException("MOTIVE NOT CORRECT!");
        }
    }

    public SeverePenaltyFee(java.util.Date d2, String dormirAoVolante, String porto, Driver c1, Vehicle v1) {
        super(d2,dormirAoVolante,porto,c1,v1);
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
