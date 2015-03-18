package com.taj.lab02;

import static org.junit.Assert.*;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runner.RunWith;


@RunWith(Parameterized.class)
public class nieksztaltekTest {
	@Parameters
	public static Collection<Object[]> data(){
	return Arrays.asList(new Object[][] {
			{ 482, 432 },
			{ 11, 11 }, 
			{ 211, 217 }, 
			});
	}
	private Integer input;
	private Integer result;
   
    public nieksztaltekTest(Integer exResult,Integer in){
    	this.result = exResult;
    	this.input = in;
    }

    @Test
    public void TestingParameters(){
    	Psik target = new Psik();
    	assertEquals(result, (target.nieksztaltek(input)));	
    }
}
