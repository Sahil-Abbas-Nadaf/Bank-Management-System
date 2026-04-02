package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JButton RS_100, back, RS_500, RS_1000, RS_2000, RS_5000, RS_10000;
    String pinNumber;
    FastCash(String pinNumber){
        this.pinNumber = pinNumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Select withdrawl amount");
        text.setBounds(220, 300, 700, 35);
//        add(text); --> this text add on frame not on image. so we need to add on image
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        RS_100 = new JButton("RS 100");
        RS_100.setBounds(170, 415, 150, 30);
        RS_100.addActionListener(this);
        image.add(RS_100);

        RS_500 = new JButton("Rs 500");
        RS_500.setBounds(355, 415, 150, 30);
        RS_500.addActionListener(this);
        image.add(RS_500);

        RS_1000 = new JButton("Rs 1000");
        RS_1000.setBounds(170, 450, 150, 30);
        RS_1000.addActionListener(this);
        image.add(RS_1000);

        RS_2000 = new JButton("Rs 2000");
        RS_2000.setBounds(355, 450, 150, 30);
        RS_2000.addActionListener(this);
        image.add(RS_2000);

        RS_5000 = new JButton("Rs 5000");
        RS_5000.setBounds(170, 485, 150, 30);
        RS_5000.addActionListener(this);
        image.add(RS_5000);

        RS_10000 = new JButton("Rs 10000");
        RS_10000.setBounds(355, 485, 150, 30);
        RS_10000.addActionListener(this);
        image.add(RS_10000);

        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);

        setSize(900, 840);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == back){
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        } else{
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conn conn = new Conn();
            try{
                ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pinNumber+"'");
                int balance = 0;

                while (rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }

                if (ae.getSource() != back && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "You have insufficient balance");
                    return;
                }

                Date date = new Date();
                String query = "insert into bank values('"+pinNumber+"','"+date+"', 'Withdrawl', '"+amount+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");

                setVisible(false);
                new Transactions(pinNumber).setVisible(true);
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new FastCash("");
    }
}

