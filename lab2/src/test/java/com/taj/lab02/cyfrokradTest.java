package com.taj.lab02;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runner.RunWith;

@RunWith(Parameterized.class)
public class cyfrokradTest{

		@Parameters
		public static Collection<Object[]> data(){
	        return Arrays.asList(new Object[][] {
	                 { 1111,111 },
	                 {  3333,333 },  
	                 { null, 1 }, 
	           });
	    }
	private Integer input;
	private Integer result;

   
    public cyfrokradTest(Integer exResult,Integer in){
    	this.result = exResult;
    	this.input = in;       
 }
    @Test
    public void TestingParameters(){
    	Psik target = new Psik();
    	assertEquals(result, (target.cyfrokrad(input)));	
    }
}
