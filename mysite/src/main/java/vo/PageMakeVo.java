package vo;

public class PageMakeVo {
	private int page = 1;
	private int totalCount;
	private int beginPage;
	private int endPage;
	private int displayRow = 10;
	private int displayPage = 5;
	boolean prev;
	boolean next;
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getBeginPage() {
		return beginPage;
	}
	public void setBeginPage(int beginPage) {
		this.beginPage = beginPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getDisplayRow() {
		return displayRow;
	}
	public void setDisplayRow(int displayRow) {
		this.displayRow = displayRow;
	}
	public int getDisplayPage() {
		return displayPage;
	}
	public void setDisplayPage(int displayPage) {
		this.displayPage = displayPage;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	
	public void paging() {
		
		// prev, next, beginPage, endPage�� ����ؼ� �����.
        // 2+9 = 11, 11/10 = 1, 1*10 = 10
        // 10+9 = 19, 19/10 = 1, 1*10 = 10
        // 11+9 = 20, 20/10 = 2, 2*10 = 20
        // 20+9 = 29, 29/10 = 2, 2*10 = 20
        // 111+9 = 120 120/10 = 12, 12*10 = 120
        
        // (2+9)/10 * 10 (1�� ���)
        //endPage = ((page+(displayPage-1))/displayPage)*displayPage;
        
        // 1/10 0.1(�ø�) 1 (2�� ���)
		endPage = ((int)Math.ceil(page/(double)displayPage))*displayPage;
		System.out.println("endPage :"+endPage);
		
		beginPage = endPage - (displayPage-1);
		System.out.println("beginPage:"+beginPage);
		
		int totalPage = (int)Math.ceil(totalCount/(double)displayRow);
		
		if(totalPage < endPage) {
			endPage = totalPage;			
			next = false;
		}
		else {
			next = true;
		}
		prev = (beginPage==1)?false:true;//page�� 11�̻󿡸� ���´�.
		System.out.println("endPage : " + endPage);
	    System.out.println("totalPage : " + totalPage);
	}
	
	
	
}
