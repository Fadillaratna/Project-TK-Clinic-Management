import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Transaction {
    private String id;
    private Appointment appointment;
    private List<TransactionDetail> transactionDetails;
    private double totalPayment;
    private double totalReturn;

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

    public double getTotalPayment() {
        return totalPayment;
    }

    public double getTotalReturn() {
        return totalReturn;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public void setTransactionDetails(List<TransactionDetail> transactionDetails) {
        this.transactionDetails = transactionDetails;
    }

    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }

    public void setTotalReturn(double totalReturn) {
        this.totalReturn = totalReturn;
    }

    public void addTransactionDetail(TransactionDetail transactionDetail) {
        transactionDetails.add(transactionDetail);
    }

    public double calculateTotalTransaction() {
        double total = 0;
        for (TransactionDetail detail : transactionDetails) {
            total += detail.getPrice();
        }

        return total;
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

        if (totalPayment != 0.0 && !Double.isNaN(totalPayment)) {
            System.out.printf("| %-30s | %-20s |%n", "Total Payment", "Rp " + totalPayment);
            System.out.printf("| %-30s | %-20s |%n", "Total Return", "Rp " + totalReturn);
            System.out.printf("---------------------------------------------------------%n");
        } else {
            System.out.printf("---------------------------------------------------------%n");
        }
    }
}
