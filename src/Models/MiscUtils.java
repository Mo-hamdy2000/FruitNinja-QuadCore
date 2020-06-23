package Models;
import java.lang.Math;

public class MiscUtils {
	public static double rand(double min, double max) {
        double range = max - min;
        double rand = (Math.random() * range) + min;
        return rand;
	}
}
