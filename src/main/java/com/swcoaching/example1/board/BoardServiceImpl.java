package com.swcoaching.example1.board;

import com.swcoaching.example1.board.jpa.BoardEntity;
import com.swcoaching.example1.board.jpa.BoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoardServiceImpl implements BoardService {

  private final BoardRepository boardRepository;

  public BoardServiceImpl(BoardRepository boardRepository) {
    this.boardRepository = boardRepository;
  }

  @Override
  @Transactional(readOnly = true)
  public Board findById(long id) {
    return boardRepository.findById(id)
            .map(Board::of)
            .orElseThrow(() -> new BoardNotFoundException(id));
  }

  @Override
  @Transactional(readOnly = true)
  public BoardEntity findEntityById(Long id) {
    return boardRepository.findById(id)
            .orElseThrow(() -> new BoardNotFoundException(id));
  }

  @Override
  public List<BoardListResponseDto> findAllDesc() {
    return boardRepository.findAllDesc().stream().map(BoardListResponseDto::new).collect(Collectors.toList());
  }

  @Override
  public void AddBoard(BoardSaveRequestDto boardSaveRequestDto) {
    boardRepository.save(boardSaveRequestDto.toEntity());
  }

  // transaction: 커넥션을 연결해주는 역할을 함
  // 여러 번 연결하지 않고 한 번의 연결만으로 해결 가능
  // write DB -> admin
  // read DB -> user

}
// 나만의 custom exception 만들어도 좋음
