public class BMRCalculator extends HealthCalculator{

    /**
     * @param weight น้ำหนักของผู้ใช้(หน่วย กิโลกรัม)
     * @param height ส่วนสูงของผู้ใช้(หน่วย เซนติเมตร)
     * @param age อายุของผู้ใช้(หน่วย ปี)
     * @param gender เพศของผู้ใช้(ชาย หญิง)
     */
    public BMRCalculator(double weight, double height, int age, String gender) {
        super(weight, height, age, gender);
    }

    @Override
    public double calculate() {
        if (getGender().equalsIgnoreCase("male")) {
            return 88.362 + (13.397 * getWeight()) + (4.799 * getHeight()) - (5.677 * getAge());
        } else {
            return 447.593 + (9.247 * getWeight()) + (3.098 * getHeight()) - (4.330 * getAge());
        }
    }

    @Override
    public String getResultDescription() {
        return "BMR";
    }
}