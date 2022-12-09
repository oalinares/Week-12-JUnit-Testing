import java.io.InvalidClassException;
import java.util.Objects;
import java.util.Random;

public class TestDemo {
	
	/**
	 * Adds the sum of two integers.
	 * @param a
	 * @param b
	 * @return Returns the sum if greater than zero, or will throw an IllegalArgumentException w/ message.
	 */

	/*public Integer addPositive(Integer a, Integer b) {
		Integer sum = a + b;
		
		if(Objects.isNull(a) || Objects.isNull(b)) {
			throw new NullPointerException("A valid, non-null value must be entered!");
			}
		if (a > 0 && b > 0) {
			return sum;	
		}
		else {
			throw new IllegalArgumentException("Both parameters must be positive!");
		}
	}*/
	
	public int addPositive(int a, int b) {
		int sum = a + b;
		if (a > 0 && b > 0) {
			return sum;	
		}
		else {
			throw new IllegalArgumentException("Both parameters must be positive, and greater than zero!");
		}
	}
	/**
	 * getRandomInt method generates value for num, which is used to get the value of square when the num value is multiplied to itself.
	 * @return Returns the value of num squared.
	 */
	public int randomNumberSquared() {
		int num = getRandomInt();
		int square = num * num;
		return square;
		
		
	}
	
	int getRandomInt() {
		Random random = new Random();
		return random.nextInt(10) + 1;
	}
	
}
