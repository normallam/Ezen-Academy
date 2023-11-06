package 이젠아카데미.controller;


import java.util.ArrayList;


import 이젠아카데미.model.dao.BoardDao;
import 이젠아카데미.model.dto.BoardDto;

public class BoardController {
	// 1. 싱글톤 객체 생성
	private static BoardController boardController = new BoardController();
	public static BoardController getInstance() {return boardController;}
	private BoardController () {}
	private int loginSession = 0; // 0: 로그인 안한상태 1이상 : 로그인된 회원의 번호
	public int getLoginSession() {return loginSession;} 
	
	// 2. 게시글 전체보기
	public ArrayList<BoardDto> boardPrint(){
		return BoardDao.getInstance().boardPrint();
	}
	// 3. 게시글 상세 보기
	public BoardDto boardView(int bno) {
		return BoardDao.getInstance().boardView(bno);
	}
	// 6. 내 게시물 수정
	public int boardUpdate(int bno, int sno, String title, String content) {
	    
	    
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
	// 글쓰기!!
	public boolean boardWrite(String title , String content) {
	      
	      // 1. 제목이 0글자이거나 50글자 이상이면 글 쓰기 실패
	      if(title.length()==0 || title.length()>50) {return false;}
	      
	      // 2. Dto[ 입력받은제목 , 입력받은내용 , 로그인된회원번호]
	      BoardDto boardDto = new BoardDto(loginSession , title,content  );   
	      return BoardDao.getInstance().boardWrite(boardDto);
	   }

	// 내글보기
	public ArrayList<BoardDto> myWriting() {
		
		return BoardDao.getInstance().myWriting(loginSession);
		
	}
	
	public int boardDelete(int bno) {
	    try {
	        // 게시글 정보 조회
	        BoardDto boardDto = boardView(bno);

	        // 게시글 작성자의 회원번호(sno) 확인
	        int authorSno = boardDto.getSno();

	        

	        // 게시글 작성자와 로그인 세션의 회원번호 비교
	        if (authorSno != loginSession) {
	            return 3; // 작성자가 아닌 경우 삭제 불가 상태 코드 반환
	        }

	        // 게시글 삭제 진행
	        boolean result = BoardDao.getInstance().boardDelete(bno);

	        // 삭제 결과에 따른 반환 코드 설정
	        if (result) {
	            return 1; // 삭제 성공 상태 코드 반환
	        } else {
	            return 2; // 삭제 실패 상태 코드 반환
	        }
	    } catch (NullPointerException e) {
	        return 4; // 게시글 번호가 없는 경우 오류 상태 코드 반환
	    }
	}
	
	
	public void attendanceView() {}
	
	public boolean information(String name,String phone) {
		
		int result= BoardDao.getInstance().information(name,phone);
		// 로그인 성공했을때 기록 하기 [ -로그인 이후 로그인된정보로 활동 ]
		if(result>=1) {this.loginSession=result;  return true;}
		else{return false;}	
	}
	
	
	
}

