package com.example.mockdemo.bdd;

import static org.junit.Assert.assertEquals;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import com.example.mockdemo.app.Messenger;
import com.example.mockdemo.messenger.MessageService;
import com.example.mockdemo.messenger.MessageServiceSimpleImpl;

public class MessengerSteps {
	
	private Messenger _Messenger;
	private MessageService _msgService;
	private int connectionStatus;
	private int sendingStatus;

	@Given("Messenger app")
	public void givenmsg() 
	{
		_msgService = new MessageServiceSimpleImpl();
		_Messenger = new Messenger(_msgService);
	}
	@When("check connection with proper adress name $name")
	public void whenCheckConnectionWithProperAdressName(String name)
	{
		connectionStatus = _Messenger.testConnection(name);
	}
	@Then("status value $value is returned")
	public void thenStatusValueIsReturned(int value)
	{
		assertEquals(value, connectionStatus);
	}
	
	@When("check connection with .com ending name $name")
	public void whenCheckConnectionWithNotValidServerName(String name)
	{
		connectionStatus = _Messenger.testConnection(name);
	}
	@When("send message $m with server $s successfully")
	public void whenSendMessagemWithServersSuccessfully(String message, String server)
	{
		System.out.println("adress is " + server + ", msg " + message);
		sendingStatus = _Messenger.sendMessage(server, message);
	}
	@Then("result equals $value is returned")
	public void thenSendingValueIsReturned(int value)
	{
		assertEquals(value, sendingStatus);
	}
	




}
