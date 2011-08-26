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

public class FixDerivativeInstrumentPartySubIDsGrp
{

	public int noDerivativeInstrumentPartySubIDs;
	public DerivativeInstrumentPartySubIDsGrp[] group;

	public void getAll(int noDerivativeInstrumentPartySubIDs, ByteBuffer buf) throws FixSessionException, FixGarbledException {
		this.noDerivativeInstrumentPartySubIDs = noDerivativeInstrumentPartySubIDs;

		if (noDerivativeInstrumentPartySubIDs < 1) throw new FixSessionException(SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, ("Incorrect num in group count " + noDerivativeInstrumentPartySubIDs ).getBytes(), FixTags.NODERIVATIVEINSTRUMENTPARTYSUBIDS_INT, new byte[0]);
		// this will leak memory if we grow the group
		if (group == null || group.length < noDerivativeInstrumentPartySubIDs) {
			group = new DerivativeInstrumentPartySubIDsGrp[noDerivativeInstrumentPartySubIDs];

			for ( int i = 0; i < noDerivativeInstrumentPartySubIDs; i++ ) group[i] = new DerivativeInstrumentPartySubIDsGrp();
	}

		for ( int i = 0; i < noDerivativeInstrumentPartySubIDs; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noDerivativeInstrumentPartySubIDs; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noDerivativeInstrumentPartySubIDs; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noDerivativeInstrumentPartySubIDs; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noDerivativeInstrumentPartySubIDs; i++)
			s += group[i].toString();
		return s;
	}

public class DerivativeInstrumentPartySubIDsGrp implements FixComponent
{

	public byte[] derivativeInstrumentPartySubID;
	public long derivativeInstrumentPartySubIDType = 0;

	public DerivativeInstrumentPartySubIDsGrp() {
		super();

		derivativeInstrumentPartySubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		Utils.fill( derivativeInstrumentPartySubID, (byte)0 );
		derivativeInstrumentPartySubIDType = Long.MAX_VALUE;		
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException, FixGarbledException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.DERIVATIVEINSTRUMENTPARTYSUBID_INT) {
				derivativeInstrumentPartySubID = FixUtils.getTagStringValue(value, derivativeInstrumentPartySubID);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.DERIVATIVEINSTRUMENTPARTYSUBIDTYPE_INT) {
				derivativeInstrumentPartySubIDType = FixUtils.getTagIntValue( value );
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
		if (FixUtils.isSet(derivativeInstrumentPartySubID)) return true;
		if (FixUtils.isSet(derivativeInstrumentPartySubIDType)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(derivativeInstrumentPartySubID)) FixUtils.putFixTag( out, FixTags.DERIVATIVEINSTRUMENTPARTYSUBID_INT, derivativeInstrumentPartySubID, 0, Utils.lastIndexTrim(derivativeInstrumentPartySubID, (byte)0) );
		if (FixUtils.isSet(derivativeInstrumentPartySubIDType)) FixUtils.putFixTag( out, FixTags.DERIVATIVEINSTRUMENTPARTYSUBIDTYPE_INT, derivativeInstrumentPartySubIDType);
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

			if (FixUtils.isSet(derivativeInstrumentPartySubID)) s += "DerivativeInstrumentPartySubID(1297)=" + new String(derivativeInstrumentPartySubID) + sep;
			if (FixUtils.isSet(derivativeInstrumentPartySubIDType)) s += "DerivativeInstrumentPartySubIDType(1298)=" + String.valueOf(derivativeInstrumentPartySubIDType) + sep;
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof DerivativeInstrumentPartySubIDsGrp)) return false;

			DerivativeInstrumentPartySubIDsGrp msg = (DerivativeInstrumentPartySubIDsGrp) o;

		if ( ! super.equals(msg) ) return false;

		if (!Utils.equals( derivativeInstrumentPartySubID, msg.derivativeInstrumentPartySubID)) return false;

		if (!( derivativeInstrumentPartySubIDType==msg.derivativeInstrumentPartySubIDType)) return false;

		return true;
	}
}
}
