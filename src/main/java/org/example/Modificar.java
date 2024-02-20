package org.example;

import com.mongodb.client.*;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import com.mongodb.client.model.Filters;
import org.bson.conversions.Bson;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Modificar {
    public JPanel modificar;
    private JTextField busquedacampo;
    private JTextField nombrefield;
    private JTextField calif1field;
    private JTextField calif2field;
    private JButton modificarButton;
    private JButton buscar;

    public Modificar() {
        buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
                    MongoDatabase database = mongoClient.getDatabase("Baseprogra");
                    MongoCollection<org.bson.Document> collection = database.getCollection("coleccion1");
                    String name = busquedacampo.getText();

                    // Construir el filtro para buscar por ID
                    Bson filter = Filters.eq("name", name);

                    // Ejecutar la consulta
                    Document result = collection.find(filter).first();

                    // Ejecutar la consulta
                    if (result != null) {
                        System.out.println("Documento encontrado: " + result.toJson());

                    } else {
                        System.out.println("Documento no encontrado");
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
