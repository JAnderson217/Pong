import java.io.IOException;
import java.util.Random;
import processing.core.PApplet;

public class Pong extends PApplet
{
	private Ball ball;
	private Paddle paddleOne;
	private Paddle paddleTwo;
    final private int width = 640;
    final private int height = 480;
    public Random r = new Random();
    private int score;
    private boolean gameOver;
    
    public static void main(String[] args) {
        //Set up the processing library
        PApplet.main("Pong");
    }

    public void settings() {
        //Set  window size
        size(width, height);
    }	

    public Pong() {
    	//Pong constructor, set initial values for ball, paddle, score
        this.ball = new Ball(width/2, height/2, r.nextInt(2)*3 -1, 6);
        this.paddleOne = new Paddle(40,200,20,80,6);
        this.score = 0;
        this.gameOver = false;
    }

    public void draw() {
    	//draws on window
    	if (gameOver == false) {
        background(0, 0, 0);
        fill(255,255,255);
        textSize(44);
    	text(score, 60, 50);
        //Draw Ball, Paddle, HalfwayLine
        drawBall();
        drawPaddle();
        drawHalfwayLine();
        //call methods to move ball and paddle
        ball.moveBall();
        int collision = ball.ballHits(paddleOne,paddleTwo);
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
    		  paddleOne.movePaddle(true, this.height);
          }
          else if (Character.toUpperCase(key) == 'S'){
        	  paddleOne.movePaddle(false, this.height);
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
    
    
    public void drawPaddle(){
    	//Paddle Colour
        fill(255,255,255);
        //Draw Paddle
        rect(paddleOne.getCoords()[0], paddleOne.getCoords()[1], paddleOne.getDimensions()[0], paddleOne.getDimensions()[1]);
    }
    
    public void Quit() {
    	System.exit(0);
    }
    
}	



