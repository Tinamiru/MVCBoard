package boardDAO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import boardVO.BoardVO;
import util.MybatisUtil;

public class BoardDAOImpl implements IBoardDAO {

    private static IBoardDAO bDao;
    private final SqlSession sqlSession;

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
        return sqlSession.selectList("board.searchBoard", bv);
    }

    @Override
    public int deleteBoard(BoardVO bv) {

        int cnt = sqlSession.delete("board.deleteBoard", bv);

        if (cnt > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        return cnt;
    }

    @Override
    public int updateBoard(BoardVO bv) {
        int cnt = sqlSession.insert("board.updateBoard", bv);

        if (cnt > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        return cnt;
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

        return sqlSession.selectList("board.getBoardAll");
    }

    @Override
    public boolean checkBoard(String bTitle) {
        boolean isExist = false;

        int cnt = sqlSession.selectOne("board.checkBoard", bTitle);

        if (cnt > 0) {
            isExist = true;
        }

        return isExist;
    }
}
