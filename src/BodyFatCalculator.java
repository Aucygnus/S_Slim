public class BodyFatCalculator extends HealthCalculator{
    
    /**
     * @param weight น้ำหนักของผู้ใช้(หน่วย กิโลกรัม)
     * @param height ส่วนสูงของผู้ใช้(หน่วย เซนติเมตร)
     * @param age อายุของผู้ใช้(หน่วย ปี)
     * @param gender เพศของผู้ใช้(ชาย หญิง)
     */
    public BodyFatCalculator(double weight, double height, int age, String gender) {
        super(weight, height, age, gender);
    }

    @Override
    public double calculate() {
        double bmi = new BMICalculator(getWeight(), getHeight(), getAge(), getGender()).calculate();
        if (getGender().equalsIgnoreCase("male")) {
            return (1.20 * bmi) + (0.23 * getAge()) - 16.2;
        } else {
            return (1.20 * bmi) + (0.23 * getAge()) - 5.4;
        }
    }

    @Override
    public String getResultDescription() {
        return "Body Fat";
    }
}