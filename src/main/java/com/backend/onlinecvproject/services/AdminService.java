package com.backend.onlinecvproject.services;

import com.backend.onlinecvproject.entities.Admin;
import com.backend.onlinecvproject.repositories.AdminRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    private AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public List<Admin> getAdmins(){
        return adminRepository.findAll();
    }

    public Admin add(Admin admin){
        return this.adminRepository.save(admin);
    }

    public Admin update(Long adminId, Admin updatedAdmin){
        Optional<Admin> admin = this.adminRepository.findById(adminId);
        if(admin.isPresent()){
            Admin foundedAdmin = admin.get();
            foundedAdmin.setUserName(updatedAdmin.getUserName());
            foundedAdmin.setPassword(updatedAdmin.getPassword());
            this.adminRepository.save(foundedAdmin);
            return foundedAdmin;
        }else{
            return null;
        }
    }

    public void delete(Long adminId){
        this.adminRepository.deleteById(adminId);
    }
}
