package com.example.taegyungsite.model;

import com.example.taegyungsite.paging.Criteria;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * packageName : com.example.taegyungsite.model
 * fileName : CommonDto
 * author : ds
 * date : 2022-05-18
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-18         ds          최초 생성
 */
// 롬북에서 제공하는 어노테이션
@Getter
@Setter
@ToString
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CommonDto extends Criteria {
    //    삭제여부 ( Y, N )
    private String deleteYn;
    //    등록일
    private LocalDateTime insertTime;
    //    수정일
    private LocalDateTime updateTime;
    //    삭제일
    private LocalDateTime deleteTime;
}


