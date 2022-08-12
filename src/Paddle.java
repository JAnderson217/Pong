
public class Paddle {
	//paddle coordinates
	private int x;
	private int y;
	private int width;
	private int height;
	private int paddleSpeed;
	//dimensions to draw coords to x,y
	
	public Paddle(int x, int y, int width, int height, int paddleSpeed) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.paddleSpeed = paddleSpeed;
	}
	
	public void movePaddle(boolean move, int height) {
		//move paddle up if true, down if false
		//move up
		if (move) {
			if(this.y-this.paddleSpeed <= 0) {
				this.y = 0;
			}
			else {
				this.y -= this.paddleSpeed;
			}
		}
		//move down
		else {
			if (this.y+this.paddleSpeed >= height-80) {
				this.y = height-80;
			}
			else {
				this.y += this.paddleSpeed;
			}
		}
	}
	
	public int[] getCoords() {
		return new int[] {this.x, this.y};
	}
	
	public int[] getDimensions() {
		return new int[] {this.width, this.height};
	}
 	
}
