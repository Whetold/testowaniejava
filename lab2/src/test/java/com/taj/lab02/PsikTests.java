package com.taj.lab02;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.Assert;
import org.junit.rules.ExpectedException;


public class PsikTests {
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	public Psik psik;
	
	@Before
	  public void setUp(){
       psik = new Psik();
   }
	
	@Test
	public void CyfrokradTest1(){
		Integer onenumber = psik.cyfrokrad(4);
		assertNull("should return null",onenumber);
	}
	
	@Test
	public void CyfrokradTest2(){
		Integer onenumber = psik.cyfrokrad(9);
		assertNull("should return null",onenumber);
	}

	 @Test
	 public void CyfrokradTest3(){
	 Integer result= psik.cyfrokrad(4413);
	 assertEquals("Result should be one of following",result==441|| result==413 || result==443 );
	 }
	
	
	 @Test
	 public void hultajchochlaTest() throws NieudanyPsikusException{
	 Integer result = psik.hultajchochla(46);
	 assertTrue(result.equals(64));
	 }
	 
	 @Test
	 public void hultajchochlaTest2() throws NieudanyPsikusException{
	 thrown.expect(NieudanyPsikusException.class);
	 psik.hultajchochla(1);
	 }
	 
	 public void nieksztaltekTest() throws NieudanyPsikusException{
		 Integer result=psik.nieksztaltek(376);
		 assertEquals("Result should be one of following",result==876|| result==316 || result==3793 );
	 	 }
	 
	 public void nieksztaltekTest2() throws NieudanyPsikusException{
		 Integer result=psik.nieksztaltek(111);
		 assertEquals("Expects same number",result==111);
	 	 }
}
