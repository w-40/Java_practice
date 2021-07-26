package com.wzk.edu.info.manager.service;

import com.wzk.edu.info.manager.dao.TeacherDao;
import com.wzk.edu.info.manager.domain.Teacher;

public class TeacherService {
    //1.创建TeacherDao对象
    private TeacherDao teacherdao = new TeacherDao();

    public  Teacher[] findAllTeacher() {
        //1.调用TeacherDao对象teachertdao的findAllTeacher获取老师对象数组
        Teacher[] allTeacher = teacherdao.findAllTeacher();
        //2.判断数组中是否有老师信息（有：返回地址，没有：返回null）
        //思路：数组中只要有一个不是null的元素，那就代表有老师信息
        boolean flag = false;
        for (int i = 0; i < allTeacher.length; i++) {
            Teacher tea = allTeacher[i];
            if(tea != null){
                flag = true;
                break;
            }
        }
        if(flag){
            return allTeacher;
        }else{{
            return null;
        }}
    }

    public boolean addTeacher(Teacher tea) {
        //2.将老师对象，传递给TeacherDao中的addTeacher方法
        //3.将返回的boolean类型结果，返还给TeacherController
        return teacherdao.addTeacher(tea);
    }

    public boolean isExists(String id) {
        Teacher[] teas = teacherdao.findAllTeacher();
        //假设id在数组中不存在
        boolean exists= false;
        //遍历数组获取每一个老师对象，进行判断
        for (int i = 0; i < teas.length; i++) {
            Teacher teacher = teas[i];
            if(teacher != null && teacher.getId().equals(id)){
                exists = true;
                break;
            }
        }
        return exists;
    }

    public void deleteTeacherById(String delId) {
        teacherdao.deleteTeacherById(delId);
    }

    public void updateTeacher(String updateId, Teacher newTea) {
        teacherdao.updateTeacher(updateId,newTea);
    }
}
