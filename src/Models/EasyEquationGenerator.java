package Models;
import java.lang.Math;

import Models.Interfaces.EquationGenerator;

public class EasyEquationGenerator implements EquationGenerator {
	private int screenWidth;
	private int screenHeight;
	
	public EasyEquationGenerator(int screenWidth, int screenHeight) {
		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;
	}
	
	@Override
	public Equation generateEquation() {
		int initialSpeed = (int) MiscUtils.rand(100, 200);
		int startPoint = (int) MiscUtils.rand(0, screenWidth/2);
		double maxAngle = Math.asin(Math.sqrt((2*9.8*screenHeight)/(initialSpeed*initialSpeed)));
		double projectionAngle = MiscUtils.rand(Math.PI/9, maxAngle);
		Equation equation = new Equation(this.screenHeight, initialSpeed, projectionAngle, startPoint);
		return equation;
	}
	
}
