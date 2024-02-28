package com.icia.later.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.icia.later.dto.BoardDto;
import com.icia.later.dto.MemberDto;
import com.icia.later.dto.ReservationDto;
import com.icia.later.service.BoardService;
import com.icia.later.service.ReservationService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class CompanyController {
	@Autowired
	private BoardService bServ;
	@Autowired
	private ReservationService rServ;	
	
	//업체 상세페이지
	@GetMapping("companyDetail")
	public String companyDetail(Integer boardId, Model model) {
		log.info("companyDetail()");
		
		BoardDto board = bServ.getBoard(boardId);
		
		model.addAttribute("board", board);
		return "companyDetail";
	}
	
	// 모집글 페이지 이동
	@GetMapping("companyList")
	
	public String companyList(Integer pageNum, 
								Model model,
								HttpSession session,
								Integer customerId ) {		
		log.info("companyList()");
		
			 String view = bServ.getBoardListBycustomerId(pageNum, 
					 model,
					 session, 
					 customerId);
			    return view;
		}
	
	// 신청 예약페이지 이동
	@GetMapping("applyCompany")
	
	public String applyCompany(Integer pageNum, 
								Model model,
								HttpSession session,
								Integer memberId1 ) {		
		log.info("applyCompany()");
		
	    MemberDto member = (MemberDto) session.getAttribute("mLogin");

	    if (member != null) {

	        Integer memberId = member.getMemberId();
	        
			 String view = rServ.getBoardListBymemberId(pageNum, 
					 model,
					 session, 
					 memberId);
			    return view;
	} else{
			
	        return "redirect:/login"; // 로그인 페이지로 리다이렉트 예시
		
			}
		}
	
	// 업체를 신청한 회원을 보여주는 페이지
	@GetMapping("selectApply")
	public String selectApply(Model model, Integer boardId) {
		log.info("selectApply()");
		
		List<ReservationDto> rList = rServ.getReservationList(boardId);
		
		System.out.println(rList);
		
		model.addAttribute("rList", rList);
		
		
		return "selectApply";
	}
}
