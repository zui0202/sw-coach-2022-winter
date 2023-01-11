package com.swcoaching.example1.controller;

import com.swcoaching.example1.board.Board;
import com.swcoaching.example1.board.BoardListResponseDto;
import com.swcoaching.example1.board.BoardService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping
public class BoardController {
  private final Logger logger = LoggerFactory.getLogger(getClass());
//  interface
  private final BoardService boardService;

  @GetMapping("/board")
  public List<BoardListResponseDto> findAll() {
    return boardService.findAllDesc();
  }

  @GetMapping("/board/{boardId}")
  public Board getBoard(@PathVariable long boardId) {
    Board board = boardService.findById(boardId);
    logger.info("Board: {}", board);
    return board;
  }
}


