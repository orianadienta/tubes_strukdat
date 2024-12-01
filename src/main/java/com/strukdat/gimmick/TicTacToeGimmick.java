package com.strukdat.gimmick;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TicTacToeGimmick implements GimmickInterface {
    @Override
    public String runGimmick() {
        try {
            Parent ticTacToeRoot = FXMLLoader.load(getClass().getResource("/com/strukdat/tictactoe.fxml"));

            Stage ticTacToeStage = new Stage();
            ticTacToeStage.setTitle("Tic-Tac-Toe");
            ticTacToeStage.setScene(new Scene(ticTacToeRoot));
            ticTacToeStage.show();

            return "Tic-Tac-Toe game launched!";
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to launch Tic-Tac-Toe game";
        }
    }
}
