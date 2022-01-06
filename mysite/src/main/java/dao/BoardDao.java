package dao;

import java.util.List;

import vo.BoardVo;

public interface BoardDao {
	public List<BoardVo> getlist(int page);
	public List<BoardVo> getlist();
	public BoardVo getBoard(int no);
	public boolean insert(BoardVo vo);
	public boolean update(BoardVo vo);
	public boolean delete(int no);
	public boolean countHit(int no);
	public int getAllCount();
	
}
