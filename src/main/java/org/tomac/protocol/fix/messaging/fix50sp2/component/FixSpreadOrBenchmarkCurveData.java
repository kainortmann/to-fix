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

public class FixSpreadOrBenchmarkCurveData implements FixComponent
{

	public long spread = 0;
	public byte[] benchmarkCurveCurrency;
	public byte[] benchmarkCurveName;
	public byte[] benchmarkCurvePoint;
	public long benchmarkPrice = 0;
	public long benchmarkPriceType = 0;
	public byte[] benchmarkSecurityID;
	public byte[] benchmarkSecurityIDSource;

	public FixSpreadOrBenchmarkCurveData() {
		super();

		benchmarkCurveCurrency = new byte[FixUtils.CURRENCY_LENGTH];
		benchmarkCurveName = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		benchmarkCurvePoint = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		benchmarkSecurityID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		benchmarkSecurityIDSource = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		spread = Long.MAX_VALUE;		
		Utils.fill( benchmarkCurveCurrency, (byte)0 );
		Utils.fill( benchmarkCurveName, (byte)0 );
		Utils.fill( benchmarkCurvePoint, (byte)0 );
		benchmarkPrice = Long.MAX_VALUE;		
		benchmarkPriceType = Long.MAX_VALUE;		
		Utils.fill( benchmarkSecurityID, (byte)0 );
		Utils.fill( benchmarkSecurityIDSource, (byte)0 );
	}

	public void getAll(int id, ByteBuffer buf) throws FixSessionException
	{

		int startTagPosition = buf.position();

		int lastTagPosition = buf.position();
		do {
			ByteBuffer value;

			value = buf;

			switch( id ) {

			case FixTags.SPREAD_INT:
				spread = FixUtils.getTagFloatValue(value);
				break;

			case FixTags.BENCHMARKCURVECURRENCY_INT:
				benchmarkCurveCurrency = FixUtils.getTagStringValue(value, benchmarkCurveCurrency);
				break;

			case FixTags.BENCHMARKCURVENAME_INT:
				benchmarkCurveName = FixUtils.getTagStringValue(value, benchmarkCurveName);
				if (!BenchmarkCurveName.isValid(benchmarkCurveName) ) throw new FixSessionException(buf, "Invalid enumerated value(" + benchmarkCurveName + ") for tag: " + id );
				break;

			case FixTags.BENCHMARKCURVEPOINT_INT:
				benchmarkCurvePoint = FixUtils.getTagStringValue(value, benchmarkCurvePoint);
				break;

			case FixTags.BENCHMARKPRICE_INT:
				benchmarkPrice = FixUtils.getTagFloatValue(value);
				break;

			case FixTags.BENCHMARKPRICETYPE_INT:
				benchmarkPriceType = FixUtils.getTagIntValue( value );
				break;

			case FixTags.BENCHMARKSECURITYID_INT:
				benchmarkSecurityID = FixUtils.getTagStringValue(value, benchmarkSecurityID);
				break;

			case FixTags.BENCHMARKSECURITYIDSOURCE_INT:
				benchmarkSecurityIDSource = FixUtils.getTagStringValue(value, benchmarkSecurityIDSource);
				break;

			// we will always endup with unknown tag, unread and return to upper layer in hierarchy
			default:
				id = checkRequiredTags();
				if (id > 0) throw new FixSessionException(buf, "Required tag missing: " + id );

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
		if (FixUtils.isSet(spread)) return true;
		if (FixUtils.isSet(benchmarkCurveCurrency)) return true;
		if (FixUtils.isSet(benchmarkCurveName)) return true;
		if (FixUtils.isSet(benchmarkCurvePoint)) return true;
		if (FixUtils.isSet(benchmarkPrice)) return true;
		if (FixUtils.isSet(benchmarkPriceType)) return true;
		if (FixUtils.isSet(benchmarkSecurityID)) return true;
		if (FixUtils.isSet(benchmarkSecurityIDSource)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(spread)) FixUtils.putFixFloatTag( out, FixTags.SPREAD_INT, spread);
		if (FixUtils.isSet(benchmarkCurveCurrency)) FixUtils.putFixTag( out, FixTags.BENCHMARKCURVECURRENCY_INT, benchmarkCurveCurrency, 0, Utils.lastIndexTrim(benchmarkCurveCurrency, (byte)0) );
		if (FixUtils.isSet(benchmarkCurveName)) FixUtils.putFixTag( out, FixTags.BENCHMARKCURVENAME_INT, benchmarkCurveName, 0, Utils.lastIndexTrim(benchmarkCurveName, (byte)0) );
		if (FixUtils.isSet(benchmarkCurvePoint)) FixUtils.putFixTag( out, FixTags.BENCHMARKCURVEPOINT_INT, benchmarkCurvePoint, 0, Utils.lastIndexTrim(benchmarkCurvePoint, (byte)0) );
		if (FixUtils.isSet(benchmarkPrice)) FixUtils.putFixFloatTag( out, FixTags.BENCHMARKPRICE_INT, benchmarkPrice);
		if (FixUtils.isSet(benchmarkPriceType)) FixUtils.putFixTag( out, FixTags.BENCHMARKPRICETYPE_INT, benchmarkPriceType);
		if (FixUtils.isSet(benchmarkSecurityID)) FixUtils.putFixTag( out, FixTags.BENCHMARKSECURITYID_INT, benchmarkSecurityID, 0, Utils.lastIndexTrim(benchmarkSecurityID, (byte)0) );
		if (FixUtils.isSet(benchmarkSecurityIDSource)) FixUtils.putFixTag( out, FixTags.BENCHMARKSECURITYIDSOURCE_INT, benchmarkSecurityIDSource, 0, Utils.lastIndexTrim(benchmarkSecurityIDSource, (byte)0) );
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

			if (FixUtils.isSet(spread)) s += "Spread(218)=" + String.valueOf(spread) + sep;
			if (FixUtils.isSet(benchmarkCurveCurrency)) s += "BenchmarkCurveCurrency(220)=" + new String(benchmarkCurveCurrency) + sep;
			if (FixUtils.isSet(benchmarkCurveName)) s += "BenchmarkCurveName(221)=" + new String(benchmarkCurveName) + sep;
			if (FixUtils.isSet(benchmarkCurvePoint)) s += "BenchmarkCurvePoint(222)=" + new String(benchmarkCurvePoint) + sep;
			if (FixUtils.isSet(benchmarkPrice)) s += "BenchmarkPrice(662)=" + String.valueOf(benchmarkPrice) + sep;
			if (FixUtils.isSet(benchmarkPriceType)) s += "BenchmarkPriceType(663)=" + String.valueOf(benchmarkPriceType) + sep;
			if (FixUtils.isSet(benchmarkSecurityID)) s += "BenchmarkSecurityID(699)=" + new String(benchmarkSecurityID) + sep;
			if (FixUtils.isSet(benchmarkSecurityIDSource)) s += "BenchmarkSecurityIDSource(761)=" + new String(benchmarkSecurityIDSource) + sep;
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixSpreadOrBenchmarkCurveData)) return false;

			FixSpreadOrBenchmarkCurveData msg = (FixSpreadOrBenchmarkCurveData) o;

		if ( ! super.equals(msg) ) return false;

		if (!( spread==msg.spread)) return false;

		if (!Utils.equals( benchmarkCurveCurrency, msg.benchmarkCurveCurrency)) return false;

		if (!Utils.equals( benchmarkCurveName, msg.benchmarkCurveName)) return false;

		if (!Utils.equals( benchmarkCurvePoint, msg.benchmarkCurvePoint)) return false;

		if (!( benchmarkPrice==msg.benchmarkPrice)) return false;

		if (!( benchmarkPriceType==msg.benchmarkPriceType)) return false;

		if (!Utils.equals( benchmarkSecurityID, msg.benchmarkSecurityID)) return false;

		if (!Utils.equals( benchmarkSecurityIDSource, msg.benchmarkSecurityIDSource)) return false;

		return true;
	}
}
