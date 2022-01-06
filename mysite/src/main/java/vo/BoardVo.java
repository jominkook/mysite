package vo;

public class BoardVo {
	
	private int no;
	private String title;
	private String content;
	private int hit;
	private String reg_date;
	private int user_no;
	private String user_name;
	private int rn;
	public int getRn() {
		return rn;
	}

	public void setRn(int rn) {
		this.rn = rn;
	}

	@Override
	public String toString() {
		return "BoardVo [no=" + no + ", title=" + title + ", content=" + content + ", hit=" + hit + ", reg_date="
				+ reg_date + ", user_no=" + user_no + ", user_name=" + user_name + ", rn=" + rn + "]";
	}

	/*//pageVO
	private int startPage;	
	private int endPage;
	private boolean prev,next;
	private int pageNum;
	private int amount = 10;
	private int total;
	
	public BoardVo(int pageNum, int amount, int total) {
		super();
		this.pageNum = pageNum;
		this.amount = amount;
		this.total = total;
		this.endPage = (int)Math.ceil(this.pageNum * 0.1) * 10;
		
		// 2. startPage결정
		// 공식 = 끝페이지 - 페이지네이션개수 + 1
		this.startPage = this.endPage - 10 + 1;
		
		// 3. realEnd(진짜 끝번호) 구해서 endPage의 값을 다시 결정
//		 만약 게시글이 52개라면 -> 진짜 끝번호 6
//		 만약 게시글이 105개라면 -> 진짜 끝번호 11
//		 공식 = (int)Math.ceil(전체게시글수 / 화면에보여질데이터개수)
		int realEnd = (int)Math.ceil(this.total / (double)this.amount);
		
//		 마지막페이지 도달했을 때 보여져야 하는 끝번호가 달라집니다.
//		 ex) 131개 게시물
//		 1번 페이지 클릭시 -> endPage = 10, realEnd = 14 ( endPage로 세팅 )
//		 11번 페이지 클릭시 -> endPage = 20, realEnd = 14 ( realEnd로 세팅 )
		if(this.endPage > realEnd) {
			this.endPage = realEnd;
		}
		
		// 4. prev결정 ( startPage의 번호는 1, 11, 21... )
		this.prev = this.startPage > 1;
		
		// 5. next결정
//		 ex: 131개 게시물
//		 1~10 클릭시 endPage = 10, realEnd = 14 -> 다음버튼 true
//		 11 클릭시 endPage = 14 , realEnd = 14 -> 다음버튼 false
		this.next = this.endPage < realEnd;
		
		// 확인
		System.out.println("시작페이지:" + this.startPage + ", 끝페이지:" + this.endPage);
		
		// GetListService에서 페이지VO 계산처리 코드작성...
	
	*/
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getReg_date() {
		return reg_date;
	}
		public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

}
