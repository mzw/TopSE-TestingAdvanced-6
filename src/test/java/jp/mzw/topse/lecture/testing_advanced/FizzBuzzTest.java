package jp.mzw.topse.lecture.testing_advanced;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collection;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class FizzBuzzTest {

	@Parameters
	public static Collection<Parameter> getParameters() {
		return Arrays.asList(
				new Parameter(2, "2"),
				new Parameter(3, "Fizz"),
				new Parameter(5, "Buzz"),
				new Parameter(15, "FizzBuzz"));
	}

	private static class Parameter {
		private final int input;
		private final String outout;

		private Parameter(final int input, final String output) {
			this.input = input;
			this.outout = output;
		}
	}

	private final Parameter param;

	public FizzBuzzTest(Parameter param) {
		this.param = param;
	}

	private Mockery context;
	private PrintStream mock;

	@Before
	public void setup() {
		this.context = new Mockery() {{ setImposteriser(ClassImposteriser.INSTANCE); }};
		this.mock = this.context.mock(PrintStream.class);
		System.setOut(this.mock);
	}

	@Test
	public void test() {
		this.context.checking(new Expectations() {{
			oneOf(mock).println(param.outout);
		}});
		FizzBuzz.print(this.param.input);
	}

	@After
	public void teardown() {
		this.context.assertIsSatisfied();
	}

}
