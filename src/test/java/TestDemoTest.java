import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.lang.instrument.IllegalClassFormatException;
import java.util.Objects;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;




class TestDemoTest {
	private TestDemo testDemo;
	
	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}
	
	/*@ParameterizedTest
	@MethodSource("TestDemoTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(Integer a, Integer b, Integer expected, Class<? extends Exception> exceptionClass) {
	
	if(Objects.isNull(exceptionClass)) {
		Integer actual = testDemo.addPositive(a, b);
		assertThat(actual).isEqualTo(expected);
		}
		else {
			assertThatThrownBy(() -> testDemo.addPositive(a,b)).isInstanceOf(exceptionClass);
		}
		}
	static Stream<Arguments> argumentsForAddPositive() {
		return Stream.of(
				arguments(2, 4, 6, null),
				arguments(15, 20, 35, null),
				arguments(0, 0, 0, IllegalArgumentException.class),
				arguments(-1, 2, 1, IllegalArgumentException.class),
				arguments(null, 2, 2, NullPointerException.class),
				arguments(3, null, 3, NullPointerException.class),
				arguments("abc", 2, 2, IllegalArgumentException.class)
				);
	}
	*/			
	
	/**
	 * Method shows that the addPositive method correctly handles valid and invalid values.
	 * @param a
	 * @param b
	 * @param expected
	 * @param expectException
	 */
	@ParameterizedTest
	@MethodSource("TestDemoTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		
		if(!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		}
		else {
			assertThatThrownBy(() -> testDemo.addPositive(a,b)).isInstanceOf(IllegalArgumentException.class);
		}
	}
	
	/**
	 * Stream of values for running test.
	 * @return
	 */
	static Stream<Arguments> argumentsForAddPositive() {
		return Stream.of(
				arguments(2, 4, 6, false),
				arguments(15, 20, 35, false),
				arguments(0, 0, 0, true),
				arguments(349, 1, 350, false),
				arguments(-7, 6, -1, true),
				arguments(25, -30, -5, true),
				arguments(-2, 2, 0, true),
				arguments(0, 2, 2, true)
				);
	}

	@Test
	void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);
		
		doReturn(3).when(mockDemo).getRandomInt();
		
		int fiveSquared = mockDemo.randomNumberSquared();
		
		assertThat(fiveSquared).isEqualTo(9);
	}
	
}
