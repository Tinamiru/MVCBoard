package boardDAO;

import java.util.List;

import boardVO.BoardVO;

public interface IBoardDAO {

	List<BoardVO> searchBoard(BoardVO bv);

	int deleteBoard(String bTitle, String bWriter);

	int updateBoard(BoardVO bv);

	int insertBoard(BoardVO bv);

	List<BoardVO> getAllBoardList();

	boolean checkBoard(String bTitle);

}
