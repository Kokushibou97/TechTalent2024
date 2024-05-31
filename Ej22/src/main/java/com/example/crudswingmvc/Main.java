package com.example.crudswingmvc;

import com.example.crudswingmvc.controller.CientificoController;
import com.example.crudswingmvc.view.CientificoView;

public class Main {
    public static void main(String[] args) {
        CientificoView view = new CientificoView();
        CientificoController controller = new CientificoController(view);
        view.setVisible(true);
    }
}
