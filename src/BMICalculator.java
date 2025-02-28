public class BMICalculator extends HealthCalculator {

    /**
     * @param weight น้ำหนักของผู้ใช้(หน่วย กิโลกรัม)
     * @param height ส่วนสูงของผู้ใช้(หน่วย เซนติเมตร)
     * @param age อายุของผู้ใช้(หน่วย ปี)
     * @param gender เพศของผู้ใช้(ชาย หญิง)
     */
    public BMICalculator(double weight, double height, int age, String gender) {
        super(weight,height,age,gender);
    }

    @Override
    public double calculate() {
        return getWeight() / Math.pow(getHeight() / 100, 2);
    }

    @Override
    public String getResultDescription() {
        return "BMI";
    }
}
