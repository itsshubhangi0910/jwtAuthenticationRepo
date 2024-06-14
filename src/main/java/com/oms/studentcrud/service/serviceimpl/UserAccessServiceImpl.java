package com.oms.studentcrud.service.serviceimpl;

import com.oms.studentcrud.entities.Student;
import com.oms.studentcrud.repository.StudentRepository;
import com.oms.studentcrud.service.UserAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserAccessServiceImpl  implements UserAccessService, UserDetailsService
{
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException
    {
        Student student = studentRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("user not found" + email));
        return student;
    }
}
