package com;

import com.Operations.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by Katrin on 12.12.2014.
 */
public class Calculator {
    private String lastOperation = "+";
    private double result = 0;
    private boolean isFirstOperand = true;

    private JButton[] numberButtons;
    private JButton plusButton;
    private JButton minusButton;
    private JButton multiButton;
    private JButton divisionButton;
    private JButton resultButton;
    private JButton pointButton;

    private JLabel labelTurn;
    private JTextArea textArea;
    private JTextArea interimResArea;
    private double lastN;
    private boolean res = false;

    public void build() {
        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(200, 200, 600, 400);

        labelTurn = new JLabel("    ");
        labelTurn.setFont(new Font("Arial", Font.BOLD, 50));
        labelTurn.setForeground(Color.red);

        textArea = new JTextArea("");
        textArea.setFont(new Font("Arial", Font.BOLD, 50));

        interimResArea = new JTextArea("");
        interimResArea.setFont(new Font("Arial", Font.BOLD, 50));

        JPanel numberPanel = new JPanel(new GridLayout(4, 3));
        JPanel buttonPanel = new JPanel(new GridLayout(4, 1));
        JPanel pointPanel = new JPanel(new GridLayout(2, 1));

        numberButtons = new JButton[12];
        for (int i = 0; i < 12; i++) {
            numberButtons[i] = new JButton();
            numberPanel.add(numberButtons[i]);
            numberButtons[i].setFont(new Font("Arial", Font.BOLD, 50));
        }
        for (int i = 1; i < 10; i++) {
            numberButtons[i].setForeground(Color.magenta);
            numberButtons[i].setText(String.valueOf(i));
            final int button = i;
            numberButtons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    textArea.setText(textArea.getText() + button);
                    lastN = Double.parseDouble(textArea.getText());
                }
            });
        }

        numberButtons[0].setForeground(Color.magenta);
        numberButtons[0].setText(String.valueOf(0));
        numberButtons[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s;
                s = textArea.getText();
                if (s.length() > 1) {
                    textArea.setText(textArea.getText() + 0);
                } else if (!s.isEmpty() && s.charAt(0) == '0') {

                } else if (s.isEmpty()) {
                    textArea.setText(textArea.getText() + 0);
                }
            }
        });

        numberButtons[10].setText("<-");
        numberButtons[11].setText("C");
        numberButtons[10].setForeground(Color.blue);
        numberButtons[11].setForeground(Color.blue);
        plusButton = new JButton("+");
        minusButton = new JButton("-");
        multiButton = new JButton("*");
        divisionButton = new JButton("/");
        resultButton = new JButton("=");
        resultButton.setForeground(Color.red);
        pointButton = new JButton(".");

        pointButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s;
                int c = 0;
                s = textArea.getText();
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) == '.') {
                        c = 1;
                    }
                }
                if (!s.isEmpty() && c == 0) {
                    textArea.setText(textArea.getText() + ".");
                } else if (s.isEmpty()) {
                    textArea.setText("0.");
                }

                if (c == 1) {
                }
            }
        });

        plusButton.addActionListener(new AddListener(this));
        minusButton.addActionListener(new SubListener(this));
        multiButton.addActionListener(new MultiListener(this));
        divisionButton.addActionListener(new DivListener(this));


        numberButtons[10].setFont(new Font("Arial", Font.BOLD, 40));
        plusButton.setFont(new Font("Arial", Font.BOLD, 50));
        minusButton.setFont(new Font("Arial", Font.BOLD, 50));
        multiButton.setFont(new Font("Arial", Font.BOLD, 50));
        divisionButton.setFont(new Font("Arial", Font.BOLD, 50));
        resultButton.setFont(new Font("Arial", Font.BOLD, 50));
        pointButton.setFont(new Font("Arial", Font.BOLD, 50));

        numberButtons[11].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                result = 0;
                lastN = 0;
                interimResArea.setText("");
                res = false;
            }
        });
        numberButtons[10].addActionListener(new BackspaseListener(textArea));
        resultButton.addActionListener(new ResultListener(this));

        buttonPanel.add(plusButton);
        buttonPanel.add(minusButton);
        buttonPanel.add(multiButton);
        buttonPanel.add(divisionButton);
        pointPanel.add(pointButton);
        pointPanel.add(resultButton);

        frame.getContentPane().add(BorderLayout.NORTH, textArea);
        frame.getContentPane().add(BorderLayout.CENTER, numberPanel);
        frame.getContentPane().add(BorderLayout.EAST, buttonPanel);
        frame.getContentPane().add(BorderLayout.SOUTH, interimResArea);
        frame.getContentPane().add(BorderLayout.WEST, pointPanel);

        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new Calculator().build();
    }

    public void setText(String s) {
        textArea.setText(s);
    }

    public void setOperation(String oper) {
        lastOperation = oper;
    }

    public boolean isFirst() {
        return isFirstOperand;
    }

    public void setFirst(boolean isFirst) {
        isFirstOperand = isFirst;
    }

    public void setResult(String text) {
        this.result = Double.parseDouble(text);
    }

    public String getText() {
        return textArea.getText();
    }

    public void calculate() {
        if (res == true) {
            textArea.setText("");
            res = false;
        } else if (lastOperation.equals("+")) {
            lastN = Double.parseDouble(textArea.getText());
            result += lastN;
            showInterResult();
            res = false;
        } else if (lastOperation.equals("-")) {
            lastN = Double.parseDouble(textArea.getText());
            result -= lastN;
            showInterResult();
            res = false;
        } else if (lastOperation.equals("*")) {
            lastN = Double.parseDouble(textArea.getText());
            result *= lastN;
            showInterResult();
            res = false;
        } else if (lastOperation.equals("/")) {
            lastN = Double.parseDouble(textArea.getText());
            result /= lastN;
            showInterResult();
            res = false;
        }

    }

    public void calculateRes() {

        if (lastOperation.equals("+")) {
            result += lastN;
            showInterResult();
        } else if (lastOperation.equals("-")) {
            result -= lastN;
            showInterResult();
        } else if (lastOperation.equals("*")) {
            result *= lastN;
            showInterResult();
        } else if (lastOperation.equals("/")) {
            result /= lastN;
            showInterResult();
        }
    }

    public void showResult() {

        int x = (int) result;
        if ((result - x) == 0) {
            textArea.setText(Integer.toString(x));
        } else {
            textArea.setText(Double.toString(result));
        }
    }

    public void showInterResult() {

        int x = (int) result;
        if ((result - x) == 0) {
            interimResArea.setText(Integer.toString(x));
        } else {
            interimResArea.setText(Double.toString(result));
        }
    }

    public void Listen() {
        String i;

        i = textArea.getText();
        if (result != 0 && i.isEmpty()) {
        } else if (result == 0 && i.isEmpty()) {
        } else {
            if (isFirst()) {
                setFirst(false);
                setResult(getText());
            } else {
                calculate();
            }
            setText("");
        }
    }

    public void listenRes() {
        String i;
        res = true;
        i = textArea.getText();
        if (result == 0 && i.isEmpty()) {
        } else {
            calculateRes();
            showResult();
        }
    }
}

