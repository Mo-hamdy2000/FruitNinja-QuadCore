package Models;

import java.awt.*;

public class Equation {
	private int screenHeight;
	private int screenWidth;
	private float initialSpeed;
	private double projectionAngle;
	private float startPoint;

	public Equation(int screenHeight, int screenWidth, float initialSpeed, double projectionAngle, float startPoint) {
		this.screenHeight = screenHeight;
		this.screenWidth = screenWidth;
		this.initialSpeed = initialSpeed;
		this.projectionAngle = projectionAngle;
		this.startPoint = startPoint;
	}

	public Point updateCoordinates(int x, int y, double deltaTime) {
		Point point = new Point();
		point.x = (int) (initialSpeed * deltaTime*GameLogic.speedFactor * Math.cos(projectionAngle) / 1000 + startPoint);
		point.y = (int) (initialSpeed * deltaTime*GameLogic.speedFactor * Math.sin(projectionAngle) / 1000
				- 0.5 * 9.8 * deltaTime * deltaTime / 1000000);
		point.y = this.screenHeight - point.y;
		return point;
	}

	public float getInitialSpeed() {
		return initialSpeed;
	}

	public int[] getScreenSize() {
		int[] arr = {screenHeight, screenWidth};
		return arr;
	}
}
