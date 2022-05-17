package service;

import dto.CafeManagerDTO;
import dto.CafeMenuDTO;
import jdk.nashorn.api.scripting.ScriptObjectMirror;

import java.util.ArrayList;

public class CafeArrayList {
    // 파일에 넣을 배열 생성자 생성
	static ArrayList<CafeManagerDTO> memberList = new ArrayList<>();

	public static ArrayList<CafeManagerDTO> getMemberList() {
		return memberList;
	}

	static ArrayList<CafeMenuDTO> menuList = new ArrayList<>();

	public static ArrayList<CafeMenuDTO> getMenuList() {
		return menuList;
	}

}
