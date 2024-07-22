import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@FunctionalInterface
interface IDGeneratorFunction {
    String generate();
}

public class IDGenerator {

    private static int counterDoctors = 1;
    private static int counterServices = 1;
    private static int counterPatients = 1;
    private static int counterAppointments = 1;
    private static int counterPrescriptions = 1;
    private static int counterMedicalRecord = 1;
    private static int counterTransactions = 1;
    private static int counterTransactionsDetail = 1;
    private static int counterCashier = 1;
    private static int counterAdmStaff = 1;

    private static String getCurrentDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        return LocalDateTime.now().format(formatter);
    }

    public static String generateDoctorId() {
        return getCurrentDate() + "DOC" + String.format("%04d", counterDoctors++);
    }

    public static String generateServiceId() {
        return getCurrentDate() + "SVC" + String.format("%04d", counterServices++);
    }

    public static String generatePatientId() {
        return getCurrentDate() + "PTT" + String.format("%04d", counterPatients++);
    }

    public static String generateAppointmentId() {
        return getCurrentDate() + "APN" + String.format("%04d", counterAppointments++);
    }

    public static String generatePrescriptionId() {
        return getCurrentDate() + "PRN" + String.format("%04d", counterPrescriptions++);
    }

    public static String generateMedicalRecordId() {
        return getCurrentDate() + "MDR" + String.format("%04d", counterMedicalRecord++);
    }

    public static String generateTransactionId() {
        return getCurrentDate() + "TRS" + String.format("%04d", counterTransactions++);
    }

    public static String generateTransactionDetailId() {
        return getCurrentDate() + "TRD" + String.format("%04d", counterTransactionsDetail++);
    }

    public static String generateCashierId() {
        return getCurrentDate() + "CSR" + String.format("%04d", counterCashier++);
    }

    public static String generateAdmStaffId() {
        return getCurrentDate() + "ADM" + String.format("%04d", counterAdmStaff++);
    }
}
