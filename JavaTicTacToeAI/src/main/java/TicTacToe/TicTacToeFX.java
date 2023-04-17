package TicTacToe;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TicTacToeFX extends Application {

    private TicTacToe game;
    private Button[][] buttons;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        game = new TicTacToe();
        buttons = new Button[3][3];
        GridPane gridPane = new GridPane();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Button button = new Button();
                button.setMinSize(100, 100);
                final int finalI = i;
                final int finalJ = j;
                button.setOnAction(event -> handleButtonClick(finalI, finalJ));
                gridPane.add(button, i, j);
                buttons[i][j] = button;
            }
        }

        Scene scene = new Scene(gridPane, 300, 300);
        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void handleButtonClick(int row, int col) {
        if (game.placeMark(row, col)) {
            buttons[row][col].setText(String.valueOf(game.getCurrentPlayer()));
            if (game.checkForWin()) {
                System.out.println("O jogador " + game.getCurrentPlayer() + " venceu!");
                // Implemente o que fazer quando um jogador vencer, como mostrar uma mensagem e reiniciar o jogo.
            } else if (game.isBoardFull()) {
                System.out.println("Empate!");
                // Implemente o que fazer em caso de empate, como mostrar uma mensagem e reiniciar o jogo.
            } else {
                game.changePlayer();
            }
        }
    }
}