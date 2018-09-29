package davidrowantechnologies.medibuddy4;

import java.util.ArrayList;

/**
 * Created by inspi on 1/28/2017.
 */

public class FakeDatabase {
    ArrayList<Medicine> medlist = new ArrayList<Medicine>();
    public FakeDatabase(){
        addValues();
    }
    public void addValues(){
        Medicine Brisk = new Medicine();
        Medicine Pepsi = new Medicine();
        Medicine Mist = new Medicine();
        Brisk.setBarcode("012000202384");
        Brisk.setAmount("30");
        Brisk.setInteract("Pepsi");
        Brisk.setDosage("1 L");
        Brisk.setName("Brisk");
        Brisk.setSideEffects("Sugar Rush");
        Pepsi.setBarcode("01201303");
        Pepsi.setAmount("20");
        Pepsi.setSideEffects("Sugar Rush, Diabetes");
        Pepsi.setName("Pepsi");
        Pepsi.setInteract("Brisk");
        Pepsi.setDosage("12 oz");
        Mist.setBarcode("012000150135");
        Mist.setName("Mist");
        Mist.setInteract("Pepsi");
        Mist.setDosage("8oz");
        Mist.setSideEffects("Cancer");
        Mist.setAmount("15");
        medlist.add(Pepsi);
        medlist.add(Brisk);
        medlist.add(Mist);
    }
    public Medicine checkMed(String barcode){
        @SuppressWarnings("UnusedAssignment") boolean found = false;
        for (int x =0;x<medlist.size();x++){
            Medicine temp = medlist.get(x);
            if(temp.getBarcode().equals(barcode)){
                System.out.println("Found the Medicine");
                return temp;
            }
            System.out.println("Looped");
        }

        System.out.println("No information found!! No Meds in the database***************");
        return null;
    }



}
