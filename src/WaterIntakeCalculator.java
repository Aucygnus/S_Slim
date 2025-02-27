public class WaterIntakeCalculator extends HealthCalculator{
    
    /**
     * @param weight น้ำหนักของผู้ใช้(หน่วย กิโลกรัม)
     * @param height ส่วนสูงของผู้ใช้(หน่วย เซนติเมตร)
     * @param age อายุของผู้ใช้(หน่วย ปี)
     * @param gender เพศของผู้ใช้(ชาย หญิง)
     */
    public WaterIntakeCalculator(double weight, double height, int age, String gender) {
        super(weight, height, age, gender);
    }

    /**
     * @return ปริมาณน้ำที่ควรดื่มใน 1 วัน
     */
    public double calculateWaterIntake() {
        return weight * 0.033;
    }
}