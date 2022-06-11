package boardService;

import java.util.List;

import boardDAO.BoardDAOImpl;
import boardDAO.IBoardDAO;
import boardVO.BoardVO;

public class BoardServiceImpl implements IBoardService {

	private static IBoardService bService;
	private final IBoardDAO bDAO;

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
		return bDAO.searchBoard(bv);
	}

	@Override
	public int deleteBoard(BoardVO bv) {
		return bDAO.deleteBoard(bv);
	}

	@Override
	public int updateBoard(BoardVO bv) {
		return bDAO.updateBoard(bv);
	}

	@Override
	public int insertBoard(BoardVO bv) {
		return bDAO.insertBoard(bv);
	}

	@Override
	public List<BoardVO> getAllBoardList() {
		return bDAO.getAllBoardList();
	}

	@Override
	public boolean checkBoard(String bTitle) {
		return bDAO.checkBoard(bTitle);
	}

}
