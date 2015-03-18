package com.taj.lab02;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.Assert;
import org.junit.rules.ExpectedException;

import com.taj.lab01.Roman;

public class PsikTests {

	 @Rule
	 public ExpectedException thrown = ExpectedException.none();
	
	public Psik psik;
	
	@Before
	  public void setUp(){
       psik = new Psik();
   }
	
	
	@Test
	public void TooBigTest() {
		thrown.expect(IllegalArgumentException.class);
		toRom.makeitroman(4000);
	}
	
	@Test
	public void TooSmallTest() {
		thrown.expect(IllegalArgumentException.class);
		toRom.makeitroman(0);
	}
	
	@Test
	public void CheckThousands() {
		 Assert.assertEquals("MM",toRom.makeitroman(2000));
	}
	
	@Test
	public void FirstCheck() {
		 Assert.assertEquals("MMCM",toRom.makeitroman(2900));
	}
	@Test
	public void CheckBigNumber() {
		 Assert.assertEquals("MMMCDXXVI",toRom.makeitroman(3426));
	}
	
	@Test
	public void CheckMedicoreNumber() {
		 Assert.assertEquals("MCCCLXXXVII",toRom.makeitroman(1387));
	}
	
	@Test
	public void CheckSmallNumber() {
		 Assert.assertEquals("DLVI",toRom.makeitroman(556));
	}

}
