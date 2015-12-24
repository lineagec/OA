package com.zw.oa.common;

import java.util.List;

public class Page<E> {

	private List<E> data;
	private long count;
	private int pageIndex;
	private int pageRows;
	private int pageCount;
	private int start;
	private int end;
	
	public Page(List<E> data, long count, int pageIndex, int pageRows) {
		super();
		this.data = data;
		this.count = count;
		this.pageIndex = pageIndex;
		this.pageRows = pageRows;
		
		this.pageCount = (int)((count + pageRows - 1) / pageRows);
		
		if(pageIndex < 7) {
			start = 1;
			end = pageCount > 10 ? 10 : pageCount;
		} else if(pageCount - pageIndex < 4) {
			end = pageCount;
			start = pageCount - 10;
			if(start < 1) {
				start = 1;
			}
		} else {
			start = pageIndex - 5;
			end = pageIndex + 4;
		}
	}
	
	public long getCount() {
		return count;
	}
	public List<E> getData() {
		return data;
	}
	public int getEnd() {
		return end;
	}
	public int getPageCount() {
		return pageCount;
	}
	public int getPageIndex() {
		return pageIndex;
	}
	public int getPageRows() {
		return pageRows;
	}
	public int getStart() {
		return start;
	}
}
