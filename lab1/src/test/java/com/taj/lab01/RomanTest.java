package com.taj.lab01;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.Assert;
import org.junit.rules.ExpectedException;




public class RomanTest {
	
	 @Rule
	 public ExpectedException thrown = ExpectedException.none();
	
	public Roman toRom;
	
	@Before
	  public void setUp(){
        toRom = new Roman();
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
