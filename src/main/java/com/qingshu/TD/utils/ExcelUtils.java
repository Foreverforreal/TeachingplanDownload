package com.qingshu.TD.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.qingshu.TD.entity.TeachingplanCourseEbook;

public class ExcelUtils {
	public static File generateExcel(List<TeachingplanCourseEbook> list ,String filePath,String schoolSymbol){
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet();
		FileOutputStream stream=null;
		String fileStorePath=null;
		
		try {
			fileStorePath=generateFilePath(schoolSymbol);
			stream = new FileOutputStream(fileStorePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		putObjectToRow(list,sheet);
		
		try {
			workbook.write(stream);
			stream.close();
			workbook.close();
			return new File(fileStorePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
		
		
	}

	public static String generateFilePath(String schoolSymbol){
		String newPath = ("D:\\apache-tomcat-8.0.28\\"+schoolSymbol+"教学计划.xlsx");
		return newPath;
	}
	
	public static void putObjectToRow(List<TeachingplanCourseEbook> list,XSSFSheet sheet){
		for (int i = 0; i < list.size(); i++) {
			XSSFRow row = sheet.createRow(i);
			String[] fileds=toString(list.get(i));
			for (int j = 0; j < fileds.length; j++) {
				row.createCell(j).setCellValue(fileds[j]);
			}
		}
	}
	
	public static String[] toString(TeachingplanCourseEbook t){
		return t.toString().split(",") ;		
	}
}
