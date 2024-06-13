import java.util.ArrayList;
import java.util.List;

public class Doctor {
    private String id;
    private String name;
    private String specialization;
    private List<Service> services;

    public Doctor(String id, String name, String specialization) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
        this.services = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public List<Service> getServices() {
        return services;
    }

    public void addService(Service service) {
        services.add(service);
    }

    public boolean hasServiceWithName(String serviceName) {
        for (Service service : services) {
            if (service.getName().equalsIgnoreCase(serviceName)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasService() {
        return !services.isEmpty();
    }

    @Override
    public String toString() {
        return "ID: " + id + "\nName: " + name + "\nSpecialization: " + specialization;
    }

    public void displayServices() {
        if (services != null) {
            System.out.println("Services offered by Dr. " + name + ":");
            for (Service service : services) {
                System.out.println("- " + service.getName() + " (" + service.getPrice() + ")");
            }
        } else {

        }
    }

}
