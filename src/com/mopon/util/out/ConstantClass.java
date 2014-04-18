/**
 * Copy Right Information   : Forsoft 
 * Project                  : ICS
 * JDK version used         : jdk1.6
 * Comments                 : 常量接口
 *                            Interface里的常量都是public static final的.
 * Version                  : 1.0
 * create date              : 2008.4.15
 * author                   ：
 * Modified by              ：ghc
*/
package com.mopon.util.out;


public interface ConstantClass {	
	
	//工程统一的磁盘文件路径规则：
	//工程统一的上传文件跟路径
//	public final static String UPLOAD_URL_BASE = "../webapps/hskkw-uploads/";  
	public final static String UPLOAD_URL_BASE = ConstantClass.UPLOAD_URL_HEAD + ConstantClass.GetFile_URL_BASE;  
	
	//为了照片的跨工程显示，对照片路径的跟路径做特殊处理，可能也包括如excel等文件的下载路径的问题
	public final static String GetFile_URL_BASE = "/upload/"; 
	
	//文件跨工程上传的相对跟路径
	public final static String UPLOAD_URL_HEAD = ".."; 

	//路径符号
	public final static String MyFile_Separator = "/"; 

	
	//常量
	String SESSION_OLDPATH = "oldpath";
	String SESSION_USERNAME = "username";
	String SESSION_RIGHT = "userright";
	String SESSION_OPER  = "oper";
	String SESSION_PATH  = "path";
	String SESSION_VIEWINFO = "viewinfo";    // 窗口显示信息
	String SESSION_AUTHEN_CODE = "authen_code";
	String PAGE_DEFAULT_VALUE = "1";
	String MAP_KEY_PAGE_DEFAULT = "default";
	String USER_PROVI_TYPE = "2";
	String USER_SUPPLY_TYPE = "3";
	int SESSION_TIME = 3600;
	int UNLOGIN_SESSION_TIME = 120;
	
	String NO_SESSION = "nosession";
	String NO_ACCESS = "noaccess";
	String NO_SESSION_AJAX = "nosessionajax";
	
	//
	String RQ_PER_PAGE = "per_page";
	String RQ_PER_DATA = "per_data";
	
	//JNDI
	String DSJNDI = "hsk";
	String SERVER_TYPE = "tomcat";
		
	//模块类型
	String MODULE_MOD = "00"; //是模块
	String MODULE_OPR = "01"; //是模块操作
	
	//根
	String TREE_ROOT = "11";
	boolean SYSTEM_OUT_PRINTLN = true; //输出打印开关。true打印，false关闭打印
	
	String ACTION_LIST = "list";
	String ACTION_CREATE = "create";
	String ACTION_SAVE = "save";
	String ACTION_DELETE = "delete";
	String ACTION_EDIT = "edit";
	String ACTION_READ = "read";
	String ACTION_UPDATA = "updata";
	String ACTION_BACK = "back";
	String ACTION_SUBJECT = "subject";
	String ACTION_AK = "ak";
	String ACTION = "action";
	/**
	 * add by jyf 调试工具 
	 * 
	 */
    String DEBUG_FINALGATEWAY="editFinalMachineIpGateway";//更改终端机IP，网关
    String DEBUG_JIZHONGMACHINE="editJizhongMachineIpPort";//更改集中器IP,端口
    String DEBUG_PHOTOTIME="editFinalMachinePhotoTime";//更改拍照周期
    String DEBUG_REFRESH="refresh";//刷新状态
    String DEBUG_CARPARKENABLE="editCarParkEnable";//设置车位使能
    String DEBUG_CARPARKTYPE="editCarParkType";//更改车位类型
    String DEBUG_CARPARKNUMBER="editCarParkNumber";//更改车位编号
    String DEBUG_CARPARKPICTURE="showCarPictures";//显示车位 图片
    
    String DEBUG_READ_FINAL_SINGAL="readFinalSingal";//显示终端机信号强度
    String DEBUG_READ_FINAL_VERSION="readFinalVersion";//读取终端机版本号
    String DEBUG_READ_SET_MACADDRESS="readSetMacAddr";//读取和设置mac地址
    String DEBUG_CHANGE_FIRST_NETWORK="changeFirstNetwork";//更改首选网络标示
    
    //条屏
    String DEBUG_SCREEN_PAR="parmeterSetup";//基础参数设置
    String DEBUG_SCREEN_STNADSEND="standDataSend";//标准数据发送
    String DEBUG_SCREEN_GROUP_ADDR_SET="groupAddrSet";//组地址设置
   
	public final static int CTR_SCR_NUM = 6;	//每个管理器预计绑定的条屏的数量
	public static String Excel_DIR = "excel";	//Excel文件存储位置
}
