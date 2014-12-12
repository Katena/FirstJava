package com;

import com.Listeners.NumberListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Katrin on 12.12.2014.
 */
public class Calculator {
    private JButton[] numberButtons;
    private JButton plusButton;
    private JButton minusButton;
    private JButton multiButton;
    private JButton divisionButton;

    private JLabel labelTurn;

    public void build(){
        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(200, 200, 300, 400);

        labelTurn = new JLabel("    ");
        labelTurn.setFont(new Font("Arial", Font.BOLD, 50));
        labelTurn.setForeground(Color.red);

        JPanel numberPanel = new JPanel(new GridLayout(4, 3));
        JPanel buttonPanel = new JPanel(new GridLayout(4,1));

        numberButtons = new JButton[12];
        for (int i = 0; i < 12; i++) {
            numberButtons[i] = new JButton();
            numberButtons[i].addActionListener(new NumberListener(numberButtons[i], this, labelTurn, i));
            numberPanel.add(numberButtons[i]);
            numberButtons[i].setFont(new Font("Arial", Font.BOLD, 50));
        }
        for (int i = 0; i < 10; i++) {

            numberButtons[i].setText(String.valueOf(i));
        }

        numberButtons[10].setText("<-");
        numberButtons[11].setText("C");
        plusButton = new JButton("+");
        minusButton = new JButton("-");
        multiButton =new JButton("*");
        divisionButton =new JButton("/");

        numberButtons[10].setFont(new Font("Arial", Font.BOLD, 40));
        plusButton.setFont(new Font("Arial", Font.BOLD, 50));
        minusButton.setFont(new Font("Arial", Font.BOLD, 50));
        multiButton.setFont(new Font("Arial", Font.BOLD, 50));
        divisionButton.setFont(new Font("Arial", Font.BOLD, 50));

        numberButtons[11].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelTurn.setText("         ");
            }
        });

        buttonPanel.add(plusButton);
        buttonPanel.add(minusButton);
        buttonPanel.add(multiButton);
        buttonPanel.add(divisionButton);

        frame.getContentPane().add(BorderLayout.NORTH, labelTurn);
        frame.getContentPane().add(BorderLayout.CENTER, numberPanel);
        frame.getContentPane().add(BorderLayout.EAST, buttonPanel);

        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new Calculator().build();

    }

}

