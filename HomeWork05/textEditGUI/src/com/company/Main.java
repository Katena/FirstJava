package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Katrin on 05.12.2014.
 */
public class Main {
    private JButton button;
    private JButton savebuttton;
    private JButton paste;
    private JButton upFont;
    private JButton downFont;

    private JButton bold;
    private JButton italic;
    private JButton base;

    private int font;


    private int count;
    private int textCount = 12;
    private String text = "";


    public static void main(String[] args) {
        Main m = new Main();
        m.buildGUI();
    }

    public void buildGUI() {


        JFrame mainFrame = new JFrame("text edit");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setBounds(300, 300, 400, 400);

        JPanel buttonPanel = new JPanel();
        GridLayout g = new GridLayout(2, 1);
        buttonPanel.setLayout(g);

        JPanel supportPanel = new JPanel();
        supportPanel.setLayout(new GridLayout(1, 3));
        JPanel fontPanel = new JPanel();
        supportPanel.setLayout(new GridLayout(1, 2));
        JPanel stylePanel = new JPanel();
        supportPanel.setLayout(new GridLayout(1, 3));


        final JTextArea textArea = new JTextArea();
        mainFrame.getContentPane().add(BorderLayout.CENTER, textArea);


        button = new JButton("Clear");
        savebuttton = new JButton("Save");
        paste = new JButton("Paste");
        upFont = new JButton("Up");
        downFont = new JButton("Down");
        bold = new JButton("Bold");
        italic = new JButton("Italic");
        base =new JButton("Base");


        base.setBackground(Color.yellow);


        bold.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                font = Font.BOLD;
                textArea.setFont(new Font("Arial", font, textCount));
                if (font == Font.BOLD) {
                    bold.setBackground(Color.yellow);
                    base.setBackground(null);
                    italic.setBackground(null);
                }

            }
        });

        italic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                font = Font.ITALIC;
                textArea.setFont(new Font("Arial", font, textCount));
                if (font == Font.ITALIC) {
                    bold.setBackground(null);
                    base.setBackground(null);
                    italic.setBackground(Color.yellow);
                }
            }
        });

        base.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                font = 0;
                textArea.setFont(new Font("Arial", font, textCount));
                if (font == 0) {
                    bold.setBackground(null);
                    italic.setBackground(null);
                    base.setBackground(Color.yellow);
                }
            }
        });

        upFont.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textCount++;
                textArea.setFont(new Font("Arial", font, textCount));
            }
        });

        downFont.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textCount--;
                textArea.setFont(new Font("Arial", font, textCount));
            }
        });


        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
            }
        });

        savebuttton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text = textArea.getText();
            }
        });

        paste.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText(textArea.getText() + "\n" + text);
            }
        });


        supportPanel.add(savebuttton);
        supportPanel.add(paste);
        supportPanel.add(button);

        stylePanel.add(bold);
        stylePanel.add(italic);
        stylePanel.add(base);

        fontPanel.add(upFont);
        fontPanel.add(downFont);

        buttonPanel.add(supportPanel);
        buttonPanel.add(fontPanel);

        mainFrame.getContentPane().add(BorderLayout.SOUTH, buttonPanel);
        mainFrame.getContentPane().add(BorderLayout.NORTH, stylePanel);

        mainFrame.setVisible(true);

    }
}
