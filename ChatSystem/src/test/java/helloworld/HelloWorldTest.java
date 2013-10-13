package helloworld;
import static org.junit.Assert.assertThat;

import org.hamcrest.core.Is;
import org.junit.Test;


public class HelloWorldTest {

	@Test
	public void shouldReturnHelloWorld(){
		assertThat(new HelloWorld().greeting(), Is.is("Hello World"));
	}
}
