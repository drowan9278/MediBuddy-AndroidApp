package davidrowantechnologies.medibuddy4;

/**
 * Created by inspi on 1/28/2017.
 */

public class Medicine {
    private String Name = null;
    private String Amount= null;
    private String SideEffects=null;
    private String dosage=null;
    private String Interact=null;
    private String Barcode =null;
    public String getBarcode() {
        return Barcode;
    }

    public void setBarcode(String barcode) {
        Barcode = barcode;
    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }

    public String getSideEffects() {
        return SideEffects;
    }

    public void setSideEffects(String sideEffects) {
        SideEffects = sideEffects;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getInteract() {
        return Interact;
    }

    public void setInteract(String interact) {
        Interact = interact;
    }



}
