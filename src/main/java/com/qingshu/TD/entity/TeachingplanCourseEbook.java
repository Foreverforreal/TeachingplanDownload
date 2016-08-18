package com.qingshu.TD.entity;

import java.util.List;

public class TeachingplanCourseEbook {
	private String major;
	private String level;
	private String course;
	private String term;
	private String enroll_year;
	private String res_course;
	private String res_courseware;
	private String url;
	private List<String> ebookId;
	private String ebookInfo;
	private String courseware_status;

	
	public String getMajor() {
		return major;
	}


	public void setMajor(String major) {
		this.major = major;
	}


	public String getLevel() {
		return level;
	}


	public void setLevel(String level) {
		this.level = level;
	}


	public String getCourse() {
		return course;
	}


	public void setCourse(String course) {
		this.course = course;
	}


	public String getTerm() {
		return term;
	}


	public void setTerm(String term) {
		this.term = term;
	}


	public String getEnroll_year() {
		return enroll_year;
	}


	public void setEnroll_year(String enroll_year) {
		this.enroll_year = enroll_year;
	}


	public String getRes_course() {
		return res_course;
	}


	public void setRes_course(String res_course) {
		this.res_course = res_course;
	}


	public String getRes_courseware() {
		return res_courseware;
	}


	public void setRes_courseware(String res_courseware) {
		this.res_courseware = res_courseware;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public List<String> getEbookId() {
		return ebookId;
	}


	public void setEbookId(List<String> ebookId) {
		this.ebookId = ebookId;
	}


	public String getEbookInfo() {
		return ebookInfo;
	}


	public void setEbookInfo(String ebookInfo) {
		this.ebookInfo = ebookInfo;
	}
	

	public String getCourseware_status() {
		return courseware_status;
	}


	public void setCourseware_status(String courseware_status) {
		this.courseware_status = courseware_status;
	}


	public String toString1() {

		return major + "," + level + "," + course + "," + term + "," + enroll_year + "," + url + "," + ebookInfo;
	}
	@Override
	public String toString() {	
		return major + "," + level + "," + course + "," + term + "," + enroll_year + ","+res_course + ","+res_courseware + "," + url+ "," + courseware_status+"," + ebookInfo;
	}

}
