package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Member;

public interface MemberDao {

	//create
	void add(Member m);
	
	//read
	List<Member> queryAll();
	Member queryId(Integer id);
	Member queryUser(String username, String password);
	Boolean queryUsername(String username);
	
	//update
	void update(Member m);
	
	//delete
	void delete(Integer id);
	
}
