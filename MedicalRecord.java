
import java.text.SimpleDateFormat;

public class MedicalRecord {
    private String id;
    private String complaint;
    private String diagnosis;
    private Appointment appointment;

    public MedicalRecord(String id, String complaint, String diagnosis, Appointment appointment) {
        this.id = id;
        this.complaint = complaint;
        this.diagnosis = diagnosis;
        this.appointment = appointment;
    }

    public String getId() {
        return id;
    }

    public String getComplaint() {
        return complaint;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public void displayMedicalRecord() {
        System.out.println(
                "Date: " + new SimpleDateFormat("dd/MM/yyyy").format(appointment.getAppointmentDate()));
        System.out.println("---------------------------------------------------------------");
        System.out.println(appointment.getPatient());
        System.out.println("---------------------------------------------------------------");
        System.out.println(appointment.getDoctor());
        System.out.println("---------------------------------------------------------------");
        System.out.println("ID Medical Record: " + id + "\nComplaint: " + complaint + "\nDiagnosis: " + diagnosis);
    }

}
