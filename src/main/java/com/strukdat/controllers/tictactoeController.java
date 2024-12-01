package com.strukdat.controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

import java.util.Random;

public class tictactoeController {
    @FXML
    private Button Button1;

    @FXML
    private Button Button2;

    @FXML
    private Button Button3;

    @FXML
    private Button Button4;

    @FXML
    private Button Button5;

    @FXML
    private Button Button6;

    @FXML
    private Button Button7;

    @FXML
    private Button Button8;

    @FXML
    private Button Button9;

    @FXML
    private Button restartButton;

    @FXML
    private Text tictactoeText;

    private Button[] buttons;
    private boolean player1Turn;
    private Random random = new Random();

    @FXML
    public void initialize() {
        buttons = new Button[]{
                Button1, Button2, Button3,
                Button4, Button5, Button6,
                Button7, Button8, Button9
        };
        for (Button button : buttons) {
            button.setOnAction(this::handleButtonClick);
            button.setStyle(
                    "-fx-border-color: black;" +
                            "-fx-border-width: 1px;" +
                            "-fx-background-color: white;"
            );
        }
        tictactoeText.setText("Tic-Tac-Toe");
        Platform.runLater(this::firstTurn);
    }

    private void handleButtonClick(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();

        if (clickedButton.getText().isEmpty()) {
            if (player1Turn) {
                clickedButton.setText("X");
                clickedButton.setTextFill(Color.RED);
                player1Turn = false;
                tictactoeText.setText("O turn");
            } else {
                clickedButton.setText("O");
                clickedButton.setTextFill(Color.BLUE);
                player1Turn = true;
                tictactoeText.setText("X turn");
            }

            check();
        }
    }

    @FXML
    void handleRestart(ActionEvent event) {
        for (Button button : buttons) {
            button.setText("");
            button.setDisable(false);
            button.setStyle(
                    "-fx-border-color: black;" +
                            "-fx-border-width: 1px;" +
                            "-fx-background-color: white;"
            );
            button.setTextFill(Color.BLACK);
        }
        tictactoeText.setText("Tic-Tac-Toe");
        firstTurn(); //restart game
    }

    private void firstTurn() {
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO, e -> tictactoeText.setText("Tic-Tac-Toe")),
                new KeyFrame(Duration.seconds(3), e -> {
                    if (random.nextInt(2) == 0) {
                        player1Turn = true;
                        tictactoeText.setText("X turn");
                    } else {
                        player1Turn = false;
                        tictactoeText.setText("O turn");
                    }
                })
        );
        timeline.play();
    }

    private void check() {
        checkWinCondition("X", this::xWins);
        checkWinCondition("O", this::oWins);
    }

    private void checkWinCondition(String player, WinCallback callback) {
        // horizontal
        if (buttons[0].getText().equals(player) && buttons[1].getText().equals(player) && buttons[2].getText().equals(player))
            callback.onWin(0, 1, 2);
        if (buttons[3].getText().equals(player) && buttons[4].getText().equals(player) && buttons[5].getText().equals(player))
            callback.onWin(3, 4, 5);
        if (buttons[6].getText().equals(player) && buttons[7].getText().equals(player) && buttons[8].getText().equals(player))
            callback.onWin(6, 7, 8);

        // Vertikal
        if (buttons[0].getText().equals(player) && buttons[3].getText().equals(player) && buttons[6].getText().equals(player))
            callback.onWin(0, 3, 6);
        if (buttons[1].getText().equals(player) && buttons[4].getText().equals(player) && buttons[7].getText().equals(player))
            callback.onWin(1, 4, 7);
        if (buttons[2].getText().equals(player) && buttons[5].getText().equals(player) && buttons[8].getText().equals(player))
            callback.onWin(2, 5, 8);

        // Diagonal
        if (buttons[0].getText().equals(player) && buttons[4].getText().equals(player) && buttons[8].getText().equals(player))
            callback.onWin(0, 4, 8);
        if (buttons[2].getText().equals(player) && buttons[4].getText().equals(player) && buttons[6].getText().equals(player))
            callback.onWin(2, 4, 6);
    }

    private void xWins(int a, int b, int c) {
        buttons[a].setStyle("-fx-background-color: green;");
        buttons[b].setStyle("-fx-background-color: green;");
        buttons[c].setStyle("-fx-background-color: green;");

        for (Button button : buttons) {
            button.setDisable(true);
        }
        tictactoeText.setText("X wins");
    }

    private void oWins(int a, int b, int c) {
        buttons[a].setStyle("-fx-background-color: green;");
        buttons[b].setStyle("-fx-background-color: green;");
        buttons[c].setStyle("-fx-background-color: green;");

        for (Button button : buttons) {
            button.setDisable(true);
        }
        tictactoeText.setText("O wins");
    }
    @FunctionalInterface
    private interface WinCallback {
        void onWin(int a, int b, int c);
    }
}