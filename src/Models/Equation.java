package Models;

import java.lang.Math;
import java.awt.Point;

public class Equation {
	private int screenHeight;
	private float initialSpeed;
	private long startTime;
	private double projectionAngle;
	private float startPoint;
	
	public Equation(int screenHeight, float initialSpeed, double projectionAngle, float startPoint) {
		this.screenHeight = screenHeight;
		this.initialSpeed = initialSpeed;
		this.startTime = System.currentTimeMillis();
		this.projectionAngle = projectionAngle;
		this.startPoint = startPoint;
	}
	
	public Point updateCoordinates(int x, int y) {
		Point point = new Point();
		double deltaTime = System.currentTimeMillis() - startTime;
		point.x = (int) (initialSpeed * deltaTime * Math.cos(projectionAngle)/1000 + startPoint);
		point.y = (int) (initialSpeed * deltaTime * Math.sin(projectionAngle) / 1000
				- 0.5 * 9.8 * deltaTime * deltaTime/1000000);
		point.y = this.screenHeight - point.y;
		return point;
	}
	
}
