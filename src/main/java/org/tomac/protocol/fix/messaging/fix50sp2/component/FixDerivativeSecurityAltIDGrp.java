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

public class FixDerivativeSecurityAltIDGrp
{

	public int noDerivativeSecurityAltID;
	public DerivativeSecurityAltIDGrp[] group;

	public void getAll(int noDerivativeSecurityAltID, ByteBuffer buf) throws FixSessionException {
		this.noDerivativeSecurityAltID = noDerivativeSecurityAltID;

		if (noDerivativeSecurityAltID < 1) throw new FixSessionException("asdasd");
		// this will leak memory if we grow the group
		if (group.length < noDerivativeSecurityAltID) 
			group = new DerivativeSecurityAltIDGrp[noDerivativeSecurityAltID];

		for ( int i = 0; i < noDerivativeSecurityAltID; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noDerivativeSecurityAltID; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noDerivativeSecurityAltID; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noDerivativeSecurityAltID; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noDerivativeSecurityAltID; i++)
			s += group[i].toString();
		return s;
	}

public class DerivativeSecurityAltIDGrp implements FixComponent
{

	public byte[] derivativeSecurityAltID;
	public byte[] derivativeSecurityAltIDSource;

	public DerivativeSecurityAltIDGrp() {
		super();

		derivativeSecurityAltID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		derivativeSecurityAltIDSource = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		Utils.fill( derivativeSecurityAltID, (byte)0 );
		Utils.fill( derivativeSecurityAltIDSource, (byte)0 );
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.DERIVATIVESECURITYALTID_INT) {
				derivativeSecurityAltID = FixUtils.getTagStringValue(value, derivativeSecurityAltID);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.DERIVATIVESECURITYALTIDSOURCE_INT) {
				derivativeSecurityAltIDSource = FixUtils.getTagStringValue(value, derivativeSecurityAltIDSource);
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
		if (FixUtils.isSet(derivativeSecurityAltID)) return true;
		if (FixUtils.isSet(derivativeSecurityAltIDSource)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(derivativeSecurityAltID)) FixUtils.putFixTag( out, FixTags.DERIVATIVESECURITYALTID_INT, derivativeSecurityAltID, 0, Utils.lastIndexTrim(derivativeSecurityAltID, (byte)0) );
		if (FixUtils.isSet(derivativeSecurityAltIDSource)) FixUtils.putFixTag( out, FixTags.DERIVATIVESECURITYALTIDSOURCE_INT, derivativeSecurityAltIDSource, 0, Utils.lastIndexTrim(derivativeSecurityAltIDSource, (byte)0) );
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

			if (FixUtils.isSet(derivativeSecurityAltID)) s += "DerivativeSecurityAltID(1219)=" + new String(derivativeSecurityAltID) + sep;
			if (FixUtils.isSet(derivativeSecurityAltIDSource)) s += "DerivativeSecurityAltIDSource(1220)=" + new String(derivativeSecurityAltIDSource) + sep;
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof DerivativeSecurityAltIDGrp)) return false;

			DerivativeSecurityAltIDGrp msg = (DerivativeSecurityAltIDGrp) o;

		if ( ! super.equals(msg) ) return false;

		if (!Utils.equals( derivativeSecurityAltID, msg.derivativeSecurityAltID)) return false;

		if (!Utils.equals( derivativeSecurityAltIDSource, msg.derivativeSecurityAltIDSource)) return false;

		return true;
	}
}
}
