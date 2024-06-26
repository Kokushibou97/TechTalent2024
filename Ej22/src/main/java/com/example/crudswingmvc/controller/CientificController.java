package com.example.crudswingmvc.controller;

import com.example.crudswingmvc.view.CientificoView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class CientificController {
    private CientificoView view;
    private List<Cientific> cientificos;

    public CientificController(CientificoView view) {
        this.view = view;
        this.cientificos = new ArrayList<>();
        this.view.getAddButton().addActionListener(new AddCientificoListener());
        this.view.getEditButton().addActionListener(new EditCientificoListener());
        this.view.getDeleteButton().addActionListener(new DeleteCientificoListener());
        this.view.getListButton().addActionListener(new ListCientificosListener());
    }

    class AddCientificoListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String dni = view.getDniField().getText();
            String nombreApellidos = view.getNombreApellidosField().getText();
            Cientific cientifico = new Cientific(dni, nombreApellidos);
            cientificos.add(cientifico);
            JOptionPane.showMessageDialog(view, "Científico agregado exitosamente.");
        }
    }

    class EditCientificoListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Lógica para editar un científico
        }
    }

    class DeleteCientificoListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Lógica para eliminar un científico
        }
    }

    class ListCientificosListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            StringBuilder sb = new StringBuilder();
            for (Cientific cientifico : cientificos) {
                sb.append(cientifico.getDni()).append(" - ").append(cientifico.getNombreApellidos()).append("\n");
            }
            JOptionPane.showMessageDialog(view, sb.toString());
        }
    }
}
