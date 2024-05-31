package com.example.crudswingmvc.view;

import javax.swing.*;
import java.awt.*;

public class CientificoView extends JFrame {
    private JTextField dniField;
    private JTextField nombreApellidosField;
    private JButton addButton;
    private JButton editButton;
    private JButton deleteButton;
    private JButton listButton;

    public CientificoView() {
        setTitle("Científicos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new GridLayout(5, 2));

        dniField = new JTextField();
        nombreApellidosField = new JTextField();
        addButton = new JButton("Agregar");
        editButton = new JButton("Editar");
        deleteButton = new JButton("Eliminar");
        listButton = new JButton("Listar");

        add(new JLabel("DNI:"));
        add(dniField);
        add(new JLabel("Nombre y Apellidos:"));
        add(nombreApellidosField);
        add(addButton);
        add(editButton);
        add(deleteButton);
        add(listButton);
    }

    public JTextField getDniField() {
        return dniField;
    }

    public JTextField getNombreApellidosField() {
        return nombreApellidosField;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getEditButton() {
        return editButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public JButton getListButton() {
        return listButton;
    }
}
