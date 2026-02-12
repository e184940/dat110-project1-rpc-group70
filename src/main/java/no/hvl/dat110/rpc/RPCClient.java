package no.hvl.dat110.rpc;

import no.hvl.dat110.TODO;
import no.hvl.dat110.messaging.*;

public class RPCClient {

	// underlying messaging client used for RPC communication
	private MessagingClient msgclient;

	// underlying messaging connection used for RPC communication
	private MessageConnection connection;
	
	public RPCClient(String server, int port) {
	
		msgclient = new MessagingClient(server,port);
	}
	
	public void connect() {

		connection = msgclient.connect();
	}
	
	public void disconnect() {

		connection.close();
	}

	/*
	 Make a remote call om the method on the RPC server by sending an RPC request message and receive an RPC reply message

	 rpcid is the identifier on the server side of the method to be called
	 param is the marshalled parameter of the method to be called
	 */

	public byte[] call(byte rpcid, byte[] param) {
		
		byte[] returnval = null;

		// encapsulate rpcid og param according to rpc message format
		byte[] rpcrequest = RPCUtils.encapsulate(rpcid, param);

		// sende rpc request message
		Message requestmsg = new Message(rpcrequest);
		connection.send(requestmsg);

		// recieve rpc reply message
		Message replymsg = connection.receive();

		// decapsulate returned value from rpc reply
		byte[] rpcreply = replymsg.getData();
		returnval = RPCUtils.decapsulate(rpcreply);

		return returnval;
		
	}

}
