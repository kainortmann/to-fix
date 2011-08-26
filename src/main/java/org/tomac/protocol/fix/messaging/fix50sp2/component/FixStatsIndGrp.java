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

public class FixStatsIndGrp
{

	public int noStatsIndicators;
	public StatsIndGrp[] group;

	public void getAll(int noStatsIndicators, ByteBuffer buf) throws FixSessionException, FixGarbledException {
		this.noStatsIndicators = noStatsIndicators;

		if (noStatsIndicators < 1) throw new FixSessionException(SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, ("Incorrect num in group count " + noStatsIndicators ).getBytes(), FixTags.NOSTATSINDICATORS_INT, new byte[0]);
		// this will leak memory if we grow the group
		if (group == null || group.length < noStatsIndicators) {
			group = new StatsIndGrp[noStatsIndicators];

			for ( int i = 0; i < noStatsIndicators; i++ ) group[i] = new StatsIndGrp();
	}

		for ( int i = 0; i < noStatsIndicators; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noStatsIndicators; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noStatsIndicators; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noStatsIndicators; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noStatsIndicators; i++)
			s += group[i].toString();
		return s;
	}

public class StatsIndGrp implements FixComponent
{

	public long statsType = 0;

	public StatsIndGrp() {
		super();

		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		statsType = Long.MAX_VALUE;		
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException, FixGarbledException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.STATSTYPE_INT) {
				statsType = FixUtils.getTagIntValue( value );
				if (!FixMessageInfo.StatsType.isValid(statsType) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + statsType + ") for tag").getBytes(), id, new byte[0] );
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
		if (FixUtils.isSet(statsType)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(statsType)) FixUtils.putFixTag( out, FixTags.STATSTYPE_INT, statsType);
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

			if (FixUtils.isSet(statsType)) s += "StatsType(1176)=" + String.valueOf(statsType) + sep;
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof StatsIndGrp)) return false;

			StatsIndGrp msg = (StatsIndGrp) o;

		if ( ! super.equals(msg) ) return false;

		if (!( statsType==msg.statsType)) return false;

		return true;
	}
}
}
