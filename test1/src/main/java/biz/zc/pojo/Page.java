package biz.zc.pojo;

import java.util.List;

public class Page {
	private int page;
	private List<Integer> pages;
	private List<Student> students;
	private int sizi = 5;
	private long tote;
	private long start;
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public List<Integer> getPages() {
		return pages;
	}
	public void setPages(List<Integer> pages) {
		this.pages = pages;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public int getSizi() {
		return sizi;
	}
	public void setSizi(int sizi) {
		this.sizi = sizi;
	}
	public long getTote() {
		return tote;
	}
	public void setTote(long tote) {
		this.tote = tote;
	}
	public long getStart() {
		return start;
	}
	public void setStart(long start) {
		this.start = start;
	}
	
	
	

}
