package sample.ui;

import javafx.scene.*;
import javafx.scene.text.*;
import sample.logic.*;
import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * This class launches creates the user interface
 * and launches the game. It also checks if a user has won
 * by having 4 in a row, column, or diagonally.
 */

public class TicTacToe extends Application {
    gameLogic gameboard = new gameLogic();
    public int arr [][] = new int[4][4];
    public int turn; // keep track of x or y's turn
    public Label label = new Label("");
    public GridPane gridpane = new GridPane();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Button restart = new Button();
        Image img = new Image("file:ng.jpg", 100,30, false, false);
        ImageView view = new ImageView(img);
        restart.setGraphic(view);
        restart.setOnAction(new ButtonClickHandler());

        gridpane.add(restart, 2,6);
        gridpane.setAlignment(Pos.CENTER);
        setGridpane();
        gridpane.setPadding(new Insets(10));
        label.setFont(new Font("Arial", 15));
        VBox vb = new VBox(gridpane, label, restart);
        vb.setAlignment(Pos.CENTER);
        vb.setSpacing(5);
        Scene scene = new Scene(vb,500, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("4x4 Tic-Tac-Toe");
        primaryStage.show();
    }

    // set the gameboard to blanks
    public void setGridpane() {
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                Image blank = new Image("file:blankBox.png");
                ImageView imgView = new ImageView(blank);
                imgView.setFitHeight(100);
                imgView.setFitWidth(100);
                gridpane.add(imgView, i, j);
                imgView.addEventHandler(MouseEvent.MOUSE_CLICKED, new ImageClickHandler());
            }
        }
    }

    class ButtonClickHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            turn = 0;
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    arr[i][j] = 0;
                }
            }
            label.setText("");
            gridpane.getChildren().removeAll();
            gridpane.getChildren().clear();
            setGridpane();
        }
    }

    class ImageClickHandler implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent mouseEvent) {
            ImageView source = (ImageView)mouseEvent.getSource();
            Integer colIndex = GridPane.getColumnIndex(source);
            Integer rowIndex = GridPane.getRowIndex(source);
            int row = rowIndex.intValue();
            int col = colIndex.intValue();
            if(turn % 2 == 0) {
                if(arr[row][col] != 0) { // nothing happens if space is occupied
                    return;
                }
                ((ImageView) mouseEvent.getSource()).setImage(new Image("file:x.png"));
                arr[row][col] = 1;
                checkWinner();
            }
            else { // other player's turn
                if(arr[row][col] != 0) {
                    return;
                }
                Image yImg = new Image("file:o.png");
                ((ImageView) mouseEvent.getSource()).setImage(yImg);
                arr[row][col] = 2;
                checkWinner();
            }
            turn++;
        }
    }

    public void checkWinner() {
        if (gameboard.checkDiagonal(arr) == 1 || gameboard.checkRows(arr) == 1 ||
                gameboard.checkCols(arr) == 1) {
            xWon();
        }
        if (gameboard.checkDiagonal(arr) == 2 || gameboard.checkRows(arr) == 2 ||
                gameboard.checkCols(arr) == 2) {
            xWon();
        }
        if (gameboard.checkDraw(arr) == 16) {
            label.setText("Draw!");
        }
    }

    public void xWon() {
        stopGame();
        label.setText("Player X has won!");
    }

    public void yWon() {
        stopGame();
        label.setText("Player Y has won!");
    }

    public void stopGame() {
        for (int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                arr[i][j] = 100; // change every box to another value
            }
        }
    }
}

