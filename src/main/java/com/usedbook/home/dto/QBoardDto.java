package com.usedbook.home.dto;


public class QBoardDto {
	
	private int qnum;//게시판 글 번호(기본키)
	private String qid;//글쓴이 아이디
	private String qname;//글쓴이 이름
	private String qcontent;//질문 내용
	private String qemail;//글쓴이 이메일
	private String qdate;//글 등록일시
	public QBoardDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public QBoardDto(int qnum, String qid, String qname, String qcontent, String qemail, String qdate) {
		super();
		this.qnum = qnum;
		this.qid = qid;
		this.qname = qname;
		this.qcontent = qcontent;
		this.qemail = qemail;
		this.qdate = qdate;
	}
	public int getQnum() {
		return qnum;
	}
	public void setQnum(int qnum) {
		this.qnum = qnum;
	}
	public String getQid() {
		return qid;
	}
	public void setQid(String qid) {
		this.qid = qid;
	}
	public String getQname() {
		return qname;
	}
	public void setQname(String qname) {
		this.qname = qname;
	}
	public String getQcontent() {
		return qcontent;
	}
	public void setQcontent(String qcontent) {
		this.qcontent = qcontent;
	}
	public String getQemail() {
		return qemail;
	}
	public void setQemail(String qemail) {
		this.qemail = qemail;
	}
	public String getQdate() {
		return qdate;
	}
	public void setQdate(String qdate) {
		this.qdate = qdate;
	}
	
	
	
}
