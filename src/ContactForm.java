import javax.swing.*;
import javax.swing.plaf.basic.BasicOptionPaneUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContactForm extends JFrame {
    JTextField nameField, emailField;
    JRadioButton male, female;
    JCheckBox check;
    public ContactForm() {
        super("Тыгыдык");
        super.setBounds(200, 100, 300, 230);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = super.getContentPane();
        container.setLayout(new GridLayout(5, 2, 2, 10));


        JLabel name = new JLabel("Введите имя:");
        nameField = new JTextField("", 1);
        JLabel email = new JLabel("Введите email:");
        emailField = new JTextField("@", 1);

        container.add(name);
        container.add(nameField);
        container.add(email);
        container.add(emailField);

        male = new JRadioButton("Мужской");
        female = new JRadioButton("Женский");
        check = new JCheckBox("Согласен?", false);
        JButton sendButton = new JButton("Ok");

        male.setSelected(true);
        container.add(male);
        container.add(female);

        ButtonGroup group = new ButtonGroup();
        group.add(male);
        group.add(female);

        container.add(check);
        container.add(sendButton);

        sendButton.addActionListener(new ButtonEventManager());
    }

    class ButtonEventManager implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String name = nameField.getText();
            String email = emailField.getText();

            String isMale = "Мужской";
            if(!male.isSelected())
                isMale = "Женский";

            boolean checkBox = check.isSelected();

            JOptionPane.showMessageDialog(null, "Your mail: " + email +
                    "\nВаш пол: " + isMale + "\nВы согласны? " + checkBox,
                    "Hello, " + name, JOptionPane.PLAIN_MESSAGE);
        }
    }
}
