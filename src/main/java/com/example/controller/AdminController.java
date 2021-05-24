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

    @GetMapping("/admin/{login}/{password}")
    public ResponseEntity<Admin> existenceAdmin(@PathVariable String login, @PathVariable String password){
        System.out.println("adminService.existence(login,password)" + adminService.existence(login,password));
        return ResponseEntity.ok(adminService.existence(login,password));
    }
}
