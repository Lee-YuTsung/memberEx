package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.model.Member;

@Mapper
public interface MemberMapper {

	//create
	@Insert("insert into member(name, username, password, address, phone, mobile) "
			+ "values(#{name}, #{username}, #{password}, #{address}, #{phone}, #{mobile})")
	void add(Member m);
	
	//read
	@Select("select * from member where username = #{username} and password = #{password}")
	Member queryUser(String username, String password);
	
	@Select("select * from member")
	List<Member> queryAll();
	
	@Select("select * from member where id = #{id}")
	Member queryId(Integer id);
	
	@Select("select * from member where username = #{username}")
	Member queryUsername(String username);
	
	//update
	@Update("update set"
			+ "name = #{name}, password = #{password}, address = #{address}, phone = #{phone}"
			+ "where id = #{id}")
	void updateMember(Member m);
	
	//delete
	@Delete("delete member where id = #{id}")
	void deleteMember(Integer id);
}
