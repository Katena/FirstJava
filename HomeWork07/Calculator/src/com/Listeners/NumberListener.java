package com.Listeners;

import com.Calculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Katrin on 12.12.2014.
 */
public class NumberListener implements ActionListener {
    JButton numberButton;
    Calculator calculator;
    JLabel labelTurn;
    int i;

    public NumberListener(JButton numberButton, Calculator calculator, JLabel labelTurn, int i) {
        this.numberButton = numberButton;
        this.calculator = calculator;
        this.labelTurn = labelTurn;
        this.i = i;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (i != 10 && i !=11) labelTurn.setText(String.valueOf(i));
    }
}
