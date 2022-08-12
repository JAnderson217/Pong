import java.io.IOException;
import java.util.ArrayList;

public class Ball {
	//ball coordinates
	private int x;
	private int y;
	private int ballSpeedX;
	private int ballSpeedY;
	private int radius;
	private int score;
	
	public Ball(int x, int y, int ballSpeed, int radius) {
		this.x = x;
		this.y = y;
		this.ballSpeedX = ballSpeed;
		this.ballSpeedY = ballSpeed;
		this.radius = radius;
		this.score = 0;
	}
	
	public void moveBall() {
		this.x+=this.ballSpeedX;
		this.y+=this.ballSpeedY;
	}
	
	public void increaseSpeed(){
		if (this.ballSpeedX > 0) {
			this.ballSpeedX++;
		}
		else {
			this.ballSpeedX--;
		}
		if (this.ballSpeedY > 0) {
			this.ballSpeedY++;
		}
		else {
			this.ballSpeedY--;
		}
	}
	
	public int[] getCoords() {
		return new int[] {this.x, this.y};
	}
	
	public int getRadius() {
		return this.radius;
	}
	
	public int[] getSpeed() {
		return new int[] {this.ballSpeedX, this.ballSpeedY};
	}
//	public int ballHits(Paddle paddleOne, Paddle paddleTwo) {
//		//return true if game continues, false if game/round ends i.e. hits wall  
//		//0,300,400 just used as example coords, fix
//		//Single Player, if hits walls/paddle then ballSpeed negative, if hits close wall then game end
//		if (this.x <= 0) {
//			return -1;
//		}
//		//hits top or bottom walls
//		else if (this.y <=0 || this.y>=480) {
//			this.y = -this.y;	
//		}
//		//hits first Paddle , add y
//		else if (this.x <= paddleOne.getCoords()[0] ) {
//			increaseSpeed();
//			this.x =-this.x;
//			return 1;
//		}
//		else if (this.x >= 640) {
//			this.x =-this.x;
//		}
//
//		return 0;
//	}
	
	public int ballHits(Paddle paddleOne, Paddle paddleTwo) {
		//System.out.println("current speed X: " + getSpeed()[0] + " Y: " + getSpeed()[1]);
		int temp = ballWallHit(paddleOne);
		if (temp == -1) {
			return temp;
		}
		return ballPaddleHit(paddleOne);
	}

	public int ballPaddleHit(Paddle paddle) {
    	//Change speeds if hits corner then x and y equal magnitude, if middle then y is lower?
    	//if ball hits corner +-5 of edges then 
    	//so ball bounces diff, if off corners then x, y equal magnitude
    	if ((this.x-this.radius == paddle.getCoords()[0] +20) && (this.y-this.radius < paddle.getCoords()[1] + 80 -5) && (this.y+this.radius > paddle.getCoords()[1] +5)) {
    		//Increase speed every other hit
    		//ballSpeedX will always be negative if hits paddle
    		System.out.println("paddle hit");
    		score++;
    		if ((this.score % 2 == 0)) {
    			this.ballSpeedX -= 1;
    		}
    		//ball speed y doesnt need to change every 2 hits
    		if ((this.ballSpeedY > 0)) {
    			this.ballSpeedY = 1;
    		}
    		else if ((this.y < 0)) {
    			this.ballSpeedY = -1;
    		}
    		//reverse X
    		this.ballSpeedX =-this.ballSpeedX;
    		return score;
    	}
    	else if ((this.x-this.radius == paddle.getCoords()[0] +20) && (this.y-this.radius < paddle.getCoords()[1] + 80) && (this.y+this.radius > paddle.getCoords()[1])) {
    		System.out.println("paddle hit");
    		score++;
    		//Increase speed every other hit
    		if ((this.score % 2 == 0)) {
    			this.ballSpeedX -= 1;
    		}
    		//dont need to check score as speed isnt added just changed to X
    		if ((this.ballSpeedY > 0)) {
    			this.ballSpeedY = -this.ballSpeedX;
    		}
    		else if (this.ballSpeedY < 0) {
    			this.ballSpeedY = +this.ballSpeedX;
    		}
    		this.ballSpeedX =-this.ballSpeedX;

    		return score;
    	}
    	//if hits sides, reverse y, to hit back and lose
    	//top side
    	else if ((this.x-this.radius < paddle.getCoords()[0]+20) &&(this.x-this.radius > paddle.getCoords()[0]) && (this.y+this.radius == paddle.getCoords()[1])) {  		
    		System.out.println("paddle hit");
    		this.ballSpeedY =-this.ballSpeedY;
    		score++;
    	}
    	//bottom side
    	else if ((this.x-this.radius < paddle.getCoords()[0]+20) &&(this.x-this.radius > paddle.getCoords()[0]) && (this.y-this.radius == paddle.getCoords()[1] + 80)) {
    		System.out.println("paddle hit");
    		this.ballSpeedY =-this.ballSpeedY;
    		score++;
    	}
    	System.out.println("Ball speed X,Y: " + this.ballSpeedX + "," + ballSpeedY);
    	return 0;
    }
    
    //Move the ball
    public int ballWallHit(Paddle paddle) {
        //Ball bounce off edges (X and Y)
        if (this.x > 640 - this.radius) {
        	System.out.println("wall hit");
        	this.ballSpeedX = -this.ballSpeedX;
        }
        else if (this.x <= 0 + this.radius) {
          return -1;	
        }
        if (this.y > 480 - this.radius) {
        	System.out.println("wall hit");
            this.ballSpeedY = -this.ballSpeedY;
        }
        else if (this.y < this.radius) {
        	System.out.println("wall hit");
            this.ballSpeedY = -this.ballSpeedY;
        }
        return 0;
    }
	
}