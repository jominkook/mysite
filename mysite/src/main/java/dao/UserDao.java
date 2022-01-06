package dao;

import vo.UserVo;

public interface UserDao {
	
	public boolean insert(UserVo vo);
	public void getlist(UserVo vo);
	public void getUser(UserVo vo);		
	public boolean update(UserVo vo);
	
}
