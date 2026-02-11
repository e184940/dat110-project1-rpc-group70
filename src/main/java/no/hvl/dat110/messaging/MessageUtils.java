package no.hvl.dat110.messaging;

import java.util.Arrays;

import no.hvl.dat110.TODO;

public class MessageUtils {

	public static final int SEGMENTSIZE = 128;

	public static int MESSAGINGPORT = 8080;
	public static String MESSAGINGHOST = "localhost";

	public static byte[] encapsulate(Message message) {
		
		byte[] segment = new byte[SEGMENTSIZE];
		byte[] data = message.getData();
		
		// first byte set as length of data
		segment[0] = (byte)data.length;

		// copy data into the segment starting from index 1
		System.arraycopy(data, 0, segment, 1, data.length);

		return segment;
		
	}

	public static Message decapsulate(byte[] segment) {
		
		int dataLen = segment[0] & 0xFF; // convert byte to int (unsigned

		byte[] data = new byte[dataLen];
		System.arraycopy(segment, 1 , data, 0, dataLen);

		Message message = new Message(data);
		return message;
		
	}
	
}
