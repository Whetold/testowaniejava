package lab01;


import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Assert;
import org.junit.Before;

public class CalculatorTest { 
	
	public ExpectedException except = ExpectedException.none();
	private Calculator calculator;
	
	
	@Before 
	public void setUp(){ 
		calculator = new Calculator();
	}
	 @Test
	 public void AddTestDouble(){
		 	Assert.assertEquals(5.0,calculator.add(4.0,1.0),0.1); //0.1 is delta
	 }

	    @Test
	    public void SubTestDouble(){
	        Assert.assertEquals(4.0,calculator.sub(11.2, 7.2),0.1);
	    }

	    @Test
	    public void DivTestDouble(){
	        Assert.assertEquals(5,calculator.div(20.0,4.0), 0.1);
	    }

	    @Test
	    public void MultiplyTestDouble(){
	        Assert.assertEquals(12.3,calculator.multi(4.1,3.0),0.1);
	    }

	    @Test
	    public void GreaterTestDouble(){
	        Assert.assertTrue(calculator.greater(23.5,5.3));
	    }

	    @Test
	    public void Divide_ArithmeticException_ExpectedDouble(){
	        except.expect(ArithmeticException.class);
	        calculator.div(50.0,0);
	    }


}
