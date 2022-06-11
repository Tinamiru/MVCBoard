package boardService;

import java.util.List;

import boardVO.BoardVO;

public interface IBoardService {

	List<BoardVO> searchBoard(BoardVO bv);

	int deleteBoard(BoardVO bv);

	int updateBoard(BoardVO bv);

	int insertBoard(BoardVO bv);

	List<BoardVO> getAllBoardList();

	boolean checkBoard(String bTitle);

}
