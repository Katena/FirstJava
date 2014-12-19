package com.company;

import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Katrin on 19.12.2014.
 */
public class Main {
    private JButton button;
    private JButton savebutton;
    private JButton loadbutton;
    private JButton upFont;
    private JButton downFont;

    private JButton bold;
    private JButton italic;
    private JButton base;

    private int font;

    private int textCount = 14;

    public static void main(String[] args) {
        Main m = new Main();
        m.buildGUI();
    }

    public void buildGUI() {
        JFrame mainFrame = new JFrame("text edit");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setBounds(300, 300, 400, 400);

        final JFrame errorFrame = new JFrame("Error");
        errorFrame.setBounds(300, 300, 400, 200);

        JPanel buttonPanel = new JPanel();
        GridLayout g = new GridLayout(3, 1);
        buttonPanel.setLayout(g);

        JPanel supportPanel = new JPanel();
        supportPanel.setLayout(new GridLayout(1, 3));
        JPanel fontPanel = new JPanel();
        supportPanel.setLayout(new GridLayout(1, 2));
        JPanel stylePanel = new JPanel();
        supportPanel.setLayout(new GridLayout(1, 3));

        final JTextArea textArea = new JTextArea();
        mainFrame.getContentPane().add(BorderLayout.CENTER, textArea);

        final JTextArea toFile = new JTextArea();
        final JTextArea errorText = new JTextArea();
        errorText.setFont(new Font("Arial", Font.BOLD, 50));
        errorText.setForeground(Color.red);

        errorFrame.add(errorText);

        button = new JButton("Clear");
        savebutton = new JButton("Save");
        loadbutton = new JButton("Load");
        upFont = new JButton("Up");
        downFont = new JButton("Down");
        bold = new JButton("Bold");
        italic = new JButton("Italic");
        base = new JButton("Base");

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

        savebutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String savefile;
                savefile = toFile.getText();
                File file = new File(savefile);
                try {
                    PrintWriter writer = new PrintWriter(new FileOutputStream(file));

                    writer.println(textArea.getText());

                    writer.flush();
                    writer.close();
                } catch (FileNotFoundException ex) {
                    errorText.setText("File not found!");
                    errorFrame.setVisible(true);
                }
            }
        });

        loadbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sfile;
                sfile = toFile.getText();

                File file = new File(sfile);
                BufferedReader reader;
                try {
                    reader = new BufferedReader(
                            new InputStreamReader(
                                    new FileInputStream(file)
                            )
                    );

                    String s;
                    while ((s = reader.readLine()) != null) {
                        textArea.setText(textArea.getText() + s + "\n");
                    }

                    reader.close();
                } catch (FileNotFoundException ex) {
                    errorText.setText("File not found!");
                    errorFrame.setVisible(true);
                } catch (IOException ex) {
                    errorText.setText("Error closing the file");
                    errorFrame.setVisible(true);
                }
            }
        });

        supportPanel.add(savebutton);
        supportPanel.add(loadbutton);
        supportPanel.add(button);

        stylePanel.add(bold);
        stylePanel.add(italic);
        stylePanel.add(base);

        fontPanel.add(upFont);
        fontPanel.add(downFont);

        buttonPanel.add(supportPanel);
        buttonPanel.add(toFile);
        buttonPanel.add(fontPanel);

        mainFrame.getContentPane().add(BorderLayout.SOUTH, buttonPanel);
        mainFrame.getContentPane().add(BorderLayout.NORTH, stylePanel);

        mainFrame.setVisible(true);

    }
}
