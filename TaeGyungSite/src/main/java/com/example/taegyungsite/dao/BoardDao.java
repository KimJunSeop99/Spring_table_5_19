package com.example.taegyungsite.dao;

import com.example.taegyungsite.model.BoardDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * packageName : com.example.taegyungsite.dao
 * fileName : BoardDao
 * author : ds
 * date : 2022-05-17
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-17         ds          최초 생성
 */
// @Mapper : Mybatis에서 사용하는 어노테이션 , 스프링에 객체 생성
//           xml에서 interface를 구현함( CRUD sql문 작성 )
@Mapper
public interface BoardDao {

//    insert sql문을 위한 메소드
    int insertBoard(BoardDto params);

//    게시판 목록 조회하는 메소드 ( select sql문 )
    List<BoardDto> selectBoardAllList();

//    게시판 페이징 처리를 위한 메소드
    List<BoardDto> selectBoardList(BoardDto params);

//    게시판 상세 목록 조회하는 메소드 ( 매개변수가 게시판번호인 select sql문 )
    BoardDto selectBoardDetail(Long idx);

//    게시물의 총 건수를 가져오는 메소드 ( select : 1건 )
    int selectBoardTotalCount(BoardDto params);

//    게시판 글 수정 메소드
    int updateBoard(BoardDto params);

//    게시판 글 삭제 메소드
    int deleteBoard(Long idx);
}












