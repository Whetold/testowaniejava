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
		Assert.assertEquals(10,calculator.add(5,5)); 
	} 
	
	@Test 
	public void SubT(){ 
		Assert.assertEquals(10,calculator.sub(20, 10)); 
	}
	
	@Test 
	public void multiT(){ 
		Assert.assertEquals(20,calculator.multi(5,4)); 
	}
	
	@Test 
	public void divT(){ 
		Assert.assertEquals(20,calculator.div(100,5)); 
	} 
	
	@Test 
	public void GreaterT(){
		Assert.assertTrue(calculator.greater(112,23)); 
	} 
	


}
