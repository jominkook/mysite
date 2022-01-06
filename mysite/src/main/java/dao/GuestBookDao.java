package dao;

import java.util.List;

import vo.GuestBookVo;

public interface GuestBookDao {
	public boolean insert(GuestBookVo vo);
	public List<GuestBookVo> getlist();
	public boolean delete(GuestBookVo vo);

	
}
