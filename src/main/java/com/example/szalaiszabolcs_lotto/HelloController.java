package com.example.szalaiszabolcs_lotto;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.*;

public class HelloController {
    @FXML
    private Label labelSorsoltSzam;
    @FXML
    private Label labelSorsoltSzamok;
    @FXML
    private Button buttonSorsol;
    private List<Integer> szamok = new ArrayList<>();
    private Timer timer;
    private int sorsolHelp;
    private boolean done;

    @FXML
    public void btnSorsolClick() {
        if (szamok.size() != 5) {
            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    Platform.runLater(() -> sorsol());
                }
            },0, 200);
        } else {
            Collections.sort(szamok);
            labelSorsoltSzamok.setText(kiir());
            reset();
        }
    }

    public void sorsol() {
        if (sorsolHelp < 50) {
            int szam = (int) (Math.random() * 90 + 1);
            labelSorsoltSzam.setText(String.format("%d", szam));
            sorsolHelp++;
            if (sorsolHelp % 10 == 0) {
                szamok.add(szam);
                labelSorsoltSzamok.setText(kiir());
            }
        } else {
            timer.cancel();
            buttonSorsol.setText("Rendez");
        }
    }

    public String kiir() {
        StringBuilder s = new StringBuilder();
        for (int szam: szamok) {
            s.append(szam).append("\t");
        }
        return s.toString();
    }

    public void reset() {
        buttonSorsol.setText("Sorsol");
        szamok.clear();
        sorsolHelp = 0;
    }
}