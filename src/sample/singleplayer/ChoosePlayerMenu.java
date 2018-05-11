package sample.singleplayer;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import sample.GameMenu;
import sample.Main;
import sample.Player;


public class ChoosePlayerMenu extends GameMenu{

    public Image player2Body
            ,player2Arm
            ,player1Arm
            ,player1Body;
    public String player1Name,player2Name;

    private Group root = new Group();// group to hold all elements in scene
    private Scene scene = new Scene(root, 1000, 721);// scene to show all components
    private VBox Images;//vbox for images to be in the same place of invisible vbox

    Image rick = new Image("gameres/rickBody.png");
    Image morty = new Image("gameres/body.png");
    Image Background = new Image("menures/menuBck2_preview.png");
    Image Single = new Image("menures/singleplayer_preview.png");


    Label Easy = new Label("Easy");
    Label Medium = new Label(" Medium");
    Label Hard = new Label ("Hard");
    Label guide = new Label("Choose your character by pressing on \nthe Image  and choose difficulty");
    HBox Diffculties;


    ImageView player = new ImageView();
    ImageView BackgroundImage = new ImageView(Background);
    ImageView SingleImage = new ImageView(Single);


    public ChoosePlayerMenu(){
        Main.ChangeScene(this.getScene());
        player.setCache(true);
        SingleImage.setCache(true);
        BackgroundImage.setCache(true);
        player.setImage(rick);


        Button region = new Button();
        region.setMinHeight(rick.getHeight());
        region.setMinWidth(rick.getWidth());
        Diffculties= new HBox(Easy,Medium,Hard);



        InvisibleButtons = new VBox(50, region);
        InvisibleButtons.setAlignment(Pos.TOP_CENTER);
        InvisibleButtons.setLayoutX(1000/2-302/2+100);
        InvisibleButtons.setLayoutY(300);
        InvisibleButtons.setOpacity(0);

        guide.setAlignment(Pos.CENTER);
        guide.setLayoutX(200);
        guide.setLayoutY(600);

        Images = new VBox(50,player);
        Images.setAlignment(Pos.TOP_CENTER);
        Images.setLayoutX(1000/2-302/2+100);
        Images.setLayoutY(250);
        Diffculties= new HBox(Easy,Medium,Hard);
        Easy.setFont(Font.font("Courier New",30));
        Medium.setFont(Font.font("Courier New",30));
        Hard.setFont(Font.font("Courier New",30));
        guide.setFont(Font.font("Courier New",30));
        Easy.setTextFill(Color.WHITE);
        Medium.setTextFill(Color.WHITE);
        Hard.setTextFill(Color.WHITE);
        guide.setTextFill(Color.GREEN);
        Diffculties.setLayoutX(1000/2-Hard.getWidth()/2-175);
        Diffculties.setLayoutY(Images.getLayoutY()+rick.getHeight()+60);
        Diffculties.setSpacing(30);
        Glow glow = new Glow();
        glow.setLevel(40);

        Easy.setEffect(glow);
        Medium.setEffect(glow);
        Hard.setEffect(glow);
        guide.setEffect(glow);


        Button EasyButton = new Button();
        Button MediumButton = new Button();
        Button HardButton = new Button();
        EasyButton.setMinWidth(100);
        EasyButton.setMinHeight(40);

        MediumButton.setMinWidth(120);
        MediumButton.setMinHeight(40);
        HardButton.setMinWidth(100);
        HardButton.setMinHeight(40);



        HBox InvisibleDiffs= new HBox(EasyButton,MediumButton,HardButton);
        InvisibleDiffs.setLayoutX(1000/2-Hard.getWidth()/2-173);
        InvisibleDiffs.setLayoutY(Images.getLayoutY()+rick.getHeight()+70);
        InvisibleDiffs.setSpacing(20);
        InvisibleDiffs.setOpacity(0);
        EasyButton.setOnAction(e->{
            System.out.println("Button clicked");
            if(player.getImage()==rick){
                player1Body = new Image("gameres/rickBody.png", Player.playerWidth,Player.playerHeight,false,false);
                player1Arm =  new Image("gameres/rickGun.png",Player.arm_width,Player.arm_height,false,false);
                player2Body  = new Image("gameres/body.png", Player.playerWidth,Player.playerHeight,false,false);
                player2Arm  = new Image("gameres/arm.png",Player.arm_width,Player.arm_height,false,false);
                player1Name = "Rick";
                player2Name = "Morty";
            }
            else {
                player2Body = new Image("gameres/rickBody.png", Player.playerWidth,Player.playerHeight,false,false);
                player2Arm = new Image("gameres/rickGun.png",Player.arm_width,Player.arm_height,false,false);
                player1Body  = new Image("gameres/body.png", Player.playerWidth,Player.playerHeight,false,false);
                player1Arm  = new Image("gameres/arm.png",Player.arm_width,Player.arm_height,false,false);
                player1Name = "Morty";
                player2Name = "Rick";
            }
            SinglePlayerGame game = new SinglePlayerGame(this,"easy");
            Main.ChangeScene(game.getScene());
        });
        MediumButton.setOnAction(e->{
            System.out.println("Button clicked");
            if(player.getImage()==rick){
                player1Body = new Image("gameres/rickBody.png", Player.playerWidth,Player.playerHeight,false,false);
                player1Arm =  new Image("gameres/rickGun.png",Player.arm_width,Player.arm_height,false,false);
                player2Body  = new Image("gameres/body.png", Player.playerWidth,Player.playerHeight,false,false);
                player2Arm  = new Image("gameres/arm.png",Player.arm_width,Player.arm_height,false,false);
                player1Name = "Rick";
                player2Name = "Morty";
            }
            else {
                player2Body = new Image("gameres/rickBody.png", Player.playerWidth,Player.playerHeight,false,false);
                player2Arm = new Image("gameres/rickGun.png",Player.arm_width,Player.arm_height,false,false);
                player1Body  = new Image("gameres/body.png", Player.playerWidth,Player.playerHeight,false,false);
                player1Arm  = new Image("gameres/arm.png",Player.arm_width,Player.arm_height,false,false);
                player1Name = "Morty";
                player2Name = "Rick";
            }
            SinglePlayerGame game = new SinglePlayerGame(this,"medium");
            Main.ChangeScene(game.getScene());
        });
        HardButton.setOnAction(e->{
            System.out.println("Button clicked");
            if(player.getImage()==rick){
                player1Body = new Image("gameres/rickBody.png", Player.playerWidth,Player.playerHeight,false,false);
                player1Arm =  new Image("gameres/rickGun.png",Player.arm_width,Player.arm_height,false,false);
                player2Body  = new Image("gameres/body.png", Player.playerWidth,Player.playerHeight,false,false);
                player2Arm  = new Image("gameres/arm.png",Player.arm_width,Player.arm_height,false,false);
                player1Name = "Rick";
                player2Name = "Morty";
            }
            else {
                player2Body = new Image("gameres/rickBody.png", Player.playerWidth,Player.playerHeight,false,false);
                player2Arm = new Image("gameres/rickGun.png",Player.arm_width,Player.arm_height,false,false);
                player1Body  = new Image("gameres/body.png", Player.playerWidth,Player.playerHeight,false,false);
                player1Arm  = new Image("gameres/arm.png",Player.arm_width,Player.arm_height,false,false);
                player1Name = "Morty";
                player2Name = "Rick";
            }
            SinglePlayerGame game = new SinglePlayerGame(this,"hard");
            Main.ChangeScene(game.getScene());
        });



        this.root.getChildren().addAll(BackgroundImage,guide,Images,InvisibleButtons,Diffculties,InvisibleDiffs);

        region.setOnMouseClicked(event -> {
            if(player.getImage()==rick){
                player.setImage(morty);
            }
            else{
                player.setImage(rick);
            }
        });


    }

    public Scene getScene(){
        return this.scene;
    }

}
