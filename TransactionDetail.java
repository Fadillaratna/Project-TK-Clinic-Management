import java.io.PrintStream;

public class TransactionDetail {
    private String id;
    private Service service;
    private double price;

    public TransactionDetail(String id, Service service, double price) {
        this.id = id;
        this.service = service;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public Service getService() {
        return service;
    }

    public double getPrice() {
        return price;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public PrintStream toPrintStream() {
        return System.out.printf("| %-30s | %-20s |%n", service.getName(), "Rp " + price);
    }
}
