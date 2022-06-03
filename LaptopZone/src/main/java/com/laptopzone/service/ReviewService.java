package com.laptopzone.service;

import java.util.ArrayList;
import com.laptopzone.dao.ReviewDao;
import com.laptopzone.dto.ReviewDto;


public class ReviewService {

	//리뷰 목록
	public ArrayList<ReviewDto> getReviewList(int productNum){
		return new ReviewDao().reviewList(productNum);
	}
	
	//리뷰 작성
	public void getInsertReview(int productNum, String reviewTitle, String reviewWriter, String reviewContent, String reviewImage) {
		ReviewDto dto = new ReviewDto();
		dto.setProductNum(productNum);
		dto.setReviewTitle(reviewTitle);
		dto.setReviewWriter(reviewWriter);
		dto.setReviewContent(reviewContent);
		dto.setReviewImage(reviewImage);
		
		new ReviewDao().insertReview(dto);	
	}
	
	//리뷰 조회
	public ReviewDto getSelectReview(int reviewNum) {
		ReviewDto dto = new ReviewDao().selectReview(reviewNum, true);
		dto.setReviewTitle(dto.getReviewTitle().replace(" ", "&nbsp;"));
		dto.setReviewContent(dto.getReviewContent().replace(" ", "&nbsp;").replace("\n", "<br>"));
		
		return dto;
	}
	
	//리뷰 작성 페이지
	public ReviewDto getSelectReviewUpdate(int reviewNum) {
		return new ReviewDao().selectReview(reviewNum, false);
	}
	
	//리뷰 수정
	
	public void getUpdateReview(int reviewNum, String reviewTitle, String reviewContent, String reviewImage) {
		ReviewDto dto = new ReviewDto();
		dto.setReviewNum(reviewNum);
		dto.setReviewTitle(reviewTitle);
		dto.setReviewContent(reviewContent);
		dto.setReviewImage(reviewImage);
		
		new ReviewDao().updateReview(dto);	
	}
	
	
}
