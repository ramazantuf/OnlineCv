package com.backend.onlinecvproject.services;

import com.backend.onlinecvproject.core.mapping.ModelMapperService;
import com.backend.onlinecvproject.entities.Admin;
import com.backend.onlinecvproject.entities.Candidate;
import com.backend.onlinecvproject.repositories.AdminRepository;
import com.backend.onlinecvproject.requests.AdminCreateRequest;
import com.backend.onlinecvproject.requests.AdminUpdateRequest;
import com.backend.onlinecvproject.responses.AdminViewResponse;
import com.backend.onlinecvproject.responses.CandidateViewResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdminService {
    private AdminRepository adminRepository;
    private ModelMapperService modelMapperService;

    public AdminService(AdminRepository adminRepository, ModelMapperService modelMapperService) {
        this.adminRepository = adminRepository;
        this.modelMapperService = modelMapperService;
    }

    public List<AdminViewResponse> getall(){
        List<Admin> admins = this.adminRepository.findAll();
        List<AdminViewResponse> result = admins.stream().map(color -> this.modelMapperService.forDto().map(color, AdminViewResponse.class)).collect(Collectors.toList());
        return result;
    }

    public Admin add(AdminCreateRequest admin){
        Admin toAdd = new Admin();
        toAdd.setUserName(admin.getUserName());
        toAdd.setPassword(admin.getPassword());
        return this.adminRepository.save(toAdd);
    }

    public Admin update(int adminId, AdminUpdateRequest updatedAdmin){
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

    public void delete(int adminId){
        this.adminRepository.deleteById(adminId);
    }
}
