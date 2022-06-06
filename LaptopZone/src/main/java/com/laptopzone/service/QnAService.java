package com.laptopzone.service;

import java.util.ArrayList;

import com.laptopzone.dao.QnADao;
import com.laptopzone.dto.QnADto;

public class QnAService {

	//QnA 목록
	public ArrayList<QnADto> getQnaList(){
		return new QnADao().qnaList();
	}
	
	//QnA 조회
	public QnADto getSelectQnA(int qnaNum) {
		QnADto dto = new QnADao().selectQnA(qnaNum, true);
		dto.setQnaTitle(dto.getQnaTitle().replace(" ", "&nbsp;"));
		dto.setQnaContent(dto.getQnaContent().replace(" ", "&nbsp;").replace("\n", "<br>"));
		
		return dto;
	}
	
	//QnA 작성페이지
	public QnADto getSelectQnaUpate(int qnaNum) {
		return new QnADao().selectQnA(qnaNum, false);
	}
	
	//QnA 작성
	public void getInsertQnA(String qnaTitle, String qnaWriter, String qnaContent) {
		QnADto dto = new QnADto();
		dto.setQnaTitle(qnaTitle);
		dto.setQnaWriter(qnaWriter);
		dto.setQnaContent(qnaContent);
		
		new QnADao().insertQnA(dto);
	}
	
	//QnA 수정
	public void getUpdateQnA(int qnaNum, String qnaTitle, String qnaContent) {
		QnADto dto = new QnADto();
		dto.setQnaNum(qnaNum);
		dto.setQnaTitle(qnaTitle);
		dto.setQnaContent(qnaContent);
		
		new QnADao().updateQnA(dto);
	}
	
	//QnA 삭제
	public void getDeleteQnA(int qnaNum) {
		new QnADao().deleteQnA(qnaNum);
	}
	
	//QnA 답글 작성
	public void getInsertReply(int parentNum, String qnaTitle, String qnaWriter, String qnaContent) {
		QnADto dto = new QnADto();
		dto.setParentNum(parentNum);
		dto.setQnaTitle(qnaTitle);
		dto.setQnaWriter(qnaWriter);
		dto.setQnaContent(qnaContent);
		
		new QnADao().insertReply(dto);
	}
	
}
