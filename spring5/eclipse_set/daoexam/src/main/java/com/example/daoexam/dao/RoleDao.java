package com.example.daoexam.dao;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.example.daoexam.dto.Role;
import static com.example.daoexam.dao.RoleDaoSqls.*;

@Repository //component service controller
public class RoleDao {
	
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<Role> rowMapper
		=BeanPropertyRowMapper.newInstance(Role.class);
	private SimpleJdbcInsert insertAction;
	
	public RoleDao(DataSource dataSource) {
		this.jdbc=new NamedParameterJdbcTemplate(dataSource);
		this.insertAction=new SimpleJdbcInsert(dataSource)
				.withTableName("role");
	}
	
	public List<Role> selectAll(){
		return jdbc.query(
				SELECT_ALL, 
				Collections.emptyMap(),
				rowMapper);
	}
	
	public int insert(Role role) {
		SqlParameterSource params=
				new BeanPropertySqlParameterSource(role);
		return insertAction.execute(params);
	}
	
	public int update(Role role) {
		SqlParameterSource params=
				new BeanPropertySqlParameterSource(role);
		return jdbc.update(UPDATE, params);
	}
	
	//int Integer
	public Role selectById(int roleId) {
		try {
			//?-와일드카드
			//int Integer->오토박싱 언박싱
			Map<String,?> params=
					Collections.singletonMap("roleId",roleId);
			return jdbc.queryForObject(
					SELECT_BY_ROLE_ID, params, rowMapper);
		}catch(EmptyResultDataAccessException e){
			return null;
		}
	}
	
	public int deleteById(Integer roleId) {
		Map<String,?> params=
				Collections.singletonMap("roleId",roleId);
		return jdbc.update(DELETE_BY_ROLE_ID, params);
	}
}
