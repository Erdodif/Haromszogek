package com.example.haromszogek;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.FileChooser;
import javafx.stage.Window;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class HaromszogController {
    @FXML
    public Button buttonAdatokBetoltese;
    @FXML
    public ListView<String> listViewDerekszoguek;
    @FXML
    public ListView<String> listViewKijeloltek;
    @FXML
    public ListView<String> listViewHibak;

    @FXML
    public void onButtonAdatokBetolteseClick(ActionEvent actionEvent) {
        FileChooser fc = new FileChooser();
        fc.setTitle("Opening text files");
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text files (*.txt)", "*.txt"));
        File f= fc.showOpenDialog(null);
        fajlBeolvas(f);
    }

    private void fajlBeolvas(File fajl) {
        try {
            FileReader fr = new FileReader(fajl);
            BufferedReader br = new BufferedReader(fr);
            String sor = br.readLine();
            int i = 1;
            while (sor != null) {
                try {
                    DHaromszog dh = new DHaromszog(sor, i++);
                    listViewDerekszoguek.getItems().add(dh.toString());
                } catch (Exception e) {
                    listViewHibak.getItems().add(e.getMessage());
                }
                sor = br.readLine();
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}