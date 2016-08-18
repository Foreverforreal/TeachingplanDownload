package com.qingshu.TD.mapper;

import java.util.List;

import com.qingshu.TD.entity.StudentCount;
import com.qingshu.TD.entity.TeachingplanCourseEbook;

public interface TeachingplanCourseMapper {
	List<TeachingplanCourseEbook> selectTeachingplanCourseEbook();
	List<StudentCount> selectStudentCount();
}
