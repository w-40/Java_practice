package com.wzk.edu.info.manager.dao;

import com.wzk.edu.info.manager.domain.Student;

public interface BaseStudentDao {
    public abstract boolean addStudent(Student stu);

    public abstract Student[] findAllStudent();

    public abstract void deleteStudentById(String delId);
    public abstract int getIndex(String id);

    public abstract void updateStudent(String updateId, Student newStu);
}
