package com;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TicTacToe {
    private JButton[] gameButtons;
    private JButton newGameButton;
    private JButton exitButton;
    private JLabel labelTurn;
    private boolean turn = false;
    int[] arrayX = new int[9];
    int[] arrayO = new int[9];

    public void build() {
        JFrame frame = new JFrame("TicTacToe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(200, 200, 300, 400);

        labelTurn = new JLabel("                 X's turn");
        labelTurn.setFont(new Font("Arial", Font.BOLD, 21));
        labelTurn.setForeground(Color.red);

        JPanel gamePanel = new JPanel(new GridLayout(3, 3));
        JPanel buttonPanel = new JPanel();

        gameButtons = new JButton[9];
        for (int i = 0; i < 9; i++) {
            gameButtons[i] = new JButton();
            gameButtons[i].addActionListener(new TurnListener(gameButtons[i], i));
            gamePanel.add(gameButtons[i]);
        }

        newGameButton = new JButton("New game");
        exitButton = new JButton("Exit");

        newGameButton.addActionListener(new NewGameButtonListener());

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        buttonPanel.add(newGameButton);
        buttonPanel.add(exitButton);

        frame.getContentPane().add(BorderLayout.NORTH, labelTurn);
        frame.getContentPane().add(BorderLayout.CENTER, gamePanel);
        frame.getContentPane().add(BorderLayout.SOUTH, buttonPanel);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new TicTacToe().build();
    }

    private class NewGameButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            for (JButton button : gameButtons) {
                button.setText("");
                button.setEnabled(true);
            }
            for (int i = 0; i < arrayX.length; i++) {
                arrayX[i] = 0;
            }
            for (int i = 0; i < arrayO.length; i++) {
                arrayO[i] = 0;
            }
        }
    }

    private class TurnListener implements ActionListener {
        private JButton button;
        int temp;

        public TurnListener(JButton button, int i) {
            this.button = button;
            temp = i;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame frameWin = new JFrame("TicTacToe");
            frameWin.setBounds(200, 300, 200, 100);

            JLabel labelWinO;
            labelWinO = new JLabel("          O Win!!");
            labelWinO.setFont(new Font("Arial", Font.BOLD, 21));
            labelWinO.setForeground(Color.red);

            JLabel labelWinX;
            labelWinX = new JLabel("          X Win!!");
            labelWinX.setFont(new Font("Arial", Font.BOLD, 21));
            labelWinX.setForeground(Color.red);

            JLabel labelWinN;
            labelWinN = new JLabel("      Dead heat!!");
            labelWinN.setFont(new Font("Arial", Font.BOLD, 21));
            labelWinN.setForeground(Color.red);

            if (turn) {
                if (arrayX[temp] == 1) {
                    arrayO[temp] = 0;

                } else if (arrayO[temp] == 0) {
                    arrayO[temp] = 1;
                    button.setFont(new Font("Arial", Font.BOLD, 50));
                    button.setForeground(Color.magenta);
                    button.setText("O");
                    labelTurn.setText("                 X's turn");
                    turn = false;
                } else if (arrayO[temp] == 1) {
                    button.setText("O");
                    turn = true;
                }
            } else {
                if (arrayO[temp] == 1) {
                    arrayX[temp] = 0;

                } else if (arrayX[temp] == 0) {
                    arrayX[temp] = 1;
                    button.setFont(new Font("Arial", Font.BOLD, 50));
                    button.setForeground(Color.blue);
                    button.setText("X");
                    labelTurn.setText("                 O's turn");
                    turn = true;
                } else if (arrayX[temp] == 1) {
                    button.setText("X");
                    turn = false;
                }
            }

            if ((arrayX[0] == 1 && arrayX[3] == 1 && arrayX[6] == 1) ||
                    (arrayX[1] == 1 && arrayX[4] == 1 && arrayX[7] == 1) ||
                    (arrayX[2] == 1 && arrayX[5] == 1 && arrayX[8] == 1) ||
                    (arrayX[0] == 1 && arrayX[1] == 1 && arrayX[2] == 1) ||
                    (arrayX[3] == 1 && arrayX[4] == 1 && arrayX[5] == 1) ||
                    (arrayX[6] == 1 && arrayX[7] == 1 && arrayX[8] == 1) ||
                    (arrayX[0] == 1 && arrayX[4] == 1 && arrayX[8] == 1) ||
                    (arrayX[2] == 1 && arrayX[4] == 1 && arrayX[6] == 1)) {
                frameWin.getContentPane().add(BorderLayout.CENTER, labelWinX);
                frameWin.setVisible(true);
                for (int i = 0; i < 9; i++) {
                    gameButtons[i].setEnabled(false);
                }
            } else if ((arrayO[0] == 1 && arrayO[3] == 1 && arrayO[6] == 1) ||
                    (arrayO[1] == 1 && arrayO[4] == 1 && arrayO[7] == 1) ||
                    (arrayO[2] == 1 && arrayO[5] == 1 && arrayO[8] == 1) ||
                    (arrayO[0] == 1 && arrayO[1] == 1 && arrayO[2] == 1) ||
                    (arrayO[3] == 1 && arrayO[4] == 1 && arrayO[5] == 1) ||
                    (arrayO[6] == 1 && arrayO[7] == 1 && arrayO[8] == 1) ||
                    (arrayO[0] == 1 && arrayO[4] == 1 && arrayO[8] == 1) ||
                    (arrayO[2] == 1 && arrayO[4] == 1 && arrayO[6] == 1)) {
                frameWin.getContentPane().add(BorderLayout.CENTER, labelWinO);
                frameWin.setVisible(true);
                for (int i = 0; i < 9; i++) {
                    gameButtons[i].setEnabled(false);
                }
            } else if ((arrayX[0] + arrayX[1] + arrayX[2] + arrayX[3] + arrayX[4] + arrayX[5] +
                    arrayX[6] + arrayX[7] + arrayX[8] + arrayO[0] + arrayO[1] + arrayO[2] +
                    arrayO[3] + arrayO[4] + arrayO[5] + arrayO[6] + arrayO[7] + arrayO[8]) == 9) {
                frameWin.getContentPane().add(BorderLayout.CENTER, labelWinN);
                frameWin.setVisible(true);
                for (int i = 0; i < 9; i++) {
                    gameButtons[i].setEnabled(false);
                }
            }
        }

    }
}
