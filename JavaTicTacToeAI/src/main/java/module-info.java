module com.mycompany.javatictactoeai {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires javafx.graphics;

    opens TicTacToe to javafx.fxml;
    exports TicTacToe;
}
