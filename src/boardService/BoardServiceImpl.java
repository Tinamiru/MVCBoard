package boardService;

import java.util.List;

import boardDAO.BoardDAOImpl;
import boardDAO.IBoardDAO;
import boardVO.BoardVO;

public class BoardServiceImpl implements IBoardService {

	private static IBoardService bService;
	private IBoardDAO bDAO;

	private BoardServiceImpl() {
		bDAO = BoardDAOImpl.getInstance();
	}

	public static IBoardService getInstance() {
		if (bService == null) {
			bService = new BoardServiceImpl();
		}
		return bService;
	}

	@Override
	public List<BoardVO> searchBoard(BoardVO bv) {

		return null;
	}

	@Override
	public int deleteBoard(String bTitle, String bWriter) {
	int cnt = bDAO.deleteBoard(bTitle, bWriter);
		return cnt;
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
