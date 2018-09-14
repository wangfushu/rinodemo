package com.xmrbi.rinoWeb.utils.socket.msgProc;


import com.xmrbi.rinoWeb.utils.ConfFileInfo;
import com.xmrbi.rinoWeb.utils.DateTimeUtil;
import com.xmrbi.rinoWeb.utils.DateTimeUtilException;
import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class ClientNotiMsgConverter {
	static Logger logger = LoggerFactory.getLogger(ClientNotiMsgConverter.class);

	private static ClientNotiMsgConverter instance = null;

	private static final String EVENT_STAT = "StatEvet";

	public static ClientNotiMsgConverter getInstance(){
		if( instance == null ){
			instance = new ClientNotiMsgConverter();
		}
		return instance;
	}

	private ClientNotiMsgConverter(){}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String msgConvert(String msg){
//		logger.debug("ClientNotiMsgConverter- {}", msg);
		Map<String, Object> msgMap = (Map<String, Object>) new JSONDeserializer().deserialize(msg);
		Set<String> msgKeySet = msgMap.keySet();
		Iterator<String> msgIterator = msgKeySet.iterator();
		String msgTypNm = msgIterator.next();
		String msgItem = new JSONSerializer().deepSerialize(msgMap.get(msgTypNm));
//		logger.debug("{}", msgItem);
		Map<String, Object> itemMap = (Map<String, Object>) new JSONDeserializer().deserialize(msgItem);

		Map<String, String> resMap = null;

		Locale locale = new Locale(ConfFileInfo.get("langCode"), ConfFileInfo.get("countryCode"));
//		logger.debug("{}", msgTypNm);
		switch(msgTypNm){
			case EVENT_STAT	:
				resMap = statEvetFormat(itemMap, locale);
				break;
			default :
				break;
		}
		resMap.put("type", msgTypNm);
		logger.debug("{}", resMap.toString());
		return new JSONSerializer().deepSerialize(resMap);
	}

	// 상황이벤트 NOTI 생성
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map statEvetFormat(Map itemMap, Locale locale){
		Map resMap = new HashMap();
		StringBuilder outbPosStr = new StringBuilder();

		resMap.put("evetNm", itemMap.get("statEvetNm"));
		resMap.put("outbPosNm", itemMap.get("outbPosNm"));
		try {
			resMap.put("outbDtm", DateTimeUtil.getDateTimeStringByLocaleWithLong((String) itemMap.get("statEvetOutbDtm"), locale.getLanguage(), locale.getCountry()));
		} catch (DateTimeUtilException e) {
			logger.error(e.getMessage(),e);
		}
		for (Map outbPosMap : (ArrayList<Map>) itemMap.get("outbPos")) {
			outbPosStr .append( outbPosMap.get("x")).append("@");
			outbPosStr .append( outbPosMap.get("y")).append("@");
			outbPosStr .append( outbPosMap.get("z")).append("#");
		}
		resMap.put("outbPos", outbPosStr.toString());
		resMap.put("outbScopRads", itemMap.get("outbScopRads"));
		resMap.put("statEvetId", itemMap.get("statEvetId"));
		resMap.put("statEvetGdCd", itemMap.get("statEvetGdCd"));
		resMap.put("statEvetCntn", itemMap.get("statEvetCntn"));
		resMap.put("uSvcOutbId", itemMap.get("uSvcOutbId"));
		resMap.put("procSt", itemMap.get("procSt"));

		resMap.put("evetItems", itemMap.get("statEvetItem"));

		return resMap;
	}
}
