package lab01;


import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

public class CalculatorTest { 
	
	private Calculator calculator;
	
	
	@Before 
	public void setUp(){ 
		calculator = new Calculator();
	}
	
	@Test 
	public void AddT(){ 
		Assert.assertEquals(5,calculator.add(4,1)); 
	} 
	
	@Test 
	public void SubT(){ 
		Assert.assertEquals(18,calculator.sub(20, 2)); 
	}
	
	@Test 
	public void multiT(){ 
		Assert.assertEquals(24,calculator.multi(6,4)); 
	}
	
	@Test 
	public void divT(){ 
		Assert.assertEquals(4,calculator.div(20,5)); 
	} 
	
	@Test 
	public void GreaterT(){
		Assert.assertTrue(calculator.greater(12,5)); 
	} 
	


}
