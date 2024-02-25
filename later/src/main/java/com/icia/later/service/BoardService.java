package com.icia.later.service;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.icia.later.dao.BoardDao;
import com.icia.later.dto.BoardDto;
import com.icia.later.dto.CustomerDto;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BoardService {
	@Autowired
	private BoardDao bDao;

	public String insertBoard(List<MultipartFile> files, BoardDto board, HttpSession session,
			RedirectAttributes rttr) {
		log.info("insertBoard()");
		String msg = null; // DB에 저장 성공/실패 관련 메세지 저장
		String view = null;// 대상 페이지 지정 변수
		String upFile = files.get(0).getOriginalFilename();
		// 업로드하는 파일의 이름을 추출.

		try {
			if (!upFile.equals("")) {
				FileUpload(files, session, board);
			}
			bDao.insertBoard(board);
			view = "redirect:/";
			msg = "작성 성공";
		} catch (Exception e) {// 저장 실패인 경우
			e.printStackTrace();
			view = "redirect:/";
			msg = "작성 실패";
		}
		rttr.addFlashAttribute("msg", msg);

		return view;
	}

	private void FileUpload(List<MultipartFile> files, HttpSession session, BoardDto board) throws Exception {
		log.info("fileUpload()");

		String sysname = null;// 변경하는 파일명
		String oriname = null;// 원래 파일명

		String realPath = session.getServletContext().getRealPath("/");
		log.info(realPath);
		realPath += "resources/upload/";
		File folder = new File(realPath);
//isDirectory() : 해당 이름이 폴더가 아니거나 존재하지않으면 false
		if (folder.isDirectory() == false) {
			folder.mkdir();// 폴더생성 메소드
		}

		MultipartFile mf = files.get(0);
		oriname = mf.getOriginalFilename();

		sysname = System.currentTimeMillis() + oriname.substring(oriname.lastIndexOf("."));

		File file = new File(realPath + sysname);

		mf.transferTo(file); // 하드디스크(경로상의 폴더)에 저장
		board.setBoardFile(sysname);
	}

	public String boardUpdate(List<MultipartFile> files, BoardDto board,  HttpSession session, RedirectAttributes rttr) {
		
		log.info("boardUpdate()");
		String msg = null;
		String view = null;
		String poster = board.getBoardFile();// 기존파일(포스터)
		
		try {
			if (!files.get(0).isEmpty()) {
				FileUpload(files, session, board);

				// 기존파일 삭제
				if (poster != null) {
					FileDelete(poster, session);
				}
			}
			bDao.updateBoard(board);
			System.out.println("mServ" + board);

			view = "redirect:/"; // + member.getMemberId();
			msg = "수정 성공";
			// 기존 파일 삭제
		} catch (Exception e) {
			e.printStackTrace();
			view = "redirect:mUpdate?memberId=" + board.getBoardId();
			msg = "수정 실패";
		}

		rttr.addFlashAttribute("msg", msg);
		return view;
	}

	private void FileDelete(String poster, HttpSession session) {
		// TODO Auto-generated method stub
		
	}
	//수정할 업체정보 가져오기
	public void getBoard(Integer boardId, Model model) {
		log.info("getBoard()");
		
		boardId = 4;
		
		BoardDto board = bDao.selectBoard(boardId);
		
		model.addAttribute("board", board);
	}

	public List<BoardDto> getBoardList() {
		
		List<BoardDto> bList = bDao.getBoardList();
		
		return bList;
	}

}