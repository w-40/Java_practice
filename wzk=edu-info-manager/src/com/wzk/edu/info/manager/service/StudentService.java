package com.wzk.edu.info.manager.service;

import com.wzk.edu.info.manager.dao.BaseStudentDao;
import com.wzk.edu.info.manager.dao.OtherStudentDao;
import com.wzk.edu.info.manager.dao.StudentDao;
import com.wzk.edu.info.manager.domain.Student;
import com.wzk.edu.info.manager.factory.StudentDaoFactory;

public class StudentService {

    //1.创建StudentDao对象
    //private OtherStudentDao studentdao = new OtherStudentDao();
    private BaseStudentDao studentdao = StudentDaoFactory.getStudentDao();

    public  Student[] findAllStudent() {
        //1.调用StudentDao对象studentdao的findAllStudent获取学生对象数组
        Student[] allStudent = studentdao.findAllStudent();
        //2.判断数组中是否有学生信息（有：返回地址，没有：返回null）
        //思路：数组中只要有一个不是null的元素，那就代表有学生信息
        boolean flag = false;
        for (int i = 0; i < allStudent.length; i++) {
            Student stu = allStudent[i];
            if(stu != null){
                flag = true;
                break;
            }
        }
        if(flag){
            return allStudent;
        }else{{
            return null;
        }}
    }

    public boolean addStudent(Student stu) {
        //2.将学生对象，传递给StudentDao中的addStudent方法
        //3.将返回的boolean类型结果，返还给StudentController
        return studentdao.addStudent(stu);
    }

    public boolean isExists(String id) {
        Student[] stus = studentdao.findAllStudent();
        //假设id在数组中不存在
        boolean exists= false;
        //遍历数组获取每一个学生对象，进行判断
        for (int i = 0; i < stus.length; i++) {
            Student student = stus[i];
            if(student != null && student.getId().equals(id)){
                exists = true;
                break;
            }
        }
        return exists;
    }

    public void deleteStudentById(String delId) {
        studentdao.deleteStudentById(delId);
    }

    public void updateStudent(String updateId, Student newStu) {
        studentdao.updateStudent(updateId,newStu);
    }
}
