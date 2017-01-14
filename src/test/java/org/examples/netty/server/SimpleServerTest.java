package org.examples.netty.server;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by Denis Sitenkov on 14/01/17.
 */
public class SimpleServerTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testJustOnce() throws Exception {
        Socket clientSocket = new Socket("localhost", 8000);
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        outToServer.writeBytes("{\"some_data\":[\"1\",\"2\"]}\n");
        String response = inFromServer.readLine();
        System.out.println("FROM SERVER: " + response);
        clientSocket.close();
    }
}
