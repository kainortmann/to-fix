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


import org.tomac.protocol.fix.messaging.fix50sp2.FixMessageInfo.SessionRejectReason;
import org.tomac.protocol.fix.messaging.fix50sp2.FixMessageInfo;
import org.tomac.protocol.fix.messaging.fix50sp2.FixTags;

public class FixNstdPtys3SubGrp
{

	public int noNested3PartySubIDs;
	public NstdPtys3SubGrp[] group;

	public void getAll(int noNested3PartySubIDs, ByteBuffer buf) throws FixSessionException, FixGarbledException {
		this.noNested3PartySubIDs = noNested3PartySubIDs;

		if (noNested3PartySubIDs < 1) throw new FixSessionException(SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, ("Incorrect num in group count " + noNested3PartySubIDs ).getBytes(), FixTags.NONESTED3PARTYSUBIDS_INT, new byte[0]);
		// this will leak memory if we grow the group
		if (group == null || group.length < noNested3PartySubIDs) {
			group = new NstdPtys3SubGrp[noNested3PartySubIDs];

			for ( int i = 0; i < noNested3PartySubIDs; i++ ) group[i] = new NstdPtys3SubGrp();
	}

		for ( int i = 0; i < noNested3PartySubIDs; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noNested3PartySubIDs; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noNested3PartySubIDs; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noNested3PartySubIDs; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noNested3PartySubIDs; i++)
			s += group[i].toString();
		return s;
	}

public class NstdPtys3SubGrp implements FixComponent
{

	public byte[] nested3PartySubID;
	public long nested3PartySubIDType = 0;

	public NstdPtys3SubGrp() {
		super();

		nested3PartySubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		Utils.fill( nested3PartySubID, (byte)0 );
		nested3PartySubIDType = Long.MAX_VALUE;		
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException, FixGarbledException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.NESTED3PARTYSUBID_INT) {
				nested3PartySubID = FixUtils.getTagStringValue(value, nested3PartySubID);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.NESTED3PARTYSUBIDTYPE_INT) {
				nested3PartySubIDType = FixUtils.getTagIntValue( value );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			id = checkRequiredTags();
				if (id > 0) throw new FixSessionException(SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing".getBytes(), id, new byte[0] );

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
		if (FixUtils.isSet(nested3PartySubID)) return true;
		if (FixUtils.isSet(nested3PartySubIDType)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(nested3PartySubID)) FixUtils.putFixTag( out, FixTags.NESTED3PARTYSUBID_INT, nested3PartySubID, 0, Utils.lastIndexTrim(nested3PartySubID, (byte)0) );
		if (FixUtils.isSet(nested3PartySubIDType)) FixUtils.putFixTag( out, FixTags.NESTED3PARTYSUBIDTYPE_INT, nested3PartySubIDType);
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

			if (FixUtils.isSet(nested3PartySubID)) s += "Nested3PartySubID(953)=" + new String(nested3PartySubID) + sep;
			if (FixUtils.isSet(nested3PartySubIDType)) s += "Nested3PartySubIDType(954)=" + String.valueOf(nested3PartySubIDType) + sep;
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof NstdPtys3SubGrp)) return false;

			NstdPtys3SubGrp msg = (NstdPtys3SubGrp) o;

		if ( ! super.equals(msg) ) return false;

		if (!Utils.equals( nested3PartySubID, msg.nested3PartySubID)) return false;

		if (!( nested3PartySubIDType==msg.nested3PartySubIDType)) return false;

		return true;
	}
}
}
