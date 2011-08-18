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


import org.tomac.protocol.fix.messaging.fix50sp2.FixMessageInfo.*;
import org.tomac.protocol.fix.messaging.fix50sp2.FixTags;

public class FixAttrbGrp
{

	public int noInstrAttrib;
	public AttrbGrp[] group;

	public void getAll(int noInstrAttrib, ByteBuffer buf) throws FixSessionException {
		this.noInstrAttrib = noInstrAttrib;

		if (noInstrAttrib < 1) throw new FixSessionException("asdasd");
		// this will leak memory if we grow the group
		if (group.length < noInstrAttrib) 
			group = new AttrbGrp[noInstrAttrib];

		for ( int i = 0; i < noInstrAttrib; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noInstrAttrib; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noInstrAttrib; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noInstrAttrib; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noInstrAttrib; i++)
			s += group[i].toString();
		return s;
	}

public class AttrbGrp implements FixComponent
{

	public long instrAttribType = 0;
	public byte[] instrAttribValue;

	public AttrbGrp() {
		super();

		instrAttribValue = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		instrAttribType = Long.MAX_VALUE;		
		Utils.fill( instrAttribValue, (byte)0 );
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.INSTRATTRIBTYPE_INT) {
				instrAttribType = FixUtils.getTagIntValue( value );
				if (!InstrAttribType.isValid(instrAttribType) ) throw new FixSessionException(buf, "Invalid enumerated value(" + instrAttribType + ") for tag: " + id );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.INSTRATTRIBVALUE_INT) {
				instrAttribValue = FixUtils.getTagStringValue(value, instrAttribValue);
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
		if (FixUtils.isSet(instrAttribType)) return true;
		if (FixUtils.isSet(instrAttribValue)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(instrAttribType)) FixUtils.putFixTag( out, FixTags.INSTRATTRIBTYPE_INT, instrAttribType);
		if (FixUtils.isSet(instrAttribValue)) FixUtils.putFixTag( out, FixTags.INSTRATTRIBVALUE_INT, instrAttribValue, 0, Utils.lastIndexTrim(instrAttribValue, (byte)0) );
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

			if (FixUtils.isSet(instrAttribType)) s += "InstrAttribType(871)=" + String.valueOf(instrAttribType) + sep;
			if (FixUtils.isSet(instrAttribValue)) s += "InstrAttribValue(872)=" + new String(instrAttribValue) + sep;
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof AttrbGrp)) return false;

			AttrbGrp msg = (AttrbGrp) o;

		if ( ! super.equals(msg) ) return false;

		if (!( instrAttribType==msg.instrAttribType)) return false;

		if (!Utils.equals( instrAttribValue, msg.instrAttribValue)) return false;

		return true;
	}
}
}
