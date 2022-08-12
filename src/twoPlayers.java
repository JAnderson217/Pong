import java.io.IOException;
import java.util.Random;
import javax.swing.JOptionPane;

import processing.core.PApplet;

public class twoPlayers extends PApplet
{
	private Ball ball;
	private Paddle paddleOne;
	private Paddle paddleTwo;
	//Width and Height of Window
    final private int width = 640;
    final private int height = 480;
    public Random r = new Random();
    private int score;
    private boolean gameOver;

    
    public static void main(String[] args) {
        // Set up the processing library
        PApplet.main("twoPlayers");
    }

    public void settings() {
        // Set our window size
        size(width, height);
    }	

    public twoPlayers() {
    	//increase speed every 2 hits not one
        // Create a random initial position and speed for the ball
        //Start ball in middle
        this.ball = new Ball(width/2, height/2, r.nextInt(2)*3 -1, 6);
        //if singleplayer
        this.paddleOne = new Paddle(40,200,20,80,6);
        this.paddleTwo = new Paddle(600,200,20,80,6);
        this.score = 0;
        this.gameOver = false;
    	//bg = loadImage(System.getProperty("user.dir") + "/src/background.png");
    }

    public void draw() {
    	if (gameOver == false) {
        // Clear the background of the window
        background(0, 0, 0);
        //Score
        fill(255,255,255);
        textSize(44);
    	text(score, 60, 50);
        //Draw Ball, Paddle, HalfwayLine
        drawBall();
        drawPaddle(this.paddleOne);
        drawPaddle(this.paddleTwo);
        drawHalfwayLine();
        //Move paddle
        ball.moveBall();
        int collision = ball.ballHits(paddleOne,paddleTwo,true);
        if (collision == -1) {
        	gameOver = true;
        }
        else if (collision != 0) {
        	score = collision;
        }
    	}
    }
    
    //If W pressed move UP, S move DOWN 
    public void keyPressed() {
    	  if (Character.toUpperCase(key) == 'W'){
    		  paddleOne.movePaddle(false);
          }
          else if (Character.toUpperCase(key) == 'S'){
        	  paddleOne.movePaddle(true);
          }
    	  if (Character.toUpperCase(key) == 'I'){
    		  paddleTwo.movePaddle(false);
          }
          else if (Character.toUpperCase(key) == 'K'){
        	  paddleTwo.movePaddle(true);
          }
    }

    public void drawHalfwayLine() {
    	//Width 4 Height 
    	//Gap of 4 between each
    	//Start 4 in = 476/20
    	int n = 0;
    	for (int i=0; i < height/20; i++) {
    		fill(255,255,255);
            rect((width/2)-2, n , 4, 16);
            n += 20;
    	}
    }

    public void drawBall() {
    	//Ball Colour
        fill(255,255,255);
    	// Draw the ball
        ellipse(ball.getCoords()[0], ball.getCoords()[1], ball.getRadius()*2, ball.getRadius()*2);
    }
    
    
    public void drawPaddle(Paddle paddle){
    	//Paddle Colour
        fill(255,255,255);
        //Draw Paddle
        rect(paddle.getCoords()[0], paddle.getCoords()[1], paddle.getDimensions()[0], paddle.getDimensions()[1]);
    }
    
    public void Quit() {
    	System.exit(0);
    }
    
}	



