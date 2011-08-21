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

public class FixUndlyInstrumentPtysSubGrp
{

	public int noUndlyInstrumentPartySubIDs;
	public UndlyInstrumentPtysSubGrp[] group;

	public void getAll(int noUndlyInstrumentPartySubIDs, ByteBuffer buf) throws FixSessionException {
		this.noUndlyInstrumentPartySubIDs = noUndlyInstrumentPartySubIDs;

		if (noUndlyInstrumentPartySubIDs < 1) throw new FixSessionException("asdasd");
		// this will leak memory if we grow the group
		if (group == null || group.length < noUndlyInstrumentPartySubIDs) {
			group = new UndlyInstrumentPtysSubGrp[noUndlyInstrumentPartySubIDs];

			for ( int i = 0; i < noUndlyInstrumentPartySubIDs; i++ ) group[i] = new UndlyInstrumentPtysSubGrp();
	}

		for ( int i = 0; i < noUndlyInstrumentPartySubIDs; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noUndlyInstrumentPartySubIDs; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noUndlyInstrumentPartySubIDs; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noUndlyInstrumentPartySubIDs; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noUndlyInstrumentPartySubIDs; i++)
			s += group[i].toString();
		return s;
	}

public class UndlyInstrumentPtysSubGrp implements FixComponent
{

	public byte[] underlyingInstrumentPartySubID;
	public long underlyingInstrumentPartySubIDType = 0;

	public UndlyInstrumentPtysSubGrp() {
		super();

		underlyingInstrumentPartySubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		Utils.fill( underlyingInstrumentPartySubID, (byte)0 );
		underlyingInstrumentPartySubIDType = Long.MAX_VALUE;		
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.UNDERLYINGINSTRUMENTPARTYSUBID_INT) {
				underlyingInstrumentPartySubID = FixUtils.getTagStringValue(value, underlyingInstrumentPartySubID);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.UNDERLYINGINSTRUMENTPARTYSUBIDTYPE_INT) {
				underlyingInstrumentPartySubIDType = FixUtils.getTagIntValue( value );
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
		if (FixUtils.isSet(underlyingInstrumentPartySubID)) return true;
		if (FixUtils.isSet(underlyingInstrumentPartySubIDType)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(underlyingInstrumentPartySubID)) FixUtils.putFixTag( out, FixTags.UNDERLYINGINSTRUMENTPARTYSUBID_INT, underlyingInstrumentPartySubID, 0, Utils.lastIndexTrim(underlyingInstrumentPartySubID, (byte)0) );
		if (FixUtils.isSet(underlyingInstrumentPartySubIDType)) FixUtils.putFixTag( out, FixTags.UNDERLYINGINSTRUMENTPARTYSUBIDTYPE_INT, underlyingInstrumentPartySubIDType);
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

			if (FixUtils.isSet(underlyingInstrumentPartySubID)) s += "UnderlyingInstrumentPartySubID(1063)=" + new String(underlyingInstrumentPartySubID) + sep;
			if (FixUtils.isSet(underlyingInstrumentPartySubIDType)) s += "UnderlyingInstrumentPartySubIDType(1064)=" + String.valueOf(underlyingInstrumentPartySubIDType) + sep;
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof UndlyInstrumentPtysSubGrp)) return false;

			UndlyInstrumentPtysSubGrp msg = (UndlyInstrumentPtysSubGrp) o;

		if ( ! super.equals(msg) ) return false;

		if (!Utils.equals( underlyingInstrumentPartySubID, msg.underlyingInstrumentPartySubID)) return false;

		if (!( underlyingInstrumentPartySubIDType==msg.underlyingInstrumentPartySubIDType)) return false;

		return true;
	}
}
}
