package com.example.szalaiszabolcs_lotto;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.List;

public class HelloController {
    @FXML
    private Label labelSorsoltSzam;
    @FXML
    private Label labelSorsoltSzamok;
    private List<Integer> szamok = new ArrayList<>();

    @FXML
    public void btnSorsol() {

    }
}