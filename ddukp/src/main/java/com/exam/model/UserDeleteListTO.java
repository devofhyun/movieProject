package com.exam.model;

import java.util.ArrayList;

public class UserDeleteListTO {

	private int cpage;
	private int recordPerPage;
	private int blockPerPage;
	private int totalPage;
	private int totalRecord;
	private int startBlock;
	private int endBlock;
	
	private String SearchKey;
	private String SearchWord;
	
	public String getSearchKey() {
		return SearchKey;
	}

	public void setSearchKey(String searchKey) {
		SearchKey = searchKey;
	}

	public String getSearchWord() {
		return SearchWord;
	}

	public void setSearchWord(String searchWord) {
		SearchWord = searchWord;
	}

	private ArrayList<UserTO> userLists;
	
	private UserTO userTO;
	
	public UserDeleteListTO() {
		// TODO Auto-generated constructor stub
		this.cpage=1;
		this.recordPerPage=10;
		this.blockPerPage=5;
		this.totalPage=1;
		this.totalRecord=0;
	}

	public int getCpage() {
		return cpage;
	}

	public void setCpage(int cpage) {
		this.cpage = cpage;
	}

	public int getRecordPerPage() {
		return recordPerPage;
	}

	public void setRecordPerPage(int recordPerPage) {
		this.recordPerPage = recordPerPage;
	}

	public int getBlockPerPage() {
		return blockPerPage;
	}

	public void setBlockPerPage(int blockPerPage) {
		this.blockPerPage = blockPerPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getStartBlock() {
		return startBlock;
	}

	public void setStartBlock(int startBlock) {
		this.startBlock = startBlock;
	}

	public int getEndBlock() {
		return endBlock;
	}

	public void setEndBlock(int endBlock) {
		this.endBlock = endBlock;
	}

	public ArrayList<UserTO> getUserLists() {
		return userLists;
	}

	public void setUserLists(ArrayList<UserTO> userLists) {
		this.userLists = userLists;
	}

	public UserTO getUserTO() {
		return userTO;
	}

	public void setUserTO(UserTO userTO) {
		this.userTO = userTO;
	}
	
	
}
