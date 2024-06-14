package com.oms.studentcrud.entities.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentRequest {
    private Long studentId;
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private String address;

}
