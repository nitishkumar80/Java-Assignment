import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentForm extends JFrame {
    private JTextField firstNameField, lastNameField, fatherNameField, motherNameField, phoneField;
    private JTextArea addressArea;
    private JRadioButton maleRadioButton, femaleRadioButton;
    private JComboBox<String> courseComboBox;

    public StudentForm() {
        // Set up the frame
        setTitle("Student Information Form");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create components
        JLabel nameLabel = new JLabel("Name:");
        JLabel lastNameLabel = new JLabel("Last Name:");
        JLabel fatherNameLabel = new JLabel("Father's Name:");
        JLabel motherNameLabel = new JLabel("Mother's Name:");
        JLabel genderLabel = new JLabel("Gender:");
        JLabel courseLabel = new JLabel("Course:");
        JLabel addressLabel = new JLabel("Address:");
        JLabel phoneLabel = new JLabel("Phone No:");

        firstNameField = new JTextField(20);
        lastNameField = new JTextField(20);
        fatherNameField = new JTextField(20);
        motherNameField = new JTextField(20);
        phoneField = new JTextField(20);
        addressArea = new JTextArea(5, 20);
        JScrollPane addressScrollPane = new JScrollPane(addressArea);

        maleRadioButton = new JRadioButton("Male");
        femaleRadioButton = new JRadioButton("Female");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);

        String[] courses = {"Bca", "Btech", "Bba", "Biotech"};
        courseComboBox = new JComboBox<>(courses);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Display a message when the submit button is clicked
                JOptionPane.showMessageDialog(null, "Submit Successful!");
            }
        });

        // Set layout
        setLayout(new GridLayout(10, 2));

        // Add components to the frame
        add(nameLabel);
        add(firstNameField);
        add(lastNameLabel);
        add(lastNameField);
        add(fatherNameLabel);
        add(fatherNameField);
        add(motherNameLabel);
        add(motherNameField);
        add(genderLabel);
        add(maleRadioButton);
        add(new JLabel()); // Empty label for layout spacing
        add(femaleRadioButton);
        add(courseLabel);
        add(courseComboBox);
        add(addressLabel);
        add(addressScrollPane);
        add(phoneLabel);
        add(phoneField);
        add(new JLabel()); // Empty label for layout spacing
        add(submitButton);

        // Set frame visibility
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new StudentForm();
            }
        });
    }
}
