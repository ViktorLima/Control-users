package com.users.control.repositories;

import com.users.control.models.UsersModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

// Inteface utilizado para fazer comunicação com o banco de dados
@Repository
public interface UsersRepository extends JpaRepository<UsersModel, UUID> {


}
