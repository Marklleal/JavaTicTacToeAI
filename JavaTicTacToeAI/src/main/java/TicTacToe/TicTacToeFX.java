package TicTacToe;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TicTacToeFX extends Application {

    private TicTacToe game;
    private Button[][] buttons;
    private Button reset;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        game = new TicTacToe();
        buttons = new Button[3][3];
        reset = new Button("Reset");
        reset.setOnAction(event -> handleResetButtonClick());

        // Cria um segundo GridPane para o botão de reset
        GridPane topGridPane = new GridPane();
        topGridPane.add(reset, 1, 0);
        topGridPane.setHgap(10);

        // Define o posicionamento do segundo GridPane no topo do GridPane principal
        GridPane gridPane = new GridPane();
        gridPane.add(topGridPane, 0, 0);
        GridPane.setColumnSpan(topGridPane, 3);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Button button = new Button();
                button.setMinSize(100, 100);
                final int finalI = i;
                final int finalJ = j;
                button.setOnAction(event -> handleButtonClick(finalI, finalJ));
                gridPane.add(button, i, j+1); // adiciona os botões em linhas abaixo do botão de reset
                buttons[i][j] = button;
            }
        }

        Scene scene = new Scene(gridPane, 320, 420); // aumenta o tamanho da janela para acomodar o botão de reset
        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Define o tamanho mínimo do botão de reset em relação ao tamanho da janela
        reset.setMinWidth(scene.getWidth()/3 - 10);
    }

    private void handleResetButtonClick() {
        game.resetGame();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
            }
        }
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