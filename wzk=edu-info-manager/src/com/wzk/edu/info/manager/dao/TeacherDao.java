package com.wzk.edu.info.manager.dao;

import com.wzk.edu.info.manager.domain.Teacher;

public class TeacherDao {
    //1.创建学生对象数组
    private static Teacher[] teas = new Teacher[5];
    public boolean addTeacher(Teacher tea) {

        //2.添加老师到数组
        //2.1定义变量index为-1，假设数组已经全部存满，没有NULL的元素
        int index = -1;
        //2.2遍历数组取出每一个元素，判断是否为NULL
        for (int i = 0; i < teas.length; i++) {
            Teacher teacher = teas[i];
            //2.3如果是NULL，用index记录当前索引位置，并用break结束循环遍历
            if(teacher == null){
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
            teas[index] = tea;
            return true;
        }
    }

    public Teacher[] findAllTeacher() {
        return teas;
    }

    public void deleteTeacherById(String delId) {
        //1.查找id在容器中所在的索引位置
        int index = getIndex(delId);
        //2.将该索引位置，用null元素进行覆盖
        teas[index] = null;
    }
    public int getIndex(String id){
        int index = -1;
        for (int i = 0; i < teas.length; i++) {
            Teacher tea = teas[i];
            if(tea != null && tea.getId().equals(id)){
                index = i;
                break;
            }
        }
        return index;
    }

    public void updateTeacher(String updateId, Teacher newTea) {
        //1.查找updateId在容器中的索引
        int index = getIndex(updateId);
        //2.将该索引位置使用新的学生对象替换
        teas[index] = newTea;
    }
}
