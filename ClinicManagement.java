import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClinicManagement {
    private List<Doctor> doctors;
    private List<Service> services;
    private List<Patient> patients;
    private List<Appointment> appointments;
    private List<Transaction> transactions;
    private List<MedicalRecord> medicalRecords;
    private List<Cashier> cashiers;
    private List<AdministrationStaff> admStaffs;
    private Clinic clinic;

    public ClinicManagement(String clinicName, String address, String contact) {
        this.clinic = new Clinic(clinicName, address, contact);
        doctors = new ArrayList<>();
        services = new ArrayList<>();
        patients = new ArrayList<>();
        appointments = new ArrayList<>();
        medicalRecords = new ArrayList<>();
        transactions = new ArrayList<>();
        cashiers = new ArrayList<>();
        admStaffs = new ArrayList<>();
    }
    
    public Clinic getClinic() {
        return clinic;
    }
    static String generateId(IDGeneratorFunction idGenFunc) {
        return idGenFunc.generate();
    }


    // #region Doctor
    public void addDoctor(String name, String specialization) {
        Doctor foundedDoctor = findDoctorByNameAndSpecialization(name, specialization);
        if (foundedDoctor != null) {
            System.out.println("Doctor already registered!");
        } else {
            String id = generateId(IDGenerator::generateDoctorId);

            Doctor newDoctor = new Doctor(id, name, specialization);
            doctors.add(newDoctor);

            System.out.println("Doctor registered successfully!");
        }
    }

    public void deleteDoctor(String idDoctor) {
        Doctor foundedDoctor = findDoctorById(idDoctor);
        if (foundedDoctor != null) {
            doctors.remove(foundedDoctor);

            System.out.println("Doctor deleted successfully!");
        } else {
            System.out.println("Doctor not found!");
        }
    }

    public void updateDoctor(String id, String newName, String newSpecialization) {
        Doctor doctor = findDoctorById(id);
        if (doctor != null) {
            doctor.setName(newName);
            doctor.setSpecialization(newSpecialization);
            System.out.println("Doctor updated successfully!");
        } else {
            System.out.println("Doctor not found!");
        }
    }

    public void displayDoctors() {
        if (!(doctors.isEmpty())) {
            System.out.println("\nList of Doctors:");
            for (int i = 1; i <= doctors.size(); i++) {
                System.out.println("Doctor#" + i);
                System.out.println(doctors.get(i - 1) + "\n");
            }
        } else {
            System.out.println("No doctor available.");
        }
    }

    public Doctor findDoctorById(String id) {
        return doctors.stream()
                .filter(doctor -> doctor.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Doctor findDoctorByNameAndSpecialization(String name, String specialization) {
        return doctors.stream()
                .filter(doctor -> doctor.getName().equals(name) && doctor.getSpecialization().equals(specialization))
                .findFirst()
                .orElse(null);
    }
    // #endregion

    // #region Service
    public void addService(String serviceName, double servicePrice) {
        Service service = findServiceByName(serviceName);
        if (service != null) {
            System.out.println("Service with Name " + serviceName + "already registered!");
        } else {
            String id = generateId(IDGenerator::generateServiceId);

            Service newService = new Service(id, serviceName, servicePrice);
            services.add(newService);

            System.out.println("Service registered successfully!");

        }
    }

    public void deleteService(String idService) {
        Service foundedService = findServiceById(idService);
        if (foundedService != null) {
            services.remove(foundedService);

            System.out.println("Service deleted successfully!");
        } else {
            System.out.println("Service not found!");
        }
    }

    public void updateService(String id, String newServiceName, double newServicePrice) {
        Service foundedService = findServiceById(id);
        if (foundedService != null) {
            foundedService.setName(newServiceName);
            foundedService.setPrice(newServicePrice);
            System.out.println("Service updated successfully!");
        } else {
            System.out.println("Service not found!");
        }
    }

    public void displayServices() {
        if (!(services.isEmpty())) {
            System.out.println("\nList of Services:");
            for (int i = 1; i <= services.size(); i++) {
                System.out.println("Service#" + i);
                System.out.println(services.get(i - 1) + "\n");
            }
        } else {
            System.out.println("No service available.");
        }
    }

    public Service findServiceByName(String name) {
        return services.stream()
                .filter(service -> service.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public Service findServiceById(String id) {
        return services.stream()
                .filter(service -> service.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
    // #endregion

    // #region Patient
    public void addPatient(String name, String gender, int age) {

        String id = generateId(IDGenerator::generatePatientId);

        Patient newPatient = new Patient(id, name, gender, age);
        patients.add(newPatient);

        System.out.println("Patient registered successfully!");
    }

    public void deletePatient(String idPatient) {
        Patient foundedPatient = findPatientById(idPatient);
        if (foundedPatient != null) {
            patients.remove(foundedPatient);

            System.out.println("Patient deleted successfully!");
        } else {
            System.out.println("Patient not found!");
        }
    }

    public void updatePatient(String id, String name, String gender, int age) {
        Patient foundedPatient = findPatientById(id);
        if (foundedPatient != null) {
            foundedPatient.setName(name);
            foundedPatient.setGender(gender);
            foundedPatient.setAge(age);
            System.out.println("Patient updated successfully!");
        } else {
            System.out.println("Patient not found!");
        }
    }

    public void displayPatients() {
        if (!(patients.isEmpty())) {
            System.out.println("\nList of Patients:");
            for (int i = 1; i <= patients.size(); i++) {
                System.out.println("Patient#" + i);
                System.out.println(patients.get(i - 1) + "\n");
            }
        } else {
            System.out.println("No patient available.");
        }
    }

    public Patient findPatientById(String id) {
        return patients.stream()
                .filter(patient -> patient.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
    // #endregion

    // #region Appointment
    public void scheduleAppointment(String idPatient, String idDoctor, Date appointmentDate) {
        Doctor foundedDoctor = findDoctorById(idDoctor);
        Patient foundedPatient = findPatientById(idPatient);

        String idAppointment = generateId(IDGenerator::generateAppointmentId);

        Appointment appointment = new Appointment(idAppointment, foundedPatient, foundedDoctor, appointmentDate);
        appointments.add(appointment);

        System.out.println("Appointment registered successfully!");
    }

    public void searchAppointment(String patientName, Date appointmentDate, String doctorName) {
        List<Appointment> searchResult = new ArrayList<>();
        for (Appointment appointment : appointments) {
            boolean matchPatientName = patientName.isEmpty()
                    || appointment.getPatient().getName().equalsIgnoreCase(patientName);
            boolean matchAppointmentDate = appointmentDate == null
                    || appointment.getAppointmentDate().equals(appointmentDate);
            boolean matchDoctorName = doctorName.isEmpty()
                    || appointment.getDoctor().getName().equalsIgnoreCase(doctorName);

            if (matchPatientName && matchAppointmentDate && matchDoctorName) {
                searchResult.add(appointment);
            }
        }

        if (!(searchResult.isEmpty())) {
            System.out.println("\nList of Appointments:");
            for (int i = 1; i <= searchResult.size(); i++) {
                System.out.println("Appointment#" + i);
                System.out.println(searchResult.get(i - 1) + "\n");
            }
        } else {
            System.out.println("No appointments were found for the given search criteria.");

        }
    }

    public void displayAppointments() {
        if (!(appointments.isEmpty())) {
            System.out.println("\nList of Appointments:");
            for (int i = 1; i <= appointments.size(); i++) {
                System.out.println("Appointment#" + i);
                System.out.println(appointments.get(i - 1) + "\n");
            }
        } else {
            System.out.println("No appointment available.");
        }
    }

    public Appointment findAppointmentById(String id) {
        return appointments.stream()
                .filter(appointment -> appointment.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
    // #endregion

    // #region Prescription
    public void addPrescription(String idAppointment, String medicineName, int quantity, String dosage) {
        Appointment foundedAppointment = findAppointmentById(idAppointment);

        String idPrescription = generateId(IDGenerator::generatePrescriptionId);
        Prescription newPrescription = new Prescription(idPrescription, medicineName, quantity, dosage);

        foundedAppointment.addPrescription(newPrescription);
        System.out.println("Prescription Registered Successfull");
    }

    public void displayPrescriptions() {
        if (!(appointments.isEmpty())) {
            boolean hasPrescriptions = false;
            for (Appointment appointment : appointments) {
                if (!appointment.getPrescriptions().isEmpty()) {
                    hasPrescriptions = true;
                    break;
                }
            }

            if (hasPrescriptions) {
                System.out.println("\nList of Prescription:");
                System.out.println("==========================================");
                int i = 0;
                for (Appointment appointment : appointments) {
                    if (!(appointment.getPrescriptions().isEmpty())) {
                        i++;
                        System.out.println("\n\nPrescription#" + i + ":");
                        appointment.displayPrescriptions();
                    }
                }
            } else {
                System.out.println("No prescription avaiilable.");
            }

        } else {
            System.out.println("No prescription available.");
        }
    }

    public void searchPrescription(String patientName, Date appointmentDate) {
        List<Appointment> searchResult = new ArrayList<>();
        for (Appointment appointment : appointments) {
            boolean matchPatientName = patientName.isEmpty()
                    || appointment.getPatient().getName().equalsIgnoreCase(patientName);
            boolean matchAppointmentDate = appointmentDate == null
                    || appointment.getAppointmentDate().equals(appointmentDate);

            if (matchPatientName && matchAppointmentDate) {
                searchResult.add(appointment);
            }
        }

        boolean hasPrescriptions = false;
        for (Appointment appointment : searchResult) {
            if (!appointment.getPrescriptions().isEmpty()) {
                hasPrescriptions = true;
                break;
            }
        }

        if (hasPrescriptions) {
            System.out.println("\nList of Prescriptions:");

            int i = 0;
            for (Appointment appointment : searchResult) {
                if (!(appointment.getPrescriptions().isEmpty())) {
                    i++;
                    System.out.println("\n\nPrescription#" + i + ":");
                    appointment.displayPrescriptions();
                }
            }
        } else {
            System.out.println("No prescription were found for the given search criteria.");

        }
    }
    // #endregion

    // #region Medical Record
    public void addMedicalRecord(String idAppointment, String complaint, String diagnosis) {
        Appointment foundedAppointment = findAppointmentById(idAppointment);

        String idMedicalRecord = generateId(IDGenerator::generateMedicalRecordId);;

        MedicalRecord newMedicalRecord = new MedicalRecord(idMedicalRecord, complaint, diagnosis, foundedAppointment);
        medicalRecords.add(newMedicalRecord);

        System.out.println("Medical Record Registered Successfull");
    }

    public void displayMedicalRecords() {
        if (!(medicalRecords.isEmpty())) {
            System.out.println("\nList of Medical Records:");
            for (int i = 1; i <= medicalRecords.size(); i++) {
                System.out.println("\nMedical Record#" + i);
                medicalRecords.get(i - 1).displayMedicalRecord();
            }

        } else {
            System.out.println("No medical record available.");
        }
    }

    public void searchMedicalRecord(String patientName, Date appointmentDate) {
        List<MedicalRecord> searchResult = new ArrayList<>();
        for (MedicalRecord medicalRecord : medicalRecords) {
            boolean matchPatientName = patientName.isEmpty()
                    || medicalRecord.getAppointment().getPatient().getName().equalsIgnoreCase(patientName);
            boolean matchAppointmentDate = appointmentDate == null
                    || medicalRecord.getAppointment().getAppointmentDate().equals(appointmentDate);

            if (matchPatientName && matchAppointmentDate) {
                searchResult.add(medicalRecord);
            }
        }

        if (!(searchResult.isEmpty())) {
            System.out.println("\nList of Transactions:");
            for (int i = 1; i <= searchResult.size(); i++) {
                System.out.println("\nMedical Record#" + i);
                searchResult.get(i - 1).displayMedicalRecord();
            }
        } else {
            System.out.println("No medical record were found for the given search criteria.");

        }
    }
    // #endregion

    // #region Transaction
    public void processTransaction(String idAppointment, String idService, String idCashier) {
        Service foundedService = findServiceById(idService);
        Transaction foundedTransaction = findTransactionByAppointmentId(idAppointment);
        Appointment foundedAppointment = findAppointmentById(idAppointment);
        Cashier foundedCashier = findCashierById(idCashier);

        String idTransactionDetail = generateId(IDGenerator::generateTransactionDetailId);;
        TransactionDetail newTransactionDetail = new TransactionDetail(idTransactionDetail, foundedService,
                foundedService.getPrice());

        if (foundedTransaction != null) {
            foundedTransaction.addTransactionDetail(newTransactionDetail);
        } else {
            String idTransaction = generateId(IDGenerator::generateTransactionId);;
            Transaction newTransaction = new Transaction(idTransaction, foundedAppointment, foundedCashier);
            transactions.add(newTransaction);

            newTransaction.addTransactionDetail(newTransactionDetail);
        }
    }

    public void displayTransactions() {
        if (!(transactions.isEmpty())) {
            System.out.println("\nList of Transaction:");
            for (int i = 1; i <= transactions.size(); i++) {
                System.out.println("\nTransaction#" + i);
                transactions.get(i - 1).displayTransaction();
            }
        } else {
            System.out.println("No transaction available.");
        }
    }

    public void searchTransaction(String patientName, Date appointmentDate, String doctorName) {
        List<Transaction> searchResult = new ArrayList<>();
        for (Transaction transaction : transactions) {
            boolean matchPatientName = patientName.isEmpty()
                    || transaction.getAppointment().getPatient().getName().equalsIgnoreCase(patientName);
            boolean matchAppointmentDate = appointmentDate == null
                    || transaction.getAppointment().getAppointmentDate().equals(appointmentDate);
            boolean matchDoctorName = doctorName.isEmpty()
                    || transaction.getAppointment().getDoctor().getName().equalsIgnoreCase(doctorName);

            if (matchPatientName && matchAppointmentDate && matchDoctorName) {
                searchResult.add(transaction);
            }
        }

        if (!(searchResult.isEmpty())) {
            System.out.println("\nList of Transactions:");
            for (int i = 1; i <= searchResult.size(); i++) {
                System.out.println("\nTransaction#" + i);
                searchResult.get(i - 1).displayTransaction();
            }
        } else {
            System.out.println("No transaction were found for the given search criteria.");

        }
    }

    public void payTransaction(String idAppointment, double totalPayment) {
        Transaction foundedTransaction = findTransactionByAppointmentId(idAppointment);

        if (foundedTransaction != null) {
            double totalReturn = totalPayment - foundedTransaction.calculateTotalTransaction();
            if (totalReturn >= 0) {
                foundedTransaction.setTotalPayment(totalPayment);
                foundedTransaction.setTotalReturn(totalReturn);

                System.out.println("\nTransaction was successfully processed!\n");
            }
        } else {
            System.out.println("Transaction not found!");
        }
    }

    public void displayTransactonByAppointmentId(String idAppointment) {
        Transaction foundedTransaction = findTransactionByAppointmentId(idAppointment);

        foundedTransaction.displayTransaction();
    }

    public boolean isAlreadyPaid(String idAppointment) {
        Transaction foundedTransaction = findTransactionByAppointmentId(idAppointment);

        if (foundedTransaction != null) {
            if (foundedTransaction.getTotalPayment() != 0.0 && !Double.isNaN(foundedTransaction.getTotalPayment())) {
                return true;
            }
        }

        return false;
    }

    public Transaction findTransactionByAppointmentId(String idAppointment) {
        return transactions.stream()
                .filter(trans -> trans.getAppointment().getId().equals(idAppointment))
                .findFirst()
                .orElse(null);
    }

    // #endregion

    // #region Cashier
    public void addCashier(String name, String email) {
        Cashier foundedCashier = findCashierByNameAndEmail(name, email);
        if (foundedCashier == null) {

            String id = generateId(IDGenerator::generateCashierId);

            Cashier newCashier = new Cashier(id, name, email);
            cashiers.add(newCashier);
        }
    }

    public void displayCashiers() {
        if (!(cashiers.isEmpty())) {
            System.out.println("\nList of Cashiers:");
            int count = 1;
            for (Object obj : cashiers) {
                if (obj instanceof Cashier cashier) {
                    System.out.println("Cashier#" + count++);
                    System.out.println(cashier + "\n");
                }
            }
        } else {
            System.out.println("No cashier available.");
        }
    }

    public Cashier findCashierByNameAndEmail(String name, String email) {
        return cashiers.stream()
                .filter(cashier -> cashier.getName().equals(name) && cashier.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }

    public Cashier findCashierById(String id) {
        return cashiers.stream()
                .filter(cashier -> cashier.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
    // #endregion

    // #region Adm Staff
    public void addAdmStaff(String name, String email) {
        AdministrationStaff foundedAdm = findAdministrationStaffByNameAndEmail(name, email);
        if (foundedAdm == null) {
            String id = generateId(IDGenerator::generateAdmStaffId);

            AdministrationStaff newAdm = new AdministrationStaff(id, name, email);
            admStaffs.add(newAdm);
        }
    }

    public void displayAdmStaff() {
        if (!(admStaffs.isEmpty())) {
            System.out.println("\nList of Administration Staff:");
            int count = 1;
            for (Object obj : admStaffs) {
                if (obj instanceof AdministrationStaff staff) {
                    System.out.println("Adm Staff#" + count++);
                    System.out.println(staff + "\n");
                }
            }
        } else {
            System.out.println("No admin staff available.");
        }
    }

    public AdministrationStaff findAdministrationStaffByNameAndEmail(String name, String email) {
        return admStaffs.stream()
                .filter(adm -> adm.getName().equals(name) && adm.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }

    public AdministrationStaff findAdministrationStaffById(String id) {
        return admStaffs.stream()
                .filter(adm -> adm.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
    // #endregion
}
