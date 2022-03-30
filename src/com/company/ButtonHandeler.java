package com.company;

import javax.swing.*;
import java.awt.*;

public class ButtonHandeler {
    public String type;
    public String label;
    public JButton Button;
    ButtonHandeler(String typeButton ,String labelText){
         type =typeButton;
         label= labelText;
         Button =new JButton(label);
         //Button.setBounds(200,100,50,50);
        Button.setFont(new Font("Cominc Sans",Font.BOLD,25));
        Button.setBackground(Color.lightGray);
    }

}
