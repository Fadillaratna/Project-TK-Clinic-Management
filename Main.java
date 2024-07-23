
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ClinicManagement clinic = new ClinicManagement("Clinic Dwita", "Jl Panglima Sudirman No 11A", "(0341) 77525");

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            //add data cashierand administration staff first(hardcode)
            addDataCashier();
            addDataAdministrationStaff();

            clinic.displayAdmStaff();

            System.out.println(
                    "\n============================== Clinic Management System ==============================");
            System.out.println("Clinic Name: " + clinic.getClinic().clinicName());
            System.out.println("Address: " + clinic.getClinic().address());
            System.out.println("Contact: " + clinic.getClinic().contact());
            System.out.println("1. Doctor Menu");
            System.out.println("2. Service Menu");
            System.out.println("3. Patient Menu");
            System.out.println("4. Appointment Menu");
            System.out.println("5. Medical Record Menu");
            System.out.println("6. Prescription Menu");
            System.out.println("7. Transaction Menu");

            System.out.print("Input [0:EXIT]: ");

            int selectionMenu = scanner.nextInt();
            scanner.nextLine();
        
            running = switch (selectionMenu) {
                case 0 -> {
                    exitApplication();
                    yield false;
                }
                case 1 -> {
                    doctorMenu();
                    yield true;
                }
                case 2 -> {
                    serviceMenu();
                    yield true;
                }
                case 3 -> {
                    patientMenu();
                    yield true;
                }
                case 4 -> {
                    appointmentMenu();
                    yield true;
                }
                case 5 -> {
                    medicalRecordMenu();
                    yield true;
                }
                case 6 -> {
                    prescriptionMenu();
                    yield true;
                }
                case 7 -> {
                    transactionMenu();
                    yield true;
                }
                default -> {
                    System.out.println("Invalid menu code. Please enter a valid menu code!");
                    yield true;
                }
            };
        }
    }

    public static void addDataCashier(){
        clinic.addCashier("Iriana Dewi", "iriana@gmail.com");
        clinic.addCashier("Olivia Jane", "olivia@gmail.com");
        clinic.addCashier("Bambang Jaya", "bambang@gmail.com");
        clinic.addCashier("Aditya Putra", "aditya@gmail.com");
    }

    public static void addDataAdministrationStaff(){
        clinic.addAdmStaff("Cahya Laisya", "cahya@gmail.com");
        clinic.addAdmStaff("Syifa Ayu", "syifa@gmail.com");
        clinic.addAdmStaff("Abirama", "abirama@gmail.com");
        clinic.addAdmStaff("Arindi Putri", "arindi@gmail.com");
    }

    public static void doctorMenu() {
        while (true) {
            System.out.println(
                    "\n============================== Doctor Menu ==============================");
            System.out.println("1. Add Doctor");
            System.out.println("2. Delete Doctor");
            System.out.println("3. Update Doctor");

            System.out.println("4. View Doctors");
            System.out.print("Input [0:Back]: ");

            int selectionMenu = scanner.nextInt();
            scanner.nextLine();

            switch (selectionMenu) {
                case 0:
                    return;

                case 1:
                    System.out.print("Enter doctor name: ");
                    String doctorName = scanner.nextLine();

                    System.out.print("Enter doctor specialization: ");
                    String doctorSpecialization = scanner.nextLine();

                    clinic.addDoctor(doctorName, doctorSpecialization);
                    break;

                case 2:
                    System.out.print("Enter doctor id: ");
                    String idDoctor = scanner.nextLine();

                    clinic.deleteDoctor(idDoctor);
                    break;

                case 3:
                    System.out.print("Enter doctor id: ");
                    String idDoctorToUpdate = scanner.nextLine();

                    Doctor foundedDoctor = clinic.findDoctorById(idDoctorToUpdate);
                    if (foundedDoctor != null) {
                        System.out.print("Enter doctor name: ");
                        String newDoctorName = scanner.nextLine();

                        System.out.print("Enter doctor specialization: ");
                        String newDoctorSpecialization = scanner.nextLine();

                        clinic.updateDoctor(idDoctorToUpdate, newDoctorName, newDoctorSpecialization);
                    } else {
                        System.out.println("Data not found!");
                    }

                    break;

                case 4:
                    clinic.displayDoctors();
                    break;

                default:
                    System.out.println("Invalid menu code. Please enter a valid menu code!");
            }
        }
    }

    public static void serviceMenu() {
        while (true) {
            System.out.println(
                    "\n============================== Service Menu ==============================");
            System.out.println("1. Add Service");
            System.out.println("2. Delete Service");
            System.out.println("3. Update Service");
            System.out.println("4. View Services");
            System.out.print("Input [0:Back]: ");

            int selectionMenu = scanner.nextInt();
            scanner.nextLine();

            switch (selectionMenu) {
                case 0:
                    return;

                case 1:
                    System.out.print("Enter service name: ");
                    String serviceName = scanner.nextLine();

                    System.out.print("Enter service price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();

                    clinic.addService(serviceName, price);
                    break;

                case 2:
                    System.out.print("Enter service id: ");
                    String idService = scanner.nextLine();

                    clinic.deleteService(idService);
                    break;

                case 3:
                    System.out.print("Enter service id: ");
                    String idServiceToUpdate = scanner.nextLine();

                    Service foundedService = clinic.findServiceById(idServiceToUpdate);
                    if (foundedService != null) {
                        System.out.print("Enter new service name: ");
                        String newServiceName = scanner.nextLine();

                        System.out.print("Enter new service price: ");
                        double newServicePrice = scanner.nextDouble();
                        scanner.nextLine();

                        clinic.updateService(idServiceToUpdate, newServiceName, newServicePrice);
                    } else {
                        System.out.println("Data not found!");
                    }

                    break;

                case 4:
                    clinic.displayServices();
                    break;

                default:
                    System.out.println("Invalid menu code. Please enter a valid menu code!");
            }
        }
    }

    public static void patientMenu() {
        while (true) {
            System.out.println(
                    "\n============================== Patient Menu ==============================");
            System.out.println("1. Add Patient");
            System.out.println("2. Delete Patient");
            System.out.println("3. Update Patient");
            System.out.println("4. View Patients");
            System.out.print("Input [0:Back]: ");

            int selectionMenu = scanner.nextInt();
            scanner.nextLine();

            switch (selectionMenu) {
                case 0:
                    return;

                case 1:
                    System.out.print("Enter patient name: ");
                    String patientName = scanner.nextLine();

                    System.out.print("Enter patient gender: ");
                    String gender = scanner.nextLine();

                    System.out.print("Enter patient age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();

                    clinic.addPatient(patientName, gender, age);
                    break;

                case 2:
                    System.out.print("Enter patient id: ");
                    String idPatient = scanner.nextLine();

                    clinic.deletePatient(idPatient);
                    break;

                case 3:
                    System.out.print("Enter patient id: ");
                    String idPatientToUpdate = scanner.nextLine();

                    Patient foundedPatient = clinic.findPatientById(idPatientToUpdate);
                    if (foundedPatient != null) {
                        System.out.print("Enter new patient name: ");
                        String newPatientName = scanner.nextLine();

                        System.out.print("Enter new patient gender: ");
                        String newPatientGender = scanner.nextLine();

                        System.out.print("Enter new patient age: ");
                        int newPatientAge = scanner.nextInt();
                        scanner.nextLine();

                        clinic.updatePatient(idPatientToUpdate, newPatientName, newPatientGender, newPatientAge);
                    } else {
                        System.out.println("Data not found!");
                    }

                    break;

                case 4:
                    clinic.displayPatients();
                    break;

                default:
                    System.out.println("Invalid menu code. Please enter a valid menu code!");
            }
        }
    }

    public static void appointmentMenu() {
        while (true) {
            System.out.println(
                    "\n============================== Appointment Menu ==============================");
            System.out.println("1. Schedule Appointment");
            System.out.println("2. View Appointments");
            System.out.println("3. Search Appointments");

            System.out.print("Input [0:Back]: ");

            int selectionMenu = scanner.nextInt();
            scanner.nextLine();

            switch (selectionMenu) {
                case 0:
                    return;

                case 1:
                    clinic.displayPatients();

                    System.out.print("Enter patient id: ");
                    String idPatient = scanner.nextLine();

                    Patient foundedPatient = clinic.findPatientById(idPatient);
                    if (foundedPatient != null) {
                        clinic.displayDoctors();

                        System.out.print("Enter doctor id: ");
                        String idDoctor = scanner.nextLine();

                        Doctor foundedDoctor = clinic.findDoctorById(idDoctor);
                        if (foundedDoctor != null) {
                            System.out.print("Enter appointment date (dd/MM/yyyy): ");
                            String appointmentDateString = scanner.nextLine();

                            Date appointmentDate;
                            try {
                                appointmentDate = new SimpleDateFormat("dd/MM/yyyy").parse(appointmentDateString);
                            } catch (ParseException e) {
                                System.out.println("Format date not valid!");
                                return;
                            }

                            clinic.scheduleAppointment(idPatient, idDoctor, appointmentDate);
                        } else {
                            System.out.println("Doctor not found!");

                        }
                    } else {
                        System.out.println("Patient not found!");
                    }

                    break;

                case 2:
                    clinic.displayAppointments();
                    break;

                case 3:
                    System.out.print("Enter patient name: ");
                    String patientName = scanner.nextLine();

                    System.out.print("Enter doctor name: ");
                    String doctorName = scanner.nextLine();

                    System.out.print("Enter appointment date (dd/MM/yyyy): ");
                    String appointmentDateString = scanner.nextLine();

                    Date appointmentDate;
                    if (!(appointmentDateString.isEmpty())) {
                        try {
                            appointmentDate = new SimpleDateFormat("dd/MM/yyyy").parse(appointmentDateString);
                        } catch (ParseException e) {
                            System.out.println("Format date not valid!");
                            return;
                        }
                        clinic.searchAppointment(patientName, appointmentDate, doctorName);
                    } else {
                        clinic.searchAppointment(patientName, null, doctorName);

                    }

                    break;

                default:
                    System.out.println("Invalid menu code. Please enter a valid menu code!");
            }
        }
    }

    public static void prescriptionMenu() {
        while (true) {
            System.out.println(
                    "\n============================== Prescription Menu ==============================");
            System.out.println("1. Add Prescription");
            System.out.println("2. View Prescriptions");
            System.out.println("3. Search Prescriptions");

            System.out.print("Input [0:Back]: ");

            int selectionMenu = scanner.nextInt();
            scanner.nextLine();

            switch (selectionMenu) {
                case 0:
                    return;
                case 1:
                    clinic.displayAppointments();

                    System.out.print("Enter appointment id: ");
                    String idAppointment = scanner.nextLine();

                    Appointment foundedAppointment = clinic.findAppointmentById(idAppointment);
                    if (foundedAppointment != null) {
                        boolean addMore = true;
                        while (addMore) {
                            System.out.print("Enter medicine name: ");
                            String medicineName = scanner.nextLine();

                            System.out.print("Enter medicine quantity: ");
                            int medicineQty = scanner.nextInt();
                            scanner.nextLine();

                            System.out.print("Enter medicine dosage: ");
                            String medicineDosage = scanner.nextLine();

                            clinic.addPrescription(idAppointment, medicineName, medicineQty, medicineDosage);

                            System.out.println(
                                    "Do you want to add more recipes to the appointmend ID " + idAppointment + " ?\n");
                            System.out.print("Input [0:No] [1:Yes]: ");
                            int selectedOption = scanner.nextInt();
                            scanner.nextLine();

                            switch (selectedOption) {
                                case 0:
                                    addMore = false;
                                    break;
                                case 1:
                                    break;
                                default:
                                    System.out.println("Your selected option not valid!");
                            }
                        }
                    } else {
                        System.out.println("Appointment not found!");
                    }

                    break;

                case 2:
                    clinic.displayPrescriptions();
                    break;

                case 3:
                    System.out.print("Enter patient name: ");
                    String patientName = scanner.nextLine();

                    System.out.print("Enter appointment date (dd/MM/yyyy): ");
                    String appointmentDateString = scanner.nextLine();

                    Date appointmentDate;
                    if (!(appointmentDateString.isEmpty())) {
                        try {
                            appointmentDate = new SimpleDateFormat("dd/MM/yyyy").parse(appointmentDateString);
                        } catch (ParseException e) {
                            System.out.println("Format date not valid!");
                            return;
                        }
                        clinic.searchPrescription(patientName, appointmentDate);
                    } else {
                        clinic.searchPrescription(patientName, null);

                    }

                    break;

                default:
                    System.out.println("Invalid menu code. Please enter a valid menu code!");
            }
        }
    }

    public static void medicalRecordMenu() {
        while (true) {
            System.out.println(
                    "\n============================== Medical Record Menu ==============================");
            System.out.println("1. Add Medical Record");
            System.out.println("2. View Medical Records");
            System.out.println("3. Search Medical Records");

            System.out.print("Input [0:Back]: ");

            int selectionMenu = scanner.nextInt();
            scanner.nextLine();

            switch (selectionMenu) {
                case 0:
                    return;
                case 1:
                    clinic.displayAppointments();

                    System.out.print("Enter appointment id: ");
                    String idAppointment = scanner.nextLine();

                    Appointment foundedAppointment = clinic.findAppointmentById(idAppointment);
                    if (foundedAppointment != null) {

                        System.out.print("Enter client complaint: ");
                        String complaint = scanner.nextLine();

                        System.out.print("Enter diagnosis: ");
                        String diagnosis = scanner.nextLine();

                        clinic.addMedicalRecord(idAppointment, complaint, diagnosis);

                    } else {
                        System.out.println("Appointment not found!");
                    }

                    break;

                case 2:
                    clinic.displayMedicalRecords();
                    break;

                case 3:
                    System.out.print("Enter patient name: ");
                    String patientName = scanner.nextLine();

                    System.out.print("Enter appointment date (dd/MM/yyyy): ");
                    String appointmentDateString = scanner.nextLine();

                    Date appointmentDate;
                    if (!(appointmentDateString.isEmpty())) {
                        try {
                            appointmentDate = new SimpleDateFormat("dd/MM/yyyy").parse(appointmentDateString);
                        } catch (ParseException e) {
                            System.out.println("Format date not valid!");
                            return;
                        }
                        clinic.searchMedicalRecord(patientName, appointmentDate);
                    } else {
                        clinic.searchMedicalRecord(patientName, null);
                    }

                    break;

                default:
                    System.out.println("Invalid menu code. Please enter a valid menu code!");
            }
        }
    }

    public static void transactionMenu() {
        while (true) {
            System.out.println(
                    "\n============================== Transaction Menu ==============================");
            System.out.println("1. Add Transaction");
            System.out.println("2. View Transactions");
            System.out.println("3. Search Transactions");

            System.out.print("Input [0:Back]: ");

            int selectionMenu = scanner.nextInt();
            scanner.nextLine();

            switch (selectionMenu) {
                case 0:
                    return;
                case 1:
                    clinic.displayCashiers();
                    System.out.print("Enter Cashier ID: ");
                    String idCashier = scanner.nextLine();

                    Cashier foundedCashier = clinic.findCashierById(idCashier);
                    if(foundedCashier != null){
                        clinic.displayAppointments();

                        System.out.print("Enter appointment id: ");
                        String idAppointment = scanner.nextLine();

                        Appointment foundedAppointment = clinic.findAppointmentById(idAppointment);
                        if (foundedAppointment != null) {
                            if (!clinic.isAlreadyPaid(idAppointment)) {
                                boolean addMore = true;
                                while (addMore) {
                                    clinic.displayServices();

                                    System.out.print("Enter service id: ");
                                    String idService = scanner.nextLine();

                                    Service foundedService = clinic.findServiceById(idService);

                                    if (foundedService != null) {
                                        clinic.processTransaction(idAppointment, idService, idCashier);

                                        System.out.println(
                                                "Do you want to add more service transactions to the appointmend ID "
                                                        + idAppointment + " ?\n");
                                        System.out.print("Input [0:No] [1:Yes]: ");
                                        int selectedOption = scanner.nextInt();
                                        scanner.nextLine();

                                        switch (selectedOption) {
                                            case 0:
                                                addMore = false;
                                                boolean notPaid = true;

                                                while (notPaid) {
                                                    clinic.displayTransactonByAppointmentId(idAppointment);

                                                    System.out.print("Enter total payment: ");
                                                    double totalPayment = scanner.nextDouble();
                                                    scanner.nextLine();

                                                    Transaction transaction = clinic
                                                            .findTransactionByAppointmentId(idAppointment);

                                                    if (totalPayment >= transaction.calculateTotalTransaction()) {
                                                        clinic.payTransaction(idAppointment, totalPayment);
                                                        clinic.displayTransactonByAppointmentId(idAppointment);

                                                        notPaid = false;
                                                    } else {
                                                        System.out.println("\nTotal payment not match!\n");
                                                    }
                                                }

                                                break;
                                            case 1:
                                                break;
                                            default:
                                                System.out.println("Your selected option not valid!");
                                        }
                                    } else {
                                        System.out.println("Service not found!");
                                    }
                                }
                            }else{
                                System.out.println("\nTransaction is already registered!\n");
                            }
                        } else {
                            System.out.println("Appointment not found!");
                        }
                    }else{
                        System.out.println("Cashier not found!");
                    }

                    break;

                case 2:
                    clinic.displayTransactions();
                    break;

                case 3:
                    System.out.print("Enter patient name: ");
                    String patientName = scanner.nextLine();

                    System.out.print("Enter doctor name: ");
                    String doctorName = scanner.nextLine();

                    System.out.print("Enter appointment date (dd/MM/yyyy): ");
                    String appointmentDateString = scanner.nextLine();

                    Date appointmentDate;
                    if (!(appointmentDateString.isEmpty())) {
                        try {
                            appointmentDate = new SimpleDateFormat("dd/MM/yyyy").parse(appointmentDateString);
                        } catch (ParseException e) {
                            System.out.println("Format date not valid!");
                            return;
                        }
                        clinic.searchTransaction(patientName, appointmentDate, doctorName);
                    } else {
                        clinic.searchTransaction(patientName, null, doctorName);

                    }

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
