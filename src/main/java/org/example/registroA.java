package org.example;

import com.mongodb.client.*;
import org.bson.Document;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;

public class registroA {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton ingresarNotasButton;
    public JPanel registroA;
    private JButton Buscar;

    public registroA() {
        ingresarNotasButton.addComponentListener(new ComponentAdapter() {
        });
        ingresarNotasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
                MongoDatabase database = mongoClient.getDatabase("Baseprogra");
                MongoCollection<Document> collection = database.getCollection("coleccion1");

                String nombre= textField1.getText();
                String calif1= textField2.getText();
                String calif2= textField3.getText();



                Document document = new Document("name", nombre)
                        .append("Calificacion 1", calif1)
                        .append("Calificacion 2", calif2);

                collection.insertOne(document);
                System.out.println("Documento insertado");
                JOptionPane.showMessageDialog(null, "Datos ingresados correctamente");
                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
            }
        });

    }
}
