import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class S_SlimGUI extends JFrame {
    private JButton bmiButton, bmrButton, bodyFatButton, waterButton;

    public S_SlimGUI() {
        setTitle("S-Slim");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1));

        bmiButton = new JButton("Calculate BMI");
        bmrButton = new JButton("Calculate BMR");
        bodyFatButton = new JButton("Calculate Body Fat");
        waterButton = new JButton("Calculate Water Intake");

        add(bmiButton);
        add(bmrButton);
        add(bodyFatButton);
        add(waterButton);

        bmiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showInputDialog("BMI", true, true, false, false);
            }
        });

        bmrButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showInputDialog("BMR", true, true, true, true);
            }
        });

        bodyFatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               showInputDialog("Body Fat", true, true, true, true);
            }
        });

        waterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showInputDialog("Water Intake", true, false, false, false);
            }
        });
    }

    /**
     * @param calculationType แยกประเภทการคำนวณของแต่ละฟังก์ชัน
     * @param needWeight ตรวจสอบว่าต้องการข้อมูลน้ำหนักหรือไม่
     * @param needHeight ตรวจสอบว่าต้องการข้อมูลส่วนสูงหรือไม่
     * @param needAge ตรวจสอบว่าต้องการข้อมูลอายุหรือไม่
     * @param needGender ตรวจสอบว่าต้องการข้อมูลเพศหรือไม่
     */
    private void showInputDialog(String calculationType, boolean needWeight, boolean needHeight, boolean needAge, boolean needGender) {
        JPanel panel = new JPanel(new GridLayout(0 , 2));
        JTextField weightField = new JTextField();
        JTextField heightField = new JTextField();
        JTextField ageField = new JTextField();
        JComboBox<String> genderComboBox = new JComboBox<>(new String[]{"Male", "Female"});

        if (needWeight) {
            panel.add(new JLabel("Weight (kg):"));
            panel.add(weightField);
        }
        if (needHeight) {
        panel.add(new JLabel("Height (cm):"));
        panel.add(heightField);            
        }
        if (needAge) {
        panel.add(new JLabel("Age:"));
        panel.add(ageField);            
        }
        if (needGender) {
        panel.add(new JLabel("Gender:"));
        panel.add(genderComboBox);            
        }

        int result = JOptionPane.showConfirmDialog(null, panel, "Enter Details for " + calculationType, JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try {
                double weight = needWeight ? Double.parseDouble(weightField.getText()) : 0;
                double height = needHeight ? Double.parseDouble(heightField.getText()) : 0;
                int age = needAge ? Integer.parseInt(ageField.getText()) : 0;
                String gender = needGender ? (String) genderComboBox.getSelectedItem() : "Male";

                switch (calculationType) {
                    case "BMI":
                        BMICalculator bmiCalculator = new BMICalculator(weight, height, age, gender);
                        double bmi = bmiCalculator.calculateBMI();
                        JOptionPane.showMessageDialog(null, "BMI: " + String.format("%.2f", bmi), "Result", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case "BMR":
                        BMRCalculator bmrCalculator = new BMRCalculator(weight, height, age, gender);
                        double bmr = bmrCalculator.calculateBMR();
                        JOptionPane.showMessageDialog(null, "BMR: " + String.format("%.2f", bmr) + " calories/day", "Result", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case "Body Fat":
                        BodyFatCalculator bodyFatCalculator = new BodyFatCalculator(weight, height, age, gender);
                        double bodyFat = bodyFatCalculator.calculateBodyFat();
                        JOptionPane.showMessageDialog(null, "Body Fat: " + String.format("%.2f", bodyFat) + "%", "Result", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case "Water Intake":
                        WaterIntakeCalculator waterCalculator = new WaterIntakeCalculator(weight, height, age, gender);
                        double waterIntake = waterCalculator.calculateWaterIntake();
                        JOptionPane.showMessageDialog(null, "Water Intake: " + String.format("%.2f", waterIntake) + " liters/day", "Result", JOptionPane.INFORMATION_MESSAGE);
                        break;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter numbers.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new S_SlimGUI().setVisible(true);
            }
        });
    }
}