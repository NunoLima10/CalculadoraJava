package com.company;

import com.company.GUI;

public class Main {

    public static void main(String[] args) {
        GUI Calculadora = new GUI(600,600,"Calculadora");
        Calculadora.setGUI();
        Calculadora.setUpButtonListeners();
    }
}
