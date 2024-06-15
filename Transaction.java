import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Transaction {
    private String id;
    private Appointment appointment;
    private List<TransactionDetail> transactionDetails;

    public Transaction(String id, Appointment appointment) {
        this.id = id;
        this.appointment = appointment;
        this.transactionDetails = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public List<TransactionDetail> getTransactionDetails() {
        return transactionDetails;
    }

    public void setIdTransaction(String idTransaction) {
        this.id = idTransaction;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public void setTransactionDetails(List<TransactionDetail> transactionDetails) {
        this.transactionDetails = transactionDetails;
    }

    public void addTransactionDetail(TransactionDetail transactionDetail) {
        transactionDetails.add(transactionDetail);
    }

    public void displayTransaction() {
        System.out.println(
                "Date: " + new SimpleDateFormat("dd/MM/yyyy").format(appointment.getAppointmentDate()));
        System.out.println("---------------------------------------------------------------");
        System.out.println(appointment.getPatient());
        System.out.println("---------------------------------------------------------------");
        System.out.println(appointment.getDoctor());

        System.out.printf("---------------------------------------------------------%n");
        System.out.printf("| %-30s | %-20s |%n", "Service Name", "Price");
        System.out.printf("---------------------------------------------------------%n");

        double total = 0;
        for (TransactionDetail detail : transactionDetails) {
            total += detail.getPrice();
            detail.toPrintStream();
        }

        System.out.printf("---------------------------------------------------------%n");
        System.out.printf("| %-30s | %-20s |%n", "Total", "Rp " + total);
        System.out.printf("---------------------------------------------------------%n");
    }
}
