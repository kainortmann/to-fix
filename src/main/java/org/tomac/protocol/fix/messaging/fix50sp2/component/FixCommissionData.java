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


import org.tomac.protocol.fix.messaging.fix50sp2.FixTags;
import org.tomac.protocol.fix.messaging.fix50sp2.FixMessageInfo.*;

public class FixCommissionData implements FixComponent
{

	public long commission = 0;
	public byte commType = (byte)' ';
	public byte[] commCurrency;
	public byte fundRenewWaiv = (byte)' ';

	public FixCommissionData() {
		super();

		commCurrency = new byte[FixUtils.CURRENCY_LENGTH];
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		commission = Long.MAX_VALUE;		
		commType = Byte.MAX_VALUE;		
		Utils.fill( commCurrency, (byte)0 );
		fundRenewWaiv = Byte.MAX_VALUE;		
	}

	public void getAll(int id, ByteBuffer buf) throws FixSessionException, FixGarbledException
	{

		int startTagPosition = buf.position();

		int lastTagPosition = buf.position();
		do {
			ByteBuffer value;

			value = buf;

			switch( id ) {

			case FixTags.COMMISSION_INT:
				commission = FixUtils.getTagFloatValue(value);
				break;

			case FixTags.COMMTYPE_INT:
				commType = FixUtils.getTagCharValue( value );
				if (!CommType.isValid(commType) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + commType + ") for tag").getBytes(), id, new byte[0] );
				break;

			case FixTags.COMMCURRENCY_INT:
				commCurrency = FixUtils.getTagStringValue(value, commCurrency);
				break;

			case FixTags.FUNDRENEWWAIV_INT:
				fundRenewWaiv = FixUtils.getTagCharValue( value );
				if (!FundRenewWaiv.isValid(fundRenewWaiv) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + fundRenewWaiv + ") for tag").getBytes(), id, new byte[0] );
				break;

			// we will always endup with unknown tag, unread and return to upper layer in hierarchy
			default:
				id = checkRequiredTags();
				if (id > 0) throw new FixSessionException(SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing".getBytes(), id, new byte[0] );

				buf.position( lastTagPosition );
				return;

			}

			lastTagPosition = buf.position();

		} while ( ( id = FixUtils.getTagId( buf ) ) > 0 );

		buf.position(startTagPosition);

	}

	private int checkRequiredTags() {
		int tag = -1;

		return tag;

	}
	@Override
	public boolean isSet()
	{
		if (FixUtils.isSet(commission)) return true;
		if (FixUtils.isSet(commType)) return true;
		if (FixUtils.isSet(commCurrency)) return true;
		if (FixUtils.isSet(fundRenewWaiv)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(commission)) FixUtils.putFixTag( out, FixTags.COMMISSION_INT, commission);
		if (FixUtils.isSet(commType)) FixUtils.putFixTag( out, FixTags.COMMTYPE_INT, commType );
		if (FixUtils.isSet(commCurrency)) FixUtils.putFixTag( out, FixTags.COMMCURRENCY_INT, commCurrency, 0, Utils.lastIndexTrim(commCurrency, (byte)0) );
		if (FixUtils.isSet(fundRenewWaiv)) FixUtils.putFixTag( out, FixTags.FUNDRENEWWAIV_INT, fundRenewWaiv );
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

			if (FixUtils.isSet(commission)) s += "Commission(12)=" + String.valueOf(commission) + sep;
			if (FixUtils.isSet(commType)) s += "CommType(13)=" + String.valueOf(commType) + sep;
			if (FixUtils.isSet(commCurrency)) s += "CommCurrency(479)=" + new String(commCurrency) + sep;
			if (FixUtils.isSet(fundRenewWaiv)) s += "FundRenewWaiv(497)=" + String.valueOf(fundRenewWaiv) + sep;
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixCommissionData)) return false;

			FixCommissionData msg = (FixCommissionData) o;

		if (!( commission==msg.commission)) return false;

		if (!( commType==msg.commType)) return false;

		if (!Utils.equals( commCurrency, msg.commCurrency)) return false;

		if (!( fundRenewWaiv==msg.fundRenewWaiv)) return false;

		return true;
	}
}