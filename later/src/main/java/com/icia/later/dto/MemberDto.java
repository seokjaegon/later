package com.icia.later.dto;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Alias("member")
public class MemberDto {
	private Integer memberId;
	private String memberName;
	private String memberEmail;
	private String memberPass;
	private String memberPhone;
	private int snsFollower;
	private String snsLink;
	private String memberProfile;
	private String snsKind;
	
	
}