package boardService;

import java.util.List;

import boardDAO.BoardDAO;
import boardDAO.IBoardDAO;
import boardVO.BoardVO;

public class BoardService implements IBoardService {

	private static IBoardService bService;
	private IBoardDAO bDAO;

	private BoardService() {
		bDAO = BoardDAO.getInstance();
	}

	public static IBoardService getInstance() {
		if (bService == null) {
			bService = new BoardService();
		}
		return bService;
	}

	@Override
	public List<BoardVO> searchBoard(BoardVO bv) {

		return null;
	}

	@Override
	public int deleteBoard(String bTitle) {

		return 0;
	}

	@Override
	public int updateBoard(BoardVO bv) {

		return 0;
	}

	@Override
	public int insertBoard(BoardVO bv) {
		int cnt = bDAO.insertBoard(bv);
		return cnt;
	}

	@Override
	public List<BoardVO> getAllBoardList() {
		List<BoardVO> bList = bDAO.getAllBoardList();
		return bList;
	}

	@Override
	public boolean checkBoard(String bTitle) {

		return false;
	}

}
