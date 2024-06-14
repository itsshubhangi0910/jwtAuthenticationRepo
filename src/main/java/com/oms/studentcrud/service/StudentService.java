package com.oms.studentcrud.service;


import com.oms.studentcrud.entities.request.StudentRequest;

public interface StudentService {
    Object saveOrUpdateStudent(StudentRequest studentRequest);

    Object getById(Long studentId) throws Exception;

    Object getAllStudent();

    Object deleteById(Long studentId) throws Exception;

    Object chnageStatus(Long studentId) throws Exception;

}
