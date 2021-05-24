package com.example.service;

import com.example.entity.Admin;
import com.example.repository.AdminRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    private final AdminRepository adminRepository;


    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public Admin existence(String login, String password){
        return adminRepository.findByLoginAndPassword(login, password);
    }
}
