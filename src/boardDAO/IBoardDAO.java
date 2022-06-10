package boardDAO;

import java.util.List;

import boardVO.BoardVO;

public interface IBoardDAO {

	public List<BoardVO> searchBoard(BoardVO bv);

	public int deleteBoard(String bTitle);

	public int updateBoard(BoardVO bv);

	public int insertBoard(BoardVO bv);

	public List<BoardVO> getAllBoardList();

	public boolean checkBoard(String bTitle);

}
