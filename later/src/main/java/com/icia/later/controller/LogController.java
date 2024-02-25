package com.icia.later.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.icia.later.dto.MemberDto;
import com.icia.later.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class LogController {
	@Autowired
	private MemberService mServ;
	
	// �α��� ���� ������ �̵�
	@GetMapping("loginSelect") 
		public String loginSelect(){
		log.info("loginSelect()");
		
		return "loginSelect";
	}
	
	// �α��������� �̵�
		@GetMapping("mLogin")
		public String mLogin() {
			log.info("mLogin()");
			
			return "mLogin";
		}
		
		// �α��� ó�� �޼���
		@PostMapping("loginCheck")
		public String loginCheck(MemberDto member,
								HttpSession session,
								RedirectAttributes rttr) {
			log.info("loginCheck()");
			System.out.println(member);
			
			String view = mServ.login(member, session, rttr);
			return view;
		}
		
		// �α׾ƿ� 
		@GetMapping("mLogout")
		public String logout(HttpServletRequest request, RedirectAttributes rttr) {
		    log.info("mLogout()");
		    String msg = null;

		    HttpSession session = request.getSession(false); // false �÷��״� ���ο� ������ �������� �ʵ��� �մϴ�.

		    if (session != null && session.getAttribute("mLogin") != null) {
		        // ������ ������� ���� �� �α׾ƿ� ó��
		        session.invalidate();
		        System.out.println(session);
		        msg = "�α׾ƿ� �Ǿ����ϴ�. �����մϴ�.";
		        
		    } else {
		        // �̹� �α׾ƿ� �Ǿ��ְų� ������ ���� ���
		    	System.out.println(session);
		    	msg = "�̹� �α׾ƿ� �Ǿ� �ֽ��ϴ�.";
		        
		    }

		    rttr.addFlashAttribute("msg", msg);
		    return "redirect:/";
		}
		
		// �α׾ƿ� 
				@GetMapping("cLogout")
				public String cLogout(HttpServletRequest request, RedirectAttributes rttr) {
				    log.info("cLogout()");
				    String msg = null;

				    HttpSession session = request.getSession(false); // false �÷��״� ���ο� ������ �������� �ʵ��� �մϴ�.

				    if (session != null && session.getAttribute("cLogin") != null) {
				        // ������ ������� ���� �� �α׾ƿ� ó��
				        session.invalidate();
				        System.out.println(session);
				        msg = "�α׾ƿ� �Ǿ����ϴ�. �����մϴ�.";
				        
				    } else {
				        // �̹� �α׾ƿ� �Ǿ��ְų� ������ ���� ���
				    	System.out.println(session);
				    	msg = "�̹� �α׾ƿ� �Ǿ� �ֽ��ϴ�.";
				        
				    }

				    rttr.addFlashAttribute("msg", msg);
				    return "redirect:/";
				}
}
