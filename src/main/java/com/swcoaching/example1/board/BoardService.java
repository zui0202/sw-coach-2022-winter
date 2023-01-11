package com.swcoaching.example1.board;

import com.swcoaching.example1.board.jpa.BoardEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public interface BoardService {
  Board findById(long id);
  BoardEntity findEntityById(Long id);
  List<BoardListResponseDto> findAllDesc();
  void AddBoard(BoardSaveRequestDto boardSaveRequestDto);
}
