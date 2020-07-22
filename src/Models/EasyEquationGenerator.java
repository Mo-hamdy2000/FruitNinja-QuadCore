package Models;

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
		int initialSpeed = (int) ((int) MiscUtils.rand(186, 200));
		int startPoint = (int) MiscUtils.rand(0, screenWidth / 2);
		double maxAngle = Math.asin(Math.sqrt((2 * Equation.gravityFactor * screenHeight) / (initialSpeed * initialSpeed)));
		double projectionAngle = MiscUtils.rand(Math.PI / 3, maxAngle);
		Equation equation = new Equation(this.screenHeight, this.screenWidth, initialSpeed, projectionAngle, startPoint);
		return equation;
	}
	
}
