package com.company;

import javax.script.ScriptException;
import  javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Stack;


public class GUI {
    private JFrame frame;
    private final int width;
    private final int height;
    ArrayList<ButtonHandeler> buttonlist;
    String frame_title;
    JLabel result;
    String[] calculations = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "_x", "="};
    String[] Operations = {"+", "-", "/", "*", "%", "^", "(", ")"};

    //construtor
    GUI(int w, int h, String title) {
        frame = new JFrame();
        width = w;
        height = h;
        frame_title = title;
    }

    public void setGUI() {
        frame.setSize(width, height);
        frame.setTitle(frame_title);


        JPanel MainPanel = new JPanel();
        GridLayout MainPanelLayout = new GridLayout(1, 1, 5, 5);
        MainPanel.setLayout(MainPanelLayout);
        MainPanel.setBackground(Color.DARK_GRAY);

        JPanel OperationsPanel = new JPanel();
        BorderLayout borderLayout = new BorderLayout();
        OperationsPanel.setLayout(borderLayout);
        OperationsPanel.setBackground(Color.DARK_GRAY);

        JPanel OperationsCenterPanel = new JPanel();
        GridLayout OperationsCenterPanelLayout = new GridLayout(4, 2, 5, 5);
        OperationsCenterPanel.setLayout(OperationsCenterPanelLayout);
        OperationsCenterPanel.setBackground(Color.DARK_GRAY);


        JPanel calculationsPanel = new JPanel();
        GridLayout calculationsLayout = new GridLayout(1, 1);
        calculationsPanel.setLayout(calculationsLayout);
        calculationsPanel.setBackground(Color.DARK_GRAY);

        result = new JLabel(" ");
        result.setFont(new Font("Cominc Sans", Font.BOLD, 25));
        result.setForeground(Color.lightGray);


        JPanel numPanel = new JPanel();

        GridLayout numLayout = new GridLayout(4, 4, 5, 5);
        numPanel.setLayout(numLayout);
        numPanel.setBackground(Color.DARK_GRAY);

        buttonlist = createButtuon();
        for (ButtonHandeler button : buttonlist) {
            if (button.type.equals("num")) {
                numPanel.add(button.Button);
            } else if (button.type.equals("op")) {
                OperationsCenterPanel.add(button.Button);
            }

        }


        OperationsPanel.add(result, BorderLayout.SOUTH);
        OperationsPanel.add(OperationsCenterPanel, BorderLayout.CENTER);
        calculationsPanel.add(numPanel);
        MainPanel.add(calculationsPanel);
        MainPanel.add(OperationsPanel);

        frame.add(MainPanel);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void setUpButtonListeners() {
        ActionListener buttonListener = e -> {
            Object eventSource = e.getSource();
            for (ButtonHandeler button : buttonlist) {
                if (eventSource == button.Button) {

                    String newText = result.getText();
                    int textLength = newText.length();
                    if (button.label.equals("_x")) {
                        newText = textLength - 1 > 0 ? newText.substring(0, textLength - 1) : " ";
                        result.setText(newText);
                    } else if (button.label.equals("=")) {
                        getResult(newText);

                    } else {
                        newText += button.label;
                        result.setText(newText);

                    }


                }

            }
        };
        for (ButtonHandeler button : buttonlist) {
            button.Button.addActionListener(buttonListener);

        }
    }

    public ArrayList<ButtonHandeler> createButtuon() {
        ArrayList<ButtonHandeler> buttonlist = new ArrayList<ButtonHandeler>();
        for (int i = 0; i < calculations.length; i++) {
            ButtonHandeler button = new ButtonHandeler("num", calculations[i]);
            buttonlist.add(button);
        }
        for (int i = 0; i < Operations.length; i++) {
            ButtonHandeler button = new ButtonHandeler("op", Operations[i]);
            buttonlist.add(button);
        }
        return buttonlist;
    }

    static double getResult(String textResult) {

        textResult = textResult.strip();
        char[] expression = textResult.toCharArray();

        Stack<Integer> numbers = new Stack<Integer>();
        Stack<Character> operations = new Stack<Character>();

        StringBuilder numbertext = new StringBuilder();

        for (char letter : expression) {
            if (Character.isDigit(letter)) {
                numbertext.append(letter);
            } else{
                numbers.add(Integer.valueOf(numbertext.toString()));
                numbertext = new StringBuilder();
                operations.add(letter);
            }
        }
        numbers.add(Integer.valueOf(numbertext.toString()));
        return 0;
    }

}


