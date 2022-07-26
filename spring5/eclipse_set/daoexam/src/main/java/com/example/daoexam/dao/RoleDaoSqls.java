package com.example.daoexam.dao;

public class RoleDaoSqls {
	//목록 조회
	public static final String SELECT_ALL=
			"select * from role";
	//수정
	public static final String UPDATE=
			"update role "
			+ "set description=:description "
			+ "where role_id=:roleId";
	//한개 조회
	public static final String SELECT_BY_ROLE_ID=
			"select * from role "
			+ "where role_id=:roleId;";
	//한개 삭제
	public static final String DELETE_BY_ROLE_ID=
			"delete from role "
			+ "where role_id=:roleId;";
}
