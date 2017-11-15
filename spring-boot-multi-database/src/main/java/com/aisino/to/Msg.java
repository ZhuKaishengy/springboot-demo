package com.aisino.to;

import java.util.LinkedHashMap;
import java.util.Map;


/**
 * 
 * @ClassName: Msg
 * @Description: 封装响应信息，用于与客户端ajax
 * @author ZhuKaishengy
 * @date 2017年8月25日 下午12:03:22
 */
public class Msg {

	//响应状态码：1001成功，9999失败
	private String code;
	//响应消息
	private String msg;
	//封装后台结果的详细信息
	private Map<String, Object> extendMap = new LinkedHashMap<>();
	
	//支持链式风格编程，添加 到extendMap
	public Msg add(String str,Object obj){
		this.extendMap.put(str, obj);
		return this;
	}
	
	// 定义一个成功的快速返回
	public static Msg success(){
		Msg msg = new Msg();
		msg.setCode("1001");
		msg.setMsg("操作成功");
		return msg;
	}
	
//	定义一个失败的快速返回
	public static Msg fail(){
		Msg msg = new Msg();
		msg.setCode("9999");
		msg.setMsg("操作失败");
		return msg;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Map<String, Object> getExtendMap() {
		return extendMap;
	}
	public void setExtendMap(Map<String, Object> extendMap) {
		this.extendMap = extendMap;
	}
	
	
	
}
