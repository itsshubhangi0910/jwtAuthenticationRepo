package com.oms.studentcrud.service.serviceimpl;

import com.oms.studentcrud.entities.Student;
import com.oms.studentcrud.entities.request.StudentRequest;
import com.oms.studentcrud.repository.StudentRepository;
import com.oms.studentcrud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentServiceImpll implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public Object saveOrUpdateStudent(StudentRequest studentRequest) {
        if(studentRepository.existsById(studentRequest.getStudentId())){
            Student student=studentRepository.findById(studentRequest.getStudentId()).get();
            student.setFirstName(studentRequest.getFirstName());
            student.setLastName(studentRequest.getLastName());
            student.setPassword(passwordEncoder.encode(studentRequest.getPassword()));
            student.setAddress(studentRequest.getAddress());
            student.setUsername(studentRequest.getUsername());
            student.setEmail(studentRequest.getEmail());
            studentRepository.save(student);
            return "Updated successfully";
        }else{
            Student student=new Student();
            student.setEmail(studentRequest.getEmail());
            student.setFirstName(studentRequest.getFirstName());
            student.setLastName(studentRequest.getLastName());
            student.setUsername(studentRequest.getUsername());
            student.setPassword(passwordEncoder.encode(studentRequest.getPassword()));
            student.setAddress(studentRequest.getAddress());
            student.setIsDeleted(false);
            student.setIsActive(true);
            studentRepository.save(student);
            return "saved successfully";
        }
    }

    @Override
    public Object getById(Long studentId) throws Exception {
        if(studentRepository.existsById(studentId)){
            Student student=studentRepository.findById(studentId).get();
            return student;
        }else{
            throw new Exception("Student not found");
        }
    }

    @Override
    public Object getAllStudent() {

        List<Student> all = studentRepository.findAll();
        return all;
    }

    @Override
    public Object deleteById(Long studentId) throws Exception {
        if(studentRepository.existsById(studentId)){
            Student student=studentRepository.findById(studentId).get();
            student.setIsDeleted(true);
            studentRepository.save(student);
            return "Deleted Sucessfully";
        }else {
            throw new Exception("student not found");
        }
    }

    @Override
    public Object chnageStatus(Long studentId) throws Exception {
        if(studentRepository.existsById(studentId)){
            Student student=studentRepository.findById(studentId).get();

            if(student.getIsActive()){
                student.setIsActive(false);
                studentRepository.save(student);
                return "inActive";
            }
            else{
                student.setIsActive(true);
                studentRepository.save(student);
                return "Active";
            }
        }else
        {
            throw new Exception("inActive");
        }
    }
}
