package com.company;

import javax.swing.*;

public class ButtonHandeler {
    public String type;
    public String label;
    public JButton Button;
    ButtonHandeler(String typeButton ,String labelText){
         type =typeButton;
         label= labelText;
         Button =new JButton(label);
    }

}
