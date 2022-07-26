package com.example.daoexam.main;


import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.daoexam.config.ApplicationConfig;
import com.example.daoexam.dao.RoleDao;
import com.example.daoexam.dto.Role;

public class SelectAllTest {

	public static void main(String[] args) {
		ApplicationContext ac
			=new AnnotationConfigApplicationContext(
					ApplicationConfig.class);
		RoleDao roleDao=ac.getBean(RoleDao.class);
		
//		for(int i=0;i<30;i++) {
//			Role role1=new Role();
//			role1.setRoleId(300+i);
//			role1.setDescription("test"+i);
//			int count=roleDao.insert(role1);
//			System.out.println((count+i)+"건 입력하였습니다.");
//		}
		
		//한건 입력
//		Role role1=new Role();
//		role1.setRoleId(103);
//		role1.setDescription("bigdater");
//		int count=roleDao.insert(role1);
//		System.out.println(count+"건 입력하였습니다.");
		
		//수정
//		Role role2=new Role();
//		role2.setRoleId(103);
//		role2.setDescription("fullstack");
//		int uCount=roleDao.update(role2);
//		System.out.println(uCount+"건 수정하였습니다.");
		
		// 1 read
		
//		Role role3=roleDao.selectById(105);
//		if(role3!=null) {
//			System.out.println(role3);
//		}else {
//			System.out.println("찾을 수 없습니다.");
//		}
		
//		List<Role> list=roleDao.selectAll();
		//role_id->roleId 자동변환
//		for(Role role:list) {
//			System.out.println(role);
//		}
		
		int dCount=roleDao.deleteById(201);
		System.out.println(dCount+"건 삭제하였습니다.");
		
		//CRUD create, read, update, delete
	}
}
