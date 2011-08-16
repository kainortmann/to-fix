package org.tomac.protocol.fix.messaging.fix50sp2;

// DO NOT EDIT!!!
// This file is generated by FixMessageGenerator.
// If you need additional functionality, put it in a helper class
// that does not live in this folder!!!  Any java file in this folder 
// will be deleted upon the next run of the FixMessageGenerator!

import java.nio.ByteBuffer;

import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.FixSessionException;
import org.tomac.utils.Utils;



public abstract class FixMessage extends FixGeneratedBaseMessage
{

	public static boolean IGNORE_CHECKSUM = false;

	private int msgTypeEnd;
	int msgEnd = 0;

	public long signatureLength = 0;
	public byte[] signature;
	public long checkSum = 0;
	public byte[] beginString;
	public long bodyLength = 0;
	public byte[] applVerID;
	public byte[] cstmApplVerID;
	public long applExtID = 0;
	public byte[] senderCompID;
	public byte[] targetCompID;
	public byte[] onBehalfOfCompID;
	public byte[] deliverToCompID;
	public long secureDataLen = 0;
	public byte[] secureData;
	public long msgSeqNum = 0;
	public byte[] senderSubID;
	public byte[] senderLocationID;
	public byte[] targetSubID;
	public byte[] targetLocationID;
	public byte[] onBehalfOfSubID;
	public byte[] onBehalfOfLocationID;
	public byte[] deliverToSubID;
	public byte[] deliverToLocationID;
	public boolean possDupFlag = false;
	public boolean possResend = false;
	public byte[] sendingTime;
	public byte[] origSendingTime;
	public long xmlDataLen = 0;
	public byte[] xmlData;
	public byte[] messageEncoding;
	public long lastMsgSeqNumProcessed = 0;
	
	private static byte[] tmpMsgType = new byte[4];
	private static byte[] tmpBeginString = new byte[7];

	/**
	 * crackMsgType performs a garbled check on the fix message. 
	 * @param data
	 * @return msgType as an int.
	 * @throws FixSessionException
	 */
	public static int crackMsgType( ByteBuffer buf ) throws FixSessionException {
		int startPos;
		int checkSum;
		int msgType = MsgTypes.UNKNOWN_INT;
		startPos = buf.position();
		if(buf.remaining() < 2) // To start processing we need at least 8=
			return MsgTypes.UNKNOWN_INT; //Don't have a full message

		int begin = buf.position();

		int tagId = FixUtils.getTagId(buf);
		if(tagId != FixTags.BEGINSTRING_INT) {
			buf.position(startPos);
			throw new FixSessionException(buf, "First tag in FIX message is not BEGINSTRING (8)");
		}

		FixUtils.getTagStringValue(buf, tmpBeginString);
		//now look to get bodyLength field
		tagId = FixUtils.getTagId(buf);
		if(tagId != FixTags.BODYLENGTH_INT) {
			buf.position(startPos);
			throw new FixSessionException(buf, "Second tag in FIX message is not BODYLENGTH (9)");
		}

		int bodyLength = FixUtils.getTagIntValue(buf);
		if(bodyLength < 0) {
			buf.position(startPos);
			throw new FixSessionException(buf, "Invalid BODYLENGTH (9) value: " + bodyLength);
		}

		int checkSumBegin = buf.position() + bodyLength; 
		if(checkSumBegin > buf.limit()) {
			buf.position(startPos);
			return MsgTypes.UNKNOWN_INT; //Don't have a full message
		}

		//FIRST, validate that we got a msgType field
		tagId = FixUtils.getTagId(buf);
		if(tagId != FixTags.MSGTYPE_INT)
			throw new FixSessionException(buf, "Third tag in FIX message is not MSGTYPE (35)");

		FixUtils.getTagStringValue(buf, tmpMsgType);

		//we should verify that the final tag IS checksum here if we want to
		buf.position(checkSumBegin);
		tagId = FixUtils.getTagId(buf);
		if(tagId != FixTags.CHECKSUM_INT)
			throw new FixSessionException(buf, "Final tag in FIX message is not CHECKSUM (10)");

		checkSum = FixUtils.getTagIntValue(buf);
		int calculatedCheckSum = FixUtils.computeChecksum(buf, begin, checkSumBegin);
		if(checkSum != calculatedCheckSum && !IGNORE_CHECKSUM)
			throw new FixSessionException(buf, String.format("Checksum mismatch; calculated: %s is not equal message checksum: %s", calculatedCheckSum, checkSum));

		// finish-up

		buf.position(startPos);

		msgType = FixUtils.getMsgTypeTagAsInt(tmpMsgType, Utils.lastIndexTrim(tmpMsgType, (byte)0));

		msgType = FixUtils.crackNasdaqMsgType(msgType, buf);

		return msgType;
	}
	public FixMessage() {
		super();

		signature = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		beginString = new byte[8];
		applVerID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		cstmApplVerID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		senderCompID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		targetCompID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		onBehalfOfCompID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		deliverToCompID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		secureData = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		senderSubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		senderLocationID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		targetSubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		targetLocationID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		onBehalfOfSubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		onBehalfOfLocationID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		deliverToSubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		deliverToLocationID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		sendingTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];
		origSendingTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];
		xmlData = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		messageEncoding = new byte[FixUtils.FIX_MAX_STRING_LENGTH];


	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		signatureLength = Long.MAX_VALUE;		
		Utils.fill( signature, (byte)0 );
		checkSum = Long.MAX_VALUE;		
		Utils.fill( beginString, (byte)0 );
		bodyLength = Long.MAX_VALUE;		
		Utils.fill( applVerID, (byte)0 );
		Utils.fill( cstmApplVerID, (byte)0 );
		applExtID = Long.MAX_VALUE;		
		Utils.fill( senderCompID, (byte)0 );
		Utils.fill( targetCompID, (byte)0 );
		Utils.fill( onBehalfOfCompID, (byte)0 );
		Utils.fill( deliverToCompID, (byte)0 );
		secureDataLen = Long.MAX_VALUE;		
		Utils.fill( secureData, (byte)0 );
		msgSeqNum = Long.MAX_VALUE;		
		Utils.fill( senderSubID, (byte)0 );
		Utils.fill( senderLocationID, (byte)0 );
		Utils.fill( targetSubID, (byte)0 );
		Utils.fill( targetLocationID, (byte)0 );
		Utils.fill( onBehalfOfSubID, (byte)0 );
		Utils.fill( onBehalfOfLocationID, (byte)0 );
		Utils.fill( deliverToSubID, (byte)0 );
		Utils.fill( deliverToLocationID, (byte)0 );
		possDupFlag = false;		
		possResend = false;		
		Utils.fill( sendingTime, (byte)0 );
		Utils.fill( origSendingTime, (byte)0 );
		xmlDataLen = Long.MAX_VALUE;		
		Utils.fill( xmlData, (byte)0 );
		Utils.fill( messageEncoding, (byte)0 );
		lastMsgSeqNumProcessed = Long.MAX_VALUE;		
	}

	/**
	 * getAll performs stateless session level message validations. Throws a FixSessionException if this fails 
	 */
	@Override
	public void getAll() throws FixSessionException, IllegalStateException
	{

		startPos = buf.position();
		if(buf.remaining() < 2) // To start processing we need at least 8=
			throw new FixSessionException(buf, "Incorrect BodyLength(9) or incomplete message");

		int begin = buf.position();

		int tagId = FixUtils.getTagId(buf);
		if(tagId != FixTags.BEGINSTRING_INT) {
			buf.position(startPos);
			throw new FixSessionException(buf, "First tag in FIX message is not BEGINSTRING (8)");
		}

		FixUtils.getTagStringValue(buf, tmpBeginString);
		if(!Utils.equals(FixMessageInfo.BEGINSTRING_VALUE, tmpBeginString)) {
			buf.position(startPos);
			throw new FixSessionException(buf, "BeginString not equal to: " + new String(FixMessageInfo.BEGINSTRING_VALUE));
		}

		//now look to get bodyLength field
		tagId = FixUtils.getTagId(buf);
		if(tagId != FixTags.BODYLENGTH_INT) {
			buf.position(startPos);
			throw new FixSessionException(buf, "Second tag in FIX message is not BODYLENGTH (9)");
		}

		int bodyLength = FixUtils.getTagIntValue(buf);
		if(bodyLength < 0) {
			buf.position(startPos);
			throw new FixSessionException(buf, "Invalid BODYLENGTH (9) value: " + bodyLength);
		}

		int checkSumBegin = buf.position() + bodyLength; 
		if(checkSumBegin > buf.limit()) {
			buf.position(startPos);
			throw new FixSessionException(buf, "Incorrect BodyLength(9) or incomplete message");
		}

		//FIRST, validate that we got a msgType field
		tagId = FixUtils.getTagId(buf);
		if(tagId != FixTags.MSGTYPE_INT)
			throw new FixSessionException(buf, "Third tag in FIX message is not MSGTYPE (35)");

		FixUtils.getTagStringValue(buf, tmpMsgType);

		msgTypeEnd = buf.position();

		//we should verify that the final tag IS checksum here if we want to
		buf.position(checkSumBegin);
		tagId = FixUtils.getTagId(buf);
		if(tagId != FixTags.CHECKSUM_INT)
			throw new FixSessionException(buf, "Final tag in FIX message is not CHECKSUM (10)");

		checkSum = FixUtils.getTagIntValue(buf);
		int calculatedCheckSum = FixUtils.computeChecksum(buf, begin, checkSumBegin);
		if(checkSum != calculatedCheckSum && !IGNORE_CHECKSUM)
			throw new FixSessionException(buf, String.format("Checksum mismatch; calculated: %s is not equal message checksum: %s", calculatedCheckSum, checkSum));

		// finish-up

		buf.position(startPos);

		msgType = FixUtils.getMsgTypeTagAsInt(tmpMsgType, Utils.lastIndexTrim(tmpMsgType, (byte)0));

		msgType = FixUtils.crackNasdaqMsgType(msgType, buf);

		if (! MsgType.isValid(tmpMsgType))
			throw new FixSessionException(buf, msgEnd, String.format("MsgType not in specification: %s", new String(tmpMsgType).trim()));		// assumption message is full otherwise decode would return null
		// so negative id means that we are at the end of the message
		int id;
		buf.position(msgTypeEnd);
		int lastTagPosition = msgTypeEnd;
		while ( ( id = FixUtils.getTagId( buf ) ) > 0 )
		{
			ByteBuffer value;

			value = buf;

			switch( id ) {

			case FixTags.APPLVERID_INT:
				applVerID = FixUtils.getTagStringValue(value, applVerID);
				if (!ApplVerID.isValid(applVerID) ) throw new FixSessionException(buf, "Invalid enumerated value(" + applVerID + ") for tag: " + id );
				if (!ApplVerID.isValid(applVerID) ) throw new FixSessionException(buf, "Invalid enumerated value(" + applVerID + ") for tag: " + id );
				if (!ApplVerID.isValid(applVerID) ) throw new FixSessionException(buf, "Invalid enumerated value(" + applVerID + ") for tag: " + id );
				if (!ApplVerID.isValid(applVerID) ) throw new FixSessionException(buf, "Invalid enumerated value(" + applVerID + ") for tag: " + id );
				if (!ApplVerID.isValid(applVerID) ) throw new FixSessionException(buf, "Invalid enumerated value(" + applVerID + ") for tag: " + id );
				if (!ApplVerID.isValid(applVerID) ) throw new FixSessionException(buf, "Invalid enumerated value(" + applVerID + ") for tag: " + id );
				if (!ApplVerID.isValid(applVerID) ) throw new FixSessionException(buf, "Invalid enumerated value(" + applVerID + ") for tag: " + id );
				if (!ApplVerID.isValid(applVerID) ) throw new FixSessionException(buf, "Invalid enumerated value(" + applVerID + ") for tag: " + id );
				if (!ApplVerID.isValid(applVerID) ) throw new FixSessionException(buf, "Invalid enumerated value(" + applVerID + ") for tag: " + id );
				if (!ApplVerID.isValid(applVerID) ) throw new FixSessionException(buf, "Invalid enumerated value(" + applVerID + ") for tag: " + id );
				break;

			case FixTags.CSTMAPPLVERID_INT:
				cstmApplVerID = FixUtils.getTagStringValue(value, cstmApplVerID);
				break;

			case FixTags.APPLEXTID_INT:
				applExtID = FixUtils.getTagIntValue( value );
				break;

			case FixTags.SENDERCOMPID_INT:
				senderCompID = FixUtils.getTagStringValue(value, senderCompID);
				break;

			case FixTags.TARGETCOMPID_INT:
				targetCompID = FixUtils.getTagStringValue(value, targetCompID);
				break;

			case FixTags.ONBEHALFOFCOMPID_INT:
				onBehalfOfCompID = FixUtils.getTagStringValue(value, onBehalfOfCompID);
				break;

			case FixTags.DELIVERTOCOMPID_INT:
				deliverToCompID = FixUtils.getTagStringValue(value, deliverToCompID);
				break;

			case FixTags.SECUREDATALEN_INT:
				secureDataLen = FixUtils.getTagIntValue( value );
				break;

			case FixTags.SECUREDATA_INT:
				secureData = FixUtils.getTagStringValue(value, secureData);
				break;

			case FixTags.MSGSEQNUM_INT:
				msgSeqNum = FixUtils.getTagIntValue( value );
				break;

			case FixTags.SENDERSUBID_INT:
				senderSubID = FixUtils.getTagStringValue(value, senderSubID);
				break;

			case FixTags.SENDERLOCATIONID_INT:
				senderLocationID = FixUtils.getTagStringValue(value, senderLocationID);
				break;

			case FixTags.TARGETSUBID_INT:
				targetSubID = FixUtils.getTagStringValue(value, targetSubID);
				break;

			case FixTags.TARGETLOCATIONID_INT:
				targetLocationID = FixUtils.getTagStringValue(value, targetLocationID);
				break;

			case FixTags.ONBEHALFOFSUBID_INT:
				onBehalfOfSubID = FixUtils.getTagStringValue(value, onBehalfOfSubID);
				break;

			case FixTags.ONBEHALFOFLOCATIONID_INT:
				onBehalfOfLocationID = FixUtils.getTagStringValue(value, onBehalfOfLocationID);
				break;

			case FixTags.DELIVERTOSUBID_INT:
				deliverToSubID = FixUtils.getTagStringValue(value, deliverToSubID);
				break;

			case FixTags.DELIVERTOLOCATIONID_INT:
				deliverToLocationID = FixUtils.getTagStringValue(value, deliverToLocationID);
				break;

			case FixTags.POSSDUPFLAG_INT:
				possDupFlag = FixUtils.getTagBooleanValue( value );
				break;

			case FixTags.POSSRESEND_INT:
				possResend = FixUtils.getTagBooleanValue( value );
				break;

			case FixTags.SENDINGTIME_INT:
				sendingTime = FixUtils.getTagStringValue(value, sendingTime);
				break;

			case FixTags.ORIGSENDINGTIME_INT:
				origSendingTime = FixUtils.getTagStringValue(value, origSendingTime);
				break;

			case FixTags.XMLDATALEN_INT:
				xmlDataLen = FixUtils.getTagIntValue( value );
				break;

			case FixTags.XMLDATA_INT:
				xmlData = FixUtils.getTagStringValue(value, xmlData);
				break;

			case FixTags.MESSAGEENCODING_INT:
				messageEncoding = FixUtils.getTagStringValue(value, messageEncoding);
				break;

			case FixTags.LASTMSGSEQNUMPROCESSED_INT:
				lastMsgSeqNumProcessed = FixUtils.getTagIntValue( value );
				break;

			default:
				buf.position( lastTagPosition );

				return;

			}

			lastTagPosition = buf.position();

		}
	}

	/**
	 * @return the length written
	 *
	 */
	@Override
	public abstract void encode( ByteBuffer out );

	@Override
	public abstract void printBuffer( ByteBuffer out );

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixMessage)) return false;

			FixMessage msg = (FixMessage) o;

		if (!Utils.equals( beginString, msg.beginString)) return false;

		if (!Utils.equals( applVerID, msg.applVerID)) return false;

		if (!Utils.equals( cstmApplVerID, msg.cstmApplVerID)) return false;

		if (!( applExtID==msg.applExtID)) return false;

		if (!Utils.equals( senderCompID, msg.senderCompID)) return false;

		if (!Utils.equals( targetCompID, msg.targetCompID)) return false;

		if (!Utils.equals( onBehalfOfCompID, msg.onBehalfOfCompID)) return false;

		if (!Utils.equals( deliverToCompID, msg.deliverToCompID)) return false;

		if (!( secureDataLen==msg.secureDataLen)) return false;

		if (!Utils.equals( secureData, msg.secureData)) return false;

		if (!( msgSeqNum==msg.msgSeqNum)) return false;

		if (!Utils.equals( senderSubID, msg.senderSubID)) return false;

		if (!Utils.equals( senderLocationID, msg.senderLocationID)) return false;

		if (!Utils.equals( targetSubID, msg.targetSubID)) return false;

		if (!Utils.equals( targetLocationID, msg.targetLocationID)) return false;

		if (!Utils.equals( onBehalfOfSubID, msg.onBehalfOfSubID)) return false;

		if (!Utils.equals( onBehalfOfLocationID, msg.onBehalfOfLocationID)) return false;

		if (!Utils.equals( deliverToSubID, msg.deliverToSubID)) return false;

		if (!Utils.equals( deliverToLocationID, msg.deliverToLocationID)) return false;

		if (!( possDupFlag==msg.possDupFlag)) return false;

		if (!( possResend==msg.possResend)) return false;

		if (!( xmlDataLen==msg.xmlDataLen)) return false;

		if (!Utils.equals( xmlData, msg.xmlData)) return false;

		if (!Utils.equals( messageEncoding, msg.messageEncoding)) return false;

		if (!( lastMsgSeqNumProcessed==msg.lastMsgSeqNumProcessed)) return false;

		return true;

	}

	@Override
	public abstract String toString();
}
