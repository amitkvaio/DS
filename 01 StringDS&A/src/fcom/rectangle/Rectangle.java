package fcom.rectangle;

public class Rectangle {
	public Point bottomLeft;
	public Point topRight;
	
	public Rectangle() {
	}
	
	public Rectangle(Point bottomLeft,Point topRight) {
		this.bottomLeft=bottomLeft;
		this.topRight=topRight;
	}
	
	public Point getBottomLeft() {
		return bottomLeft;
	}

	public void setBottomLeft(Point bottomLeft) {
		this.bottomLeft = bottomLeft;
	}

	public Point getTopRight() {
		return topRight;
	}

	public void setTopRight(Point topRight) {
		this.topRight = topRight;
	}

	public boolean isOverlapping(Rectangle first, Rectangle second) {
		if (first.bottomLeft.x > second.topRight.x || first.topRight.x < second.bottomLeft.x)
			return false;
		if (first.bottomLeft.y > second.topRight.y || first.topRight.y < second.bottomLeft.y)
			return false;
		return true;
	}
 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
