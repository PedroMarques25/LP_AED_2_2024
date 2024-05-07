/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ufp.inf.lp2._05_bt;

import edu.ufp.inf.lp2._05_bt.*;
import org.jetbrains.annotations.NotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author rjm
 */
public class TesteBrigadaTransitoApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TransitPolice transitBrigade = new TransitPolice();
        Driver c1 = new Driver("Pedro", "P-1234");
        Vehicle v1 = new Vehicle("12-34-AB", "BMW", "S1", 4);
        PenaltyFee m1 = null;

        edu.ufp.inf.lp2._01_intro.Date now = new edu.ufp.inf.lp2._01_intro.Date(System.currentTimeMillis());
        edu.ufp.inf.lp2._01_intro.Date d1 = null;
        Date d2 = null;
        Date d3 = null;
        try {
            //d1 = new SimpleDateFormat("dd/MM/yyyy").parse("21/05/1999");
            d2 = new SimpleDateFormat("dd/MM/yyyy").parse("01/09/2000");
            d3 = new SimpleDateFormat("dd/MM/yyyy").parse("11/01/2005");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        m1 = new SeverePenaltyFee(d2, "Dormir ao volante", "Porto", c1, v1);
        System.out.println(m1.getReason());
        transitBrigade.addPenaltyFee(m1);
        System.out.println("MainTesteBT - main(): c1.getNumInfraccoes() = "+c1.getNumberPenaltyFees());
        System.out.println("Número de multas = " + transitBrigade.lookupPenaltyFees(String.valueOf(d1)).size());
        System.out.println("Número de multas (Estacionamento) = " + transitBrigade.lookupPenaltyFees(SeverePenaltyFee.PARKING_VIOLATION).size());
        PenaltyFee m2;
        m2 = new PenaltyFee(d3, "Não usar mascara", "Porto", c1, v1) {
            @Override
            public int compareTo(@NotNull PenaltyFee o) {
                return 0;
            }

            @Override
            public float value() {
                return 0;
            }

            @Override
            public int punishment() {
                return 0;
            }
        };
        transitBrigade.addPenaltyFee(m2);
        //System.out.println("Número de multas graves ou muito graves = " + transitBrigade.lookupSevereAndVerySeverePenaltyFees(SeverePenaltyFee.PARKING_VIOLATION).size());
        System.out.println("O condutor "+c1.getName()+" teve "+transitBrigade.penaltyFeesCount(c1)+" multas, cujas razões são:");
        for(String r:transitBrigade.allPenaltyFeesMotiveByDriver(c1)){
            System.out.println("-> "+r);
        }
        try {
            transitBrigade.removePenaltyFee(d3,"Porto");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Número de multas do "+c1.getName()+": "+transitBrigade.lookupPenaltyFeesDriver(c1,d1, now ).size());
    }

}
