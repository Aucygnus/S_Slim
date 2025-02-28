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
                showInputDialog(new BMICalculator(0, 0, 0, ""), true, true, false, false, true);
            }
        });

        bmrButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showInputDialog(new BMRCalculator(0, 0, 0, ""), true, true, true, true, true);
            }
        });

        bodyFatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               showInputDialog(new BodyFatCalculator(0, 0, 0, ""), true, true, true, true, true);
            }
        });

        waterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showInputDialog(new WaterIntakeCalculator(0, 0, 0, ""), true, false, false, false, true);
            }
        });
    }

    /**
     * @param calculator ฟังก์ชันการคำนวณ
     * @param needWeight ตรวจสอบว่าต้องการข้อมูลน้ำหนักหรือไม่
     * @param needHeight ตรวจสอบว่าต้องการข้อมูลส่วนสูงหรือไม่
     * @param needAge ตรวจสอบว่าต้องการข้อมูลอายุหรือไม่
     * @param needGender ตรวจสอบว่าต้องการข้อมูลเพศหรือไม่
     * @param showResult
     */
    private void showInputDialog(HealthCalculator calculator, boolean needWeight, boolean needHeight, boolean needAge, boolean needGender, boolean showResult) {
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

        int result = JOptionPane.showConfirmDialog(null, panel, "Enter Details for ", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try {
                double weight = needWeight ? Double.parseDouble(weightField.getText()) : 0;
                double height = needHeight ? Double.parseDouble(heightField.getText()) : 0;
                int age = needAge ? Integer.parseInt(ageField.getText()) : 0;
                String gender = needGender ? (String) genderComboBox.getSelectedItem() : "Male";

                calculator.setWeight(weight);
                calculator.setHeight(height);
                calculator.setAge(age);
                calculator.setGender(gender);

                double resultValue = calculator.calculate();
                String resultDescription = calculator.getResultDescription();

                String resultMessage;
                switch (resultDescription) {
                    case "BMI" :
                        resultMessage = "Your BMI is " + String.format("%.2f", resultValue);
                        break;
                    case "BMR" :
                        resultMessage = "Your BMR is " + String.format("%.2f ", resultValue) + "calories/day";
                        break;
                    case "Body Fat" :
                        resultMessage = "Your Body Fat percentage is " + String.format("%.2f ", resultValue) + "%";
                        break;
                    case "Water Intake" :
                        resultMessage = "The amount of water you should drink is " + String.format("%.2f ", resultValue) + "liters/day";
                        break;
                    default :
                        resultMessage = "Result: " + String.format("%.2f", resultValue);
                }

                JOptionPane.showMessageDialog(null, resultMessage, "Result", JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter numbers.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new S_SlimGUI().setVisible(true);
        });
    }
}