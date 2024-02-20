package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menu {
    public JPanel menu;
    private JButton modificarDatosButton;
    private JButton ingresarDatosButton;
    private JButton salirButton;




    public menu() {
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        modificarDatosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame reg = new JFrame("Mostrar Datos");
                reg.setContentPane(new Modificar().modificar);
                reg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                reg.setSize(450,800);
                reg.setVisible(true);
                JFrame form1 = (JFrame) SwingUtilities.getWindowAncestor(menu);
                form1.dispose();
                form1.dispose();
            }
        });
        ingresarDatosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame reg = new JFrame("Registro");
                reg.setContentPane(new registroA().registroA);
                reg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                reg.setSize(450,800);
                reg.setVisible(true);
                JFrame form1 = (JFrame) SwingUtilities.getWindowAncestor(menu);
                form1.dispose();
                form1.dispose();
            }
        });
    }
}
