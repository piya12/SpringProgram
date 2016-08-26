package com.bridgelabz.service;

import com.bridgelabz.model.Student;

public interface StudentService {
	Student save(Student student);
	boolean findByLogin(String userName, String password);
	boolean findByUserName(String userName);
}
