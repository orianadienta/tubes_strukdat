package com.strukdat.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import com.strukdat.model.*;
import com.strukdat.gimmick.*;
import com.strukdat.data.JSONReader;

import java.util.List;

public class SearchEngineController {
    private Tree<String, String> rbTree;

    public SearchEngineController() {
        rbTree = new Tree<>();
        JSONReader.loadJsonData(rbTree, "/data.json"); // Pastikan path benar
    }

    @FXML
    private AnchorPane Root;

    @FXML
    private Text Text1;

    @FXML
    private Text Text2;

    @FXML
    private Pane TopPane;

    @FXML
    private Button exitButton;

    @FXML
    private TextField inputField;

    @FXML
    private ImageView logoImage;

    @FXML
    private TextArea resultArea;

    @FXML
    private Button searchButton;

    @FXML
    private ImageView searchImage;


    @FXML
    void handleSearch(ActionEvent event) {
        String searchKey = inputField.getText().trim().toLowerCase();
        if ("random".equals(searchKey)) {
            RandomGimmick randomGimmick = new RandomGimmick();
            String result = randomGimmick.runGimmick();
            resultArea.setText(result);
        } else if ("tictactoe".equals(searchKey)) {
            TicTacToeGimmick ticTacToeGimmick = new TicTacToeGimmick();
            String result = ticTacToeGimmick.runGimmick();
            resultArea.setText(result);

        } else {
            // cari key dalam rbt
            List<String> results = rbTree.search(searchKey);
            if (results.isEmpty()) {
                resultArea.setText("Tidak ada hasil untuk pencarian \"" + searchKey + "\".");
            } else {
                StringBuilder resultText = new StringBuilder();
                for (String result : results) {
                    resultText.append("> ").append(result).append("\n");
                }
                resultArea.setText(resultText.toString());
            }
        }
    }

    @FXML
    void searchWord(ActionEvent event) {
    }

    @FXML
    void handleExit(ActionEvent event) {
        System.exit(0);
    }
}

