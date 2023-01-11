package com.swcoaching.example1.board;

import com.swcoaching.example1.board.jpa.BoardEntity;
import lombok.Getter;

public class BoardListResponseDto {
    private Long id;
    private String title;
    private String remark;
    public BoardListResponseDto(BoardEntity entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.remark = entity.getRemark();
    }
}
