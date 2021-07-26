package com.wzk.edu.info.manager.dao;

import com.wzk.edu.info.manager.domain.Student;

public class StudentDao implements BaseStudentDao{
    //1.创建学生对象数组
    private static Student[] stus = new Student[5];

    static {
        Student stu1 = new Student("2013040431","王志凯","19","2001-12-15");
        Student stu2 = new Student("2001","wzk","19","2001-12-15");
        stus[0] = stu1;
        stus[1] = stu2;
    }
    @Override
    public boolean addStudent(Student stu) {

        //2.添加学生到数组
        //2.1定义变量index为-1，假设数组已经全部存满，没有NULL的元素
        int index = -1;
        //2.2遍历数组取出每一个元素，判断是否为NULL
        for (int i = 0; i < stus.length; i++) {
            Student student = stus[i];
            //2.3如果是NULL，用index记录当前索引位置，并用break结束循环遍历
            if(student == null){
                index = i;
                break;
            }
        }
        //3.返回是否添加成功的boolean状态
        if(index == -1){
            //装满了
            return false;
        }else{
            //没有装满，正常添加
            stus[index] = stu;
            return true;
        }
    }

    public Student[] findAllStudent() {
        return stus;
    }

    public void deleteStudentById(String delId) {
        //1.查找id在容器中所在的索引位置
        int index = getIndex(delId);
        //2.将该索引位置，用null元素进行覆盖
        stus[index] = null;
    }
    public int getIndex(String id){
        int index = -1;
        for (int i = 0; i < stus.length; i++) {
            Student stu = stus[i];
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
        //2.将该索引位置使用新的学生对象替换
        stus[index] = newStu;
    }
}
