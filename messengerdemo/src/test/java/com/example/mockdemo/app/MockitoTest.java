package com.example.mockdemo.app;

import com.example.mockdemo.messenger.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import org.mockito.ArgumentCaptor;
import org.mockito.Spy;
import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;


public class MockitoTest {
	
	private static final String tmpstr = "rebel.pl";
	@Spy private Messenger _Messenger;
	private MessageService _msgServiceMock;
	@Before
	public void setup(){
		_msgServiceMock = mock(MessageService.class);
		_Messenger = new Messenger(_msgServiceMock);
	}
	@Test
	public void TestException() throws MalformedRecipientException{
		when(_msgServiceMock.send(tmpstr, "r")).thenThrow(new MalformedRecipientException());
		assertEquals(2, _Messenger.sendMessage(tmpstr, "r"));
	}
	@Test
	public void TestTheConnectionWithGoodEnd(){
		when(_msgServiceMock.checkConnection(endsWith(".pl"))).thenReturn(ConnectionStatus.SUCCESS);
		assertEquals(0, _Messenger.testConnection(tmpstr)); 
	}
	@Test
	public void TestTheConnectionFail(){
		when(_msgServiceMock.checkConnection("rebel.com")).thenReturn(ConnectionStatus.FAILURE);
		assertEquals(1, _Messenger.testConnection("rebel.com"));		
	}
	@Test
	public void TestTheConnectionPass(){
		when(_msgServiceMock.checkConnection(tmpstr)).thenReturn(ConnectionStatus.SUCCESS);
		assertEquals(0, _Messenger.testConnection(tmpstr));
	}
	@Test
	public void TestSendingFail() throws MalformedRecipientException{
		when(_msgServiceMock.send("rebel.com", "hello")).thenReturn(SendingStatus.SENDING_ERROR);
		assertEquals(1, _Messenger.sendMessage("rebel.com", "hello"));
	}
	@Test
	public void TestSendingPass() throws MalformedRecipientException{
		when(_msgServiceMock.send(tmpstr, "hello")).thenReturn(SendingStatus.SENT);
		assertEquals(0, _Messenger.sendMessage(tmpstr, "hello"));
	}
	

}
