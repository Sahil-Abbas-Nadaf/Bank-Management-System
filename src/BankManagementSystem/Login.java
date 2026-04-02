package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener {

    JButton login, signup, clear;
    JTextField cardTextField;
    JPasswordField pinTextField;
    Login(){
        // Name of the Frame
        setTitle("AUTOMATED TELLER MACHINE");

        setLayout(null);

        // store image in one of the variable & put image on Frame:
        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i1 = image1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon img1 = new ImageIcon(i1);
        JLabel label = new JLabel(img1);
        label.setBounds(170,10,100,100);
        add(label);

        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(300, 40, 400, 40);
        add(text);
        getContentPane().setBackground(Color.white);

        JLabel cardNo = new JLabel("CARD NO: ");
        cardNo.setFont(new Font("Raleway", Font.BOLD, 28));
        cardNo.setBounds(120, 150, 150, 30);
        add(cardNo);

        cardTextField = new JTextField();
        cardTextField.setBounds(300, 150, 250, 30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardTextField);

        JLabel pinNo = new JLabel("PIN: ");
        pinNo.setFont(new Font("Raleway", Font.BOLD, 28));
        pinNo.setBounds(120, 220, 250, 30);
        add(pinNo);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(300, 220, 250, 30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(pinTextField);

        login = new JButton("SIGN IN");
        login.setBounds(300, 300, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        clear = new JButton("CLEAR");
        clear.setBounds(450, 300, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("SIGN UP");
        signup.setBounds(300, 350, 250, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);

        // Size of Frame:
        setSize(800,480);
        // Fram dickne key liye ye line imp hai.
        setVisible(true);
        // while open the Frame open at this location
        setLocation(350,200);
    }

    @Override
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == clear){
            cardTextField.setText("");
            pinTextField.setText("");
        } else if (ae.getSource() == login) {
            Conn conn = new Conn();
            String cardNumber = cardTextField.getText();
            String pinNumber = pinTextField.getText();
            String query = "select * from login where cardNumber = '"+cardNumber+"' and pin = '"+pinNumber+"'";

            try {
               ResultSet rs = conn.s.executeQuery(query);
               if (rs.next()){
                   setVisible(false);
                   new Transactions(pinNumber).setVisible(true);
               }else {
                   JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
               }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        } else if (ae.getSource() == signup) {
            setVisible(false);
            new SignUpOne().setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Login();
    }
}
