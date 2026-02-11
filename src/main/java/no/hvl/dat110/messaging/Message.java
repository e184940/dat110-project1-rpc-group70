package no.hvl.dat110.messaging;

import no.hvl.dat110.TODO;

public class Message {

	// the up to 127 bytes of data (payload) that a message can hold
	private byte[] data;

	// construction a Message with the data provided
	public Message(byte[] data) {

		if (data == null) {
			throw new IllegalArgumentException("data cannot be null");
		}

		if(data.length > 127){
			throw new IllegalArgumentException("data cannot greater than 127b");
		}

		this.data = new byte[data.length];
		System.arraycopy(data, 0, this.data, 0, data.length);
	}

	public byte[] getData() {
		return this.data; 
	}

}
