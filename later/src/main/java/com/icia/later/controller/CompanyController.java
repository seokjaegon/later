package com.icia.later.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.icia.later.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class CompanyController {
	@Autowired
	private BoardService bServ;
	// ��ü ��������
		@GetMapping("companyDetail")
		public String companyDetail(Integer boardId, Model model) {
			log.info("companyDetail()");

			bServ.getCompanyDetail(boardId, model);
			System.out.println(model);
			// model.addAttribute(model);

			return "companyDetail";
		}
}
