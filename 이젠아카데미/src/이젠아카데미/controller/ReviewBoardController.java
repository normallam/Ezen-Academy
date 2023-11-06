package 이젠아카데미.controller;

import java.util.ArrayList;

import 이젠아카데미.model.dao.BoardDao;
import 이젠아카데미.model.dao.LessonDao;
import 이젠아카데미.model.dao.ReviewBoardDao;
import 이젠아카데미.model.dto.BoardDto;
import 이젠아카데미.model.dto.EmployeeDto;
import 이젠아카데미.model.dto.LessonDto;
import 이젠아카데미.model.dto.ReviewBoardDto;

public class ReviewBoardController {

	private static ReviewBoardController ReviewBoardController= new ReviewBoardController();
	public static ReviewBoardController getInstance() { return ReviewBoardController; }
	private ReviewBoardController() {}
	private int loginSession = 0; // 0: 로그인 안한상태 1이상 : 로그인된 회원의 번호
	public int getLoginSession() {return loginSession;} 
	
	
// 1. 글쓰기-----------------------------------------------------------------

	public boolean reviewWrite(String rtitle, String rcontent, int rgrade) {
			
		// 1. 제목이 0글자이거나 50글자 이상이면 글 쓰기 실패
		if(rtitle.length()==0|| rtitle.length()>50) {return false;}
		
		ReviewBoardDto reviewBoardDto = new ReviewBoardDto(rtitle, rcontent, rgrade); //loginSession 넣어야할지 말아야할지
		return ReviewBoardDao.getInstance().reviewWrite(reviewBoardDto);

			
	}

		
// 2. 글 전체조회-----------------------------------------------------------------	

	public ArrayList<ReviewBoardDto> reviewTotalView() {
		
		return ReviewBoardDao.getInstance().reviewTotalView();
			
	}
		
		
// 3. 내글 조회-----------------------------------------------------------------

	public ArrayList<ReviewBoardDto> reviewIndividualView() {
		
		return ReviewBoardDao.getInstance().reviewIndividualView(loginSession);
		

	}
		
		
// 4. 글 수정-----------------------------------------------------------------
/*
	public int reviewUpdate(int rno, int sno, String rtitle, String rcontent) {
	
		int loginUserSno = loginSession;
		
		ReviewBoardDto reviewBoardDto = ReviewBoardDao.getInstance().reviewIndividualView(rno);
		
			if(reviewBoardDto != null) {
				int WriterSno = ReviewBoardDto.getSno();
				
				if(sno != WriterSno ) {
					return 3;
				}
				
				if(rtitle.length() < 1 || rtitle.length() > 50) {
					return 4;
				}
				
				reviewBoardDto.setRtitle(rtitle);
				reviewBoardDto.setRcontent(rcontent);
				
				boolean result = ReviewBoardDao.getInstance().reviewUpdate(reviewBoardDto);
				
				if(result) {return 1;}
				else {return 2;}
				
			}*/
		
	/*
	 	// 6. 내 게시물 수정
	public int boardUpdate(int bno, int sno, String title, String content) {
	    // 로그인한 사용자의 회원번호 가져오기
	    int loggedInUserSno = loginSession;
	    
	    // 게시글 정보 가져오기
	    BoardDto boardDto = BoardDao.getInstance().boardView(bno);
	    
	    if (boardDto != null) {
	        int authorSno = boardDto.getSno(); // 게시글 작성자의 회원번호
	        
	        // 본인 글인지 확인
	        if (sno != authorSno) {
	            return 3; // 본인 글이 아닌 경우
	        }
	        
	        // 제목 글자 수 체크
	        if (title.length() < 1 || title.length() > 50) {
	            return 4; // 제목 글자 수 오류
	        }
	        
	        // 게시글 수정
	        boardDto.setBtitle(title);
	        boardDto.setBcontent(content);
	        
	        boolean result = BoardDao.getInstance().boardUpdate(boardDto);
	        
	        if (result) {
	            return 1; // 성공
	        } else {
	            return 2; // 실패
	        }
	    }
	    
	    return 2; // 게시글 정보가 없는 경우
	}
	 */
		
		
//	}
		
		
// 5. 글 삭제 -----------------------------------------------------------------
		
	public void reviewDelete() {
			
			
	}
		
}
