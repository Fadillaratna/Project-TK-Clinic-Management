import java.text.SimpleDateFormat;
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
    private static int counterDoctors = 1;
    private static int counterServices = 1;
    private static int counterPatients = 1;
    private static int counterAppointments = 1;
    private static int counterPrescriptions = 1;
    private static int counterMedicalRecord = 1;
    private static int counterTransaction = 1;
    private static int counterTransactionDetail = 1;

    public ClinicManagement() {
        doctors = new ArrayList<>();
        services = new ArrayList<>();
        patients = new ArrayList<>();
        appointments = new ArrayList<>();
        medicalRecords = new ArrayList<>();
        transactions = new ArrayList<>();
    }

    private static String getCurrentDate() {
        return new SimpleDateFormat("yyyyMMdd").format(new Date());

    }

    private static String generateId(String type) {
        String dateNow = getCurrentDate();

        switch (type) {
            case "doctor":
                return dateNow + "DOC" + String.format("%04d", counterDoctors++);
            case "service":
                return dateNow + "SVC" + String.format("%04d", counterServices++);
            case "patient":
                return dateNow + "PTT" + String.format("%04d", counterPatients++);
            case "appointment":
                return dateNow + "APN" + String.format("%04d", counterAppointments++);
            case "prescription":
                return dateNow + "PRN" + String.format("%04d", counterPrescriptions++);
            case "medicalrecord":
                return dateNow + "MDR" + String.format("%04d", counterMedicalRecord++);
            case "transaction":
                return dateNow + "TRS" + String.format("%04d", counterTransaction++);
            case "transactiondetail":
                return dateNow + "TRD" + String.format("%04d", counterTransactionDetail++);
            default:
                throw new AssertionError();
        }
    }

    // #region Doctor
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
    // #endregion

    // #region Service
    public void addService(String serviceName, double servicePrice) {
        Service service = findServiceByName(serviceName);
        if (service != null) {
            System.out.println("Service with Name " + serviceName + "already registered!");
        } else {
            String id = generateId("service");

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
        for (Service service : services) {
            if (service.getName().equals(name)) {
                return service;
            }
        }
        return null;
    }

    public Service findServiceById(String id) {
        for (Service service : services) {
            if (service.getId().equals(id)) {
                return service;
            }
        }
        return null;
    }
    // #endregion

    // #region Patient
    public void addPatient(String name, String gender, int age) {

        String id = generateId("patient");

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
        for (Patient patient : patients) {
            if (patient.getId().equals(id)) {
                return patient;
            }
        }
        return null;
    }
    // #endregion

    // #region Appointment
    public void scheduleAppointment(String idPatient, String idDoctor, Date appointmentDate) {
        Doctor foundedDoctor = findDoctorById(idDoctor);
        Patient foundedPatient = findPatientById(idPatient);

        String idAppointment = generateId("appointment");

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
        for (Appointment appointment : appointments) {
            if (appointment.getId().equals(id)) {
                return appointment;
            }
        }
        return null;
    }
    // #endregion

    // #region Prescription
    public void addPrescription(String idAppointment, String medicineName, int quantity, String dosage) {
        Appointment foundedAppointment = findAppointmentById(idAppointment);

        String idPrescription = generateId("prescription");
        Prescription prescription = new Prescription(idPrescription, medicineName, quantity, dosage);

        foundedAppointment.addPrescription(prescription);
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
            System.out.println("\nList of Appointments:");

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

        String idMedicalRecord = generateId("medicalrecord");

        MedicalRecord medicalRecord = new MedicalRecord(idMedicalRecord, complaint, diagnosis, foundedAppointment);
        medicalRecords.add(medicalRecord);

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
    public void processTransaction(String idAppointment, String idService) {
        Service service = findServiceById(idService);
        Transaction foundedTransaction = findTransactionByAppointmentId(idAppointment);
        Appointment foundedAppointment = findAppointmentById(idAppointment);

        String idTransactionDetail = generateId("transactiondetail");
        TransactionDetail transactionDetail = new TransactionDetail(idTransactionDetail, service, service.getPrice());

        if (foundedTransaction != null) {

            foundedTransaction.addTransactionDetail(transactionDetail);
        } else {
            String idTransaction = generateId("transaction");
            Transaction transaction = new Transaction(idTransaction, foundedAppointment);
            transactions.add(transaction);

            transaction.addTransactionDetail(transactionDetail);
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

    public Transaction findTransactionByAppointmentId(String idAppointment) {
        for (Transaction transaction : transactions) {
            if (transaction.getAppointment().getId().equals(idAppointment)) {
                return transaction;
            }
        }
        return null;
    }
    // #endregion

}
