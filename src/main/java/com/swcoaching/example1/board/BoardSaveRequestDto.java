package com.swcoaching.example1.board;

import com.swcoaching.example1.board.jpa.BoardEntity;

public class BoardSaveRequestDto {
    private String title;
    private String remark;
    private long id;

    public BoardSaveRequestDto(String title, String remark, long id){
        this.title = title;
        this.remark = remark;
        this.id = id;
    }

    public BoardEntity toEntity() {
        BoardEntity boardEntity = new BoardEntity(title, remark, id);
        return boardEntity;
    }
}
