package org.tomac.protocol.fix.messaging.fix50sp2.component;

// DO NOT EDIT!!!
// This file is generated by FixMessageGenerator.
// If you need additional functionality, put it in a helper class
// that does not live in this folder!!!  Any java file in this folder 
// will be deleted upon the next run of the FixMessageGenerator!

import java.nio.ByteBuffer;

import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.FixSessionException;
import org.tomac.protocol.fix.FixGarbledException;
import org.tomac.utils.Utils;
import org.tomac.protocol.fix.FixConstants;


import org.tomac.protocol.fix.messaging.fix50sp2.FixTags;
import org.tomac.protocol.fix.messaging.fix50sp2.FixMessageInfo.*;

public class FixApplicationSequenceControl implements FixComponent
{

	public byte[] applID;
	public long applSeqNum = 0;
	public long applLastSeqNum = 0;
	public boolean applResendFlag = false;

	public FixApplicationSequenceControl() {
		super();

		applID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		Utils.fill( applID, (byte)0 );
		applSeqNum = Long.MAX_VALUE;		
		applLastSeqNum = Long.MAX_VALUE;		
		applResendFlag = false;		
	}

	public void getAll(int id, ByteBuffer buf) throws FixSessionException, FixGarbledException
	{

		int startTagPosition = buf.position();

		int lastTagPosition = buf.position();
		do {
			ByteBuffer value;

			value = buf;

			switch( id ) {

			case FixTags.APPLID_INT:
				applID = FixUtils.getTagStringValue(value, applID);
				break;

			case FixTags.APPLSEQNUM_INT:
				applSeqNum = FixUtils.getTagIntValue( value );
				break;

			case FixTags.APPLLASTSEQNUM_INT:
				applLastSeqNum = FixUtils.getTagIntValue( value );
				break;

			case FixTags.APPLRESENDFLAG_INT:
				applResendFlag = FixUtils.getTagBooleanValue( value );
				break;

			// we will always endup with unknown tag, unread and return to upper layer in hierarchy
			default:
				id = checkRequiredTags();
				if (id > 0) throw new FixSessionException(SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing".getBytes(), id, new byte[0] );

				buf.position( lastTagPosition );
				return;

			}

			lastTagPosition = buf.position();

		} while ( ( id = FixUtils.getTagId( buf ) ) > 0 );

		buf.position(startTagPosition);

	}

	private int checkRequiredTags() {
		int tag = -1;

		return tag;

	}
	@Override
	public boolean isSet()
	{
		if (FixUtils.isSet(applID)) return true;
		if (FixUtils.isSet(applSeqNum)) return true;
		if (FixUtils.isSet(applLastSeqNum)) return true;
		if (FixUtils.isSet(applResendFlag)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(applID)) FixUtils.putFixTag( out, FixTags.APPLID_INT, applID, 0, Utils.lastIndexTrim(applID, (byte)0) );
		if (FixUtils.isSet(applSeqNum)) FixUtils.putFixTag( out, FixTags.APPLSEQNUM_INT, applSeqNum);
		if (FixUtils.isSet(applLastSeqNum)) FixUtils.putFixTag( out, FixTags.APPLLASTSEQNUM_INT, applLastSeqNum);
		if (FixUtils.isSet(applResendFlag)) FixUtils.putFixTag( out, FixTags.APPLRESENDFLAG_INT, applResendFlag?(byte)'Y':(byte)'N' );
	}
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will end up in nifelheim!
	**/
	@Override
	public String toString() {
		char sep = '\n';
		if (Boolean.getBoolean("fix.useOneLiner")) sep = ( byte )0x01;

		String s = "";

			if (FixUtils.isSet(applID)) s += "ApplID(1180)=" + new String(applID) + sep;
			if (FixUtils.isSet(applSeqNum)) s += "ApplSeqNum(1181)=" + String.valueOf(applSeqNum) + sep;
			if (FixUtils.isSet(applLastSeqNum)) s += "ApplLastSeqNum(1350)=" + String.valueOf(applLastSeqNum) + sep;
			if (FixUtils.isSet(applResendFlag)) s += "ApplResendFlag(1352)=" + String.valueOf(applResendFlag) + sep;
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixApplicationSequenceControl)) return false;

			FixApplicationSequenceControl msg = (FixApplicationSequenceControl) o;

		if (!Utils.equals( applID, msg.applID)) return false;

		if (!( applSeqNum==msg.applSeqNum)) return false;

		if (!( applLastSeqNum==msg.applLastSeqNum)) return false;

		if (!( applResendFlag==msg.applResendFlag)) return false;

		return true;
	}
}