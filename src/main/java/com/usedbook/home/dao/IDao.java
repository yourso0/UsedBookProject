package com.usedbook.home.dao;

import java.util.List;

import com.usedbook.home.dto.BookGenreDto;
import com.usedbook.home.dto.BookNationDto;
import com.usedbook.home.dto.BooklistDto;
import com.usedbook.home.dto.BuyDto;
import com.usedbook.home.dto.Criteria;
import com.usedbook.home.dto.MemberDto;
import com.usedbook.home.dto.QBoardDto;


public interface IDao {
	
	//회원관리
	public int memberJoin(String mid, String mpw, String mname, String memail, String mphone, String maddress);//회원 가입 insert
	public int checkId(String mid);//아이디 존재여부 확인 select
	public int checkIdAndPW(String mid, String mpw);//아이디와 비밀번호의 존재 및 일치 여부 select
	public MemberDto getMemberInfo(String mid);//아이디로 조회하여 회원정보 가져오기 select.
	public void memberModify(String mid, String mpw, String mname, String memail, String mphone, String maddress);//회원 정보 수정 update
	
	//질문게시판
	public void writeQuestion(String qid, String qname, String qcontent, String qemail);//질문하기 insert
	public List<QBoardDto> questionList(Criteria cri);//질문게시판 리스트 가져오기 select
	public QBoardDto questionView(String qnum);//선택한 글 번호의 정보 가져오기 select
	public void questionModify(String qnum, String qname, String qcontent, String qemail);//해당 글번호로 조회하여 질문 수정 update
	public void questionDelete(String qnum);//글 삭제 delete
	public int boardAllCount();//게시판 총 글의 개수 가져오기
	
	//책 가져오기
	
	  public List<BooklistDto> Booklist();
      public BooklistDto BookView(String btitle);
      public void BookDT(String isbn , String btitle,String bimg, String bname, int bprice , String bstory, String bgenre);
 

	   
	// 책 구매
	public void buyBook(String sid, String sname, String sphone, String saddress, String stitle, String swriter,
				String sgenre, String sprice, String sisbn );
	
	// 내정보 구매 데이터 
	public List<BuyDto>probuy(String sid);
	public void buyDelete(int snum);// 삭제 delete
	
	
    public List<BooklistDto> BookNationView(String nation);
    public List<BooklistDto> BookGenreView(String bgenre);
    public List<BooklistDto> GenreBooklist();
    public List<BookGenreDto> GenreNamelist();
    public List<BookNationDto> NationList();


	
}
