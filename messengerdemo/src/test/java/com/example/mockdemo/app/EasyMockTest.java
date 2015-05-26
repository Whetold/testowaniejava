package com.example.mockdemo.app;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import com.example.mockdemo.messenger.ConnectionStatus;
import com.example.mockdemo.messenger.MalformedRecipientException;
import com.example.mockdemo.messenger.MessageService;
import com.example.mockdemo.messenger.SendingStatus;

public class EasyMockTest {

	private Messenger _Messenger;
	private MessageService _msgServiceMock;
	
	@Before
	public void setup(){
		_msgServiceMock = createMock(MessageService.class);
		_Messenger = new Messenger(_msgServiceMock);
	}
	@Test
	public void TestException() throws MalformedRecipientException{
		expect(_msgServiceMock.send("rebel.pl", "hel")).andThrow(new MalformedRecipientException());
		replay(_msgServiceMock);
		assertEquals(2, _Messenger.sendMessage("rebel.pl", "hel"));
		verify(_msgServiceMock);
	}
	@Test
	public void TestTheConnectionPass(){
		expect(_msgServiceMock.checkConnection("rebel.pl")).andReturn(ConnectionStatus.SUCCESS);
		replay(_msgServiceMock);
		assertEquals(0, _Messenger.testConnection("rebel.pl"));
		verify(_msgServiceMock);
	}
	
	@Test
	public void TestTheConnectionFail(){
		expect(_msgServiceMock.checkConnection("rebel.com")).andReturn(ConnectionStatus.FAILURE);
		replay(_msgServiceMock);
		assertEquals(1, _Messenger.testConnection("rebel.com"));
		verify(_msgServiceMock);
	}
	
	@Test
	public void TestSendingPass() throws MalformedRecipientException{
		expect(_msgServiceMock.send("rebel.pl", "hello")).andReturn(SendingStatus.SENT);
		replay(_msgServiceMock);
		assertEquals(0, _Messenger.sendMessage("rebel.pl", "hello"));
		verify(_msgServiceMock);
	}
	
	@Test
	public void TestSendingFail() throws MalformedRecipientException{
		expect(_msgServiceMock.send("rebel.com", "hello")).andReturn(SendingStatus.SENDING_ERROR);
		replay(_msgServiceMock);
		assertEquals(1, _Messenger.sendMessage("rebel.com", "hello"));
		verify(_msgServiceMock);
	}

}
