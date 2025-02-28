public abstract class HealthCalculator {
    private double weight;
    private double height;
    private int age;
    private String gender;

    /**
     * @param weight น้ำหนักของผู้ใช้(หน่วย กิโลกรัม)
     * @param height ส่วนสูงของผู้ใช้(หน่วย เซนติเมตร)
     * @param age อายุของผู้ใช้(หน่วย ปี)
     * @param gender เพศของผู้ใช้(ชาย หญิง)
     */
    public HealthCalculator(double weight, double height, int age, String gender) {
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.gender = gender;
    }

    /**
     * @return น้ำหนักของผู้ใช้(หน่วย กิโลกรัม)
     */
    public double getWeight() {
        return weight;
    }

    /**
     * @return ส่วนสูงของผู้ใช้(หน่วย เซนติเมตร)
     */
    public double getHeight() {
        return height;
    }

    /**
     * @return อายุของผู้ใช้(หน่วย ปี)
     */
    public int getAge() {
        return age;
    }

    /**
     * @return เพศของผู้ใช้งาน (ชาย หญิง)
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param weight ค่าน้ำหนักที่ถูกเปลี่ยนใหม่
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * @param height ค่าส่วนสูงที่ถูกเปลี่ยนใหม่
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * @param age ค่าอายุที่ถูกเปลี่ยนใหม่
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @param gender เพศที่ถูกเปลี่ยนใหม่
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    public abstract double calculate();

    public abstract String getResultDescription();
}
