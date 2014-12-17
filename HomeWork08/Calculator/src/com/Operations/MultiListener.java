package com.Operations;

import com.Calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Katrin on 13.12.2014.
 */
public class MultiListener implements ActionListener {
    private Calculator calculator;

    public MultiListener(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        calculator.Listen();
        calculator.setOperation("*");
    }
}
