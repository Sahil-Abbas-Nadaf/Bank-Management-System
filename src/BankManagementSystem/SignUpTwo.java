package BankManagementSystem;
import javax.swing.*;
import java.awt.*;
import java.util.Random;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
public class SignUpTwo extends JFrame implements ActionListener{
//    Global declaration:

    JTextField panTextField, aadhaarTextField;
    JButton next;
    JRadioButton syes, sno, eyes, eno;
    JComboBox religions, category, occupation, education, income;
    String formNo;
    SignUpTwo(String formNo){
        //Default layout is set for form you need to make it null;
        //When you setLayout is null only that time setBound works correctly.
        this.formNo = formNo;
        setLayout(null);

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        JLabel additionalDetails = new JLabel("Page 2 : Additional Details");
        additionalDetails.setBounds(290,80,400, 30);
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        add(additionalDetails);

        JLabel religion = new JLabel("Religion: ");
        religion.setFont(new Font("Raleway", Font.BOLD, 20));
        religion.setBounds(100, 140, 100, 30);
        add(religion);

        String valReligion[] = {"Muslim", "Hindu", "Sikh", "Christion", "Other"};
        religions = new JComboBox(valReligion);
        religions.setBounds(300, 140, 400, 30);
        religions.setBackground(Color.WHITE);
        add(religions);

        JLabel cat = new JLabel("Category: ");
        cat.setFont(new Font("Raleway", Font.BOLD, 20));
        cat.setBounds(100, 190, 200, 30);
        add(cat);

        String valCategory[] = {"General","OBC","SC","ST","Other"};
        category = new JComboBox(valCategory);
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.WHITE);
        add(category);

        JLabel in = new JLabel("Income: ");
        in.setFont(new Font("Raleway", Font.BOLD, 20));
        in.setBounds(100, 240, 200, 30);
        add(in);

        String incomeCategory[] = {"Null","1,50,000","2,50,000","5,00,000","Upto 10,00,000"};
        income = new JComboBox(incomeCategory);
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.WHITE);
        add(income);

        JLabel edu = new JLabel("Educational");
        edu.setFont(new Font("Raleway", Font.BOLD, 20));
        edu.setBounds(100, 290, 140, 30);
        add(edu);

        JLabel quali = new JLabel("Qualification: ");
        quali.setFont(new Font("Raleway", Font.BOLD, 20));
        quali.setBounds(100, 315, 200, 30);
        add(quali);

        String educationValues[] = {"Non-Graduate","Graduate","Post-Graduate","5,00,000","Doctrate", "Other"};
        education = new JComboBox(educationValues);
        education.setBounds(300, 315, 400, 30);
        education.setBackground(Color.WHITE);
        add(education);

        JLabel occu = new JLabel("Occupation: ");
        occu.setFont(new Font("Raleway", Font.BOLD, 20));
        occu.setBounds(100, 390, 200, 30);
        add(occu);

        String occupationValues[] = {"Salaried","Self Employed","Business","Student","Retired", "Other"};
        occupation = new JComboBox(occupationValues);
        occupation.setBounds(300, 390, 400, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);


        JLabel panNo = new JLabel("Pan Number: ");
        panNo.setFont(new Font("Raleway", Font.BOLD, 20));
        panNo.setBounds(100, 440, 200, 30);
        add(panNo);

        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        panTextField.setBounds(300, 440, 400, 30);
        add(panTextField);

        JLabel aadhaarNo = new JLabel("Aadhaar Number: ");
        aadhaarNo.setFont(new Font("Raleway", Font.BOLD, 20));
        aadhaarNo.setBounds(100, 490, 200, 30);
        add(aadhaarNo);

        aadhaarTextField = new JTextField();
        aadhaarTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        aadhaarTextField.setBounds(300, 490, 400, 30);
        add(aadhaarTextField);

        JLabel seniorCitizen = new JLabel("Senior Citizen: ");
        seniorCitizen.setFont(new Font("Raleway", Font.BOLD, 20));
        seniorCitizen.setBounds(100, 540, 200, 30);
        add(seniorCitizen);

        syes = new JRadioButton("Yes");
        syes.setBounds(300, 540, 100, 30);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno = new JRadioButton("No");
        sno.setBounds(450, 540, 100, 30);
        sno.setBackground(Color.WHITE);
        add(sno);

        ButtonGroup seniorCitizenStatus = new ButtonGroup();
        seniorCitizenStatus.add(syes);
        seniorCitizenStatus.add(sno);


        JLabel existingAccount = new JLabel("Existing Account: ");
        existingAccount.setFont(new Font("Raleway", Font.BOLD, 20));
        existingAccount.setBounds(100, 590, 200, 30);
        add(existingAccount);

        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 590, 100, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno = new JRadioButton("No");
        eno.setBounds(450, 590, 100, 30);
        eno.setBackground(Color.WHITE);
        add(eno);

        ButtonGroup existingAccountStatus = new ButtonGroup();
        existingAccountStatus.add(eyes);
        existingAccountStatus.add(eno);

        next = new JButton("Next");
        next.setForeground(Color.WHITE);
        next.setBackground(Color.BLACK);
        next.setBounds(620, 660, 80,30);
        next.setFont(new Font("Raleway", Font.BOLD,14));
        next.addActionListener(this);
        add(next);

        setTitle("Sign Up");
        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350,10);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        String sreligion = (String) religions.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();;
        String soccupation = (String) occupation.getSelectedItem();

        String sseniorCitizen = null;
        if (syes.isSelected()){
            sseniorCitizen = "Yes";
        }else if(sno.isSelected()){
            sseniorCitizen = "No";
        }

        String sexistingAccount = null;
        if (eyes.isSelected()){
            sexistingAccount = "Yes";
        }else if (eno.isSelected()){
            sexistingAccount = "No";
        }

        String span = panTextField.getText();
        String saadhaar = aadhaarTextField.getText();


//        Datebase is an external entity so need to put in try and catch;
        try {
                Conn c = new Conn();
                String query = "insert into signuptwo values('"+formNo+"', '"+sreligion+"', '"+scategory+"', '"+sincome+"', '"+seducation+"','"+soccupation+"','"+span+"','"+saadhaar+"', '"+sseniorCitizen+"', '"+sexistingAccount+"')";
                if (c.s != null) {
                    c.s.executeUpdate(query);

                    //Signup3 object
                    setVisible(false);
                    new SignUpThree(formNo).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Database connection failed");
                }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    public static void main(String[] args) {
        new SignUpTwo("");
    }
}
