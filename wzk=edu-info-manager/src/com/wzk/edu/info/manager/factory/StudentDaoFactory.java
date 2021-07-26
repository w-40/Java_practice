package com.wzk.edu.info.manager.factory;

import com.wzk.edu.info.manager.dao.BaseStudentDao;
import com.wzk.edu.info.manager.dao.OtherStudentDao;
import com.wzk.edu.info.manager.dao.StudentDao;

public class StudentDaoFactory {
    public static BaseStudentDao getStudentDao(){
        return new OtherStudentDao();
        //return new StudentDao();
    }
}
