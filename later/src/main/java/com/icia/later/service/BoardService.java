package com.icia.later.service;


import java.io.File;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.icia.later.dao.BoardDao;
import com.icia.later.dto.BoardDto;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BoardService {
	@Autowired
	private BoardDao bDao;
	
	public String insertBroad(List<MultipartFile> files, BoardDto board, HttpSession session, RedirectAttributes rttr) {
		log.info("insertBoard()");
		String msg = null;
		String view = null;
		String upFile = files.get(0).getOriginalFilename();
		
		try {
			if (!upFile.equals("")) {
				FileUpload(files, session, board);
			}
			bDao.insertBoard(board);
			view = "redirect:/";
			msg = "작성 성공";
		} catch (Exception e) {
			e.printStackTrace();
			view = "redirect:/";
			msg = "작성 실패";
		}
		rttr.addFlashAttribute("msg", msg);
		
		return view;
	}

	private void FileUpload(List<MultipartFile> files, HttpSession session, BoardDto board) throws Exception{
		log.info("fileUpload()");
		
		String sysname = null;
		String oriname = null;
		
		String realPath = session.getServletContext().getRealPath("/");
		log.info(realPath);
		realPath += "resources/upload/";
		File folder = new File(realPath);
		if(folder.isDirectory() == false) {
			folder.mkdir();
		}
		
		MultipartFile mf = files.get(0);
		oriname = mf.getOriginalFilename();
		
		sysname = System.currentTimeMillis() + oriname.substring(oriname.lastIndexOf("."));
		
		File file = new File(realPath + sysname);
		
		mf.transferTo(file);
		board.setBoardFile(sysname);
	}

}
