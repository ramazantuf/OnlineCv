package com.backend.onlinecvproject.controllers;

import com.backend.onlinecvproject.entities.Admin;
import com.backend.onlinecvproject.services.AdminService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admins")
public class AdminController {
    private AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping
    public List<Admin> getAdmins(){
        return this.adminService.getAdmins();
    }

    @PostMapping
    public Admin add(@RequestBody Admin admin){
        return this.adminService.add(admin);
    }

    @PutMapping("/{adminId}")
    public Admin update(@PathVariable Long adminId,@RequestBody Admin updatedAdmin){
        return this.adminService.update(adminId,updatedAdmin);
    }

    @DeleteMapping("/{adminId}")
    public void delete(@PathVariable Long adminId) {
        this.adminService.delete(adminId);
    }
}
