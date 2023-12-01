package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.MemberMapper;
import com.example.demo.model.Member;
import com.example.demo.service.MemberDao;

@Service
public class MemberDaoImpl implements MemberDao{

	@Autowired
	MemberMapper mm;
	
	@Override
	public void add(Member m) {
		// TODO Auto-generated method stub
		if(mm.queryUsername(m.getUsername()) == null) {
			mm.add(m);
		}
	}

	@Override
	public List<Member> queryAll() {
		// TODO Auto-generated method stub
		return mm.queryAll();
	}

	@Override
	public Member queryId(Integer id) {
		// TODO Auto-generated method stub
		return mm.queryId(id);
	}

	@Override
	public Member queryUser(String username, String password) {
		// TODO Auto-generated method stub
		return mm.queryUser(username, password);
	}

	@Override
	public Boolean queryUsername(String username) {
		// TODO Auto-generated method stub
		//true 為存在，false 為不存在
		return mm.queryUsername(username) != null;
	}

	@Override
	public void update(Member m) {
		// TODO Auto-generated method stub
		if(mm.queryId(m.getId()) != null) {
			mm.updateMember(m);
		}
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		if(mm.queryId(id) != null) {
			mm.deleteMember(id);
		}
	}

}
