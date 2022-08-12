import processing.core.PApplet;
import processing.core.PImage;

public class Main extends PApplet
{
    // Width of our window
    final private int width = 640;
    // height of our window
    final private int height = 480;
    //XandYMenuOptions
    private int X;
    private int SingleY;
    private int TwoY;
    private int HighY;
    private int Clicked;
    private PImage bg;
    
    
    public static void main(String[] args) {
        // Set up the processing library
        PApplet.main("Main");
    }

    public void settings() {
        // Set our window size
        size(width, height);
        X = 220;
        SingleY = 140;
        TwoY = 200;
        HighY = 260;
        Clicked = 1;
    }	

    public void setup() {
    	bg = loadImage(System.getProperty("user.dir") + "/src/background.jpg");
    }

    public void draw() {
    	//Create menu with 3 options, Single Player, Two Player, Highscores
    	//Background
    	background(bg);
        //background(0,0,0);
        //Title
        fill(255,255,255);
        textSize(32);
    	text("Pong!", 275, 60);
    	//Single Player
        fill(255,255,255);
        rect(X, SingleY, 200, 50);
        fill(0,0,0);
        textSize(28);
    	text("Single Player", 235, 175);
    	//Two Players
    	fill(255,255,255);
        rect(X, TwoY, 200, 50);
        fill(0,0,0);
        textSize(28);
    	text("Two Players", 235, 235);
    	//Highscores
    	fill(255,255,255);
        rect(X, HighY, 200, 50);
        fill(0,0,0);
        textSize(28);
    	text("Highscores", 235, 295);
    	//Instructions
    	 fill(255);
         textSize(26);
    	text("UP/DOWN: Player One - W/S, Player Two - K/M", 20, 400);
    	//If Option Clicked
    	if (mousePressed && (mouseX > X && mouseX < X+200 && mouseY > SingleY && mouseY < SingleY+50) && Clicked == 1){
    		Clicked = 0;
    		Pong.main(args);
    	}
    	else if (mousePressed && (mouseX > X && mouseX < X+200 && mouseY > TwoY && mouseY < TwoY+50) && Clicked == 1){
    		Clicked = 0;
    		twoPlayers.main(args);
    	}
    	else if (mousePressed && (mouseX > X && mouseX < X+200 && mouseY > HighY && mouseY < HighY+50) && Clicked == 1){
    		Clicked = 0;
    		//Highscores.main(args);
    	}
    }
}	
	