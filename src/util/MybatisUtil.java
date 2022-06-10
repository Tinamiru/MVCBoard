package util;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {

		private static SqlSessionFactory sessionFactory;
		
		static {
			try {
//				1-1. xml문서 읽어오기
//				설정 파일의 인코딩 설정(한글 처리를 위해서...)

				Charset charset = Charset.forName("UTF-8");
				Resources.setCharset(charset);
				Reader rd = Resources.getResourceAsReader("mybatis-config.xml");

//				1-2. 위에서 읽어온 Reader 객체를 이용하여 실제 작업을 진행할 객체를 생성하기

				sessionFactory = new SqlSessionFactoryBuilder().build(rd);
				
				rd.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public static SqlSession getInstance() {
			return sessionFactory.openSession(false); // 오토커밋 false
		}

		/**
		 * SqlSession 객체를 제공하는 팩토리 메서드 
		 * @param autoCommit 오토커밋 여부
		 * @return SqlSession 객체
		 */
		public static SqlSession getInstance(boolean autoCommit) {
			return sessionFactory.openSession(autoCommit); // 오토커밋 false
		}
		
		
		
}
