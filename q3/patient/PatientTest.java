public class PatientTest {
    public static void main(String[] args) {
        Patient p = new InPatient("Nakato Sarah", "P001", 3, 50000, 120000);
        System.out.println(p.summary());
    }
}
