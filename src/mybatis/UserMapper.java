package mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Insert;

public interface UserMapper {
	public List<User> selectALL();
	
	@Insert("insert into user (userName,userPwd) values (#{userName},#{userPwd})")
	public int insertUser(User user);
	
	public int deleteUser(User user);
	
	public boolean updateUser(User user);
}
