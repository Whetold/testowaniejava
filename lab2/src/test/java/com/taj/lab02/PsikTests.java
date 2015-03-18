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
	
	
	

}
