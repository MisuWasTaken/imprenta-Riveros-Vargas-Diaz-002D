package com.test.test2.PackageTest;

import javax.swing.*;
import java.awt.*;

public class TestInterfaz {

    public static void main(String[] args) {
        JFrame ventana = new JFrame("Interfaz");
        ventana.setSize(400, 300);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());

        // Botón tamaño normal
        JButton boton = new JButton("OK TODO BIEN");
        boton.setPreferredSize(new Dimension(140, 40)); // tamaño tipo "confirmar"

        // Acción: cerrar ventana
        boton.addActionListener(e -> ventana.dispose());
        //Hola mundo
        //Hola mundo 2
        //Hola mundo 3

        panel.add(boton);
        ventana.add(panel);
        ventana.setVisible(true);
    }
}