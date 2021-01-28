package com.example.News_portal.services;

import com.example.News_portal.exceptions.ElementExistsException;
import com.example.News_portal.exceptions.ElementNotFoundException;
import com.example.News_portal.models.Admin;
import com.example.News_portal.models.dto.AdminDTO;
import com.example.News_portal.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private DTOConverterService dtoConverterService;

    public AdminDTO save(AdminDTO adminDTO) throws ElementExistsException {
        if (adminRepository.existsByUserName(adminDTO.getUserName())) {
            throw new ElementExistsException();
        }
        Admin admin = dtoConverterService.convertAdminDTOToDAO(adminDTO);
        Admin save = adminRepository.save(admin);
        return dtoConverterService.convertAdminDAOToDTO(save);
    }

    public Admin findByUserName(String userName) {
        if (!adminRepository.existsByUserName(userName)) {
            throw new ElementNotFoundException();
        }
        Admin found = adminRepository.findAdminByUserName(userName);
        return found;
    }

    public Admin findById(Long id) throws ElementNotFoundException{
        try{
            Admin found = adminRepository.findById(id).get();
            return found;
        } catch (Exception e){
            throw new ElementNotFoundException();
        }
    }
}
