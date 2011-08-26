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

public class FixRelatedPtysSubGrp
{

	public int noRelatedPartySubIDs;
	public RelatedPtysSubGrp[] group;

	public void getAll(int noRelatedPartySubIDs, ByteBuffer buf) throws FixSessionException, FixGarbledException {
		this.noRelatedPartySubIDs = noRelatedPartySubIDs;

		if (noRelatedPartySubIDs < 1) throw new FixSessionException(SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, ("Incorrect num in group count " + noRelatedPartySubIDs ).getBytes(), FixTags.NORELATEDPARTYSUBIDS_INT, new byte[0]);
		// this will leak memory if we grow the group
		if (group == null || group.length < noRelatedPartySubIDs) {
			group = new RelatedPtysSubGrp[noRelatedPartySubIDs];

			for ( int i = 0; i < noRelatedPartySubIDs; i++ ) group[i] = new RelatedPtysSubGrp();
	}

		for ( int i = 0; i < noRelatedPartySubIDs; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noRelatedPartySubIDs; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noRelatedPartySubIDs; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noRelatedPartySubIDs; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noRelatedPartySubIDs; i++)
			s += group[i].toString();
		return s;
	}

public class RelatedPtysSubGrp implements FixComponent
{

	public byte[] relatedPartySubID;
	public long relatedPartySubIDType = 0;

	public RelatedPtysSubGrp() {
		super();

		relatedPartySubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		Utils.fill( relatedPartySubID, (byte)0 );
		relatedPartySubIDType = Long.MAX_VALUE;		
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException, FixGarbledException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.RELATEDPARTYSUBID_INT) {
				relatedPartySubID = FixUtils.getTagStringValue(value, relatedPartySubID);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.RELATEDPARTYSUBIDTYPE_INT) {
				relatedPartySubIDType = FixUtils.getTagIntValue( value );
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
		if (FixUtils.isSet(relatedPartySubID)) return true;
		if (FixUtils.isSet(relatedPartySubIDType)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(relatedPartySubID)) FixUtils.putFixTag( out, FixTags.RELATEDPARTYSUBID_INT, relatedPartySubID, 0, Utils.lastIndexTrim(relatedPartySubID, (byte)0) );
		if (FixUtils.isSet(relatedPartySubIDType)) FixUtils.putFixTag( out, FixTags.RELATEDPARTYSUBIDTYPE_INT, relatedPartySubIDType);
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

			if (FixUtils.isSet(relatedPartySubID)) s += "RelatedPartySubID(1567)=" + new String(relatedPartySubID) + sep;
			if (FixUtils.isSet(relatedPartySubIDType)) s += "RelatedPartySubIDType(1568)=" + String.valueOf(relatedPartySubIDType) + sep;
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof RelatedPtysSubGrp)) return false;

			RelatedPtysSubGrp msg = (RelatedPtysSubGrp) o;

		if ( ! super.equals(msg) ) return false;

		if (!Utils.equals( relatedPartySubID, msg.relatedPartySubID)) return false;

		if (!( relatedPartySubIDType==msg.relatedPartySubIDType)) return false;

		return true;
	}
}
}
