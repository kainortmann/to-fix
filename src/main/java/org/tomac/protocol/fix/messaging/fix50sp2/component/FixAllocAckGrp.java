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
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixNestedParties;

public class FixAllocAckGrp
{

	public int noAllocs;
	public AllocAckGrp[] group;

	public void getAll(int noAllocs, ByteBuffer buf) throws FixSessionException {
		this.noAllocs = noAllocs;

		if (noAllocs < 1) throw new FixSessionException("asdasd");
		// this will leak memory if we grow the group
		if (group == null || group.length < noAllocs) {
			group = new AllocAckGrp[noAllocs];

			for ( int i = 0; i < noAllocs; i++ ) group[i] = new AllocAckGrp();
	}

		for ( int i = 0; i < noAllocs; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noAllocs; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noAllocs; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noAllocs; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noAllocs; i++)
			s += group[i].toString();
		return s;
	}

public class AllocAckGrp implements FixComponent
{

	public byte[] allocAccount;
	public long allocAcctIDSource = 0;
	public long allocPrice = 0;
	public byte allocPositionEffect = (byte)' ';
	public byte[] individualAllocID;
	public long individualAllocRejCode = 0;
	public FixNestedParties nestedParties;
	public byte[] allocText;
	public long encodedAllocTextLen = 0;
	public byte[] encodedAllocText;
	public byte[] secondaryIndividualAllocID;
	public byte[] allocCustomerCapacity;
	public long individualAllocType = 0;
	public long allocQty = 0;

	public AllocAckGrp() {
		super();

		allocAccount = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		individualAllocID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		nestedParties = new FixNestedParties();
		allocText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];
		encodedAllocText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];
		secondaryIndividualAllocID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		allocCustomerCapacity = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		Utils.fill( allocAccount, (byte)0 );
		allocAcctIDSource = Long.MAX_VALUE;		
		allocPrice = Long.MAX_VALUE;		
		allocPositionEffect = Byte.MAX_VALUE;		
		Utils.fill( individualAllocID, (byte)0 );
		individualAllocRejCode = Long.MAX_VALUE;		
		Utils.fill( allocText, (byte)0 );
		encodedAllocTextLen = Long.MAX_VALUE;		
		Utils.fill( encodedAllocText, (byte)0 );
		Utils.fill( secondaryIndividualAllocID, (byte)0 );
		Utils.fill( allocCustomerCapacity, (byte)0 );
		individualAllocType = Long.MAX_VALUE;		
		allocQty = Long.MAX_VALUE;		
		nestedParties.clear();
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.ALLOCACCOUNT_INT) {
				allocAccount = FixUtils.getTagStringValue(value, allocAccount);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.ALLOCACCTIDSOURCE_INT) {
				allocAcctIDSource = FixUtils.getTagIntValue( value );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.ALLOCPRICE_INT) {
				allocPrice = FixUtils.getTagFloatValue(value);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.ALLOCPOSITIONEFFECT_INT) {
				allocPositionEffect = FixUtils.getTagCharValue( value );
				if (!FixMessageInfo.AllocPositionEffect.isValid(allocPositionEffect) ) throw new FixSessionException(buf, "Invalid enumerated value(" + allocPositionEffect + ") for tag: " + id );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.INDIVIDUALALLOCID_INT) {
				individualAllocID = FixUtils.getTagStringValue(value, individualAllocID);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.INDIVIDUALALLOCREJCODE_INT) {
				individualAllocRejCode = FixUtils.getTagIntValue( value );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.NONESTEDPARTYIDS_INT) {
				nestedParties.getAll(FixTags.NONESTEDPARTYIDS_INT, buf);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.ALLOCTEXT_INT) {
				allocText = FixUtils.getTagStringValue(value, allocText);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.ENCODEDALLOCTEXTLEN_INT) {
				encodedAllocTextLen = FixUtils.getTagIntValue( value );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.ENCODEDALLOCTEXT_INT) {
				encodedAllocText = FixUtils.getTagStringValue(value, encodedAllocText);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.SECONDARYINDIVIDUALALLOCID_INT) {
				secondaryIndividualAllocID = FixUtils.getTagStringValue(value, secondaryIndividualAllocID);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.ALLOCCUSTOMERCAPACITY_INT) {
				allocCustomerCapacity = FixUtils.getTagStringValue(value, allocCustomerCapacity);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.INDIVIDUALALLOCTYPE_INT) {
				individualAllocType = FixUtils.getTagIntValue( value );
				if (!FixMessageInfo.IndividualAllocType.isValid(individualAllocType) ) throw new FixSessionException(buf, "Invalid enumerated value(" + individualAllocType + ") for tag: " + id );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.ALLOCQTY_INT) {
				allocQty = FixUtils.getTagFloatValue(value);
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
		if (FixUtils.isSet(allocAccount)) return true;
		if (FixUtils.isSet(allocAcctIDSource)) return true;
		if (FixUtils.isSet(allocPrice)) return true;
		if (FixUtils.isSet(allocPositionEffect)) return true;
		if (FixUtils.isSet(individualAllocID)) return true;
		if (FixUtils.isSet(individualAllocRejCode)) return true;
		if (FixUtils.isSet(nestedParties.noNestedPartyIDs)) return true;
		if (FixUtils.isSet(allocText)) return true;
		if (FixUtils.isSet(encodedAllocTextLen)) return true;
		if (FixUtils.isSet(encodedAllocText)) return true;
		if (FixUtils.isSet(secondaryIndividualAllocID)) return true;
		if (FixUtils.isSet(allocCustomerCapacity)) return true;
		if (FixUtils.isSet(individualAllocType)) return true;
		if (FixUtils.isSet(allocQty)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(allocAccount)) FixUtils.putFixTag( out, FixTags.ALLOCACCOUNT_INT, allocAccount, 0, Utils.lastIndexTrim(allocAccount, (byte)0) );
		if (FixUtils.isSet(allocAcctIDSource)) FixUtils.putFixTag( out, FixTags.ALLOCACCTIDSOURCE_INT, allocAcctIDSource);
		if (FixUtils.isSet(allocPrice)) FixUtils.putFixFloatTag( out, FixTags.ALLOCPRICE_INT, allocPrice);
		if (FixUtils.isSet(allocPositionEffect)) FixUtils.putFixTag( out, FixTags.ALLOCPOSITIONEFFECT_INT, allocPositionEffect );
		if (FixUtils.isSet(individualAllocID)) FixUtils.putFixTag( out, FixTags.INDIVIDUALALLOCID_INT, individualAllocID, 0, Utils.lastIndexTrim(individualAllocID, (byte)0) );
		if (FixUtils.isSet(individualAllocRejCode)) FixUtils.putFixTag( out, FixTags.INDIVIDUALALLOCREJCODE_INT, individualAllocRejCode);
		if (FixUtils.isSet(nestedParties.noNestedPartyIDs)) nestedParties.encode( out );
		if (FixUtils.isSet(allocText)) FixUtils.putFixTag( out, FixTags.ALLOCTEXT_INT, allocText, 0, Utils.lastIndexTrim(allocText, (byte)0) );
		if (FixUtils.isSet(encodedAllocTextLen)) FixUtils.putFixTag( out, FixTags.ENCODEDALLOCTEXTLEN_INT, encodedAllocTextLen);
		if (FixUtils.isSet(encodedAllocText)) FixUtils.putFixTag( out, FixTags.ENCODEDALLOCTEXT_INT, encodedAllocText, 0, Utils.lastIndexTrim(encodedAllocText, (byte)0) );
		if (FixUtils.isSet(secondaryIndividualAllocID)) FixUtils.putFixTag( out, FixTags.SECONDARYINDIVIDUALALLOCID_INT, secondaryIndividualAllocID, 0, Utils.lastIndexTrim(secondaryIndividualAllocID, (byte)0) );
		if (FixUtils.isSet(allocCustomerCapacity)) FixUtils.putFixTag( out, FixTags.ALLOCCUSTOMERCAPACITY_INT, allocCustomerCapacity, 0, Utils.lastIndexTrim(allocCustomerCapacity, (byte)0) );
		if (FixUtils.isSet(individualAllocType)) FixUtils.putFixTag( out, FixTags.INDIVIDUALALLOCTYPE_INT, individualAllocType);
		if (FixUtils.isSet(allocQty)) FixUtils.putFixFloatTag( out, FixTags.ALLOCQTY_INT, allocQty);
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

			if (FixUtils.isSet(allocAccount)) s += "AllocAccount(79)=" + new String(allocAccount) + sep;
			if (FixUtils.isSet(allocAcctIDSource)) s += "AllocAcctIDSource(661)=" + String.valueOf(allocAcctIDSource) + sep;
			if (FixUtils.isSet(allocPrice)) s += "AllocPrice(366)=" + String.valueOf(allocPrice) + sep;
			if (FixUtils.isSet(allocPositionEffect)) s += "AllocPositionEffect(1047)=" + String.valueOf(allocPositionEffect) + sep;
			if (FixUtils.isSet(individualAllocID)) s += "IndividualAllocID(467)=" + new String(individualAllocID) + sep;
			if (FixUtils.isSet(individualAllocRejCode)) s += "IndividualAllocRejCode(776)=" + String.valueOf(individualAllocRejCode) + sep;
			if (FixUtils.isSet(nestedParties.noNestedPartyIDs)) s += nestedParties.toString();
			if (FixUtils.isSet(allocText)) s += "AllocText(161)=" + new String(allocText) + sep;
			if (FixUtils.isSet(encodedAllocTextLen)) s += "EncodedAllocTextLen(360)=" + String.valueOf(encodedAllocTextLen) + sep;
			if (FixUtils.isSet(encodedAllocText)) s += "EncodedAllocText(361)=" + new String(encodedAllocText) + sep;
			if (FixUtils.isSet(secondaryIndividualAllocID)) s += "SecondaryIndividualAllocID(989)=" + new String(secondaryIndividualAllocID) + sep;
			if (FixUtils.isSet(allocCustomerCapacity)) s += "AllocCustomerCapacity(993)=" + new String(allocCustomerCapacity) + sep;
			if (FixUtils.isSet(individualAllocType)) s += "IndividualAllocType(992)=" + String.valueOf(individualAllocType) + sep;
			if (FixUtils.isSet(allocQty)) s += "AllocQty(80)=" + String.valueOf(allocQty) + sep;
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof AllocAckGrp)) return false;

			AllocAckGrp msg = (AllocAckGrp) o;

		if ( ! super.equals(msg) ) return false;

		if (!Utils.equals( allocAccount, msg.allocAccount)) return false;

		if (!( allocAcctIDSource==msg.allocAcctIDSource)) return false;

		if (!( allocPrice==msg.allocPrice)) return false;

		if (!( allocPositionEffect==msg.allocPositionEffect)) return false;

		if (!Utils.equals( individualAllocID, msg.individualAllocID)) return false;

		if (!( individualAllocRejCode==msg.individualAllocRejCode)) return false;

		if (!nestedParties.equals(msg.nestedParties)) return false;

		if (!Utils.equals( allocText, msg.allocText)) return false;

		if (!( encodedAllocTextLen==msg.encodedAllocTextLen)) return false;

		if (!Utils.equals( encodedAllocText, msg.encodedAllocText)) return false;

		if (!Utils.equals( secondaryIndividualAllocID, msg.secondaryIndividualAllocID)) return false;

		if (!Utils.equals( allocCustomerCapacity, msg.allocCustomerCapacity)) return false;

		if (!( individualAllocType==msg.individualAllocType)) return false;

		if (!( allocQty==msg.allocQty)) return false;

		return true;
	}
}
}
