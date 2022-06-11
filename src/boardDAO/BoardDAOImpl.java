package boardDAO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import boardVO.BoardVO;
import util.MybatisUtil;

public class BoardDAOImpl implements IBoardDAO {

    private static IBoardDAO bDao;
    private SqlSession sqlSession;

    private BoardDAOImpl() {
        sqlSession = MybatisUtil.getInstance();
    }

    public static IBoardDAO getInstance() {
        if (bDao == null) {
            bDao = new BoardDAOImpl();
        }

        return bDao;
    }

    @Override
    public List<BoardVO> searchBoard(BoardVO bv) {
        return null;
    }

    @Override
    public int deleteBoard(String bTitle, String bWriter) {
        return 0;
    }

    @Override
    public int updateBoard(BoardVO bv) {
        return 0;
    }

    @Override
    public int insertBoard(BoardVO bv) {
        int cnt = sqlSession.insert("board.insertBoard", bv);

        if (cnt > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        return cnt;
    }

    @Override
    public List<BoardVO> getAllBoardList() {

        List<BoardVO> bList = sqlSession.selectList("board.getBoardAll");

        return bList;
    }

    @Override
    public boolean checkBoard(String bTitle) {
        return false;
    }
}
