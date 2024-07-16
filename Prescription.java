import java.io.PrintStream;

public class Prescription {
    private String id;
    private String name;
    private int quantity; 
    private String dosage; 

    public Prescription(String id, String name, int quantity, String dosage) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.dosage = dosage;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDosage() {
        return dosage;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    @Override
    public String toString() {
        return "Medicine Name: " + name + "\nMedicine Dosage: " + dosage + "\nMedicine Qty: " + quantity;
    }

    public PrintStream toPrintStream() {
        return System.out.printf("| %-30s | %-15s | %-8s |%n", name, dosage, quantity);
    }
}
