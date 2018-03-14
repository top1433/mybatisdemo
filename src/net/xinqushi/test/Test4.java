package net.xinqushi.test;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import mybatis.User;
import mybatis.UserMapper;
import net.xinqushi.utils.MybatisUtils;

class Test4 {

	@Test
	void testSelectAll() throws IOException {
		SqlSession sqlSession=MybatisUtils.openSession();
		UserMapper mapper= sqlSession.getMapper(UserMapper.class);
		List<User> list=mapper.selectALL();
		sqlSession.commit();
		sqlSession.close();
		System.out.println(list);

	}
	
	@Test
	public void testInsert() throws IOException {
		SqlSession sqlSession = MybatisUtils.openSession();
		UserMapper mapper =sqlSession.getMapper(UserMapper.class);
		User user = new User();
		user.setUserName("张学友");
		user.setUserPwd("132456789");
		mapper.insertUser(user);
		sqlSession.commit();
		sqlSession.close();
		
	}
	
	@Test
	public void testdeleteUser() throws IOException {
		SqlSession sqlSession = MybatisUtils.openSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		User user = new User() ;
		user.setId(1);
		mapper.deleteUser(user);
		sqlSession.commit();
		sqlSession.close();
	}
	
	@Test
	public void testUpdateUser() throws IOException {
		SqlSession sqlSession = MybatisUtils.openSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		User user = new User();
		user.setId(38);
		user.setUserName("贾跃亭");
		user.setUserPwd("孙宏斌");
		mapper.updateUser(user);
		sqlSession.commit();
		sqlSession.close();
	}

}
