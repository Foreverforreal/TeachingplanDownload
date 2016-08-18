package com.qingshu.TD.service;

import com.qingshu.TD.mapper.GlobalSchoolMapper;
import com.qingshu.TD.utils.PropertityUtils;

public class BaseService {
	private GlobalSchoolMapper schoolDao;
	
	public void switchDb(String schoolSymbol,GlobalSchoolMapper schoolDao){
		this.schoolDao=schoolDao;
		PropertityUtils.setProSchoolUrl(getSchoolConnectUrl(schoolSymbol));
	}
	
	public String getSchoolConnectUrl(String schoolSymbol){
		String schoolId=schoolDao.selectSchoolId(schoolSymbol);
		if(schoolId==null){
			return schoolSymbol;
		}
		return schoolDao.selectSchoolUrl(schoolId);
	}
}
