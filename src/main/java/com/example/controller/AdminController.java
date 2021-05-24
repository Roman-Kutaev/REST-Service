package com.example.controller;

import com.example.entity.Admin;
import com.example.service.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/blacklist")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/{login}/{password}")
    public ResponseEntity<Admin> existenceAdmin(@PathVariable String login, @PathVariable String password){
        return ResponseEntity.ok(new Admin(login,password));
    }
}
