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


import org.tomac.protocol.fix.messaging.fix50sp2.FixMessageInfo;
import org.tomac.protocol.fix.messaging.fix50sp2.FixTags;

public class FixApplIDReportGrp
{

	public int noApplIDs;
	public ApplIDReportGrp[] group;

	public void getAll(int noApplIDs, ByteBuffer buf) throws FixSessionException {
		this.noApplIDs = noApplIDs;

		if (noApplIDs < 1) throw new FixSessionException("asdasd");
		// this will leak memory if we grow the group
		if (group == null || group.length < noApplIDs) {
			group = new ApplIDReportGrp[noApplIDs];

			for ( int i = 0; i < noApplIDs; i++ ) group[i] = new ApplIDReportGrp();
	}

		for ( int i = 0; i < noApplIDs; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noApplIDs; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noApplIDs; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noApplIDs; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noApplIDs; i++)
			s += group[i].toString();
		return s;
	}

public class ApplIDReportGrp implements FixComponent
{

	public byte[] refApplID;
	public long applNewSeqNum = 0;
	public long refApplLastSeqNum = 0;

	public ApplIDReportGrp() {
		super();

		refApplID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		Utils.fill( refApplID, (byte)0 );
		applNewSeqNum = Long.MAX_VALUE;		
		refApplLastSeqNum = Long.MAX_VALUE;		
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.REFAPPLID_INT) {
				refApplID = FixUtils.getTagStringValue(value, refApplID);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.APPLNEWSEQNUM_INT) {
				applNewSeqNum = FixUtils.getTagIntValue( value );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.REFAPPLLASTSEQNUM_INT) {
				refApplLastSeqNum = FixUtils.getTagIntValue( value );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			id = checkRequiredTags();
			if (id > 0) throw new FixSessionException(buf, "Required tag missing: " + id );

			buf.position( lastTagPosition );
			return;

	}

	private int checkRequiredTags() {
		int tag = -1;

		return tag;

	}
	@Override
	public boolean isSet()
	{
		if (FixUtils.isSet(refApplID)) return true;
		if (FixUtils.isSet(applNewSeqNum)) return true;
		if (FixUtils.isSet(refApplLastSeqNum)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(refApplID)) FixUtils.putFixTag( out, FixTags.REFAPPLID_INT, refApplID, 0, Utils.lastIndexTrim(refApplID, (byte)0) );
		if (FixUtils.isSet(applNewSeqNum)) FixUtils.putFixTag( out, FixTags.APPLNEWSEQNUM_INT, applNewSeqNum);
		if (FixUtils.isSet(refApplLastSeqNum)) FixUtils.putFixTag( out, FixTags.REFAPPLLASTSEQNUM_INT, refApplLastSeqNum);
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

			if (FixUtils.isSet(refApplID)) s += "RefApplID(1355)=" + new String(refApplID) + sep;
			if (FixUtils.isSet(applNewSeqNum)) s += "ApplNewSeqNum(1399)=" + String.valueOf(applNewSeqNum) + sep;
			if (FixUtils.isSet(refApplLastSeqNum)) s += "RefApplLastSeqNum(1357)=" + String.valueOf(refApplLastSeqNum) + sep;
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof ApplIDReportGrp)) return false;

			ApplIDReportGrp msg = (ApplIDReportGrp) o;

		if ( ! super.equals(msg) ) return false;

		if (!Utils.equals( refApplID, msg.refApplID)) return false;

		if (!( applNewSeqNum==msg.applNewSeqNum)) return false;

		if (!( refApplLastSeqNum==msg.refApplLastSeqNum)) return false;

		return true;
	}
}
}
