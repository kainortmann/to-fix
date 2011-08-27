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

public class FixPositionAmountData
{

	public int noPosAmt;
	public PositionAmountData[] group;

	public void getAll(int noPosAmt, ByteBuffer buf) throws FixSessionException, FixGarbledException {
		this.noPosAmt = noPosAmt;

		if (noPosAmt < 1) throw new FixSessionException(SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, ("Incorrect num in group count " + noPosAmt ).getBytes(), FixTags.NOPOSAMT_INT, new byte[0]);
		// this will leak memory if we grow the group
		if (group == null || group.length < noPosAmt) {
			group = new PositionAmountData[noPosAmt];

			for ( int i = 0; i < noPosAmt; i++ ) group[i] = new PositionAmountData();
	}

		for ( int i = 0; i < noPosAmt; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noPosAmt; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noPosAmt; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noPosAmt; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixPositionAmountData)) return false;

		FixPositionAmountData msg = (FixPositionAmountData) o;

		for (int i = 0; i<noPosAmt; i++)
			if (!group[i].equals(msg.group[i])) return false;
		return true;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noPosAmt; i++)
			s += group[i].toString();
		return s;
	}

public class PositionAmountData implements FixComponent
{

	public byte[] posAmtType;
	public long posAmt = 0;
	public byte[] positionCurrency;

	public PositionAmountData() {
		super();

		posAmtType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		positionCurrency = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		Utils.fill( posAmtType, (byte)0 );
		posAmt = Long.MAX_VALUE;		
		Utils.fill( positionCurrency, (byte)0 );
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException, FixGarbledException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.POSAMTTYPE_INT) {
				posAmtType = FixUtils.getTagStringValue(value, posAmtType);
				if (!FixMessageInfo.PosAmtType.isValid(posAmtType) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + posAmtType + ") for tag").getBytes(), id, new byte[0] );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.POSAMT_INT) {
				posAmt = FixUtils.getTagFloatValue(value);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.POSITIONCURRENCY_INT) {
				positionCurrency = FixUtils.getTagStringValue(value, positionCurrency);
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
		if (FixUtils.isSet(posAmtType)) return true;
		if (FixUtils.isSet(posAmt)) return true;
		if (FixUtils.isSet(positionCurrency)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(posAmtType)) FixUtils.putFixTag( out, FixTags.POSAMTTYPE_INT, posAmtType, 0, Utils.lastIndexTrim(posAmtType, (byte)0) );
		if (FixUtils.isSet(posAmt)) FixUtils.putFixTag( out, FixTags.POSAMT_INT, posAmt);
		if (FixUtils.isSet(positionCurrency)) FixUtils.putFixTag( out, FixTags.POSITIONCURRENCY_INT, positionCurrency, 0, Utils.lastIndexTrim(positionCurrency, (byte)0) );
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

			if (FixUtils.isSet(posAmtType)) s += "PosAmtType(707)=" + new String(posAmtType) + sep;
			if (FixUtils.isSet(posAmt)) s += "PosAmt(708)=" + String.valueOf(posAmt) + sep;
			if (FixUtils.isSet(positionCurrency)) s += "PositionCurrency(1055)=" + new String(positionCurrency) + sep;
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof PositionAmountData)) return false;

			PositionAmountData msg = (PositionAmountData) o;

		if (!Utils.equals( posAmtType, msg.posAmtType)) return false;

		if (!( posAmt==msg.posAmt)) return false;

		if (!Utils.equals( positionCurrency, msg.positionCurrency)) return false;

		return true;
	}
}
}