package com.wzk.edu.info.manager.dao;

import com.wzk.edu.info.manager.domain.Student;

import java.util.ArrayList;

public class OtherStudentDao implements BaseStudentDao{
    //1.创建学生对象数组
    private static ArrayList<Student> stus = new ArrayList<>();

    static {
        Student stu1 = new Student("2013040431","王志凯","19","2001-12-15");
        Student stu2 = new Student("2001","wzk","19","2001-12-15");
        stus.add(stu1);
        stus.add(stu2);
    }

    public boolean addStudent(Student stu) {
        stus.add(stu);
        return true;
    }

    public Student[] findAllStudent() {
        Student[] students = new Student[stus.size()];
        for (int i = 0; i < students.length; i++) {
            students[i] = stus.get(i);
        }
        
        return students;
    }

    public void deleteStudentById(String delId) {
        //1.查找id在容器中所在的索引位置
        int index = getIndex(delId);
       stus.remove(index);
    }
    public int getIndex(String id){
        int index = -1;
        for (int i = 0; i < stus.size(); i++) {
            Student stu = stus.get(i);
            if(stu != null && stu.getId().equals(id)){
                index = i;
                break;
            }
        }
        return index;
    }

    public void updateStudent(String updateId, Student newStu) {
        //1.查找updateId在容器中的索引
        int index = getIndex(updateId);
        stus.set(index,newStu);
    }
}
