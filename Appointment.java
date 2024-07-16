import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Appointment {
    private String id;
    private Patient patient;
    private Doctor doctor;
    private Date appointmentDate;
    private List<Prescription> prescriptions;

    public Appointment(String id, Patient patient, Doctor doctor, Date appointmentDate) {
        this.id = id;
        this.patient = patient;
        this.doctor = doctor;
        this.appointmentDate = appointmentDate;
        this.prescriptions = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public List<Prescription> getPrescriptions() {
        return prescriptions;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public void setPrescriptions(List<Prescription> prescriptions) {
        this.prescriptions = prescriptions;
    }

    public void addPrescription(Prescription prescription) {
        prescriptions.add(prescription);
    }

    public void displayPrescriptions() {
        System.out.println(
                "Date: " + new SimpleDateFormat("dd/MM/yyyy").format(appointmentDate));
        System.out.println("---------------------------------------------------------------");
        System.out.println(patient);
        System.out.println("---------------------------------------------------------------");
        System.out.println(doctor);

        System.out.printf("---------------------------------------------------------------%n");
        System.out.printf("| %-30s | %-15s | %-8s |%n", "Medicine Name", "Dosage", "Qty");
        System.out.printf("---------------------------------------------------------------%n");

        for (Prescription prescription : prescriptions) {
            prescription.toPrintStream();
        }
        System.out.println("---------------------------------------------------------------");

    }

    @Override
    public String toString() {
        return "ID Appointment: " + id + "\nAppointment Date: "
                + new SimpleDateFormat("dd/MM/yyyy").format(appointmentDate)
                + "\n------------------------------\n" + patient + "\n------------------------------\n" + doctor;
    }

}
