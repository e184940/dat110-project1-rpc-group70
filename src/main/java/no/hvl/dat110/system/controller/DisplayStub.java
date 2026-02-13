package no.hvl.dat110.system.controller;

import no.hvl.dat110.TODO;
import no.hvl.dat110.rpc.*;

public class DisplayStub extends RPCLocalStub {

	public DisplayStub(RPCClient rpcclient) {
		super(rpcclient);
	}
	
	public void write (String message) {

		// rpc method 1 = wrtie
		byte rpcid = 1;

		// marshall params for rpc method
		byte[] request = RPCUtils.marshallString(message);

		// call rpc method
		rpcclient.call(rpcid, request);
	}
}
