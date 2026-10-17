public abstract class Patient {
    private String name;
    private String patientId;

    public Patient(String name, String patientId) {
        this.name = name;
        this.patientId = patientId;
    }

    public String getName() { return name; }
    public String getPatientId() { return patientId; }

    public abstract double calculateBill();
    public abstract String getWard();

    public String summary() {
        return patientId + " " + name + ", " + getWard() + ", bill UGX " + calculateBill();
    }
}
