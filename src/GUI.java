package com.company;
import  javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class GUI {
    private JFrame frame;
    private int width;
    private int height;
    ArrayList<ButtonHandeler> buttonlist;
    String frame_title;
    JLabel result;
    String [] calculations= {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", ",", "="};
    String [] Operations= {"+","-","/","*","%","**"};

    //construtor
    GUI(int w, int h,String title){
        frame = new JFrame();
        width = w ;
        height = h ;
        frame_title =title;
    }

    public void setGUI(){
        frame.setSize(width,height);
        frame.setTitle(frame_title);

        JPanel MainPanel= new JPanel();
        GridLayout MainPanelLayout = new GridLayout(1,1);
        MainPanel.setLayout(MainPanelLayout);

        JPanel OperationsPanel= new JPanel();
        GridLayout OperationsPanelLayout = new GridLayout(3,2,5,5);
        OperationsPanel.setLayout(OperationsPanelLayout);

        JPanel calculationsPanel= new JPanel();
        GridLayout calculationsLayout = new GridLayout(2,1);
        calculationsPanel.setLayout(calculationsLayout);
        result=new JLabel("Resultado=");


        JPanel numPanel= new JPanel();
        GridLayout numLayout = new GridLayout(4,4,5,5);
        numPanel.setLayout(numLayout);

        buttonlist=createButtuon();
        for (ButtonHandeler button:buttonlist) {
            if (button.type=="num"){
                numPanel.add(button.Button);
            }else if(button.type=="op"){
                OperationsPanel.add(button.Button);
            }

        }


        calculationsPanel.add(result);
        calculationsPanel.add(numPanel);
        MainPanel.add(calculationsPanel);
        MainPanel.add(OperationsPanel);

        frame.add(MainPanel);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public void setUpButtonListeners(){
        ActionListener buttonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object eventSource=e.getSource();
                for (ButtonHandeler button:buttonlist){
                    if (eventSource==button.Button){
                        result.setText(result.getText()+button.label);
                    }

                }
            }
        };
        for (ButtonHandeler button:buttonlist){
            button.Button.addActionListener(buttonListener);

        }
    }
    public ArrayList<ButtonHandeler> createButtuon(){
        ArrayList<ButtonHandeler> buttonlist=new ArrayList<ButtonHandeler>();
        for (int i = 0; i <calculations.length ; i++) {
            ButtonHandeler button = new ButtonHandeler("num",calculations[i]);
            buttonlist.add(button);
        }
        for (int i = 0; i <Operations.length ; i++) {
            ButtonHandeler button = new ButtonHandeler("op",Operations[i]);
            buttonlist.add(button);
        }
        return buttonlist;
    }

}
