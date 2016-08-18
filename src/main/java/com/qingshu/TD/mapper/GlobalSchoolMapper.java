package com.qingshu.TD.mapper;

import java.util.List;

import com.qingshu.TD.entity.Ebook;

public interface GlobalSchoolMapper {
	List<String> selectAllSchoolSymbol();
	String selectSchoolId(String schoolSymbol);
	String selectSchoolUrl(String schoolId);
	
	List<Ebook> selectAllEbook();
	
}
