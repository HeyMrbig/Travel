package min.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import min.bbs.model.BbsDAO;
import min.bbs.model.BbsDTO;

@Controller
public class BbsController {

	@Autowired
	private BbsDAO bbsDao;

	@RequestMapping("/bbs.do")
	public ModelAndView bbsMain(@RequestParam(value = "cp", defaultValue = "1") int cp) {

		int totalCnt = bbsDao.getTotalCnt();
		int listSize = 5;
		int pageSize = 5;

		ModelAndView mav = new ModelAndView();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("cp", cp);
		map.put("ls", listSize);
		List<BbsDTO> list = bbsDao.bbsList(cp, listSize);
		mav.addObject("list", list);
		String pageStr = min.page.pageModule.makePage("bbs.do", totalCnt, listSize, pageSize, cp);
		mav.addObject("pageStr", pageStr);
		mav.setViewName("bbs/bbs");
		return mav;
	}

	@RequestMapping(value = "/bbsWrite.do", method = RequestMethod.GET)
	public String bbsWrite() {
		return "bbs/bbsWrite";
	}

	@RequestMapping(value = "/bbsWrite.do", method = RequestMethod.POST)
	public ModelAndView bbsWriteSubmit(BbsDTO dto) {
		ModelAndView mav = new ModelAndView();
		int result = bbsDao.bbsWrite(dto);
		String msg = result > 0 ? "작성 완료" : "작성 실패";
		mav.addObject("msg", msg);
		mav.addObject("gopage", "bbs.do");
		mav.setViewName("bbs/Msg");
		return mav;
	}

	@RequestMapping("/bbsContent.do")
	public ModelAndView bbsContent(@RequestParam("idx") int idx) {
		ModelAndView mav = new ModelAndView();
		BbsDTO dto = bbsDao.bbsContent(idx);
		if (dto == null) {
			mav.addObject("msg", "잘못된 접근 또는 삭제된 게시글입니다.");
			mav.addObject("gopage", "bbs.do");
			mav.setViewName("bbs/Msg");
		} else {
			dto.setContent(dto.getContent().replaceAll("\n", "<br>"));
			mav.addObject("dto", dto);
			mav.setViewName("bbs/bbsContent");
		}
		return mav;
	}
	
	@RequestMapping(value = "/bbsReWrite.do", method = RequestMethod.GET)
	public ModelAndView bbsReWriteForm(BbsDTO dto) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("dto", dto);
		mav.setViewName("bbs/bbsReWrite");
		return mav;
	}
	
	@RequestMapping(value = "/bbsReWrite.do", method = RequestMethod.POST)
	public ModelAndView bbsReWrite(BbsDTO dto) {
		System.out.println("ref : " + dto.getRef());
		int result = bbsDao.bbsReWrite(dto);
		ModelAndView mav = new ModelAndView();
		String msg = result > 0 ? "답글 작성완료" : "답글 작성실패";
		mav.addObject("msg", msg);
		mav.addObject("gopage", "bbs.do");
		mav.setViewName("bbs/Msg");
		return mav;
	}
}
