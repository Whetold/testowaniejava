package com.example.mockdemo.messenger;

public interface IMessageService {
    ConnectionStatus checkConnection(String server);

    SendingStatus send(String server, String contents) throws MalformedRecipientException;
}
