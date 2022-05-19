package com.example.taegyungsite.service;

import com.example.taegyungsite.dao.BoardDao;
import com.example.taegyungsite.model.BoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * packageName : com.example.taegyungsite.service
 * fileName : BoardServiceImpl
 * author : ds
 * date : 2022-05-18
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-18         ds          최초 생성
 */
// @Service : 스프링에 객체로 생성되는 어노테이션
@Service
public class BoardServiceImpl implements BoardService {

//   @Autowired : 아래 멤버변수에 스프링의 객체를 넣어줌
    @Autowired
    private BoardDao boardDao; // 객체 생성이 안되고 정의

//    게시판에 Idx(글번호)가 없으면 insert 문 실행 (사용자가 새글쓰기 버튼을 클릭 )
//    글번호가 있으면 update문 실행( 사용자가 글목록 버튼을 클릭 + 수정버튼 클릭 )
    @Override
    public boolean registerBoard(BoardDto params) {

//        insert 또는 update 결과를 저장하는 변수
//        위의 sql문이 정상수행되면 : 1 아니면 다른 값
        int queryResult = 0;

        System.out.println(" Service params : " + params);
        if(params.getIdx() == null) {
//            새글 쓰기 ( insert 문 실행 )
            System.out.println(" Service params 2 : " + params);
            queryResult = boardDao.insertBoard(params);
        } else {
//            상세 목록에서 글 수정 ( update 문 실행 )
            queryResult = boardDao.updateBoard(params);
        }

        return (queryResult == 1) ? true : false;
    }

    @Override
    public BoardDto getBoardDetail(Long idx) {
//        글번호(idx)에 해당하는 상세 목록 보기 ( select 문 실행 : 1건 )
        return boardDao.selectBoardDetail(idx);
    }

//    전체 게시물 select 하는 서비스
    @Override
    public List<BoardDto> getBoardAllList() {
        List<BoardDto> boardList = Collections.emptyList();

//        select( 전체 게시물 ) 문 실행
        boardList = boardDao.selectBoardAllList();

        return boardList;
    }

//    게시판 번호를 받아서 게시물을 삭제하는 서비스
    @Override
    public boolean deleteBoard(Long idx) {

        int queryResult = 0;

//        게시물이 있는지 확인 하는 절차 ( Select : 1건 )
//        게시물이 있으면 board != null
        BoardDto board = boardDao.selectBoardDetail(idx);

//        Delete_Yn : "N" 일때만 + board != null 아닐때 삭제를 진행
        if(board != null && "N".equals(board.getDeleteYn())) {
//            게시물 삭제 서비스 ( 하지만 내부적으로 진짜 삭제는 안함 )
            queryResult = boardDao.deleteBoard(idx);
        }

        return (queryResult == 1) ? true : false;
    }

//    게시판 페이징 처리를 위한 서비스 구현
    @Override
    public List<BoardDto> getBoardList(BoardDto params) {
        List<BoardDto> boardDto = Collections.emptyList();

//        DB params에 해당하는 데이터가 있는지 먼저 확인
        int boardTotalCount = boardDao.selectBoardTotalCount(params);

        if( boardTotalCount > 0 ) {
//            페이징 처리 서비스 호출
            boardDto = boardDao.selectBoardList(params);
        }

        return boardDto;
    }
}









