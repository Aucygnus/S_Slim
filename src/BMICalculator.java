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

    /**
     * @return ค่าดัชนีมวลกาย
     */
    public double calculateBMI() {
        return weight / Math.pow(height / 100, 2);
    }
}
