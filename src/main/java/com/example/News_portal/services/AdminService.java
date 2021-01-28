package com.example.News_portal.services;

import com.example.News_portal.exceptions.ElementExistsException;
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

}
