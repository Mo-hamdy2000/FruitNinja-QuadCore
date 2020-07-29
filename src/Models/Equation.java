package Models;

import java.awt.*;

public class Equation {
	private int screenHeight;
	private int screenWidth;
	private float initialSpeed;
	private double projectionAngle;
	private float startPoint;
	static double gravityFactor = 50;
	private double delayTime = 0;
	
	public Equation(int screenHeight, int screenWidth, float initialSpeed, double projectionAngle, float startPoint) {
		this.screenHeight = screenHeight;
		this.screenWidth = screenWidth;
		this.initialSpeed = initialSpeed;
		this.projectionAngle = projectionAngle;
		this.startPoint = startPoint;
	}

	public Point updateCoordinates(int x, int y, double deltaTime, boolean isSliced) {
		Point point = new Point();
		deltaTime = (deltaTime - delayTime) * GameLogic.speedFactor;
		if (isSliced) {
			point.x = (int) (initialSpeed * deltaTime * Math.cos(projectionAngle) / 1000 + startPoint);
			point.y = (int) (gravityFactor*0.2 + y);
		}
		else {
			point.x = (int) (initialSpeed * deltaTime * Math.cos(projectionAngle) / 1000 + startPoint);
			point.y = (int) (initialSpeed * deltaTime * Math.sin(projectionAngle) / 1000
					- 0.5 * gravityFactor * deltaTime * deltaTime / 1000000);
			point.y = this.screenHeight - point.y;
		}
		return point;
	}
	
	
	public float getInitialSpeed() {
		return initialSpeed;
	}

	public int[] getScreenSize() {
		int[] arr = {screenHeight, screenWidth};
		return arr;
	}
	
	public int getMaxHeight() {
		return (int) (Math.pow(initialSpeed * Math.sin(projectionAngle), 2) / (2 * gravityFactor));
	}
	
	public void setSlowMotionDelayTime(double realDeltaTime, int x) {
		double coordinateDeltaTime = ((x - startPoint) * 1000) / (initialSpeed * Math.cos(projectionAngle));
		this.delayTime += (realDeltaTime - coordinateDeltaTime);
	}
	
	public void addDelayTime(double delayTime) {
		this.delayTime += delayTime;
	}
	
	public double getProjectionAngle() {
		return this.projectionAngle;
	}
	
	public float getStartPoint() {
		return this.startPoint;
	}
	
	public double getDelayTime() {
		return this.delayTime;
	}
	
	public double getPlayedTime(int x) {
		double coordinateDeltaTime = ((x - startPoint) * 1000) / (initialSpeed * Math.cos(projectionAngle));
		return coordinateDeltaTime - delayTime;
	}
}
