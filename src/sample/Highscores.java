package sample;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Highscores {
    private Group root = new Group();// group to hold all elements in scene
    private Scene scene = new Scene(root, 1000, 721);// scene to show all components
    private VBox scoresPane = new VBox();//vbox for images to be in the same place of invisible vbox
    private ScrollPane scoresScrollPane = new ScrollPane();
    private Label highscoreLbl = new Label("Highscores");
    private ArrayList<Integer> highscores = new ArrayList<Integer>();
    private ArrayList<Label> highscoresLbl = new ArrayList<>();
    private VBox highscoresBox = new VBox();
    private Label noScores = new Label("No HighScores.");
    ImageView bck =new ImageView(new Image("menures/menuBck2_preview.png"));
    public Highscores(){
        Main.ChangeScene(scene);
        String line;
        noScores.setTextFill(Color.WHITE);
        noScores.setFont(Font.font("sans",48));
        highscoreLbl.setTextFill(Color.WHITE);
        highscoreLbl.setFont(Font.font("sans",72));
        highscoresBox.getChildren().add(highscoreLbl);
        try{
            FileReader fileReader = new FileReader("MyFile.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);



            while((line = bufferedReader.readLine()) != null){
                highscores.add(Integer.parseInt(line));
                System.out.println(line);
            }
            bufferedReader.close();
            Collections.sort(highscores);
            Collections.reverse(highscores);

            if(highscores.size() > 0) {
                for (int i = 0; i < highscores.size(); i++) {
                    highscoresLbl.add(new Label((i+1)+" - "+highscores.get((i))));
                }
            }

            if(highscoresLbl.size() > 0) {
                for (int i = 0; i < highscoresLbl.size(); i++) {
                    highscoresLbl.get(i).setTextFill(Color.WHITE);
                    highscoresLbl.get(i).setFont(Font.font("sans",48));
                    highscoresBox.getChildren().add(highscoresLbl.get(i));
                }
            }
        }catch (FileNotFoundException e){
            Main.ChangeScene(new GameMenu().getScene());
            noScores.setTextFill(Color.WHITE);
            noScores.setFont(Font.font("sans",48));
            highscoresBox.getChildren().add(noScores);
        }catch (IOException ioe){
            Main.ChangeScene(new GameMenu().getScene());
        }

        highscoresBox.setAlignment(Pos.TOP_CENTER);
        scoresScrollPane.setContent(highscoresBox);
        scoresScrollPane.setLayoutX((1000/2)-200);
        scoresScrollPane.setLayoutY(250);
        scoresScrollPane.setPrefHeight(400);
        scoresScrollPane.setStyle("-fx-background: #000000;" +
                "-fx-border-color: #ffffff;");
        root.getChildren().addAll(bck,scoresScrollPane);

    }
    public Scene getScene(){
        return this.scene;
    }
}
