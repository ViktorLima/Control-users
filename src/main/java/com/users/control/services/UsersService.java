package com.users.control.services;

import com.users.control.models.UsersModel;
import com.users.control.repositories.UsersRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UsersService implements Serializable {
    final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public UsersModel save(UsersModel usersModel) {
        return usersRepository.save(usersModel);
    }

    public List<UsersModel> findAll() {
        return usersRepository.findAll();
    }

    public Optional<UsersModel> findById(UUID id) {
        return usersRepository.findById(id);
    }

    @Transactional
    public void delete(UsersModel usersModel) {
        usersRepository.delete(usersModel);
    }

}
