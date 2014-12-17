package com.Operations;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Katrin on 13.12.2014.
 */
public class BackspaseListener implements ActionListener {
    private JTextArea textArea;

    public BackspaseListener(JTextArea textArea) {
        this.textArea = textArea;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!textArea.getText().isEmpty()) {
            textArea.setText(textArea.getText().substring(0, textArea.getText().length() - 1));
        }
    }
}
