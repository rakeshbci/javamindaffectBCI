package nl.ma.utopiaserver.messages;
/*
 * Copyright (c) MindAffect B.V. 2018
 * For internal use only.  Distribution prohibited.
 */

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import nl.ma.utopiaserver.ClientException;

/**
 * The NEWTARGET utopia message class
 */
public class NewTarget implements UtopiaMessage {
    public static final int MSGID         =(int)'N';
    public static final String MSGNAME    ="NEWTARGET";
    /**
     * get the unique message ID for this message type
     */
    public int msgID(){ return MSGID; }
    /**
     * get the unique message name, i.e. human readable name, for this message type
     */
    public String msgName(){ return MSGNAME; }
    public int timeStamp;
    /**
     * get the time-stamp for this message 
     */
    public int gettimeStamp(){return this.timeStamp;}
    /**
     * set the time-stamp information for this message.
     */
    public void settimeStamp(int ts){ this.timeStamp=ts; }
    /**
     * get the version of this message
     */
    public int getVersion(){return 0;}

    public NewTarget(final int timeStamp){
        this.timeStamp=timeStamp;
    }

    /**
     * deserialize a byte-stream to create a NEWTARGET instance
     */ 
    public static NewTarget deserialize(final ByteBuffer buffer, int version)
        throws ClientException {
        buffer.order(UTOPIABYTEORDER);
        // get the timestamp
        final int timeStamp = buffer.getInt();
        return new NewTarget(timeStamp);
    }
    public static NewTarget deserialize(final ByteBuffer buffer)
        throws ClientException {
        return deserialize(buffer,0);
    }
        /**
     * serialize this instance into a byte-stream in accordance with the message spec. 
     */
    public void serialize(final ByteBuffer buf) {
        buf.order(UTOPIABYTEORDER);
        buf.putInt(timeStamp);
    }
    
	public String toString() {
		 return "t:" + msgName() + " ts:" + timeStamp;
	}

    // Field-trip buffer serialization
    public String getType(){  return msgName(); }
    public void getValue(final ByteBuffer buf){
        buf.order(UTOPIABYTEORDER);
        buf.putInt(timeStamp);
    }
    
};
