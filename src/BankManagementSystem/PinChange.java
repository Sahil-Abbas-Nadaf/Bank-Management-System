package BankManagementSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener {
    JPasswordField pinTextField, repinTextField;
    JButton change, cancel;
    String pinNumber;
    PinChange(String pinNumber){
        setLayout(null);
        this.pinNumber = pinNumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.white);
        text.setBounds(250, 280, 500, 35);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        JLabel pinText = new JLabel("NEW PIN");
        pinText.setForeground(Color.white);
        pinText.setBounds(165, 320, 180, 25);
        pinText.setFont(new Font("System", Font.BOLD, 16));
        image.add(pinText);

        pinTextField = new JPasswordField();
        pinText.setFont(new Font("Raleway", Font.BOLD, 16));
        pinTextField.setBounds(330, 320, 180, 25);
        image.add(pinTextField);

        JLabel repinText = new JLabel("Re-Enter New PIN");
        repinText.setForeground(Color.white);
        repinText.setBounds(165, 360, 180, 25);
        repinText.setFont(new Font("System", Font.BOLD, 16));
        image.add(repinText);

        repinTextField = new JPasswordField();
        repinText.setFont(new Font("Raleway", Font.BOLD, 16));
        repinTextField.setBounds(330, 360, 180, 25);
        image.add(repinTextField);


        change = new JButton("Change Pin");
        change.setBounds(355, 485,150, 30);
        change.addActionListener(this);
        image.add(change);


        cancel = new JButton("Cancel");
        cancel.setBounds(355, 520,150, 30);
        cancel.addActionListener(this);
        image.add(cancel);

        setSize(900,900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == change) {
            try {
                String npin = pinTextField.getText();
                String rpin = repinTextField.getText();
                if (!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                    return;
                }
                if (npin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter new PIN");
                    return;
                }
                if (rpin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please re-enter new PIN");
                }

//                Update Pin:
                Conn con = new Conn();
                String query1 = "update bank set pin = '"+rpin+"' where pin = '"+pinNumber+"'";
                String query2 = "update login set pin = '"+rpin+"' where pin = '"+pinNumber+"'";
                String query3 = "update signupthree set pin = '"+rpin+"' where pin = '"+pinNumber+"'";
                con.s.executeUpdate(query1);
                con.s.executeUpdate(query2);
                con.s.executeUpdate(query3);
                JOptionPane.showMessageDialog(null, "Pin changed successfully");
                setVisible(false);
                new Transactions(rpin).setVisible(true);

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }else{
            setVisible(false);
            new Transactions("").setVisible(true);
        }
    }
    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }
}
