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
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixUnderlyingInstrument;

public class FixUndInstrmtGrp
{

	public int noUnderlyings;
	public UndInstrmtGrp[] group;

	public void getAll(int noUnderlyings, ByteBuffer buf) throws FixSessionException {
		this.noUnderlyings = noUnderlyings;

		if (noUnderlyings < 1) throw new FixSessionException("asdasd");
		// this will leak memory if we grow the group
		if (group.length < noUnderlyings) 
			group = new UndInstrmtGrp[noUnderlyings];

		for ( int i = 0; i < noUnderlyings; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noUnderlyings; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noUnderlyings; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noUnderlyings; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noUnderlyings; i++)
			s += group[i].toString();
		return s;
	}

public class UndInstrmtGrp implements FixComponent
{

	public FixUnderlyingInstrument underlyingInstrument;

	public UndInstrmtGrp() {
		super();

		underlyingInstrument = new FixUnderlyingInstrument();
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		underlyingInstrument.clear();
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.UNDERLYINGSYMBOL_INT) {
				underlyingInstrument.getAll(FixTags.UNDERLYINGSYMBOL_INT, buf);
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
		if (FixUtils.isSet(underlyingInstrument.underlyingSymbol)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(underlyingInstrument.underlyingSymbol)) underlyingInstrument.encode( out );
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

			if (FixUtils.isSet(underlyingInstrument.underlyingSymbol)) s += underlyingInstrument.toString();
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof UndInstrmtGrp)) return false;

			UndInstrmtGrp msg = (UndInstrmtGrp) o;

		if ( ! super.equals(msg) ) return false;

		if (!underlyingInstrument.equals(msg.underlyingInstrument)) return false;

		return true;
	}
}
}
