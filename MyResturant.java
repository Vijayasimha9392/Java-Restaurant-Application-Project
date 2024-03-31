package com.mycompany.mavenproject1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyResturant extends JFrame {
    JLabel Customer, Name, Contact, Food, Drink, Type;
    JTextField tfNumber, tfName, tfContact, tfFood, tfDrink, tfType;
    JButton Reset, Print, Receipt;
    JComboBox<String> cbFood, cbDrink;
    JRadioButton r1, r2;
    JTextArea area1, area2;
    int total, dprice, fprice;

    MyResturant() {

        setTitle("Restaurant and Coffee");
        setSize(700, 500);
        setLayout(null);

        Customer = new JLabel("Customer No : ");
        Customer.setBounds(20, 50, 120, 30);
        tfNumber = new JTextField();
        tfNumber.setBounds(150, 50, 200, 30);

        Name = new JLabel("Name : ");
        Name.setBounds(20, 100, 120, 30);
        tfName = new JTextField();
        tfName.setBounds(150, 100, 200, 30);

        Contact = new JLabel("Contact : ");
        Contact.setBounds(20, 150, 120, 30);
        tfContact = new JTextField();
        tfContact.setBounds(150, 150, 200, 30);

        Food = new JLabel("Foods : ");
        Food.setBounds(20, 200, 120, 30);

        String foods[] = { "Pizza", "KFC", "Burger" };
        cbFood = new JComboBox<>(foods);
        cbFood.setBounds(150, 200, 120, 30);

        tfFood = new JTextField();
        tfFood.setBounds(300, 200, 200, 30);

        Drink = new JLabel("Drink : ");
        Drink.setBounds(20, 250, 120, 30);

        String drinks[] = { "Lemon", "Mango", "Sapota" };
        cbDrink = new JComboBox<>(drinks);
        cbDrink.setBounds(150, 250, 120, 30);

        tfDrink = new JTextField();
        tfDrink.setBounds(300, 250, 200, 30);

        Type = new JLabel("Type : ");
        Type.setBounds(20, 300, 120, 30);

        r1 = new JRadioButton("Diet");
        r2 = new JRadioButton("Normal");
        r1.setBounds(150, 300, 60, 30);
        r2.setBounds(220, 300, 80, 30);

        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);

        tfType = new JTextField();
        tfType.setBounds(300, 300, 200, 30);

        Reset = new JButton("Reset");
        Reset.setBounds(400, 100, 80, 40);

        Receipt = new JButton("Receipt");
        Receipt.setBounds(480, 100, 80, 40);

        Print = new JButton("Print");
        Print.setBounds(560, 100, 80, 40);

        getContentPane().add(r1);
        getContentPane().add(r2);
        getContentPane().add(Reset);
        getContentPane().add(cbFood);
        getContentPane().add(cbDrink);

        getContentPane().add(Customer);
        getContentPane().add(tfNumber);

        getContentPane().add(Name);
        getContentPane().add(tfName);

        getContentPane().add(Contact);
        getContentPane().add(tfContact);

        getContentPane().add(Food);

        getContentPane().add(Drink);

        getContentPane().add(Type);

        getContentPane().add(Reset);
        getContentPane().add(Receipt);
        getContentPane().add(Print);
        // getContentPane().add(tfType);

        area1 = new JTextArea();
        area1.setBounds(400, 150, 240, 200);
        getContentPane().add(area1);

        Reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfNumber.setText("");
                tfContact.setText("");
                tfName.setText("");
                area1.setText("");
            }
        });

        Print.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    area1.print();
                } catch (PrinterException ex) {
                    ex.printStackTrace();
                }
            }
        });

        Receipt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                area1.setText("Happy Restaurant\n");
                area1.append("Customer Number : " + tfNumber.getText()
                        + "\nName : " + tfName.getText() + "\nContact : " + tfContact.getText());

                area1.setText(area1.getText() + "\nFood : " + cbFood.getSelectedItem());
                area1.setText(area1.getText() + "\nDrink : " + cbDrink.getSelectedItem());

                if (cbFood.getSelectedIndex() == 0) {
                    fprice = 200;
                }
                if (cbFood.getSelectedIndex() == 1) {
                    fprice = 300;
                }
                if (cbFood.getSelectedIndex() == 2) {
                    fprice = 400;
                }
                if (cbDrink.getSelectedIndex() == 0) {
                    dprice = 158;
                    total = fprice + dprice;
                    area1.setText(area1.getText() + "\n Total =" + total);
                }
                if (cbDrink.getSelectedIndex() == 1) {
                    dprice = 657;
                    total = fprice + dprice;
                    area1.setText(area1.getText() + "\n Total =" + total);
                }
                if (cbDrink.getSelectedIndex() == 2) {
                    dprice = 954;
                    total = fprice + dprice;
                    area1.setText(area1.getText() + "\n Total =" + total);
                }
            }
        });

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new MyResturant();
    }
}
