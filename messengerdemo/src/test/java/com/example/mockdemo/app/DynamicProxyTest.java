package com.example.mockdemo.app;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.junit.Test;

import com.example.mockdemo.messenger.ConnectionStatus;
import com.example.mockdemo.messenger.MalformedRecipientException;
import com.example.mockdemo.messenger.MessageService;
import com.example.mockdemo.messenger.SendingStatus;

public class DynamicProxyTest {
	
	class MessageServiceHandler implements InvocationHandler {

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		//check if adress was correct
		if ("checkConnection".equals(method.getName())){
			if(args[0].toString().matches("[a-z].*.pl$")) {
				return ConnectionStatus.SUCCESS;
			} else 
			{
				return ConnectionStatus.FAILURE;
			}
		}		
		//check for throws
		if("send".equals(method.getName())){
			if(args[0].toString().equals("rebel.pl.com") && args[1].toString().equals("hello")){
				throw new MalformedRecipientException();
			}
		}
		
		if("send".equals(method.getName())){
			if(args[0].toString().length() > 3 ){
				if(args[0].toString().matches("[a-z].*.pl$")){
					return SendingStatus.SENT;
				} 
				else if(!args[0].toString().matches("[a-z].*.pl$")) {
					return SendingStatus.SENDING_ERROR;
				}
			} 
			else {
				throw new MalformedRecipientException();
			}
			if(args[1].toString().equals("hello")){
				return null;
			}
		}
		return null;
		}
	}
	
	@Test
	public void TestingConnectionSuccesfully() {

		InvocationHandler _ih = new MessageServiceHandler();
		MessageService _msgService = (MessageService) Proxy.newProxyInstance(MessageService.class.getClassLoader(),new Class[] { MessageService.class }, _ih);
		Messenger _msg = new Messenger(_msgService);
		assertEquals(0, _msg.testConnection("rebel.pl"));
	}
	
	@Test
	public void TestingConnectionNotSuccesfully() {

		InvocationHandler _ih = new MessageServiceHandler();
		MessageService _msgService = (MessageService) Proxy.newProxyInstance(MessageService.class.getClassLoader(),new Class[] { MessageService.class }, _ih);
		Messenger _msg = new Messenger(_msgService);
		assertEquals(1, _msg.testConnection("rebel.pl.com"));
	}
	
	@Test
	public void SendingMessageSuccessfully() {

		InvocationHandler _ih = new MessageServiceHandler();
		MessageService _msgService = (MessageService) Proxy.newProxyInstance(MessageService.class.getClassLoader(),new Class[] { MessageService.class }, _ih);
		Messenger _msg = new Messenger(_msgService);
		assertEquals(0, _msg.sendMessage("rebel.pl", "hello"));
	}
	
	@Test
	public void SendingMessageNotSuccessfully() {

		InvocationHandler _ih = new MessageServiceHandler();
		MessageService _msgService = (MessageService) Proxy.newProxyInstance(MessageService.class.getClassLoader(),new Class[] { MessageService.class }, _ih);
		Messenger _msg = new Messenger(_msgService);
		assertEquals(1, _msg.sendMessage("rebel.pl.com", "wiadomosc panie"));
	}
	
	@Test
	public void SendingMessageReturnsUndefined() {

		InvocationHandler _ih = new MessageServiceHandler();
		MessageService _msgService = (MessageService) Proxy.newProxyInstance(MessageService.class.getClassLoader(),new Class[] { MessageService.class }, _ih);
		Messenger _msg = new Messenger(_msgService);
		assertEquals(2, _msg.sendMessage("rebel.pl.com", "hello"));
	}
	

}
