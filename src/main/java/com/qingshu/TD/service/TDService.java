package com.qingshu.TD.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qingshu.TD.entity.Ebook;
import com.qingshu.TD.entity.StudentCount;
import com.qingshu.TD.entity.TeachingplanCourseEbook;
import com.qingshu.TD.mapper.GlobalSchoolMapper;
import com.qingshu.TD.mapper.TeachingplanCourseMapper;
import com.qingshu.TD.utils.ExcelUtils;

@Service
public class TDService extends BaseService {
	private Logger log=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private GlobalSchoolMapper schoolDao;
	@Autowired
	private TeachingplanCourseMapper teachingplanDao;
	
	private List<Ebook> courseEbookList;
	private String schoolSymbol;
	
	
	public void getReady(){
		if(courseEbookList==null || !(courseEbookList.size()>0) ){
		courseEbookList=schoolDao.selectAllEbook();
		}
	}
	
	public List<String> getAllSchoolSymbol(){
		
		//courseEbookList=schoolDao.selectAllEbook();
		return schoolDao.selectAllSchoolSymbol();
	}
	
	public void swithDb(String schoolSymbol){
		this.schoolSymbol=schoolSymbol;
		switchDb(schoolSymbol,schoolDao);
	}
	
	public File downlodaEXcel(){	
		return downloadExccel(schoolSymbol);
	}
	
	
	public File downloadExccel(String schoolSymbol){
		List<TeachingplanCourseEbook> teachingplan=teachingplanDao.selectTeachingplanCourseEbook();
		for (TeachingplanCourseEbook teachingplanCourseEbook : teachingplan) {
			teachingplanCourseEbook.setEbookInfo(getEbookInfo(teachingplanCourseEbook.getEbookId()));
		}
		
		return ExcelUtils.generateExcel(teachingplan, "", schoolSymbol);
	}

	public String getEbookInfo(List<String> ebookId){
		StringBuffer ebookInfo=new StringBuffer("");
		outer: for (String string : ebookId) {
				for (Ebook ebook : courseEbookList) {
					if(ebook.getId().equals(string)){
						ebookInfo.append(ebook.getName()).append(",").append(ebook.getAuthor()).append(",").append(ebook.getPublisher()).append(",");

						continue  outer;
					}
				}		
			}
		//System.out.println(ebookInfo.toString());
		return ebookInfo.toString();
	}
	
	public List<StudentCount> getStudentCount(String symbol){
		List<StudentCount> list = teachingplanDao.selectStudentCount();
		for (StudentCount st : list) {
			st.setSchoolSymbol(symbol);
		}
		
		return list;
	}
}
