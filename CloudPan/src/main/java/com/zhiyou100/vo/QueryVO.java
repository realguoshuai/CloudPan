package com.zhiyou100.vo;

import java.io.Serializable;

public class QueryVO implements Serializable {

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = -7140838614937397062L;

	// 搜索中使用
	// 搜索字段
	private String search;

	// 排序中使用
	// 按照什么字段名进行排序
	private String sort;
	// 按照哪种方式排序
	private String order;

	@Override
	public String toString() {
		return "QueryVO [search=" + search + ", sort=" + sort + ", order=" + order + "]";
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String[] getKeywords() {
		if (search == null || search.equals(" ")) {
			return null;
		} else {
			return search.split(" ");
		}
	}
}
