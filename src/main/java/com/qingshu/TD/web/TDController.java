package com.qingshu.TD.web;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qingshu.TD.entity.StudentCount;
import com.qingshu.TD.service.TDService;

@Controller
public class TDController {
	private Logger log=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private TDService tDService;
	
	@RequestMapping("/GetSchookList")
	public @ResponseBody List<String> getSchoolList(){
		return tDService.getAllSchoolSymbol();
	}
	
	@RequestMapping("/DownloadTeachingplan")
	public ResponseEntity<byte[]> getTeachingplanExcel(String symbol) throws IOException{
		log.debug("-----------------------------------------------/n Start"+symbol+"/n-----------------------------------------------");
		
		tDService.swithDb(symbol.substring(0,symbol.indexOf("  ")));
		File downloadExcel=tDService.downlodaEXcel();
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentDispositionFormData("attachment", new String(downloadExcel.getName().getBytes("UTF-8"),"iso-8859-1"));
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM); 
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(downloadExcel),    
                 headers, HttpStatus.CREATED);
	}
	
	@RequestMapping("Batch")
	public @ResponseBody List<StudentCount> batch(){
		String[] s={"jxsf","jxddz","gnnu","jgs","jxddc","jxcd","jxzyy","jtd","xyxy","hdjd"};
		List<StudentCount> list=new ArrayList<>();
		
		for (String string : s) {
			tDService.swithDb(string);
			list.addAll(tDService.getStudentCount(string));
		}	
		return list;
	}

}
