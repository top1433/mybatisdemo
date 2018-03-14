package net.xinqushi.test;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import mybatis.User;
import net.xinqushi.utils.MybatisUtils;

public class Test3 {


	
	@Test
	public void testInsert() throws IOException {
		SqlSession session = MybatisUtils.openSession();
		String string = "mybatis.UserMapper.insertUser";
		User user = new User();
		user.setUserName("王建");
		user.setUserPwd("王建");
		session.insert(string, user);
		session.commit();
		session.close();
		//System.out.println(count);
	}
	
	@Test
	public void testDelete() throws IOException {
		SqlSession sqlSession = MybatisUtils.openSession();
		String statment = "mybatis.UserMapper.deleteUser";
		User user = new User();
		user.setId(20);
		sqlSession.delete(statment, user);
		sqlSession.commit();
		sqlSession.close();
	}
	
	@Test
	public void testUpdate() throws IOException {
		SqlSession sqlSession = MybatisUtils.openSession();
		String statment="mybatis.UserMapper.updateUser";
		User user = new User();
		user.setUserName("哈喽");
		user.setUserPwd("8899");
		user.setId(8);
		sqlSession.update(statment, user);
		sqlSession.commit();
		sqlSession.close();
	}
	
	@Test
	public void testSelect() throws IOException {
		SqlSession session = MybatisUtils.openSession();
		String string = "mybatis.UserMapper.selectUser";
		User user=session.selectOne(string,1);
		session.close();
		System.out.println(user);
	}
	
	@Test
	public void testSelectAll() throws IOException {
		SqlSession sqlSession = MybatisUtils.openSession();
		String statment="mybatis.UserMapper.selectALL";
		List<User> list =sqlSession.selectList(statment);
		System.out.println(list);
		sqlSession.close();
		
	}
	
	

}
