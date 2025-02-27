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
    
    /**
     * @return เปอร์เซ็นต์ไขมันในร่างกาย
     */
    public double calculateBodyFat() {
        double bmi = new BMICalculator(weight, height, age, gender).calculateBMI();
        if (gender.equalsIgnoreCase("male")) {
            return (1.20 * bmi) + (0.23 * age) - 16.2;
        } else {
            return (1.20 * bmi) + (0.23 * age) - 5.4;
        }
    }
}