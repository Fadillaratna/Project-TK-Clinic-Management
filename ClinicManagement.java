
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ClinicManagement {
    private List<Doctor> doctors;
    private List<Service> services;
    private static int counterDoctors = 1;
    private static int counterServices = 1;

    public ClinicManagement() {
        doctors = new ArrayList<>();
        services = new ArrayList<>();
    }

    private static String getCurrentDate() {
        LocalDate now = LocalDate.now();
        DateTimeFormatter myformat = DateTimeFormatter.ofPattern("yyyyMMdd");
        return now.format(myformat);
    }

    private static String generateId(String type) {
        String dateNow = getCurrentDate();

        switch (type) {
            case "doctor":
                return dateNow + "DOC" + String.format("%04d", counterDoctors++);
            case "service":
                return dateNow + "SVC" + String.format("%04d", counterServices++);
            default:
                throw new AssertionError();
        }
    }

    public void addDoctor(String name, String specialization) {
        Doctor foundedDoctor = findDoctorByNameAndSpecialization(name, specialization);
        if (foundedDoctor != null) {
            System.out.println("Doctor already registered!");
        } else {
            String id = generateId("doctor");

            Doctor newDoctor = new Doctor(id, name, specialization);
            doctors.add(newDoctor);

            System.out.println("Doctor registered successfully!");
        }
    }

    public void displayDoctors() {
        System.out.println("List of Doctors:");
        if (!(doctors.isEmpty())) {
            for (int i = 1; i <= doctors.size(); i++) {
                System.out.println("Doctor#" + i);
                System.out.println(doctors.get(i - 1) + "\n");
            }
        } else {
            System.out.println("No data available.");
        }
    }

    public void displayDoctorServices(String doctorId) {
        Doctor foundedDoctor = findDoctorById(doctorId);

        if (foundedDoctor != null) {
            if (foundedDoctor.hasService()) {
                foundedDoctor.displayServices();
            } else {
                System.out.println("No services offered by doctor with ID " + doctorId);
            }
        }else{
            System.out.println("Doctor not found!");
        }
    }

    public void addServiceToDoctor(String idDoctor, String serviceName, double servicePrice) {
        Doctor foundedDoctor = findDoctorById(idDoctor);
        if (foundedDoctor != null) {
            if (foundedDoctor.hasServiceWithName(serviceName)) {
                System.out.println("Doctor with ID " + idDoctor + " already has service " + serviceName);
            } else {
                String id = generateId("service");

                Service newService = new Service(id, serviceName, servicePrice);
                foundedDoctor.addService(newService);
                System.out.println("Doctor's Service registered successfully!");
            }
        } else {
            System.out.println("Doctor not found!");
        }
    }

    public void displayAllServices() {
        boolean anyServicesAvailable = false;

        for (Doctor doctor : doctors) {
            if (!doctor.getServices().isEmpty()) {
                anyServicesAvailable = true;
                break;
            }
        }

        if (!anyServicesAvailable) {
            System.out.println("No services offered by any doctor");
        } else {
            for (Doctor doctor : doctors) {
                doctor.displayServices();
            }
        }
    }

    public Doctor findDoctorById(String id) {
        for (Doctor doctor : doctors) {
            if (doctor.getId().equals(id)) {
                return doctor;
            }
        }
        return null;
    }

    public Doctor findDoctorByNameAndSpecialization(String name, String specialization) {
        for (Doctor doctor : doctors) {
            if (doctor.getName().equalsIgnoreCase(name)
                    && doctor.getSpecialization().equalsIgnoreCase(specialization)) {
                return doctor;
            }
        }
        return null;
    }
}
