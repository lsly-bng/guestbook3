package com.javaex.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.vo.GuestbookVo;
import com.javex.dao.GuestbookDao;

@Controller
public class GuestbookController {

	// field
	// constructor
	// method - g/s
	// method - general

	// addList (등록폼)
	@RequestMapping(value = "/addList", method = { RequestMethod.GET, RequestMethod.POST })
	public String addList(Model model) {

		System.out.println("GuestbookController>addList()");

		// DAO 통해서 리스트 출력
		GuestbookDao gbDao = new GuestbookDao();
		List<GuestbookVo> gbList = gbDao.getGbList();

		// DispatcherServlet에 데이터를 보냄
		model.addAttribute("gbList", gbList);

		return "/WEB-INF/views/addList.jsp";
	}

	// add (등록)
	@RequestMapping(value = "/add", method = { RequestMethod.GET, RequestMethod.POST })
	public String add(@ModelAttribute GuestbookVo gbVo) {

		System.out.println("GuestbookController>add()");

		// Dao 통해서 등록 메소드 가져오기
		GuestbookDao gbDao = new GuestbookDao();
		int count = gbDao.gbInsert(gbVo);
		System.out.println(count);

		return "redirect:/addList";
	}

	// deleteForm (삭제폼)
	@RequestMapping(value = "/deleteForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String deleteForm() {

		System.out.println("GuestbookController>deleteForm()");

		return "/WEB-INF/views/deleteForm.jsp";
	}

	// delete (삭제)
	@RequestMapping(value = "/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public String delete(@ModelAttribute GuestbookVo gbVo) {

		System.out.println("GuestbookController>delete()");

		// DAO 통해서 삭제 메소드 가져오기
		GuestbookDao gbDao = new GuestbookDao();
		int count = gbDao.gbDelete(gbVo);
		System.out.println(count);

		return "redirect:/addList";
	}

}
