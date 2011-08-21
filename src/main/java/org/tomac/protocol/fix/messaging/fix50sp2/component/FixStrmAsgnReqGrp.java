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
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixParties;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixStrmAsgnReqInstrmtGrp;

public class FixStrmAsgnReqGrp
{

	public int noAsgnReqs;
	public StrmAsgnReqGrp[] group;

	public void getAll(int noAsgnReqs, ByteBuffer buf) throws FixSessionException {
		this.noAsgnReqs = noAsgnReqs;

		if (noAsgnReqs < 1) throw new FixSessionException("asdasd");
		// this will leak memory if we grow the group
		if (group == null || group.length < noAsgnReqs) {
			group = new StrmAsgnReqGrp[noAsgnReqs];

			for ( int i = 0; i < noAsgnReqs; i++ ) group[i] = new StrmAsgnReqGrp();
	}

		for ( int i = 0; i < noAsgnReqs; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noAsgnReqs; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noAsgnReqs; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noAsgnReqs; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noAsgnReqs; i++)
			s += group[i].toString();
		return s;
	}

public class StrmAsgnReqGrp implements FixComponent
{

	public FixParties parties;
	public FixStrmAsgnReqInstrmtGrp strmAsgnReqInstrmtGrp;

	public StrmAsgnReqGrp() {
		super();

		parties = new FixParties();
		strmAsgnReqInstrmtGrp = new FixStrmAsgnReqInstrmtGrp();
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		parties.clear();
		strmAsgnReqInstrmtGrp.clear();
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.NOPARTYIDS_INT) {
				parties.getAll(FixTags.NOPARTYIDS_INT, buf);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.NORELATEDSYM_INT) {
				strmAsgnReqInstrmtGrp.getAll(FixTags.NORELATEDSYM_INT, buf);
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
		if (FixUtils.isSet(parties.noPartyIDs)) return true;
		if (FixUtils.isSet(strmAsgnReqInstrmtGrp.noRelatedSym)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(parties.noPartyIDs)) parties.encode( out );
		if (FixUtils.isSet(strmAsgnReqInstrmtGrp.noRelatedSym)) strmAsgnReqInstrmtGrp.encode( out );
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

			if (FixUtils.isSet(parties.noPartyIDs)) s += parties.toString();
			if (FixUtils.isSet(strmAsgnReqInstrmtGrp.noRelatedSym)) s += strmAsgnReqInstrmtGrp.toString();
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof StrmAsgnReqGrp)) return false;

			StrmAsgnReqGrp msg = (StrmAsgnReqGrp) o;

		if ( ! super.equals(msg) ) return false;

		if (!parties.equals(msg.parties)) return false;

		if (!strmAsgnReqInstrmtGrp.equals(msg.strmAsgnReqInstrmtGrp)) return false;

		return true;
	}
}
}
