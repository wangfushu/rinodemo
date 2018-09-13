package com.xmrbi.rinoWeb.vo;

public class XWSConstants {

	// IAD Login 처리
	public static final int IAD_LOGIN_SUCCESS=0;
	public static final int IAD_NOT_FOUND_USER=1;
	public static final int IAD_PASSWORD_MISS=2;

	public static final String IAD_YES="Y";
	public static final String IAD_NO="N";

	// WIDGET SET 처리 성공 // 권한없음 // 위젯이 없음
	public static final int IAD_WIDGET_NOT_EXIST=0;
	public static final int IAD_WIDGET_EXIST=1;
	public static final int IAD_WIDGET_SUCCESS=2;

	// IAD mode 타입
	public static final String IAD_MODE_TYPE_CREATE 	= "C";
	public static final String IAD_MODE_TYPE_DELETE 	= "D";
	public static final String IAD_MODE_TYPE_UPDATE 	= "U";

	// IAD 처리 성공/실패
	public static final String IAD_PROC_SUCCESS 		= "SUCCESS";
	public static final String IAD_PROC_FAIL	 		= "FAIL";
	public static final String IAD_PROC_DUPL	 		= "DUPL";

	// 시스템 CHRACTER SET
	public static final String CHAR_SET = "UTF-8";

	//사용 여부
	public static final String WFS_SYS_USE_YN_YES		= "Y";
	public static final String WFS_SYS_USE_YN_NO		= "N";

	//그룹코드
	public static final String BLNG_TYP_CD	 			= "G311";


	public static final String STATC_RESULT_DAYS="01,02,03,04,05,06,07,08,09,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31";

	public static final String DTM_FORMET = "yyyyMMddHHmmssSSS";

	public static final String RECEIVER_TREE_PREFIX		= "IUF__";

	public static final String OMS_SCHEMA		= "oms";

	public static final String VIEW_MODE_ATTR_NM = "__VIEW_MODE__";

	private XWSConstants(){}
	
	// 데이터베이스 스키마 
	public static class DATABASE_SCHEMA {
		/* FMS schema  */
		public static final String OMS = "gunpo";
		/* FMS schema  */
		public static final String FMS = "gunpo";
		/* IOC schema */
		public static final String IOC = "ioc";
		/* IOC schema */
		public static final String IOT = "iot";
		
		private DATABASE_SCHEMA (){}
	}
	
	//이벤트 상태별 건수 조회 
	public static class EVET_STATE_CNT{
		
		private EVET_STATE_CNT (){}
		
		public static class PARAM_NAME {
			public static final String ZN_CD = "Z";
			public static final String SVC_THEME_CD = "S";
			public static final String UNIT_SVC_CD = "U";
			private PARAM_NAME (){}
		}
		
		public static class GROUP_MODE{
			public static final int ZN = 1;
			public static final int SVC_THEME = 2;
			public static final int UNIT_SVC = 3;
			
			public static final String ZN_STR = "znCd";
			public static final String SVC_THEME_STR = "svcThemeCd";
			public static final String UNIT_SVC_STR = "unitSvcCd";
			
			private GROUP_MODE (){}
		}
	}
	 
	
	public static class CACHE_NAME{
		public static final String ZN_INFO = "znInfoCache";
		public static final String SVC_THEME_INFO = "svcThemeInfoCache";
		public static final String UNIT_SVC_INFO = "UnitSvcInfoCache";
		public static final String MAIN_POS_INFO = "MainPosInfoCache";
		private CACHE_NAME (){}
	}
	
	// Noti Media Type
	public static class NOTI_MEDIA_TYP{
		public static final String SMS 		= "SMS";
		public static final String FAX 		= "FAX";
		public static final String EMAIL 	= "EMAIL";
		private NOTI_MEDIA_TYP (){}
	}
	
	// 메시지 교환 방식
	public static class MSG_EXCH_PTRN{
		public static final String ONE_WAY 			= "1";	
		public static final String ONE_WAY_ACK 		= "2";
		public static final String ACK 				= "3";
		private MSG_EXCH_PTRN (){}
	}
	
	public static class COMMAND{
		public static final String LIST = "LIST";
		public static final String OPEN = "OPEN";
		private COMMAND (){}
	}
	
	public static class API_FORMAT{
		public static final String JSON = "JSON";
		public static final String XML = "XML";
		private API_FORMAT (){}
	}
	
	public static class API_CODE{
		public static final String SUCCESS = "2000";
		public static final String DATA_EMPTY = "2001";
		public static final String FAIL = "2002";
		public static final String CMD_NOT_FOUND = "2003";
		public static final String FORMAT_NOT_FOUND="2004";
		public static final String ID_NOT_FOUND="2005";
		public static final String ID_NOT_EXSIT="2006";
		private API_CODE (){}
	}
	
	public static class GROUP_CD {
		public static final String MSG_TYP_CD		 		= "G001";
		public static final String MSG_ITEM_TYP_CD 			= "G002";
		
		public static final String ERR_CLFY		 			= "G005";
		public static final String CLS_TYP					= "G006";

		public static final String WIDGET_GD_CD 			= "UXP_G_001";
		
		public static final String PROC_ST					= "G202";
		public static final String FAC_EVET_PROC_ST			= "G204";
		
		public static final String BLNG_TYP_CD	 			= "G301";
		public static final String MEDIA_TYP_CD	 			= "G302";
		public static final String EXEC_RSLT_CD	 			= "G303";
		private GROUP_CD (){}
	}
	
	public static class STAT_EVET_PROC_ST {
		public static final String OUTB			= "1";
		public static final String ORDR			= "2";
		public static final String ACTN			= "3";
		public static final String CLR			= "4";
		public static final String CLS			= "5";
		private STAT_EVET_PROC_ST (){}
	}
	
	// Media Type
	public static class MEDIA_TYP_CD{
		public static final String SMS 		= "1";
		public static final String FAX 		= "2";
		public static final String EMAIL 	= "3";
		private MEDIA_TYP_CD (){}
	}
	
	public static class RESULT{
		public static final String RESULT_SUCCESS = "SUCCESS";
		public static final String RESULT_FAIL = "FAIL";
		public static final String RESULT_OK = "OK";
		private RESULT (){}
	}
	
	public static class PROPERTIES {
		public static final String LANG_CODE = "langCode";
		public static final String OMS_SERVER_URL = "oms.server.url";
		public static final String OMS_USER_INFO_URL = "oms.user.info.url";
		public static final String OMS_USER_LOGOUT_URL = "oms.user.logout.url";
		public static final String OMS_USER_SYS_LIST = "oms.user.sys.list";
		public static final String OMS_CHK_TOKEN_ALIVE = "oms.chk.token.alive";
		private PROPERTIES (){}
		
	}
}

