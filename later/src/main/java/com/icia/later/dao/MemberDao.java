package com.icia.later.dao;

import com.icia.later.dto.MemberDto;


public interface MemberDao {

	void insertMember(MemberDto member);

	void updateMember(MemberDto member);

	void deleteMember(int id);

	MemberDto login(MemberDto member);
	
}