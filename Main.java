
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ClinicManagement clinic = new ClinicManagement();

    public static void main(String[] args) {

        while (true) {
            System.out.println("\nClinic Management System");
            System.out.println("1. Add Doctor");
            System.out.println("2. View Doctors");
            System.out.println("3. Add Doctor's Service");
            System.out.println("4. View Doctor's Services");
            System.out.println("5. View All Services");
            System.out.print("Input [0:EXIT]: ");

            int selectionMenu = scanner.nextInt();
            scanner.nextLine();

            switch (selectionMenu) {
                case 0:
                    exitApplication();
                    break;
                case 1:
                    System.out.print("Enter doctor's name: ");
                    String doctorName = scanner.nextLine();

                    System.out.print("Enter doctor's specialization: ");
                    String doctorSpecialization = scanner.nextLine();

                    clinic.addDoctor(doctorName, doctorSpecialization);
                    break;

                case 2:
                    clinic.displayDoctors();
                    break;

                case 3:
                    System.out.print("Enter doctor's id: ");
                    String idDoctor = scanner.nextLine();

                    Doctor foundedDoctor = clinic.findDoctorById(idDoctor);
                    if (foundedDoctor != null) {
                        System.out.print("Enter service's name: ");
                        String serviceName = scanner.nextLine();

                        System.out.print("Enter service's price: ");
                        double price = scanner.nextDouble();
                        scanner.nextLine(); // consume newline

                        clinic.addServiceToDoctor(idDoctor, serviceName, price);
                    } else {
                        System.out.println("Doctor not found!");
                    }
                    break;

                case 4:
                    System.out.print("Enter doctor's id: ");
                    String idDoctorToDisplayService = scanner.nextLine();

                    clinic.displayDoctorServices(idDoctorToDisplayService);
                    break;

                case 5:
                    clinic.displayAllServices();
                    break;

                default:
                    System.out.println("Invalid menu code. Please enter a valid menu code!");
            }
        }
    }
    
    public static void exitApplication() {
        System.out.println("Exiting the program. Thank you!");
        System.exit(0);

    }
}
