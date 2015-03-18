package com.taj.lab02;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runner.RunWith;

@RunWith(Parameterized.class)
public class hultajchochlaTest{

	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][] {
				{56,65},
				{ 222, 222 },
	           });
	}
	
	private Integer input;
	private Integer result;
   
    public hultajchochlaTest(Integer exResult,Integer in){
    this.result = exResult;
    this.input = in;
           
    }
  
    @Test
    public void TestingParameters() throws NieudanyPsikusException{
    	Psik target = new Psik();
        assertEquals(result, (target.hultajchochla(input)));	
    }
}
