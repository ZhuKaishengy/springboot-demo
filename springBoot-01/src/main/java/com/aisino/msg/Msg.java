package com.aisino.msg;

import java.util.HashMap;
import java.util.Map;

public class Msg {

	private String code;
	
	private String msg;
	
	private Map<String, Object> extendMap = new HashMap<String, Object>();
	
	private Msg(String code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}

	public static Msg success(){
		return new Msg("1001","操作成功");
	}
	public static Msg fail(){
		return new Msg("9999","操作失败");
	}
	public Msg add(String str , Object obj){
		this.extendMap.put(str, obj);
		return this;
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
