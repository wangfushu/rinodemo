package com.xmrbi.rinoWeb.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HeaderUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(HeaderUtil.class);

	/*헤더 정보*/
	/** 헤더 타입 코드. */
	public static final int HEDR_TYP_CD 	= 0;
	/** 송신 시스템 코드. */
	public static final int SND_SYS_CD 		= 1;
	/** 메시지 교환 패턴. */
	public static final int MSG_EXCH_PATRN 	= 2;
	/** 데이터부 길이. */
	public static final int BODY_LEN 		= 3;
	/** 메시지 타입 코드. */
	public static final int MSG_TYP_CD 		= 4;
	/** 트레이스 아이디. */
	public static final int TRCE_ID 		= 5;
	/** 전송 시간. */
	public static final int SND_DTM 		= 6;
	
	
	
	/** The header item len ar. */
	private static int[] headerItemLenAr = new int[]{ 2, 9, 1, 4, 3, 24, 17 };
	
	/** The header item pos ar. */
	private static int[] headerItemStartPosAr = new int[]{ 0, 2, 11, 12, 16, 19, 43 };
	
	/** The header item end pos ar. */
	private static int[] headerItemEndPosAr = new int[]{ 2, 11, 12, 16, 19, 43, 60 };
	
	/**
	 * Instantiates a new header util.
	 */
	private HeaderUtil(){
		
	}
	
	/**
	 * Gets the header item length.
	 *
	 * @param fieldId the field id
	 * @return the header item length
	 */
	public static int getHeaderItemLength(int fieldId){
		return headerItemLenAr[fieldId];
	}
	
	/**
	 * Gets the header item pos.
	 *
	 * @param fieldId the field id
	 * @return the header item pos
	 */
	public static int getHeaderItemStartPos(int fieldId){
		return headerItemStartPosAr[fieldId];
	}
	
	/**
	 * Gets the header item end pos.
	 *
	 * @param fieldId the field id
	 * @return the header item end pos
	 */
	public static int getHeaderItemEndPos(int fieldId){
		return headerItemEndPosAr[fieldId];
	}
	
	/**
	 * Gets the header item total Len.
	 *
	 * @return header item total Len
	 */
	public static int getHeaderTotalLen(){
		int totalLen = 0;
		for(int i : headerItemLenAr){
			totalLen += i;
		}
		return totalLen;
	}
	
	/**
	 * 송신 헤더 생성 
	 * @param headerTypCd - 헤더 타입 코드
	 * @param sndSysCd - 송신 시스템 코드
	 * @param msgTypCd - 메시지 타입 코드
	 * @param mepTypCd - 메시지 교환 방식 코드
	 * @param bodyLen - 바디 길이
	 * @return String header - 헤더
	 */
	/*public static byte[] makeHeader(String headerTypCd, String sndSysCd, String msgTypCd, String mepTypCd, int bodyLen){
		byte[] headerByte = null;

		try {
			// 임시 바디길이 byte 크기 
			String bodylen = "0000";
			// 시스템 코드가 3자리일 경우 9자리 변경
			String sndSysCdSetPadded = StringUtils.setPad(sndSysCd, 9, ' ', StringUtils.PAD_LEFT);
			
			// 현재 시간 
			String sndDtm = new SimpleDateFormat(XWSConstants.DTM_FORMET,new Locale(ConfFileInfo.get(XWSConstants.PROPERTIES.LANG_CODE))).format(Calendar.getInstance().getTime());

			StringBuilder header = new StringBuilder();
			header.append(headerTypCd);
			header.append(sndSysCdSetPadded);
			header.append(mepTypCd);
			header.append(bodylen);
			header.append(msgTypCd);
			header.append(sndDtm);
			headerByte =  header.toString().getBytes(XWSConstants.CHAR_SET);

			// 바디 길이 byte 변경 
			byte[] bodyLenbyte = ByteSupport.intToByteArray(bodyLen, ByteOrder.LITTLE_ENDIAN);
			System.arraycopy(bodyLenbyte, 0, headerByte, HeaderUtil.getHeaderItemStartPos(BODY_LEN), HeaderUtil.getHeaderItemLength(BODY_LEN));

			
		} catch (StringUtilException | UnsupportedEncodingException e) {
			logger.error(e.getMessage(),e);
		}

		return headerByte;
	}
	*/
	/**
	 * 송신 헤더 생성 - statEvet
	 * @param headerTypCd - 헤더 타입 코드
	 * @param sndSysCd - 송신 시스템 코드
	 * @param msgTypCd - 메시지 타입 코드
	 * @param mepTypCd - 메시지 교환 방식 코드
	 * @param trceId - 
	 * @param bodyLen - 바디 길이
	 * @return String header - 헤더
	 */
	/*public static byte[] makeHeader(String headerTypCd, String sndSysCd, String msgTypCd, String mepTypCd, String trceId, int bodyLen){
		byte[] headerByte = null;
		
		try {
			// 임시 바디길이 byte 크기 
			String bodylen = "0000";
			// 시스템 코드가 3자리일 경우 9자리 변경
			String sndSysCdSetPadded = StringUtils.setPad(sndSysCd, 9, ' ',  StringUtils.PAD_LEFT) ;
			// TRCE_ID 24자리로 변경
			String trceIdSetPadded = StringUtils.setPad(trceId, 24, ' ',  StringUtils.PAD_RIGHT) ;
			
			// 현재 시간 
			String sndDtm = new SimpleDateFormat(XWSConstants.DTM_FORMET,new Locale(ConfFileInfo.get(XWSConstants.PROPERTIES.LANG_CODE))).format(Calendar.getInstance().getTime());

			StringBuilder header = new StringBuilder();
			header.append(headerTypCd);
			header.append(sndSysCdSetPadded);
			header.append(mepTypCd);
			header.append(bodylen);
			header.append(msgTypCd);
			header.append(trceIdSetPadded);
			header.append(sndDtm);
			headerByte =  header.toString().getBytes(XWSConstants.CHAR_SET);
			
			// 바디 길이 byte 변경 
			byte[] bodyLenbyte = ByteSupport.intToByteArray(bodyLen, ByteOrder.LITTLE_ENDIAN);
			System.arraycopy(bodyLenbyte, 0, headerByte, HeaderUtil.getHeaderItemStartPos(BODY_LEN), HeaderUtil.getHeaderItemLength(BODY_LEN));
			
		} catch (StringUtilException | UnsupportedEncodingException e) {
			logger.error(e.getMessage(),e);
		}
		
		return headerByte;
	}*/

	
	/**
	 * 송신 헤더 생성 - connevet
	 * @param headerTypCd - 헤더 타입 코드
	 * @param sndSysCd - 송신 시스템 코드
	 * @param msgTypCd - 메시지 타입 코드
	 * @param mepTypCd - 메시지 교환 방식 코드
	 * @param bodyLen - 바디 길이
	 * @return String header - 헤더
	 */

}
