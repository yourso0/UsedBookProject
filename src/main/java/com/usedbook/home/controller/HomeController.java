
package com.usedbook.home.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.usedbook.home.dao.IDao;
import com.usedbook.home.dto.BookGenreDto;
import com.usedbook.home.dto.BookNationDto;
import com.usedbook.home.dto.BooklistDto;
import com.usedbook.home.dto.BuyDto;
import com.usedbook.home.dto.Criteria;
import com.usedbook.home.dto.MemberDto;
import com.usedbook.home.dto.PageDto;
import com.usedbook.home.dto.QBoardDto;

@Controller
public class HomeController {
   
   @Autowired
   private SqlSession sqlSession;
   
   @RequestMapping(value = "/")
   public String home(Model model,  HttpServletRequest request,HttpSession session) {
      
      
      IDao dao = sqlSession.getMapper(IDao.class);
      
      if(session.getAttribute("genre")==null|| "".equals(session.getAttribute("genre"))&& session.getAttribute("nation")==null|| "".equals(session.getAttribute("nation"))) {
         
             List<BookGenreDto> genrename = dao.GenreNamelist();
             List<BookNationDto> nations = dao.NationList();
                session.setAttribute("nation", nations);
             session.setAttribute("genre", genrename);     	      

      }
      
      List<BooklistDto> booklist =  dao.Booklist();
      
 
      model.addAttribute("book", booklist);
      return "index";
   }
   
   @RequestMapping(value = "/index")
   public String index(Model model,  HttpServletRequest request,HttpSession session) {
	   IDao dao = sqlSession.getMapper(IDao.class);    
	   if(session.getAttribute("genre")==null|| "".equals(session.getAttribute("genre"))&& session.getAttribute("nation")==null|| "".equals(session.getAttribute("nation"))) {           
              List<BookGenreDto> genrename = dao.GenreNamelist();
              List<BookNationDto> nations = dao.NationList();
                 session.setAttribute("nation", nations);
              session.setAttribute("genre", genrename);
           }
	      
	      List<BooklistDto> booklist =  dao.Booklist();
	      
	 
	      model.addAttribute("book", booklist);
	      return "index";
   }
   
   @RequestMapping(value = "/profile")
   public String profile(HttpSession session, Model model,HttpServletRequest request) {
	   String sessionId = (String) session.getAttribute("memberId");

	      IDao dao = sqlSession.getMapper(IDao.class);
	      MemberDto memberDto = dao.getMemberInfo(sessionId);
	      List<BuyDto> buyDto = dao.probuy(sessionId);
	
	      model.addAttribute("memberDto", memberDto);
	      model.addAttribute("buyDto", buyDto);
      
      return "profile";
      
   }
   
   @RequestMapping(value = "/contact")
   public String contact(HttpSession session) {
      if(session.getAttribute("genre")==null|| "".equals(session.getAttribute("genre"))
            && session.getAttribute("nation")==null|| "".equals(session.getAttribute("nation"))) {
         IDao dao = sqlSession.getMapper(IDao.class);
            List<BookGenreDto> genrename = dao.GenreNamelist();
            List<BookNationDto> nation = dao.NationList();
               session.setAttribute("nation", nation);
            session.setAttribute("genre", genrename);
         }
      
      return "contact";
   }
   
   @RequestMapping(value = "/login")
   public String login(HttpSession session) {
      if(session.getAttribute("genre")==null|| "".equals(session.getAttribute("genre"))
            && session.getAttribute("nation")==null|| "".equals(session.getAttribute("nation"))) {
         IDao dao = sqlSession.getMapper(IDao.class);
            List<BookGenreDto> genrename = dao.GenreNamelist();
            List<BookNationDto> nation = dao.NationList();
               session.setAttribute("nation", nation);
            session.setAttribute("genre", genrename);
         }
      return "login";
   }
   
   @RequestMapping(value = "/join")
   public String join(HttpSession session) {
      if(session.getAttribute("genre")==null|| "".equals(session.getAttribute("genre"))
            && session.getAttribute("nation")==null|| "".equals(session.getAttribute("nation"))) {
         IDao dao = sqlSession.getMapper(IDao.class);
            List<BookGenreDto> genrename = dao.GenreNamelist();
            List<BookNationDto> nation = dao.NationList();
               session.setAttribute("nation", nation);
            session.setAttribute("genre", genrename);
         }
      
      return "join";
   }
   
   @RequestMapping(value = "/question")
   public String question(HttpSession session, Model model) {
      if(session.getAttribute("genre")==null|| "".equals(session.getAttribute("genre"))
            && session.getAttribute("nation")==null|| "".equals(session.getAttribute("nation"))) {
         IDao dao = sqlSession.getMapper(IDao.class);
            List<BookGenreDto> genrename = dao.GenreNamelist();
            List<BookNationDto> nation = dao.NationList();
               session.setAttribute("nation", nation);
            session.setAttribute("genre", genrename);
         }
         
      String sessionId = (String) session.getAttribute("memberId");
      String sessionName = (String) session.getAttribute("memberName");
      
      
      if(sessionId == null) {//로그인 상태 확인
         model.addAttribute("memberId", "GUEST");
      } else {
         model.addAttribute("memberId", sessionId);
         session.setAttribute("memberName", sessionName);
      }
      
      return "question";
   }
   
   @RequestMapping(value = "/joinOk")
   public String joinOk(HttpServletRequest request, HttpSession session, Model model) {
      if(session.getAttribute("genre")==null|| "".equals(session.getAttribute("genre"))
            && session.getAttribute("nation")==null|| "".equals(session.getAttribute("nation"))) {
         IDao dao = sqlSession.getMapper(IDao.class);
            List<BookGenreDto> genrename = dao.GenreNamelist();
            List<BookNationDto> nation = dao.NationList();
               session.setAttribute("nation", nation);
            session.setAttribute("genre", genrename);
         }
      
      String mid = request.getParameter("mid");
      String mpw = request.getParameter("mpw");
      String mname = request.getParameter("mname");
      String memail = request.getParameter("memail");
      String mphone = request.getParameter("mphone");
      String maddress = request.getParameter("maddress");
      
      IDao dao = sqlSession.getMapper(IDao.class);
      
      int joinFlag = dao.memberJoin(mid, mpw, mname, memail,mphone,maddress);
      //joinFlag가 1이면 회원가입 성공, 아니면 실패
      //System.out.println("가입성공여부:"+joinFlag);
      
      //가입하려는 아이디가 존재하는지 여부를 체크하는 메서드 삽입 예정
      
      if(joinFlag == 1) {//회원가입 성공시 바로 로그인 진행
         session.setAttribute("memberId", mid);
         session.setAttribute("memberName", mname);
         
         model.addAttribute("mname", mname);
         model.addAttribute("mid", mid);
         
         return "joinOk";
      } else { //회원가입 실패
         return "joinFail";
      }   
      
   }
   
   @RequestMapping(value = "/logout")
   public String logout(HttpSession session) {
      if(session.getAttribute("genre")==null|| "".equals(session.getAttribute("genre"))
            && session.getAttribute("nation")==null|| "".equals(session.getAttribute("nation"))) {
         IDao dao = sqlSession.getMapper(IDao.class);
            List<BookGenreDto> genrename = dao.GenreNamelist();
            List<BookNationDto> nation = dao.NationList();
               session.setAttribute("nation", nation);
            session.setAttribute("genre", genrename);
         }
      
      session.invalidate();
      
      return "redirect:index";
   }
   
   @RequestMapping(value = "/loginOk")
   public String loginOk(HttpServletRequest request, Model model, HttpSession session) {
      if(session.getAttribute("genre")==null|| "".equals(session.getAttribute("genre"))
            && session.getAttribute("nation")==null|| "".equals(session.getAttribute("nation"))) {
         IDao dao = sqlSession.getMapper(IDao.class);
            List<BookGenreDto> genrename = dao.GenreNamelist();
            List<BookNationDto> nation = dao.NationList();
               session.setAttribute("nation", nation);
            session.setAttribute("genre", genrename);
         }
      
      String mid = request.getParameter("mid");
      String mpw = request.getParameter("mpw");
      
      IDao dao = sqlSession.getMapper(IDao.class);
      
      int checkIdFlag =  dao.checkId(mid);
      //로그인하려는 아이디 존재시 1, 로그인하려는 아이디가 존재하지 않으면 0이 반환
      int checkIdPwFlag = dao.checkIdAndPW(mid, mpw);
      //로그인하려는 아이디와 비밀번호가 모두 일치하는 데이터가 존재하면 1 아니면 0이 반환      
      
      model.addAttribute("checkIdFlag", checkIdFlag);      
      model.addAttribute("checkIdPwFlag", checkIdPwFlag);
      
      if(checkIdPwFlag == 1) { //로그인 실행 
         
         session.setAttribute("memberId", mid);
         MemberDto memberDto = dao.getMemberInfo(mid);
         
         model.addAttribute("memberDto", memberDto);
         model.addAttribute("mid", mid);
      }
      
      
      return "loginOk";
   }
   
   @RequestMapping(value = "/memberModify")
   public String memberModify(Model model, HttpSession session) {
     
      
      String sessionId = (String) session.getAttribute("memberId");
      
      IDao dao = sqlSession.getMapper(IDao.class);
      
      MemberDto memberDto = dao.getMemberInfo(sessionId);
      
      model.addAttribute("memberDto", memberDto);
      
      return "memberModify";
   }
   
   @RequestMapping(value = "/memberModifyOk")
   public String memberModifyOk(HttpServletRequest request,  Model model,HttpSession session) {
      if(session.getAttribute("genre")==null|| "".equals(session.getAttribute("genre"))
            && session.getAttribute("nation")==null|| "".equals(session.getAttribute("nation"))) {
         IDao dao = sqlSession.getMapper(IDao.class);
            List<BookGenreDto> genrename = dao.GenreNamelist();
            List<BookNationDto> nation = dao.NationList();
               session.setAttribute("nation", nation);
            session.setAttribute("genre", genrename);
         }
      
      String mid = request.getParameter("mid");
      String mpw = request.getParameter("mpw");
      String mname = request.getParameter("mname");
      String memail = request.getParameter("memail");
      String mphone = request.getParameter("mphone");
      String maddress = request.getParameter("maddress");
      
      IDao dao = sqlSession.getMapper(IDao.class);
      
      dao.memberModify(mid, mpw, mname, memail, mphone, maddress);
      
      MemberDto memberDto = dao.getMemberInfo(mid);//수정된 회원정보 다시 가져오기
      
      model.addAttribute("memberDto", memberDto);//아하앟아
      
      return "memberModifyOk";
   }
   
   @RequestMapping(value = "/questionOk")
   public String questionOk(HttpServletRequest request,HttpSession session) {
      if(session.getAttribute("genre")==null|| "".equals(session.getAttribute("genre"))
            && session.getAttribute("nation")==null|| "".equals(session.getAttribute("nation"))) {
         IDao dao = sqlSession.getMapper(IDao.class);
            List<BookGenreDto> genrename = dao.GenreNamelist();
            List<BookNationDto> nation = dao.NationList();
               session.setAttribute("nation", nation);
            session.setAttribute("genre", genrename);
         }
      
      String qid = request.getParameter("qid");//글쓴유저 아이디
      String qname = request.getParameter("qname");//글쓴유저 이름
      String qcontent = request.getParameter("qcontent");//글쓴 질문 내용
      String qemail = request.getParameter("qemail");//글쓴유저 이메일
      
      IDao dao = sqlSession.getMapper(IDao.class);
      
      dao.writeQuestion(qid, qname, qcontent, qemail);
      
      return "redirect:list";
   }
   
   @RequestMapping(value = "list")
   public String list(Model model, Criteria cri, HttpServletRequest request,HttpSession session) {
      if(session.getAttribute("genre")==null|| "".equals(session.getAttribute("genre"))
            && session.getAttribute("nation")==null|| "".equals(session.getAttribute("nation"))) {
         IDao dao = sqlSession.getMapper(IDao.class);
            List<BookGenreDto> genrename = dao.GenreNamelist();
            List<BookNationDto> nation = dao.NationList();
               session.setAttribute("nation", nation);
            session.setAttribute("genre", genrename);
         }
      
      int pageNumInt = 0;
      if(request.getParameter("pageNum") == null) {
         pageNumInt = 1;
         cri.setPageNum(pageNumInt);
         
      } else {
         pageNumInt = Integer.parseInt(request.getParameter("pageNum"));
         cri.setPageNum(pageNumInt);
      }
      IDao dao = sqlSession.getMapper(IDao.class);
      
      int totalRecord = dao.boardAllCount();
      
      //cri.setPageNum();
      
      cri.setStartNum(cri.getPageNum()-1 * cri.getAmount());//해당 페이지의 시작번호를 설정
      
      PageDto pageDto = new PageDto(cri, totalRecord);
      
      List<QBoardDto> qboardDtos = dao.questionList(cri);
      
      model.addAttribute("pageMaker", pageDto);
      model.addAttribute("qdtos", qboardDtos);
      model.addAttribute("currPage", pageNumInt);
      
      return "questionList";
   }
   
   @RequestMapping(value = "/questionView")
   public String questionView(HttpServletRequest request, Model model,HttpSession session) {
      if(session.getAttribute("genre")==null|| "".equals(session.getAttribute("genre"))
            && session.getAttribute("nation")==null|| "".equals(session.getAttribute("nation"))) {
         IDao dao = sqlSession.getMapper(IDao.class);
            List<BookGenreDto> genrename = dao.GenreNamelist();
            List<BookNationDto> nation = dao.NationList();
               session.setAttribute("nation", nation);
            session.setAttribute("genre", genrename);
         }
      
      String qnum = request.getParameter("qnum");
      
      IDao dao = sqlSession.getMapper(IDao.class);
      
      QBoardDto qBoardDto = dao.questionView(qnum);
      
      model.addAttribute("qdto", qBoardDto);
      model.addAttribute("qid", qBoardDto.getQid());//글쓴 유저의 id값 전송
      
      return "questionView";
   }
   
   @RequestMapping(value = "/questionModify")
   public String questionModify(HttpServletRequest request, Model model,HttpSession session) {
      if(session.getAttribute("genre")==null|| "".equals(session.getAttribute("genre"))
            && session.getAttribute("nation")==null|| "".equals(session.getAttribute("nation"))) {
         IDao dao = sqlSession.getMapper(IDao.class);
            List<BookGenreDto> genrename = dao.GenreNamelist();
            List<BookNationDto> nation = dao.NationList();
               session.setAttribute("nation", nation);
            session.setAttribute("genre", genrename);
         }
      
      String qnum = request.getParameter("qnum");
      
      IDao dao = sqlSession.getMapper(IDao.class);
      
      QBoardDto qBoardDto = dao.questionView(qnum);
      
      model.addAttribute("qdto", qBoardDto);
      
      
      return "questionModify";
   }
   
   @RequestMapping(value = "/questionModifyOk")
   public String questionModifyOk(HttpServletRequest request,HttpSession session) {
      if(session.getAttribute("genre")==null|| "".equals(session.getAttribute("genre"))
            && session.getAttribute("nation")==null|| "".equals(session.getAttribute("nation"))) {
         IDao dao = sqlSession.getMapper(IDao.class);
            List<BookGenreDto> genrename = dao.GenreNamelist();
            List<BookNationDto> nation = dao.NationList();
               session.setAttribute("nation", nation);
            session.setAttribute("genre", genrename);
         }
      
      String qnum = request.getParameter("qnum");
      String qname = request.getParameter("qname");
      String qcontent = request.getParameter("qcontent");
      String qemail = request.getParameter("qemail");
      
      IDao dao = sqlSession.getMapper(IDao.class);
      
      dao.questionModify(qnum, qname, qcontent, qemail);
      
      return "redirect:list";
   }
   
   @RequestMapping(value = "/questionDelete")
   public String questionDelete(HttpServletRequest request,HttpSession session) {
      if(session.getAttribute("genre")==null|| "".equals(session.getAttribute("genre"))
            && session.getAttribute("nation")==null|| "".equals(session.getAttribute("nation"))) {
         IDao dao = sqlSession.getMapper(IDao.class);
            List<BookGenreDto> genrename = dao.GenreNamelist();
            List<BookNationDto> nation = dao.NationList();
               session.setAttribute("nation", nation);
            session.setAttribute("genre", genrename);
         }
      
      String qnum= request.getParameter("qnum");
      
      IDao dao = sqlSession.getMapper(IDao.class);
      
      dao.questionDelete(qnum);
      
      return "redirect:list";
   }

   
   @RequestMapping(value = "/BookDetails")
      public String BookView(HttpServletRequest request, Model model,HttpSession session) {
      if(session.getAttribute("genre")==null|| "".equals(session.getAttribute("genre"))
            && session.getAttribute("nation")==null|| "".equals(session.getAttribute("nation"))) {
         IDao dao = sqlSession.getMapper(IDao.class);
            List<BookGenreDto> genrename = dao.GenreNamelist();
            List<BookNationDto> nation = dao.NationList();
               session.setAttribute("nation", nation);
            session.setAttribute("genre", genrename);
         }
         
         String btitle = request.getParameter("btitle");
         
         IDao dao = sqlSession.getMapper(IDao.class);
         
         BooklistDto booklistdto = dao.BookView(btitle);
         
         if (booklistdto != null) {
             model.addAttribute("Bdto", booklistdto);
             model.addAttribute("btitle", booklistdto.getBtitle());
         } else {
             // handle the case when the book is not found
         }
         return "BookDetails";
      }
         
   @RequestMapping(value = "/AllBook")
   public String AllBook(Model model,  HttpServletRequest request,HttpSession session) {
      if(session.getAttribute("genre")==null|| "".equals(session.getAttribute("genre"))
            && session.getAttribute("nation")==null|| "".equals(session.getAttribute("nation"))) {
         IDao dao = sqlSession.getMapper(IDao.class);
            List<BookGenreDto> genrename = dao.GenreNamelist();
            List<BookNationDto> nation = dao.NationList();
               session.setAttribute("nation", nation);
            session.setAttribute("genre", genrename);
         }
      
      
      IDao dao = sqlSession.getMapper(IDao.class);
   
      List<BooklistDto> booklist =  dao.Booklist();
      
      model.addAttribute("book", booklist);
      
      return "AllBook";
   }
   
      @RequestMapping(value = "/NationBook")
      public String NationBook(Model model, Criteria cri, HttpServletRequest request,HttpSession session) {
         if(session.getAttribute("genre")==null|| "".equals(session.getAttribute("genre"))
               && session.getAttribute("nation")==null|| "".equals(session.getAttribute("nation"))) {
            IDao dao = sqlSession.getMapper(IDao.class);
               List<BookGenreDto> genrename = dao.GenreNamelist();
               List<BookNationDto> nation = dao.NationList();
                  session.setAttribute("nation", nation);
               session.setAttribute("genre", genrename);
               
            }
        String nation = request.getParameter("nation");
              
         IDao dao = sqlSession.getMapper(IDao.class);
         
         List<BooklistDto> booklistdto = dao.BookNationView(nation);
         
         
         model.addAttribute("nation", booklistdto);
        
         return "NationBook";
      }
         
      @RequestMapping(value = "/BuyBook")
      public String BuyBook(HttpSession session, Model model,HttpServletRequest request ,HttpServletResponse response) {
         
         String sessionId = (String) session.getAttribute("memberId");
         String btitle = request.getParameter("btitle");
         


         if(sessionId == null) {//로그인 상태 확인
            try {
               ScriptUtils.alertAndBackPage(response, "로그인후 이용해주세요.");
            } catch (IOException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
            }
         } else {
            
            IDao dao = sqlSession.getMapper(IDao.class);
            MemberDto memberDto = dao.getMemberInfo(sessionId);
            BooklistDto booklistdto = dao.BookView(btitle);
            model.addAttribute("memberDto", memberDto);
            model.addAttribute("Bdto", booklistdto);
         }
         
               
         return "BuyBook";
      }
      @RequestMapping(value = "/GenreBook")
      public String GenreBook(Model model, Criteria cri, HttpServletRequest request,HttpSession session) {
         if(session.getAttribute("genre")==null|| "".equals(session.getAttribute("genre"))&& session.getAttribute("nation")==null|| "".equals(session.getAttribute("nation"))) {
            IDao dao = sqlSession.getMapper(IDao.class);
               List<BookGenreDto> genrename = dao.GenreNamelist();
               List<BookNationDto> nations = dao.NationList();
                  session.setAttribute("nation", nations);
               session.setAttribute("genre", genrename);
            }
        String booknum = request.getParameter("bgenre");
              
         IDao dao = sqlSession.getMapper(IDao.class);
         
         List<BooklistDto> booklistdto = dao.BookGenreView(booknum);
         
         
         model.addAttribute("genrebook", booklistdto);
        
         return "GenreBook";
      }
      
      @RequestMapping(value = "/buyOk")
      public String buyOk(HttpServletRequest request ,HttpSession session, Model model) {
         
         String sid = request.getParameter("sid");
         String sname = request.getParameter("sname");
         String sphone = request.getParameter("sphone");
         String saddress = request.getParameter("saddress");
         String stitle = request.getParameter("stitle");
         String swriter = request.getParameter("swriter");
         String sgenre = request.getParameter("sgenre");
         String sprice = request.getParameter("sprice");
         String sisbn = request.getParameter("sisbn");
         
         
         
         IDao dao = sqlSession.getMapper(IDao.class);
         
         dao.buyBook(sid, sname , sphone , saddress ,stitle,swriter,sgenre,sprice, sisbn );
         
         return "redirect:index";
      }
      
      @RequestMapping(value = "/buydelete")
      public String buydelete(HttpServletRequest request) {
         
         int snum= Integer.parseInt(request.getParameter("snum"));
         
         IDao dao = sqlSession.getMapper(IDao.class);
         
         dao.buyDelete(snum);
         
         return "redirect:profile";
      }
      
      
}