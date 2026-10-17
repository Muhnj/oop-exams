public class InPatient extends Patient {
    private int daysAdmitted;
    private double dailyRate;
    private double treatmentCost;

    public InPatient(String name, String patientId, int daysAdmitted,
                     double dailyRate, double treatmentCost) {
        super(name, patientId);
        if (daysAdmitted < 0 || dailyRate < 0 || treatmentCost < 0) {
            throw new IllegalArgumentException("Values cannot be negative");
        }
        this.daysAdmitted = daysAdmitted;
        this.dailyRate = dailyRate;
        this.treatmentCost = treatmentCost;
    }

    public int getDaysAdmitted() { return daysAdmitted; }

    @Override
    public double calculateBill() {
        return (daysAdmitted * dailyRate) + treatmentCost;
    }

    @Override
    public String getWard() {
        return "General Ward";
    }
}
