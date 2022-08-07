package com.backend.onlinecvproject.services;

import com.backend.onlinecvproject.entities.Admin;
import com.backend.onlinecvproject.repositories.AdminRepository;
import com.backend.onlinecvproject.requests.AdminCreateRequest;
import com.backend.onlinecvproject.requests.AdminUpdateRequest;
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

    public Admin add(AdminCreateRequest admin){
        Admin toAdd = new Admin();
        toAdd.setUserName(admin.getUserName());
        toAdd.setPassword(admin.getPassword());
        return this.adminRepository.save(toAdd);
    }

    public Admin update(Long adminId, AdminUpdateRequest updatedAdmin){
        Optional<Admin> admin = this.adminRepository.findById(adminId);
        if(admin.isPresent()){
            Admin toUpdate = admin.get();
            toUpdate.setUserName(updatedAdmin.getUserName());
            toUpdate.setPassword(updatedAdmin.getPassword());
            this.adminRepository.save(toUpdate);
            return toUpdate;
        }else{
            return null;
        }
    }

    public void delete(Long adminId){
        this.adminRepository.deleteById(adminId);
    }
}
