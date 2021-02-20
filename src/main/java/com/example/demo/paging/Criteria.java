package com.example.demo.paging;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Criteria {

	/** 현재 페이지 번호 */
	private int currentPageNo;

	public int getCurrentPageNo() {
		return currentPageNo;
	}

	public void setCurrentPageNo(int currentPageNo) {
		this.currentPageNo = currentPageNo;
	}

	public int getRecordsPerPage() {
		return recordsPerPage;
	}

	public void setRecordsPerPage(int recordsPerPage) {
		this.recordsPerPage = recordsPerPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

	

	

	

	

	/** 페이지당 출력할 데이터 개수 */
	private int recordsPerPage;

	/** 화면 하단에 출력할 페이지 사이즈 */
	private int pageSize;

	/** 검색 키워드 */
	private String searchKeyword;




	public Criteria() {
		this.currentPageNo = 1;
		this.recordsPerPage = 10;
		this.pageSize = 10;
	}

	public String makeQueryString(int pageNo) {

		UriComponents uriComponents = UriComponentsBuilder.newInstance()
				.queryParam("currentPageNo", pageNo)
				.queryParam("recordsPerPage", recordsPerPage)
				.queryParam("pageSize", pageSize)
				.queryParam("searchKeyword", searchKeyword)
				.build()
				.encode();

		return uriComponents.toUriString();
	}

}
