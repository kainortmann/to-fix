package org.tomac.protocol.fix.messaging;

import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import java.nio.ByteBuffer;
import org.tomac.protocol.fix.messaging.FixTags;
import org.tomac.protocol.fix.FixInMessage;
import org.tomac.protocol.fix.FixUtils;
		
public class FixCollateralResponse extends FixInMessage {
	private short hasCollRespID;
	byte[] collRespID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasCollAsgnID;
	byte[] collAsgnID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasCollReqID;
	byte[] collReqID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasCollAsgnReason;
	long collAsgnReason = 0;		
	private short hasCollAsgnTransType;
	long collAsgnTransType = 0;		
	private short hasCollAsgnRespType;
	long collAsgnRespType = 0;		
	private short hasCollAsgnRejectReason;
	long collAsgnRejectReason = 0;		
	private short hasTransactTime;
	byte[] transactTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
	private short hasCollApplType;
	long collApplType = 0;		
	private short hasFinancialStatus;
	byte[] financialStatus = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasClearingBusinessDate;
	byte[] clearingBusinessDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasAccount;
	byte[] account = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasAccountType;
	long accountType = 0;		
	private short hasClOrdID;
	byte[] clOrdID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasOrderID;
	byte[] orderID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSecondaryOrderID;
	byte[] secondaryOrderID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSecondaryClOrdID;
	byte[] secondaryClOrdID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSettlDate;
	byte[] settlDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasQuantity;
	long quantity = 0;		
	private short hasQtyType;
	long qtyType = 0;		
	private short hasCurrency;
	byte[] currency = new byte[FixUtils.CURRENCY_LENGTH];		
	private short hasMarginExcess;
	long marginExcess = 0;		
	private short hasTotalNetValue;
	long totalNetValue = 0;		
	private short hasCashOutstanding;
	long cashOutstanding = 0;		
	private short hasSide;
	byte side = (byte)' ';		
	private short hasPrice;
	long price = 0;		
	private short hasPriceType;
	long priceType = 0;		
	private short hasAccruedInterestAmt;
	long accruedInterestAmt = 0;		
	private short hasEndAccruedInterestAmt;
	long endAccruedInterestAmt = 0;		
	private short hasStartCash;
	long startCash = 0;		
	private short hasEndCash;
	long endCash = 0;		
	private short hasText;
	byte[] text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
	private short hasEncodedTextLen;
	long encodedTextLen = 0;		
	private short hasEncodedText;
	byte[] encodedText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
	FixParties[] parties;
	FixExecCollGrp[] execCollGrp;
	FixTrdCollGrp[] trdCollGrp;
	FixInstrument instrument;
	FixFinancingDetails financingDetails;
	FixInstrmtLegGrp[] instrmtLegGrp;
	FixUndInstrmtCollGrp[] undInstrmtCollGrp;
	FixTrdRegTimestamps[] trdRegTimestamps;
	FixMiscFeesGrp[] miscFeesGrp;
	FixSpreadOrBenchmarkCurveData spreadOrBenchmarkCurveData;
	FixStipulations[] stipulations;
	
	public FixCollateralResponse() {
		super(FixMessageInfo.MessageTypes.COLLATERALRESPONSE);


		hasCollRespID = FixUtils.TAG_HAS_NO_VALUE;		
		collRespID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasCollAsgnID = FixUtils.TAG_HAS_NO_VALUE;		
		collAsgnID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasCollReqID = FixUtils.TAG_HAS_NO_VALUE;		
		collReqID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasCollAsgnReason = FixUtils.TAG_HAS_NO_VALUE;		
		hasCollAsgnTransType = FixUtils.TAG_HAS_NO_VALUE;		
		hasCollAsgnRespType = FixUtils.TAG_HAS_NO_VALUE;		
		hasCollAsgnRejectReason = FixUtils.TAG_HAS_NO_VALUE;		
		hasTransactTime = FixUtils.TAG_HAS_NO_VALUE;		
		transactTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		hasCollApplType = FixUtils.TAG_HAS_NO_VALUE;		
		hasFinancialStatus = FixUtils.TAG_HAS_NO_VALUE;		
		financialStatus = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasClearingBusinessDate = FixUtils.TAG_HAS_NO_VALUE;		
		clearingBusinessDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasAccount = FixUtils.TAG_HAS_NO_VALUE;		
		account = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasAccountType = FixUtils.TAG_HAS_NO_VALUE;		
		hasClOrdID = FixUtils.TAG_HAS_NO_VALUE;		
		clOrdID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasOrderID = FixUtils.TAG_HAS_NO_VALUE;		
		orderID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSecondaryOrderID = FixUtils.TAG_HAS_NO_VALUE;		
		secondaryOrderID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSecondaryClOrdID = FixUtils.TAG_HAS_NO_VALUE;		
		secondaryClOrdID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSettlDate = FixUtils.TAG_HAS_NO_VALUE;		
		settlDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasQuantity = FixUtils.TAG_HAS_NO_VALUE;		
		hasQtyType = FixUtils.TAG_HAS_NO_VALUE;		
		hasCurrency = FixUtils.TAG_HAS_NO_VALUE;		
		currency = new byte[FixUtils.CURRENCY_LENGTH];		
		hasMarginExcess = FixUtils.TAG_HAS_NO_VALUE;		
		hasTotalNetValue = FixUtils.TAG_HAS_NO_VALUE;		
		hasCashOutstanding = FixUtils.TAG_HAS_NO_VALUE;		
		hasSide = FixUtils.TAG_HAS_NO_VALUE;		
		hasPrice = FixUtils.TAG_HAS_NO_VALUE;		
		hasPriceType = FixUtils.TAG_HAS_NO_VALUE;		
		hasAccruedInterestAmt = FixUtils.TAG_HAS_NO_VALUE;		
		hasEndAccruedInterestAmt = FixUtils.TAG_HAS_NO_VALUE;		
		hasStartCash = FixUtils.TAG_HAS_NO_VALUE;		
		hasEndCash = FixUtils.TAG_HAS_NO_VALUE;		
		hasText = FixUtils.TAG_HAS_NO_VALUE;		
		text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		hasEncodedTextLen = FixUtils.TAG_HAS_NO_VALUE;		
		hasEncodedText = FixUtils.TAG_HAS_NO_VALUE;		
		encodedText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		parties = new FixParties[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) parties[i] = new FixParties();
		execCollGrp = new FixExecCollGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) execCollGrp[i] = new FixExecCollGrp();
		trdCollGrp = new FixTrdCollGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) trdCollGrp[i] = new FixTrdCollGrp();
		instrument = new FixInstrument();
		financingDetails = new FixFinancingDetails();
		instrmtLegGrp = new FixInstrmtLegGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) instrmtLegGrp[i] = new FixInstrmtLegGrp();
		undInstrmtCollGrp = new FixUndInstrmtCollGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) undInstrmtCollGrp[i] = new FixUndInstrmtCollGrp();
		trdRegTimestamps = new FixTrdRegTimestamps[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) trdRegTimestamps[i] = new FixTrdRegTimestamps();
		miscFeesGrp = new FixMiscFeesGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) miscFeesGrp[i] = new FixMiscFeesGrp();
		spreadOrBenchmarkCurveData = new FixSpreadOrBenchmarkCurveData();
		stipulations = new FixStipulations[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) stipulations[i] = new FixStipulations();

	}

    public void setBuffer( ByteBuffer buf, FixValidationError err)		
    {		
				
		super.setBuffer(buf, err);
        if (err.hasError()) return;

        int tag = FixMessage.getTag(buf, err);
        if (err.hasError()) return;

        while ( buf.hasRemaining() ) {

            switch (tag) {		
            	case FixTags.COLLRESPID_INT:		
            		hasCollRespID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.COLLASGNID_INT:		
            		hasCollAsgnID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.COLLREQID_INT:		
            		hasCollReqID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.COLLASGNREASON_INT:		
            		hasCollAsgnReason = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.COLLASGNTRANSTYPE_INT:		
            		hasCollAsgnTransType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.COLLASGNRESPTYPE_INT:		
            		hasCollAsgnRespType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.COLLASGNREJECTREASON_INT:		
            		hasCollAsgnRejectReason = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.TRANSACTTIME_INT:		
            		hasTransactTime = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.COLLAPPLTYPE_INT:		
            		hasCollApplType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.FINANCIALSTATUS_INT:		
            		hasFinancialStatus = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.CLEARINGBUSINESSDATE_INT:		
            		hasClearingBusinessDate = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ACCOUNT_INT:		
            		hasAccount = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ACCOUNTTYPE_INT:		
            		hasAccountType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.CLORDID_INT:		
            		hasClOrdID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ORDERID_INT:		
            		hasOrderID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.SECONDARYORDERID_INT:		
            		hasSecondaryOrderID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.SECONDARYCLORDID_INT:		
            		hasSecondaryClOrdID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.SETTLDATE_INT:		
            		hasSettlDate = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.QUANTITY_INT:		
            		hasQuantity = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.QTYTYPE_INT:		
            		hasQtyType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.CURRENCY_INT:		
            		hasCurrency = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.MARGINEXCESS_INT:		
            		hasMarginExcess = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.TOTALNETVALUE_INT:		
            		hasTotalNetValue = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.CASHOUTSTANDING_INT:		
            		hasCashOutstanding = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.SIDE_INT:		
            		hasSide = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.PRICE_INT:		
            		hasPrice = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.PRICETYPE_INT:		
            		hasPriceType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ACCRUEDINTERESTAMT_INT:		
            		hasAccruedInterestAmt = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ENDACCRUEDINTERESTAMT_INT:		
            		hasEndAccruedInterestAmt = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.STARTCASH_INT:		
            		hasStartCash = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ENDCASH_INT:		
            		hasEndCash = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.TEXT_INT:		
            		hasText = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ENCODEDTEXTLEN_INT:		
            		hasEncodedTextLen = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ENCODEDTEXT_INT:		
            		hasEncodedText = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	default:
        			if ( standardHeader.isKeyTag(tag)) {
        				tag = standardHeader.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
        			} else if ( standardTrailer.isKeyTag(tag)) {
        				tag = standardTrailer.setBuffer( tag, buf, err);
        				FixMessage.unreadLastTag(tag, buf);
        				if (!err.hasError()) hasRequiredTags(err);
            			return; // always last, we are done now
        			} else if ( tag == FixTags.NOPARTYIDS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag); break; }
        				while ( count < noInGroupNumber ) {
        					if ( !parties[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "no in group tag missing", tag);
        						break;
        					}
        					count++;
        					repeatingGroupTag = parties[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( tag == FixTags.NOEXECS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag); break; }
        				while ( count < noInGroupNumber ) {
        					if ( !execCollGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "no in group tag missing", tag);
        						break;
        					}
        					count++;
        					repeatingGroupTag = execCollGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( tag == FixTags.NOTRADES_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag); break; }
        				while ( count < noInGroupNumber ) {
        					if ( !trdCollGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "no in group tag missing", tag);
        						break;
        					}
        					count++;
        					repeatingGroupTag = trdCollGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( instrument.isKeyTag(tag)) {
        				tag = instrument.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
        			} else if ( financingDetails.isKeyTag(tag)) {
        				tag = financingDetails.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
        			} else if ( tag == FixTags.NOLEGS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag); break; }
        				while ( count < noInGroupNumber ) {
        					if ( !instrmtLegGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "no in group tag missing", tag);
        						break;
        					}
        					count++;
        					repeatingGroupTag = instrmtLegGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( tag == FixTags.NOUNDERLYINGS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag); break; }
        				while ( count < noInGroupNumber ) {
        					if ( !undInstrmtCollGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "no in group tag missing", tag);
        						break;
        					}
        					count++;
        					repeatingGroupTag = undInstrmtCollGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( tag == FixTags.NOTRDREGTIMESTAMPS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag); break; }
        				while ( count < noInGroupNumber ) {
        					if ( !trdRegTimestamps[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "no in group tag missing", tag);
        						break;
        					}
        					count++;
        					repeatingGroupTag = trdRegTimestamps[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( tag == FixTags.NOMISCFEES_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag); break; }
        				while ( count < noInGroupNumber ) {
        					if ( !miscFeesGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "no in group tag missing", tag);
        						break;
        					}
        					count++;
        					repeatingGroupTag = miscFeesGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( spreadOrBenchmarkCurveData.isKeyTag(tag)) {
        				tag = spreadOrBenchmarkCurveData.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
        			} else if ( tag == FixTags.NOSTIPULATIONS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag); break; }
        				while ( count < noInGroupNumber ) {
        					if ( !stipulations[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "no in group tag missing", tag);
        						break;
        					}
        					count++;
        					repeatingGroupTag = stipulations[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
            		} else {
 						FixMessage.getNext(buf, err);		
                		if (err.hasError()) break; 		
                		else break; //Ugha
					}

			}

            	tag = FixMessage.getTag(buf, err);		
        		if (err.hasError()) break;

		}

	}		

	private boolean hasRequiredTags(FixValidationError err) {
		if (!hasCollRespID()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag CollRespID missing", FixTags.COLLRESPID_INT, FixMessageInfo.MessageTypes.COLLATERALRESPONSE);
			return false;
		}
		if (!hasCollAsgnRespType()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag CollAsgnRespType missing", FixTags.COLLASGNRESPTYPE_INT, FixMessageInfo.MessageTypes.COLLATERALRESPONSE);
			return false;
		}
		if (!hasTransactTime()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag TransactTime missing", FixTags.TRANSACTTIME_INT, FixMessageInfo.MessageTypes.COLLATERALRESPONSE);
			return false;
		}
		return true;
	}
	@Override		
	public void getAll() {		
		/* not needed, just for the inet dudes recognition */		
	}		
		
	@Override		
	public int encode(ByteBuffer out) {

		int startPos = out.position();
		super.standardHeader.setBodyLength(1000);

		super.standardHeader.encode(out);		
		if (hasCollRespID()) {		
			out.put(FixTags.COLLRESPID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,collRespID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasCollAsgnID()) {		
			out.put(FixTags.COLLASGNID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,collAsgnID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasCollReqID()) {		
			out.put(FixTags.COLLREQID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,collReqID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasCollAsgnReason()) {		
			out.put(FixTags.COLLASGNREASON);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)collAsgnReason);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasCollAsgnTransType()) {		
			out.put(FixTags.COLLASGNTRANSTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)collAsgnTransType);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasCollAsgnRespType()) {		
			out.put(FixTags.COLLASGNRESPTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)collAsgnRespType);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasCollAsgnRejectReason()) {		
			out.put(FixTags.COLLASGNREJECTREASON);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)collAsgnRejectReason);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTransactTime()) {		
			out.put(FixTags.TRANSACTTIME);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,transactTime); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasCollApplType()) {		
			out.put(FixTags.COLLAPPLTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)collApplType);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasFinancialStatus()) {		
			out.put(FixTags.FINANCIALSTATUS);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,financialStatus); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasClearingBusinessDate()) {		
			out.put(FixTags.CLEARINGBUSINESSDATE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,clearingBusinessDate); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasAccount()) {		
			out.put(FixTags.ACCOUNT);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,account); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasAccountType()) {		
			out.put(FixTags.ACCOUNTTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)accountType);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasClOrdID()) {		
			out.put(FixTags.CLORDID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,clOrdID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasOrderID()) {		
			out.put(FixTags.ORDERID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,orderID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSecondaryOrderID()) {		
			out.put(FixTags.SECONDARYORDERID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,secondaryOrderID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSecondaryClOrdID()) {		
			out.put(FixTags.SECONDARYCLORDID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,secondaryClOrdID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSettlDate()) {		
			out.put(FixTags.SETTLDATE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,settlDate); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasQuantity()) {		
			out.put(FixTags.QUANTITY);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)quantity);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasQtyType()) {		
			out.put(FixTags.QTYTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)qtyType);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasCurrency()) {		
			out.put(FixTags.CURRENCY);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,currency); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasMarginExcess()) {		
			out.put(FixTags.MARGINEXCESS);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)marginExcess);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTotalNetValue()) {		
			out.put(FixTags.TOTALNETVALUE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)totalNetValue);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasCashOutstanding()) {		
			out.put(FixTags.CASHOUTSTANDING);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)cashOutstanding);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSide()) {		
			out.put(FixTags.SIDE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,side); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasPrice()) {		
			out.put(FixTags.PRICE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)price);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasPriceType()) {		
			out.put(FixTags.PRICETYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)priceType);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasAccruedInterestAmt()) {		
			out.put(FixTags.ACCRUEDINTERESTAMT);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)accruedInterestAmt);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasEndAccruedInterestAmt()) {		
			out.put(FixTags.ENDACCRUEDINTERESTAMT);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)endAccruedInterestAmt);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasStartCash()) {		
			out.put(FixTags.STARTCASH);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)startCash);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasEndCash()) {		
			out.put(FixTags.ENDCASH);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)endCash);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasText()) {		
			out.put(FixTags.TEXT);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,text); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasEncodedTextLen()) {		
			out.put(FixTags.ENCODEDTEXTLEN);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)encodedTextLen);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasEncodedText()) {		
			out.put(FixTags.ENCODEDTEXT);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,encodedText); 		
		
			out.put(FixUtils.SOH);		
		}		
		
		// set body length

		int endPos = out.position();

		super.standardHeader.setBodyLength(endPos - FixUtils.FIX_MESSAGE_START);

		out.position(startPos + FixUtils.FIX_HEADER);

		if (super.standardHeader.getBodyLength()>999) {
			FixUtils.put(out, super.standardHeader.getBodyLength());
		} else if (super.standardHeader.getBodyLength()>99) {
			FixUtils.put(out, 0);
			FixUtils.put(out, super.standardHeader.getBodyLength());
		} else {
			FixUtils.put(out, 0);
			FixUtils.put(out, 0);
			FixUtils.put(out, super.standardHeader.getBodyLength());
		}
		final byte[] tmpCheckSum = new byte[FixTags.CHECKSUM_LENGTH];
		FixUtils.generateCheckSum(tmpCheckSum, out, startPos, endPos);
		super.standardTrailer.setCheckSum(tmpCheckSum);

		out.position(endPos);

		super.standardTrailer.encode(out);
		out.limit(out.position());
		out.flip();

		return (int) super.standardHeader.getBodyLength();

	}			
			
			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		int startPos = out.position();		
					
		super.standardHeader.encode(out);		
		
		if (hasCollRespID()) {		
			FixUtils.put(out,collRespID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCollAsgnID()) {		
			FixUtils.put(out,collAsgnID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCollReqID()) {		
			FixUtils.put(out,collReqID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCollAsgnReason()) {		
			FixUtils.put(out, (long)collAsgnReason);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCollAsgnTransType()) {		
			FixUtils.put(out, (long)collAsgnTransType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCollAsgnRespType()) {		
			FixUtils.put(out, (long)collAsgnRespType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCollAsgnRejectReason()) {		
			FixUtils.put(out, (long)collAsgnRejectReason);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTransactTime()) {		
			FixUtils.put(out,transactTime); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCollApplType()) {		
			FixUtils.put(out, (long)collApplType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasFinancialStatus()) {		
			FixUtils.put(out,financialStatus); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasClearingBusinessDate()) {		
			FixUtils.put(out,clearingBusinessDate); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAccount()) {		
			FixUtils.put(out,account); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAccountType()) {		
			FixUtils.put(out, (long)accountType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasClOrdID()) {		
			FixUtils.put(out,clOrdID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOrderID()) {		
			FixUtils.put(out,orderID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSecondaryOrderID()) {		
			FixUtils.put(out,secondaryOrderID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSecondaryClOrdID()) {		
			FixUtils.put(out,secondaryClOrdID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSettlDate()) {		
			FixUtils.put(out,settlDate); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasQuantity()) {		
			FixUtils.put(out, (long)quantity);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasQtyType()) {		
			FixUtils.put(out, (long)qtyType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCurrency()) {		
			FixUtils.put(out,currency); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMarginExcess()) {		
			FixUtils.put(out, (long)marginExcess);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTotalNetValue()) {		
			FixUtils.put(out, (long)totalNetValue);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCashOutstanding()) {		
			FixUtils.put(out, (long)cashOutstanding);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSide()) {		
			FixUtils.put(out,side); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasPrice()) {		
			FixUtils.put(out, (long)price);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasPriceType()) {		
			FixUtils.put(out, (long)priceType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAccruedInterestAmt()) {		
			FixUtils.put(out, (long)accruedInterestAmt);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasEndAccruedInterestAmt()) {		
			FixUtils.put(out, (long)endAccruedInterestAmt);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasStartCash()) {		
			FixUtils.put(out, (long)startCash);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasEndCash()) {		
			FixUtils.put(out, (long)endCash);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasText()) {		
			FixUtils.put(out,text); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasEncodedTextLen()) {		
			FixUtils.put(out, (long)encodedTextLen);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasEncodedText()) {		
			FixUtils.put(out,encodedText); 		
		
	        out.put( (byte)' ' );		
		}		
		
		super.standardTrailer.encode(out);		
		
		int endPos = out.position();		
		
		// set body length		
				
		super.standardHeader.setBodyLength( out.position() - startPos );		
				
		out.position(startPos + FixUtils.FIX_HEADER); 		
		
		FixUtils.put( out, super.standardHeader.getBodyLength() );		
		
		out.position(endPos);		
		
	}			
			
	public void crackCollRespID() {		
		getCollRespID();		
	}		
			
	public byte[] getCollRespID() { 		
		if ( hasCollRespID()) {		
			if (hasCollRespID == FixUtils.TAG_HAS_VALUE) {		
				return collRespID; 		
			} else {

				buf.position(hasCollRespID);

			FixMessage.getTagStringValue(buf, collRespID, 0, collRespID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasCollRespID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return collRespID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasCollRespID() { return hasCollRespID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setCollRespID(byte[] src) {		
		if (src == null ) return;
		if (hasCollRespID()) FixUtils.fillSpace(collRespID);		
		FixUtils.copy(collRespID, src); 		
		hasCollRespID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCollRespID(String str) {		
		if (str == null ) return;
		if (hasCollRespID()) FixUtils.fillSpace(collRespID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(collRespID, src); 		
		hasCollRespID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackCollAsgnID() {		
		getCollAsgnID();		
	}		
			
	public byte[] getCollAsgnID() { 		
		if ( hasCollAsgnID()) {		
			if (hasCollAsgnID == FixUtils.TAG_HAS_VALUE) {		
				return collAsgnID; 		
			} else {

				buf.position(hasCollAsgnID);

			FixMessage.getTagStringValue(buf, collAsgnID, 0, collAsgnID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasCollAsgnID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return collAsgnID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasCollAsgnID() { return hasCollAsgnID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setCollAsgnID(byte[] src) {		
		if (src == null ) return;
		if (hasCollAsgnID()) FixUtils.fillSpace(collAsgnID);		
		FixUtils.copy(collAsgnID, src); 		
		hasCollAsgnID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCollAsgnID(String str) {		
		if (str == null ) return;
		if (hasCollAsgnID()) FixUtils.fillSpace(collAsgnID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(collAsgnID, src); 		
		hasCollAsgnID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackCollReqID() {		
		getCollReqID();		
	}		
			
	public byte[] getCollReqID() { 		
		if ( hasCollReqID()) {		
			if (hasCollReqID == FixUtils.TAG_HAS_VALUE) {		
				return collReqID; 		
			} else {

				buf.position(hasCollReqID);

			FixMessage.getTagStringValue(buf, collReqID, 0, collReqID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasCollReqID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return collReqID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasCollReqID() { return hasCollReqID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setCollReqID(byte[] src) {		
		if (src == null ) return;
		if (hasCollReqID()) FixUtils.fillSpace(collReqID);		
		FixUtils.copy(collReqID, src); 		
		hasCollReqID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCollReqID(String str) {		
		if (str == null ) return;
		if (hasCollReqID()) FixUtils.fillSpace(collReqID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(collReqID, src); 		
		hasCollReqID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackCollAsgnReason() {		
		getCollAsgnReason();		
	}		
			
	public long getCollAsgnReason() { 		
		if ( hasCollAsgnReason()) {		
			if (hasCollAsgnReason == FixUtils.TAG_HAS_VALUE) {		
				return collAsgnReason; 		
			} else {

				buf.position(hasCollAsgnReason);

			collAsgnReason = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasCollAsgnReason = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return collAsgnReason;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasCollAsgnReason() { return hasCollAsgnReason != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setCollAsgnReason(byte[] src) {		
		if (src == null ) return;
		if (hasCollAsgnReason()) collAsgnReason = FixUtils.TAG_HAS_NO_VALUE;		
		collAsgnReason = FixUtils.longValueOf(src, 0, src.length);
		hasCollAsgnReason = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCollAsgnReason(long src) {		
		collAsgnReason = src;
		hasCollAsgnReason = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCollAsgnReason(String str) {		
		if (str == null ) return;
		if (hasCollAsgnReason()) collAsgnReason = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		collAsgnReason = FixUtils.longValueOf(src, 0, src.length);
		hasCollAsgnReason = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackCollAsgnTransType() {		
		getCollAsgnTransType();		
	}		
			
	public long getCollAsgnTransType() { 		
		if ( hasCollAsgnTransType()) {		
			if (hasCollAsgnTransType == FixUtils.TAG_HAS_VALUE) {		
				return collAsgnTransType; 		
			} else {

				buf.position(hasCollAsgnTransType);

			collAsgnTransType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasCollAsgnTransType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return collAsgnTransType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasCollAsgnTransType() { return hasCollAsgnTransType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setCollAsgnTransType(byte[] src) {		
		if (src == null ) return;
		if (hasCollAsgnTransType()) collAsgnTransType = FixUtils.TAG_HAS_NO_VALUE;		
		collAsgnTransType = FixUtils.longValueOf(src, 0, src.length);
		hasCollAsgnTransType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCollAsgnTransType(long src) {		
		collAsgnTransType = src;
		hasCollAsgnTransType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCollAsgnTransType(String str) {		
		if (str == null ) return;
		if (hasCollAsgnTransType()) collAsgnTransType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		collAsgnTransType = FixUtils.longValueOf(src, 0, src.length);
		hasCollAsgnTransType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackCollAsgnRespType() {		
		getCollAsgnRespType();		
	}		
			
	public long getCollAsgnRespType() { 		
		if ( hasCollAsgnRespType()) {		
			if (hasCollAsgnRespType == FixUtils.TAG_HAS_VALUE) {		
				return collAsgnRespType; 		
			} else {

				buf.position(hasCollAsgnRespType);

			collAsgnRespType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasCollAsgnRespType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return collAsgnRespType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasCollAsgnRespType() { return hasCollAsgnRespType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setCollAsgnRespType(byte[] src) {		
		if (src == null ) return;
		if (hasCollAsgnRespType()) collAsgnRespType = FixUtils.TAG_HAS_NO_VALUE;		
		collAsgnRespType = FixUtils.longValueOf(src, 0, src.length);
		hasCollAsgnRespType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCollAsgnRespType(long src) {		
		collAsgnRespType = src;
		hasCollAsgnRespType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCollAsgnRespType(String str) {		
		if (str == null ) return;
		if (hasCollAsgnRespType()) collAsgnRespType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		collAsgnRespType = FixUtils.longValueOf(src, 0, src.length);
		hasCollAsgnRespType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackCollAsgnRejectReason() {		
		getCollAsgnRejectReason();		
	}		
			
	public long getCollAsgnRejectReason() { 		
		if ( hasCollAsgnRejectReason()) {		
			if (hasCollAsgnRejectReason == FixUtils.TAG_HAS_VALUE) {		
				return collAsgnRejectReason; 		
			} else {

				buf.position(hasCollAsgnRejectReason);

			collAsgnRejectReason = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasCollAsgnRejectReason = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return collAsgnRejectReason;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasCollAsgnRejectReason() { return hasCollAsgnRejectReason != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setCollAsgnRejectReason(byte[] src) {		
		if (src == null ) return;
		if (hasCollAsgnRejectReason()) collAsgnRejectReason = FixUtils.TAG_HAS_NO_VALUE;		
		collAsgnRejectReason = FixUtils.longValueOf(src, 0, src.length);
		hasCollAsgnRejectReason = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCollAsgnRejectReason(long src) {		
		collAsgnRejectReason = src;
		hasCollAsgnRejectReason = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCollAsgnRejectReason(String str) {		
		if (str == null ) return;
		if (hasCollAsgnRejectReason()) collAsgnRejectReason = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		collAsgnRejectReason = FixUtils.longValueOf(src, 0, src.length);
		hasCollAsgnRejectReason = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackTransactTime() {		
		getTransactTime();		
	}		
			
	public byte[] getTransactTime() { 		
		if ( hasTransactTime()) {		
			if (hasTransactTime == FixUtils.TAG_HAS_VALUE) {		
				return transactTime; 		
			} else {

				buf.position(hasTransactTime);

			FixMessage.getTagStringValue(buf, transactTime, 0, transactTime.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasTransactTime = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return transactTime;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasTransactTime() { return hasTransactTime != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setTransactTime(byte[] src) {		
		if (src == null ) return;
		if (hasTransactTime()) FixUtils.fillSpace(transactTime);		
		FixUtils.copy(transactTime, src); 		
		hasTransactTime = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTransactTime(String str) {		
		if (str == null ) return;
		if (hasTransactTime()) FixUtils.fillSpace(transactTime);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(transactTime, src); 		
		hasTransactTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackCollApplType() {		
		getCollApplType();		
	}		
			
	public long getCollApplType() { 		
		if ( hasCollApplType()) {		
			if (hasCollApplType == FixUtils.TAG_HAS_VALUE) {		
				return collApplType; 		
			} else {

				buf.position(hasCollApplType);

			collApplType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasCollApplType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return collApplType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasCollApplType() { return hasCollApplType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setCollApplType(byte[] src) {		
		if (src == null ) return;
		if (hasCollApplType()) collApplType = FixUtils.TAG_HAS_NO_VALUE;		
		collApplType = FixUtils.longValueOf(src, 0, src.length);
		hasCollApplType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCollApplType(long src) {		
		collApplType = src;
		hasCollApplType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCollApplType(String str) {		
		if (str == null ) return;
		if (hasCollApplType()) collApplType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		collApplType = FixUtils.longValueOf(src, 0, src.length);
		hasCollApplType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackFinancialStatus() {		
		getFinancialStatus();		
	}		
			
	public byte[] getFinancialStatus() { 		
		if ( hasFinancialStatus()) {		
			if (hasFinancialStatus == FixUtils.TAG_HAS_VALUE) {		
				return financialStatus; 		
			} else {

				buf.position(hasFinancialStatus);

			FixMessage.getTagStringValue(buf, financialStatus, 0, financialStatus.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasFinancialStatus = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return financialStatus;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasFinancialStatus() { return hasFinancialStatus != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setFinancialStatus(byte[] src) {		
		if (src == null ) return;
		if (hasFinancialStatus()) FixUtils.fillSpace(financialStatus);		
		FixUtils.copy(financialStatus, src); 		
		hasFinancialStatus = FixUtils.TAG_HAS_VALUE;		
	}

	public void setFinancialStatus(String str) {		
		if (str == null ) return;
		if (hasFinancialStatus()) FixUtils.fillSpace(financialStatus);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(financialStatus, src); 		
		hasFinancialStatus = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackClearingBusinessDate() {		
		getClearingBusinessDate();		
	}		
			
	public byte[] getClearingBusinessDate() { 		
		if ( hasClearingBusinessDate()) {		
			if (hasClearingBusinessDate == FixUtils.TAG_HAS_VALUE) {		
				return clearingBusinessDate; 		
			} else {

				buf.position(hasClearingBusinessDate);

			FixMessage.getTagStringValue(buf, clearingBusinessDate, 0, clearingBusinessDate.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasClearingBusinessDate = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return clearingBusinessDate;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasClearingBusinessDate() { return hasClearingBusinessDate != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setClearingBusinessDate(byte[] src) {		
		if (src == null ) return;
		if (hasClearingBusinessDate()) FixUtils.fillSpace(clearingBusinessDate);		
		FixUtils.copy(clearingBusinessDate, src); 		
		hasClearingBusinessDate = FixUtils.TAG_HAS_VALUE;		
	}

	public void setClearingBusinessDate(String str) {		
		if (str == null ) return;
		if (hasClearingBusinessDate()) FixUtils.fillSpace(clearingBusinessDate);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(clearingBusinessDate, src); 		
		hasClearingBusinessDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackAccount() {		
		getAccount();		
	}		
			
	public byte[] getAccount() { 		
		if ( hasAccount()) {		
			if (hasAccount == FixUtils.TAG_HAS_VALUE) {		
				return account; 		
			} else {

				buf.position(hasAccount);

			FixMessage.getTagStringValue(buf, account, 0, account.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasAccount = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return account;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasAccount() { return hasAccount != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setAccount(byte[] src) {		
		if (src == null ) return;
		if (hasAccount()) FixUtils.fillSpace(account);		
		FixUtils.copy(account, src); 		
		hasAccount = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAccount(String str) {		
		if (str == null ) return;
		if (hasAccount()) FixUtils.fillSpace(account);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(account, src); 		
		hasAccount = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackAccountType() {		
		getAccountType();		
	}		
			
	public long getAccountType() { 		
		if ( hasAccountType()) {		
			if (hasAccountType == FixUtils.TAG_HAS_VALUE) {		
				return accountType; 		
			} else {

				buf.position(hasAccountType);

			accountType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasAccountType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return accountType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasAccountType() { return hasAccountType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setAccountType(byte[] src) {		
		if (src == null ) return;
		if (hasAccountType()) accountType = FixUtils.TAG_HAS_NO_VALUE;		
		accountType = FixUtils.longValueOf(src, 0, src.length);
		hasAccountType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAccountType(long src) {		
		accountType = src;
		hasAccountType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAccountType(String str) {		
		if (str == null ) return;
		if (hasAccountType()) accountType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		accountType = FixUtils.longValueOf(src, 0, src.length);
		hasAccountType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackClOrdID() {		
		getClOrdID();		
	}		
			
	public byte[] getClOrdID() { 		
		if ( hasClOrdID()) {		
			if (hasClOrdID == FixUtils.TAG_HAS_VALUE) {		
				return clOrdID; 		
			} else {

				buf.position(hasClOrdID);

			FixMessage.getTagStringValue(buf, clOrdID, 0, clOrdID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasClOrdID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return clOrdID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasClOrdID() { return hasClOrdID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setClOrdID(byte[] src) {		
		if (src == null ) return;
		if (hasClOrdID()) FixUtils.fillSpace(clOrdID);		
		FixUtils.copy(clOrdID, src); 		
		hasClOrdID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setClOrdID(String str) {		
		if (str == null ) return;
		if (hasClOrdID()) FixUtils.fillSpace(clOrdID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(clOrdID, src); 		
		hasClOrdID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackOrderID() {		
		getOrderID();		
	}		
			
	public byte[] getOrderID() { 		
		if ( hasOrderID()) {		
			if (hasOrderID == FixUtils.TAG_HAS_VALUE) {		
				return orderID; 		
			} else {

				buf.position(hasOrderID);

			FixMessage.getTagStringValue(buf, orderID, 0, orderID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasOrderID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return orderID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasOrderID() { return hasOrderID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setOrderID(byte[] src) {		
		if (src == null ) return;
		if (hasOrderID()) FixUtils.fillSpace(orderID);		
		FixUtils.copy(orderID, src); 		
		hasOrderID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOrderID(String str) {		
		if (str == null ) return;
		if (hasOrderID()) FixUtils.fillSpace(orderID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(orderID, src); 		
		hasOrderID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackSecondaryOrderID() {		
		getSecondaryOrderID();		
	}		
			
	public byte[] getSecondaryOrderID() { 		
		if ( hasSecondaryOrderID()) {		
			if (hasSecondaryOrderID == FixUtils.TAG_HAS_VALUE) {		
				return secondaryOrderID; 		
			} else {

				buf.position(hasSecondaryOrderID);

			FixMessage.getTagStringValue(buf, secondaryOrderID, 0, secondaryOrderID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasSecondaryOrderID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return secondaryOrderID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSecondaryOrderID() { return hasSecondaryOrderID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setSecondaryOrderID(byte[] src) {		
		if (src == null ) return;
		if (hasSecondaryOrderID()) FixUtils.fillSpace(secondaryOrderID);		
		FixUtils.copy(secondaryOrderID, src); 		
		hasSecondaryOrderID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSecondaryOrderID(String str) {		
		if (str == null ) return;
		if (hasSecondaryOrderID()) FixUtils.fillSpace(secondaryOrderID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(secondaryOrderID, src); 		
		hasSecondaryOrderID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackSecondaryClOrdID() {		
		getSecondaryClOrdID();		
	}		
			
	public byte[] getSecondaryClOrdID() { 		
		if ( hasSecondaryClOrdID()) {		
			if (hasSecondaryClOrdID == FixUtils.TAG_HAS_VALUE) {		
				return secondaryClOrdID; 		
			} else {

				buf.position(hasSecondaryClOrdID);

			FixMessage.getTagStringValue(buf, secondaryClOrdID, 0, secondaryClOrdID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasSecondaryClOrdID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return secondaryClOrdID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSecondaryClOrdID() { return hasSecondaryClOrdID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setSecondaryClOrdID(byte[] src) {		
		if (src == null ) return;
		if (hasSecondaryClOrdID()) FixUtils.fillSpace(secondaryClOrdID);		
		FixUtils.copy(secondaryClOrdID, src); 		
		hasSecondaryClOrdID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSecondaryClOrdID(String str) {		
		if (str == null ) return;
		if (hasSecondaryClOrdID()) FixUtils.fillSpace(secondaryClOrdID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(secondaryClOrdID, src); 		
		hasSecondaryClOrdID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackSettlDate() {		
		getSettlDate();		
	}		
			
	public byte[] getSettlDate() { 		
		if ( hasSettlDate()) {		
			if (hasSettlDate == FixUtils.TAG_HAS_VALUE) {		
				return settlDate; 		
			} else {

				buf.position(hasSettlDate);

			FixMessage.getTagStringValue(buf, settlDate, 0, settlDate.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasSettlDate = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return settlDate;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSettlDate() { return hasSettlDate != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setSettlDate(byte[] src) {		
		if (src == null ) return;
		if (hasSettlDate()) FixUtils.fillSpace(settlDate);		
		FixUtils.copy(settlDate, src); 		
		hasSettlDate = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSettlDate(String str) {		
		if (str == null ) return;
		if (hasSettlDate()) FixUtils.fillSpace(settlDate);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(settlDate, src); 		
		hasSettlDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackQuantity() {		
		getQuantity();		
	}		
			
	public long getQuantity() { 		
		if ( hasQuantity()) {		
			if (hasQuantity == FixUtils.TAG_HAS_VALUE) {		
				return quantity; 		
			} else {

				buf.position(hasQuantity);

			quantity = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasQuantity = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return quantity;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasQuantity() { return hasQuantity != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setQuantity(byte[] src) {		
		if (src == null ) return;
		if (hasQuantity()) quantity = FixUtils.TAG_HAS_NO_VALUE;		
		quantity = FixUtils.longValueOf(src, 0, src.length);
		hasQuantity = FixUtils.TAG_HAS_VALUE;		
	}

	public void setQuantity(long src) {		
		quantity = src;
		hasQuantity = FixUtils.TAG_HAS_VALUE;		
	}

	public void setQuantity(String str) {		
		if (str == null ) return;
		if (hasQuantity()) quantity = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		quantity = FixUtils.longValueOf(src, 0, src.length);
		hasQuantity = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackQtyType() {		
		getQtyType();		
	}		
			
	public long getQtyType() { 		
		if ( hasQtyType()) {		
			if (hasQtyType == FixUtils.TAG_HAS_VALUE) {		
				return qtyType; 		
			} else {

				buf.position(hasQtyType);

			qtyType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasQtyType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return qtyType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasQtyType() { return hasQtyType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setQtyType(byte[] src) {		
		if (src == null ) return;
		if (hasQtyType()) qtyType = FixUtils.TAG_HAS_NO_VALUE;		
		qtyType = FixUtils.longValueOf(src, 0, src.length);
		hasQtyType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setQtyType(long src) {		
		qtyType = src;
		hasQtyType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setQtyType(String str) {		
		if (str == null ) return;
		if (hasQtyType()) qtyType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		qtyType = FixUtils.longValueOf(src, 0, src.length);
		hasQtyType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackCurrency() {		
		getCurrency();		
	}		
			
	public byte[] getCurrency() { 		
		if ( hasCurrency()) {		
			if (hasCurrency == FixUtils.TAG_HAS_VALUE) {		
				return currency; 		
			} else {

				buf.position(hasCurrency);

			FixMessage.getTagStringValue(buf, currency, 0, currency.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasCurrency = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return currency;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasCurrency() { return hasCurrency != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setCurrency(byte[] src) {		
		if (src == null ) return;
		if (hasCurrency()) FixUtils.fillSpace(currency);		
		FixUtils.copy(currency, src); 		
		hasCurrency = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCurrency(String str) {		
		if (str == null ) return;
		if (hasCurrency()) FixUtils.fillSpace(currency);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(currency, src); 		
		hasCurrency = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackMarginExcess() {		
		getMarginExcess();		
	}		
			
	public long getMarginExcess() { 		
		if ( hasMarginExcess()) {		
			if (hasMarginExcess == FixUtils.TAG_HAS_VALUE) {		
				return marginExcess; 		
			} else {

				buf.position(hasMarginExcess);

			marginExcess = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasMarginExcess = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return marginExcess;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasMarginExcess() { return hasMarginExcess != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setMarginExcess(byte[] src) {		
		if (src == null ) return;
		if (hasMarginExcess()) marginExcess = FixUtils.TAG_HAS_NO_VALUE;		
		marginExcess = FixUtils.longValueOf(src, 0, src.length);
		hasMarginExcess = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMarginExcess(long src) {		
		marginExcess = src;
		hasMarginExcess = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMarginExcess(String str) {		
		if (str == null ) return;
		if (hasMarginExcess()) marginExcess = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		marginExcess = FixUtils.longValueOf(src, 0, src.length);
		hasMarginExcess = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackTotalNetValue() {		
		getTotalNetValue();		
	}		
			
	public long getTotalNetValue() { 		
		if ( hasTotalNetValue()) {		
			if (hasTotalNetValue == FixUtils.TAG_HAS_VALUE) {		
				return totalNetValue; 		
			} else {

				buf.position(hasTotalNetValue);

			totalNetValue = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasTotalNetValue = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return totalNetValue;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasTotalNetValue() { return hasTotalNetValue != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setTotalNetValue(byte[] src) {		
		if (src == null ) return;
		if (hasTotalNetValue()) totalNetValue = FixUtils.TAG_HAS_NO_VALUE;		
		totalNetValue = FixUtils.longValueOf(src, 0, src.length);
		hasTotalNetValue = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTotalNetValue(long src) {		
		totalNetValue = src;
		hasTotalNetValue = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTotalNetValue(String str) {		
		if (str == null ) return;
		if (hasTotalNetValue()) totalNetValue = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		totalNetValue = FixUtils.longValueOf(src, 0, src.length);
		hasTotalNetValue = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackCashOutstanding() {		
		getCashOutstanding();		
	}		
			
	public long getCashOutstanding() { 		
		if ( hasCashOutstanding()) {		
			if (hasCashOutstanding == FixUtils.TAG_HAS_VALUE) {		
				return cashOutstanding; 		
			} else {

				buf.position(hasCashOutstanding);

			cashOutstanding = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasCashOutstanding = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return cashOutstanding;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasCashOutstanding() { return hasCashOutstanding != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setCashOutstanding(byte[] src) {		
		if (src == null ) return;
		if (hasCashOutstanding()) cashOutstanding = FixUtils.TAG_HAS_NO_VALUE;		
		cashOutstanding = FixUtils.longValueOf(src, 0, src.length);
		hasCashOutstanding = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCashOutstanding(long src) {		
		cashOutstanding = src;
		hasCashOutstanding = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCashOutstanding(String str) {		
		if (str == null ) return;
		if (hasCashOutstanding()) cashOutstanding = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		cashOutstanding = FixUtils.longValueOf(src, 0, src.length);
		hasCashOutstanding = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackSide() {		
		getSide();		
	}		
			
	public byte getSide() { 		
		if ( hasSide()) {		
			if (hasSide == FixUtils.TAG_HAS_VALUE) {		
				return side; 		
			} else {

				buf.position(hasSide);

			side = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (side != (byte)'D') && (side != (byte)'E') && (side != (byte)'F') && (side != (byte)'G') && (side != (byte)'A') && (side != (byte)'B') && (side != (byte)'C') && (side != (byte)'3') && (side != (byte)'2') && (side != (byte)'1') && (side != (byte)'7') && (side != (byte)'6') && (side != (byte)'5') && (side != (byte)'4') && (side != (byte)'9') && (side != (byte)'8') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 54);		
				if (err.hasError()) {		
					buf.position(0);		
					return (byte)'0';		
				}		
			}		
			hasSide = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return side;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasSide() { return hasSide != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setSide(byte[] src) {		
		if (src == null ) return;
		if (hasSide()) side = (byte)' ';		
		side = src[0];		
		hasSide = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSide(byte src) {		
		side = src;
		hasSide = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSide(String str) {		
		if (str == null ) return;
		if (hasSide()) side = (byte)' ';		
		byte[] src = str.getBytes(); 		
		side = src[0];		
		hasSide = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackPrice() {		
		getPrice();		
	}		
			
	public long getPrice() { 		
		if ( hasPrice()) {		
			if (hasPrice == FixUtils.TAG_HAS_VALUE) {		
				return price; 		
			} else {

				buf.position(hasPrice);

			price = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasPrice = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return price;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasPrice() { return hasPrice != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setPrice(byte[] src) {		
		if (src == null ) return;
		if (hasPrice()) price = FixUtils.TAG_HAS_NO_VALUE;		
		price = FixUtils.longValueOf(src, 0, src.length);
		hasPrice = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPrice(long src) {		
		price = src;
		hasPrice = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPrice(String str) {		
		if (str == null ) return;
		if (hasPrice()) price = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		price = FixUtils.longValueOf(src, 0, src.length);
		hasPrice = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackPriceType() {		
		getPriceType();		
	}		
			
	public long getPriceType() { 		
		if ( hasPriceType()) {		
			if (hasPriceType == FixUtils.TAG_HAS_VALUE) {		
				return priceType; 		
			} else {

				buf.position(hasPriceType);

			priceType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasPriceType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return priceType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasPriceType() { return hasPriceType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setPriceType(byte[] src) {		
		if (src == null ) return;
		if (hasPriceType()) priceType = FixUtils.TAG_HAS_NO_VALUE;		
		priceType = FixUtils.longValueOf(src, 0, src.length);
		hasPriceType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPriceType(long src) {		
		priceType = src;
		hasPriceType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPriceType(String str) {		
		if (str == null ) return;
		if (hasPriceType()) priceType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		priceType = FixUtils.longValueOf(src, 0, src.length);
		hasPriceType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackAccruedInterestAmt() {		
		getAccruedInterestAmt();		
	}		
			
	public long getAccruedInterestAmt() { 		
		if ( hasAccruedInterestAmt()) {		
			if (hasAccruedInterestAmt == FixUtils.TAG_HAS_VALUE) {		
				return accruedInterestAmt; 		
			} else {

				buf.position(hasAccruedInterestAmt);

			accruedInterestAmt = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasAccruedInterestAmt = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return accruedInterestAmt;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasAccruedInterestAmt() { return hasAccruedInterestAmt != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setAccruedInterestAmt(byte[] src) {		
		if (src == null ) return;
		if (hasAccruedInterestAmt()) accruedInterestAmt = FixUtils.TAG_HAS_NO_VALUE;		
		accruedInterestAmt = FixUtils.longValueOf(src, 0, src.length);
		hasAccruedInterestAmt = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAccruedInterestAmt(long src) {		
		accruedInterestAmt = src;
		hasAccruedInterestAmt = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAccruedInterestAmt(String str) {		
		if (str == null ) return;
		if (hasAccruedInterestAmt()) accruedInterestAmt = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		accruedInterestAmt = FixUtils.longValueOf(src, 0, src.length);
		hasAccruedInterestAmt = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackEndAccruedInterestAmt() {		
		getEndAccruedInterestAmt();		
	}		
			
	public long getEndAccruedInterestAmt() { 		
		if ( hasEndAccruedInterestAmt()) {		
			if (hasEndAccruedInterestAmt == FixUtils.TAG_HAS_VALUE) {		
				return endAccruedInterestAmt; 		
			} else {

				buf.position(hasEndAccruedInterestAmt);

			endAccruedInterestAmt = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasEndAccruedInterestAmt = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return endAccruedInterestAmt;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasEndAccruedInterestAmt() { return hasEndAccruedInterestAmt != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setEndAccruedInterestAmt(byte[] src) {		
		if (src == null ) return;
		if (hasEndAccruedInterestAmt()) endAccruedInterestAmt = FixUtils.TAG_HAS_NO_VALUE;		
		endAccruedInterestAmt = FixUtils.longValueOf(src, 0, src.length);
		hasEndAccruedInterestAmt = FixUtils.TAG_HAS_VALUE;		
	}

	public void setEndAccruedInterestAmt(long src) {		
		endAccruedInterestAmt = src;
		hasEndAccruedInterestAmt = FixUtils.TAG_HAS_VALUE;		
	}

	public void setEndAccruedInterestAmt(String str) {		
		if (str == null ) return;
		if (hasEndAccruedInterestAmt()) endAccruedInterestAmt = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		endAccruedInterestAmt = FixUtils.longValueOf(src, 0, src.length);
		hasEndAccruedInterestAmt = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackStartCash() {		
		getStartCash();		
	}		
			
	public long getStartCash() { 		
		if ( hasStartCash()) {		
			if (hasStartCash == FixUtils.TAG_HAS_VALUE) {		
				return startCash; 		
			} else {

				buf.position(hasStartCash);

			startCash = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasStartCash = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return startCash;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasStartCash() { return hasStartCash != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setStartCash(byte[] src) {		
		if (src == null ) return;
		if (hasStartCash()) startCash = FixUtils.TAG_HAS_NO_VALUE;		
		startCash = FixUtils.longValueOf(src, 0, src.length);
		hasStartCash = FixUtils.TAG_HAS_VALUE;		
	}

	public void setStartCash(long src) {		
		startCash = src;
		hasStartCash = FixUtils.TAG_HAS_VALUE;		
	}

	public void setStartCash(String str) {		
		if (str == null ) return;
		if (hasStartCash()) startCash = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		startCash = FixUtils.longValueOf(src, 0, src.length);
		hasStartCash = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackEndCash() {		
		getEndCash();		
	}		
			
	public long getEndCash() { 		
		if ( hasEndCash()) {		
			if (hasEndCash == FixUtils.TAG_HAS_VALUE) {		
				return endCash; 		
			} else {

				buf.position(hasEndCash);

			endCash = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasEndCash = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return endCash;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasEndCash() { return hasEndCash != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setEndCash(byte[] src) {		
		if (src == null ) return;
		if (hasEndCash()) endCash = FixUtils.TAG_HAS_NO_VALUE;		
		endCash = FixUtils.longValueOf(src, 0, src.length);
		hasEndCash = FixUtils.TAG_HAS_VALUE;		
	}

	public void setEndCash(long src) {		
		endCash = src;
		hasEndCash = FixUtils.TAG_HAS_VALUE;		
	}

	public void setEndCash(String str) {		
		if (str == null ) return;
		if (hasEndCash()) endCash = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		endCash = FixUtils.longValueOf(src, 0, src.length);
		hasEndCash = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackText() {		
		getText();		
	}		
			
	public byte[] getText() { 		
		if ( hasText()) {		
			if (hasText == FixUtils.TAG_HAS_VALUE) {		
				return text; 		
			} else {

				buf.position(hasText);

			FixMessage.getTagStringValue(buf, text, 0, text.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasText = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return text;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasText() { return hasText != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setText(byte[] src) {		
		if (src == null ) return;
		if (hasText()) FixUtils.fillSpace(text);		
		FixUtils.copy(text, src); 		
		hasText = FixUtils.TAG_HAS_VALUE;		
	}

	public void setText(String str) {		
		if (str == null ) return;
		if (hasText()) FixUtils.fillSpace(text);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(text, src); 		
		hasText = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackEncodedTextLen() {		
		getEncodedTextLen();		
	}		
			
	public long getEncodedTextLen() { 		
		if ( hasEncodedTextLen()) {		
			if (hasEncodedTextLen == FixUtils.TAG_HAS_VALUE) {		
				return encodedTextLen; 		
			} else {

				buf.position(hasEncodedTextLen);

			encodedTextLen = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasEncodedTextLen = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return encodedTextLen;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasEncodedTextLen() { return hasEncodedTextLen != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setEncodedTextLen(byte[] src) {		
		if (src == null ) return;
		if (hasEncodedTextLen()) encodedTextLen = FixUtils.TAG_HAS_NO_VALUE;		
		encodedTextLen = FixUtils.longValueOf(src, 0, src.length);
		hasEncodedTextLen = FixUtils.TAG_HAS_VALUE;		
	}

	public void setEncodedTextLen(long src) {		
		encodedTextLen = src;
		hasEncodedTextLen = FixUtils.TAG_HAS_VALUE;		
	}

	public void setEncodedTextLen(String str) {		
		if (str == null ) return;
		if (hasEncodedTextLen()) encodedTextLen = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		encodedTextLen = FixUtils.longValueOf(src, 0, src.length);
		hasEncodedTextLen = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackEncodedText() {		
		getEncodedText();		
	}		
			
	public byte[] getEncodedText() { 		
		if ( hasEncodedText()) {		
			if (hasEncodedText == FixUtils.TAG_HAS_VALUE) {		
				return encodedText; 		
			} else {

				buf.position(hasEncodedText);

			FixMessage.getTagStringValue(buf, encodedText, 0, encodedText.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasEncodedText = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return encodedText;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasEncodedText() { return hasEncodedText != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setEncodedText(byte[] src) {		
		if (src == null ) return;
		if (hasEncodedText()) FixUtils.fillSpace(encodedText);		
		FixUtils.copy(encodedText, src); 		
		hasEncodedText = FixUtils.TAG_HAS_VALUE;		
	}

	public void setEncodedText(String str) {		
		if (str == null ) return;
		if (hasEncodedText()) FixUtils.fillSpace(encodedText);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(encodedText, src); 		
		hasEncodedText = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
		try {
					if (standardHeader.hasBeginString()) s += "BeginString(8)= " + new String( FixUtils.trim(standardHeader.getBeginString()) ) + "\n" ; 
		if (standardHeader.hasBodyLength()) s += "BodyLength(9)= " + standardHeader.getBodyLength() + "\n" ; 
		if (standardHeader.hasMsgType()) s += "MsgType(35)= " + new String( FixUtils.trim(standardHeader.getMsgType()) ) + "\n" ; 
		if (standardHeader.hasSenderCompID()) s += "SenderCompID(49)= " + new String( FixUtils.trim(standardHeader.getSenderCompID()) ) + "\n" ; 
		if (standardHeader.hasTargetCompID()) s += "TargetCompID(56)= " + new String( FixUtils.trim(standardHeader.getTargetCompID()) ) + "\n" ; 
		if (standardHeader.hasOnBehalfOfCompID()) s += "OnBehalfOfCompID(115)= " + new String( FixUtils.trim(standardHeader.getOnBehalfOfCompID()) ) + "\n" ; 
		if (standardHeader.hasDeliverToCompID()) s += "DeliverToCompID(128)= " + new String( FixUtils.trim(standardHeader.getDeliverToCompID()) ) + "\n" ; 
		if (standardHeader.hasSecureDataLen()) s += "SecureDataLen(90)= " + standardHeader.getSecureDataLen() + "\n" ; 
		if (standardHeader.hasSecureData()) s += "SecureData(91)= " + new String( FixUtils.trim(standardHeader.getSecureData()) ) + "\n" ; 
		if (standardHeader.hasMsgSeqNum()) s += "MsgSeqNum(34)= " + standardHeader.getMsgSeqNum() + "\n" ; 
		if (standardHeader.hasSenderSubID()) s += "SenderSubID(50)= " + new String( FixUtils.trim(standardHeader.getSenderSubID()) ) + "\n" ; 
		if (standardHeader.hasSenderLocationID()) s += "SenderLocationID(142)= " + new String( FixUtils.trim(standardHeader.getSenderLocationID()) ) + "\n" ; 
		if (standardHeader.hasTargetSubID()) s += "TargetSubID(57)= " + new String( FixUtils.trim(standardHeader.getTargetSubID()) ) + "\n" ; 
		if (standardHeader.hasTargetLocationID()) s += "TargetLocationID(143)= " + new String( FixUtils.trim(standardHeader.getTargetLocationID()) ) + "\n" ; 
		if (standardHeader.hasOnBehalfOfSubID()) s += "OnBehalfOfSubID(116)= " + new String( FixUtils.trim(standardHeader.getOnBehalfOfSubID()) ) + "\n" ; 
		if (standardHeader.hasOnBehalfOfLocationID()) s += "OnBehalfOfLocationID(144)= " + new String( FixUtils.trim(standardHeader.getOnBehalfOfLocationID()) ) + "\n" ; 
		if (standardHeader.hasDeliverToSubID()) s += "DeliverToSubID(129)= " + new String( FixUtils.trim(standardHeader.getDeliverToSubID()) ) + "\n" ; 
		if (standardHeader.hasDeliverToLocationID()) s += "DeliverToLocationID(145)= " + new String( FixUtils.trim(standardHeader.getDeliverToLocationID()) ) + "\n" ; 
		if (standardHeader.hasPossDupFlag()) s += "PossDupFlag(43)= " + standardHeader.getPossDupFlag() + "\n" ; 
		if (standardHeader.hasPossResend()) s += "PossResend(97)= " + standardHeader.getPossResend() + "\n" ; 
		if (standardHeader.hasSendingTime()) s += "SendingTime(52)= " + new String( FixUtils.trim(standardHeader.getSendingTime()) ) + "\n" ; 
		if (standardHeader.hasOrigSendingTime()) s += "OrigSendingTime(122)= " + new String( FixUtils.trim(standardHeader.getOrigSendingTime()) ) + "\n" ; 
		if (standardHeader.hasXmlDataLen()) s += "XmlDataLen(212)= " + standardHeader.getXmlDataLen() + "\n" ; 
		if (standardHeader.hasXmlData()) s += "XmlData(213)= " + new String( FixUtils.trim(standardHeader.getXmlData()) ) + "\n" ; 
		if (standardHeader.hasMessageEncoding()) s += "MessageEncoding(347)= " + new String( FixUtils.trim(standardHeader.getMessageEncoding()) ) + "\n" ; 
		if (standardHeader.hasLastMsgSeqNumProcessed()) s += "LastMsgSeqNumProcessed(369)= " + standardHeader.getLastMsgSeqNumProcessed() + "\n" ; 
		if (standardHeader.hasApplVerID()) s += "ApplVerID(1128)= " + new String( FixUtils.trim(standardHeader.getApplVerID()) ) + "\n" ; 
		if (standardHeader.hasCstmApplVerID()) s += "CstmApplVerID(1129)= " + new String( FixUtils.trim(standardHeader.getCstmApplVerID()) ) + "\n" ; 
		if (standardHeader.hasApplExtID()) s += "ApplExtID(1156)= " + standardHeader.getApplExtID() + "\n" ; 

					if (hasCollRespID()) s += "CollRespID(904)= " + new String( FixUtils.trim(getCollRespID()) ) + "\n" ; 
		if (hasCollAsgnID()) s += "CollAsgnID(902)= " + new String( FixUtils.trim(getCollAsgnID()) ) + "\n" ; 
		if (hasCollReqID()) s += "CollReqID(894)= " + new String( FixUtils.trim(getCollReqID()) ) + "\n" ; 
		if (hasCollAsgnReason()) s += "CollAsgnReason(895)= " + getCollAsgnReason() + "\n" ; 
		if (hasCollAsgnTransType()) s += "CollAsgnTransType(903)= " + getCollAsgnTransType() + "\n" ; 
		if (hasCollAsgnRespType()) s += "CollAsgnRespType(905)= " + getCollAsgnRespType() + "\n" ; 
		if (hasCollAsgnRejectReason()) s += "CollAsgnRejectReason(906)= " + getCollAsgnRejectReason() + "\n" ; 
		if (hasTransactTime()) s += "TransactTime(60)= " + new String( FixUtils.trim(getTransactTime()) ) + "\n" ; 
		if (hasCollApplType()) s += "CollApplType(1043)= " + getCollApplType() + "\n" ; 
		if (hasFinancialStatus()) s += "FinancialStatus(291)= " + new String( FixUtils.trim(getFinancialStatus()) ) + "\n" ; 
		if (hasClearingBusinessDate()) s += "ClearingBusinessDate(715)= " + new String( FixUtils.trim(getClearingBusinessDate()) ) + "\n" ; 
		if (hasAccount()) s += "Account(1)= " + new String( FixUtils.trim(getAccount()) ) + "\n" ; 
		if (hasAccountType()) s += "AccountType(581)= " + getAccountType() + "\n" ; 
		if (hasClOrdID()) s += "ClOrdID(11)= " + new String( FixUtils.trim(getClOrdID()) ) + "\n" ; 
		if (hasOrderID()) s += "OrderID(37)= " + new String( FixUtils.trim(getOrderID()) ) + "\n" ; 
		if (hasSecondaryOrderID()) s += "SecondaryOrderID(198)= " + new String( FixUtils.trim(getSecondaryOrderID()) ) + "\n" ; 
		if (hasSecondaryClOrdID()) s += "SecondaryClOrdID(526)= " + new String( FixUtils.trim(getSecondaryClOrdID()) ) + "\n" ; 
		if (hasSettlDate()) s += "SettlDate(64)= " + new String( FixUtils.trim(getSettlDate()) ) + "\n" ; 
		if (hasQuantity()) s += "Quantity(53)= " + getQuantity() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasQtyType()) s += "QtyType(854)= " + getQtyType() + "\n" ; 
		if (hasCurrency()) s += "Currency(15)= " + new String( FixUtils.trim(getCurrency()) ) + "\n" ; 
		if (hasMarginExcess()) s += "MarginExcess(899)= " + getMarginExcess() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasTotalNetValue()) s += "TotalNetValue(900)= " + getTotalNetValue() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasCashOutstanding()) s += "CashOutstanding(901)= " + getCashOutstanding() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasSide()) s += "Side(54)= " + getSide() + "\n" ; 
		if (hasPrice()) s += "Price(44)= " + getPrice() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasPriceType()) s += "PriceType(423)= " + getPriceType() + "\n" ; 
		if (hasAccruedInterestAmt()) s += "AccruedInterestAmt(159)= " + getAccruedInterestAmt() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasEndAccruedInterestAmt()) s += "EndAccruedInterestAmt(920)= " + getEndAccruedInterestAmt() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasStartCash()) s += "StartCash(921)= " + getStartCash() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasEndCash()) s += "EndCash(922)= " + getEndCash() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasText()) s += "Text(58)= " + new String( FixUtils.trim(getText()) ) + "\n" ; 
		if (hasEncodedTextLen()) s += "EncodedTextLen(354)= " + getEncodedTextLen() + "\n" ; 
		if (hasEncodedText()) s += "EncodedText(355)= " + new String( FixUtils.trim(getEncodedText()) ) + "\n" ; 

					if (standardTrailer.hasSignatureLength()) s += "SignatureLength(93)= " + standardTrailer.getSignatureLength() + "\n" ; 
		if (standardTrailer.hasSignature()) s += "Signature(89)= " + new String( FixUtils.trim(standardTrailer.getSignature()) ) + "\n" ; 
		if (standardTrailer.hasCheckSum()) s += "CheckSum(10)= " + new String( FixUtils.trim(standardTrailer.getCheckSum()) ) + "\n" ; 

		} catch(Exception e) {  };
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixCollateralResponse)) return false;

		FixCollateralResponse msg = (FixCollateralResponse) o;

		if (!standardHeader.equals(msg.standardHeader)) return false;

		if ((hasCollRespID() && !msg.hasCollRespID()) || (!hasCollRespID() && msg.hasCollRespID())) return false;
		if (!(!hasCollRespID() && !msg.hasCollRespID()) && !FixUtils.equals(getCollRespID(), msg.getCollRespID())) return false;
		if ((hasCollAsgnID() && !msg.hasCollAsgnID()) || (!hasCollAsgnID() && msg.hasCollAsgnID())) return false;
		if (!(!hasCollAsgnID() && !msg.hasCollAsgnID()) && !FixUtils.equals(getCollAsgnID(), msg.getCollAsgnID())) return false;
		if ((hasCollReqID() && !msg.hasCollReqID()) || (!hasCollReqID() && msg.hasCollReqID())) return false;
		if (!(!hasCollReqID() && !msg.hasCollReqID()) && !FixUtils.equals(getCollReqID(), msg.getCollReqID())) return false;
		if ((hasCollAsgnReason() && !msg.hasCollAsgnReason()) || (!hasCollAsgnReason() && msg.hasCollAsgnReason())) return false;
		if (!(!hasCollAsgnReason() && !msg.hasCollAsgnReason()) && !(getCollAsgnReason()==msg.getCollAsgnReason())) return false;
		if ((hasCollAsgnTransType() && !msg.hasCollAsgnTransType()) || (!hasCollAsgnTransType() && msg.hasCollAsgnTransType())) return false;
		if (!(!hasCollAsgnTransType() && !msg.hasCollAsgnTransType()) && !(getCollAsgnTransType()==msg.getCollAsgnTransType())) return false;
		if ((hasCollAsgnRespType() && !msg.hasCollAsgnRespType()) || (!hasCollAsgnRespType() && msg.hasCollAsgnRespType())) return false;
		if (!(!hasCollAsgnRespType() && !msg.hasCollAsgnRespType()) && !(getCollAsgnRespType()==msg.getCollAsgnRespType())) return false;
		if ((hasCollAsgnRejectReason() && !msg.hasCollAsgnRejectReason()) || (!hasCollAsgnRejectReason() && msg.hasCollAsgnRejectReason())) return false;
		if (!(!hasCollAsgnRejectReason() && !msg.hasCollAsgnRejectReason()) && !(getCollAsgnRejectReason()==msg.getCollAsgnRejectReason())) return false;
		if ((hasTransactTime() && !msg.hasTransactTime()) || (!hasTransactTime() && msg.hasTransactTime())) return false;
		if (!(!hasTransactTime() && !msg.hasTransactTime()) ) return false;
		if ((hasCollApplType() && !msg.hasCollApplType()) || (!hasCollApplType() && msg.hasCollApplType())) return false;
		if (!(!hasCollApplType() && !msg.hasCollApplType()) && !(getCollApplType()==msg.getCollApplType())) return false;
		if ((hasFinancialStatus() && !msg.hasFinancialStatus()) || (!hasFinancialStatus() && msg.hasFinancialStatus())) return false;
		if (!(!hasFinancialStatus() && !msg.hasFinancialStatus()) && !FixUtils.equals(getFinancialStatus(), msg.getFinancialStatus())) return false;
		if ((hasClearingBusinessDate() && !msg.hasClearingBusinessDate()) || (!hasClearingBusinessDate() && msg.hasClearingBusinessDate())) return false;
		if (!(!hasClearingBusinessDate() && !msg.hasClearingBusinessDate()) ) return false;
		if ((hasAccount() && !msg.hasAccount()) || (!hasAccount() && msg.hasAccount())) return false;
		if (!(!hasAccount() && !msg.hasAccount()) && !FixUtils.equals(getAccount(), msg.getAccount())) return false;
		if ((hasAccountType() && !msg.hasAccountType()) || (!hasAccountType() && msg.hasAccountType())) return false;
		if (!(!hasAccountType() && !msg.hasAccountType()) && !(getAccountType()==msg.getAccountType())) return false;
		if ((hasClOrdID() && !msg.hasClOrdID()) || (!hasClOrdID() && msg.hasClOrdID())) return false;
		if (!(!hasClOrdID() && !msg.hasClOrdID()) && !FixUtils.equals(getClOrdID(), msg.getClOrdID())) return false;
		if ((hasOrderID() && !msg.hasOrderID()) || (!hasOrderID() && msg.hasOrderID())) return false;
		if (!(!hasOrderID() && !msg.hasOrderID()) && !FixUtils.equals(getOrderID(), msg.getOrderID())) return false;
		if ((hasSecondaryOrderID() && !msg.hasSecondaryOrderID()) || (!hasSecondaryOrderID() && msg.hasSecondaryOrderID())) return false;
		if (!(!hasSecondaryOrderID() && !msg.hasSecondaryOrderID()) && !FixUtils.equals(getSecondaryOrderID(), msg.getSecondaryOrderID())) return false;
		if ((hasSecondaryClOrdID() && !msg.hasSecondaryClOrdID()) || (!hasSecondaryClOrdID() && msg.hasSecondaryClOrdID())) return false;
		if (!(!hasSecondaryClOrdID() && !msg.hasSecondaryClOrdID()) && !FixUtils.equals(getSecondaryClOrdID(), msg.getSecondaryClOrdID())) return false;
		if ((hasSettlDate() && !msg.hasSettlDate()) || (!hasSettlDate() && msg.hasSettlDate())) return false;
		if (!(!hasSettlDate() && !msg.hasSettlDate()) ) return false;
		if ((hasQuantity() && !msg.hasQuantity()) || (!hasQuantity() && msg.hasQuantity())) return false;
		if (!(!hasQuantity() && !msg.hasQuantity()) && !(getQuantity()==msg.getQuantity())) return false;
		if ((hasQtyType() && !msg.hasQtyType()) || (!hasQtyType() && msg.hasQtyType())) return false;
		if (!(!hasQtyType() && !msg.hasQtyType()) && !(getQtyType()==msg.getQtyType())) return false;
		if ((hasCurrency() && !msg.hasCurrency()) || (!hasCurrency() && msg.hasCurrency())) return false;
		if (!(!hasCurrency() && !msg.hasCurrency()) && !FixUtils.equals(getCurrency(), msg.getCurrency())) return false;
		if ((hasMarginExcess() && !msg.hasMarginExcess()) || (!hasMarginExcess() && msg.hasMarginExcess())) return false;
		if (!(!hasMarginExcess() && !msg.hasMarginExcess()) && !(getMarginExcess()==msg.getMarginExcess())) return false;
		if ((hasTotalNetValue() && !msg.hasTotalNetValue()) || (!hasTotalNetValue() && msg.hasTotalNetValue())) return false;
		if (!(!hasTotalNetValue() && !msg.hasTotalNetValue()) && !(getTotalNetValue()==msg.getTotalNetValue())) return false;
		if ((hasCashOutstanding() && !msg.hasCashOutstanding()) || (!hasCashOutstanding() && msg.hasCashOutstanding())) return false;
		if (!(!hasCashOutstanding() && !msg.hasCashOutstanding()) && !(getCashOutstanding()==msg.getCashOutstanding())) return false;
		if ((hasSide() && !msg.hasSide()) || (!hasSide() && msg.hasSide())) return false;
		if (!(!hasSide() && !msg.hasSide()) && !(getSide()==msg.getSide())) return false;
		if ((hasPrice() && !msg.hasPrice()) || (!hasPrice() && msg.hasPrice())) return false;
		if (!(!hasPrice() && !msg.hasPrice()) && !(getPrice()==msg.getPrice())) return false;
		if ((hasPriceType() && !msg.hasPriceType()) || (!hasPriceType() && msg.hasPriceType())) return false;
		if (!(!hasPriceType() && !msg.hasPriceType()) && !(getPriceType()==msg.getPriceType())) return false;
		if ((hasAccruedInterestAmt() && !msg.hasAccruedInterestAmt()) || (!hasAccruedInterestAmt() && msg.hasAccruedInterestAmt())) return false;
		if (!(!hasAccruedInterestAmt() && !msg.hasAccruedInterestAmt()) && !(getAccruedInterestAmt()==msg.getAccruedInterestAmt())) return false;
		if ((hasEndAccruedInterestAmt() && !msg.hasEndAccruedInterestAmt()) || (!hasEndAccruedInterestAmt() && msg.hasEndAccruedInterestAmt())) return false;
		if (!(!hasEndAccruedInterestAmt() && !msg.hasEndAccruedInterestAmt()) && !(getEndAccruedInterestAmt()==msg.getEndAccruedInterestAmt())) return false;
		if ((hasStartCash() && !msg.hasStartCash()) || (!hasStartCash() && msg.hasStartCash())) return false;
		if (!(!hasStartCash() && !msg.hasStartCash()) && !(getStartCash()==msg.getStartCash())) return false;
		if ((hasEndCash() && !msg.hasEndCash()) || (!hasEndCash() && msg.hasEndCash())) return false;
		if (!(!hasEndCash() && !msg.hasEndCash()) && !(getEndCash()==msg.getEndCash())) return false;
		if ((hasText() && !msg.hasText()) || (!hasText() && msg.hasText())) return false;
		if (!(!hasText() && !msg.hasText()) && !FixUtils.equals(getText(), msg.getText())) return false;
		if ((hasEncodedTextLen() && !msg.hasEncodedTextLen()) || (!hasEncodedTextLen() && msg.hasEncodedTextLen())) return false;
		if (!(!hasEncodedTextLen() && !msg.hasEncodedTextLen()) && !(getEncodedTextLen()==msg.getEncodedTextLen())) return false;
		if ((hasEncodedText() && !msg.hasEncodedText()) || (!hasEncodedText() && msg.hasEncodedText())) return false;
		if (!(!hasEncodedText() && !msg.hasEncodedText()) && !FixUtils.equals(getEncodedText(), msg.getEncodedText())) return false;
		return true;
	}
	@Override
	public FixCollateralResponse clone () {
		FixCollateralResponse out = new FixCollateralResponse();

		standardHeader.clone(out.standardHeader);
		standardTrailer.clone(out.standardTrailer);
		return clone(out);
	}

	public FixCollateralResponse clone ( FixCollateralResponse out ) {
		if ( hasCollRespID())
			out.setCollRespID(getCollRespID());
		if ( hasCollAsgnID())
			out.setCollAsgnID(getCollAsgnID());
		if ( hasCollReqID())
			out.setCollReqID(getCollReqID());
		if ( hasCollAsgnReason())
			out.setCollAsgnReason(getCollAsgnReason());
		if ( hasCollAsgnTransType())
			out.setCollAsgnTransType(getCollAsgnTransType());
		if ( hasCollAsgnRespType())
			out.setCollAsgnRespType(getCollAsgnRespType());
		if ( hasCollAsgnRejectReason())
			out.setCollAsgnRejectReason(getCollAsgnRejectReason());
		if ( hasTransactTime())
			out.setTransactTime(getTransactTime());
		if ( hasCollApplType())
			out.setCollApplType(getCollApplType());
		if ( hasFinancialStatus())
			out.setFinancialStatus(getFinancialStatus());
		if ( hasClearingBusinessDate())
			out.setClearingBusinessDate(getClearingBusinessDate());
		if ( hasAccount())
			out.setAccount(getAccount());
		if ( hasAccountType())
			out.setAccountType(getAccountType());
		if ( hasClOrdID())
			out.setClOrdID(getClOrdID());
		if ( hasOrderID())
			out.setOrderID(getOrderID());
		if ( hasSecondaryOrderID())
			out.setSecondaryOrderID(getSecondaryOrderID());
		if ( hasSecondaryClOrdID())
			out.setSecondaryClOrdID(getSecondaryClOrdID());
		if ( hasSettlDate())
			out.setSettlDate(getSettlDate());
		if ( hasQuantity())
			out.setQuantity(getQuantity());
		if ( hasQtyType())
			out.setQtyType(getQtyType());
		if ( hasCurrency())
			out.setCurrency(getCurrency());
		if ( hasMarginExcess())
			out.setMarginExcess(getMarginExcess());
		if ( hasTotalNetValue())
			out.setTotalNetValue(getTotalNetValue());
		if ( hasCashOutstanding())
			out.setCashOutstanding(getCashOutstanding());
		if ( hasSide())
			out.setSide(getSide());
		if ( hasPrice())
			out.setPrice(getPrice());
		if ( hasPriceType())
			out.setPriceType(getPriceType());
		if ( hasAccruedInterestAmt())
			out.setAccruedInterestAmt(getAccruedInterestAmt());
		if ( hasEndAccruedInterestAmt())
			out.setEndAccruedInterestAmt(getEndAccruedInterestAmt());
		if ( hasStartCash())
			out.setStartCash(getStartCash());
		if ( hasEndCash())
			out.setEndCash(getEndCash());
		if ( hasText())
			out.setText(getText());
		if ( hasEncodedTextLen())
			out.setEncodedTextLen(getEncodedTextLen());
		if ( hasEncodedText())
			out.setEncodedText(getEncodedText());
		int count = 0;
		count = 0;
		for (FixParties fixParties : parties) {
			if (!fixParties.hasGroup()) continue;
			out.parties[count] = fixParties.clone( out.parties[count] );
			count++;
		}
		count = 0;
		for (FixExecCollGrp fixExecCollGrp : execCollGrp) {
			if (!fixExecCollGrp.hasGroup()) continue;
			out.execCollGrp[count] = fixExecCollGrp.clone( out.execCollGrp[count] );
			count++;
		}
		count = 0;
		for (FixTrdCollGrp fixTrdCollGrp : trdCollGrp) {
			if (!fixTrdCollGrp.hasGroup()) continue;
			out.trdCollGrp[count] = fixTrdCollGrp.clone( out.trdCollGrp[count] );
			count++;
		}
		if (instrument.hasGroup())
			out.instrument = instrument.clone( out.instrument);
		if (financingDetails.hasGroup())
			out.financingDetails = financingDetails.clone( out.financingDetails);
		count = 0;
		for (FixInstrmtLegGrp fixInstrmtLegGrp : instrmtLegGrp) {
			if (!fixInstrmtLegGrp.hasGroup()) continue;
			out.instrmtLegGrp[count] = fixInstrmtLegGrp.clone( out.instrmtLegGrp[count] );
			count++;
		}
		count = 0;
		for (FixUndInstrmtCollGrp fixUndInstrmtCollGrp : undInstrmtCollGrp) {
			if (!fixUndInstrmtCollGrp.hasGroup()) continue;
			out.undInstrmtCollGrp[count] = fixUndInstrmtCollGrp.clone( out.undInstrmtCollGrp[count] );
			count++;
		}
		count = 0;
		for (FixTrdRegTimestamps fixTrdRegTimestamps : trdRegTimestamps) {
			if (!fixTrdRegTimestamps.hasGroup()) continue;
			out.trdRegTimestamps[count] = fixTrdRegTimestamps.clone( out.trdRegTimestamps[count] );
			count++;
		}
		count = 0;
		for (FixMiscFeesGrp fixMiscFeesGrp : miscFeesGrp) {
			if (!fixMiscFeesGrp.hasGroup()) continue;
			out.miscFeesGrp[count] = fixMiscFeesGrp.clone( out.miscFeesGrp[count] );
			count++;
		}
		if (spreadOrBenchmarkCurveData.hasGroup())
			out.spreadOrBenchmarkCurveData = spreadOrBenchmarkCurveData.clone( out.spreadOrBenchmarkCurveData);
		count = 0;
		for (FixStipulations fixStipulations : stipulations) {
			if (!fixStipulations.hasGroup()) continue;
			out.stipulations[count] = fixStipulations.clone( out.stipulations[count] );
			count++;
		}
		return out;
	}

}