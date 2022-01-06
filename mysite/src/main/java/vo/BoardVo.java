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
		
		// 2. startPage����
		// ���� = �������� - ���������̼ǰ��� + 1
		this.startPage = this.endPage - 10 + 1;
		
		// 3. realEnd(��¥ ����ȣ) ���ؼ� endPage�� ���� �ٽ� ����
//		 ���� �Խñ��� 52����� -> ��¥ ����ȣ 6
//		 ���� �Խñ��� 105����� -> ��¥ ����ȣ 11
//		 ���� = (int)Math.ceil(��ü�Խñۼ� / ȭ�鿡�����������Ͱ���)
		int realEnd = (int)Math.ceil(this.total / (double)this.amount);
		
//		 ������������ �������� �� �������� �ϴ� ����ȣ�� �޶����ϴ�.
//		 ex) 131�� �Խù�
//		 1�� ������ Ŭ���� -> endPage = 10, realEnd = 14 ( endPage�� ���� )
//		 11�� ������ Ŭ���� -> endPage = 20, realEnd = 14 ( realEnd�� ���� )
		if(this.endPage > realEnd) {
			this.endPage = realEnd;
		}
		
		// 4. prev���� ( startPage�� ��ȣ�� 1, 11, 21... )
		this.prev = this.startPage > 1;
		
		// 5. next����
//		 ex: 131�� �Խù�
//		 1~10 Ŭ���� endPage = 10, realEnd = 14 -> ������ư true
//		 11 Ŭ���� endPage = 14 , realEnd = 14 -> ������ư false
		this.next = this.endPage < realEnd;
		
		// Ȯ��
		System.out.println("����������:" + this.startPage + ", ��������:" + this.endPage);
		
		// GetListService���� ������VO ���ó�� �ڵ��ۼ�...
	
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
