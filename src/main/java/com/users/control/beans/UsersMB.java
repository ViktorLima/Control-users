package com.users.control.beans;

import com.users.control.models.UsersModel;
import com.users.control.repositories.UsersRepository;
import com.users.control.services.UsersService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

// Manage utilizado para fazer comunicação com a view index utilizando metodos como deletar e criar e renderização da tabela na view.
@Named(value = "usersMB")
@SessionScoped
public class UsersMB {

    @Getter
    @Setter
    private List<UsersModel> usersModels = new ArrayList<>();

    @Getter
    @Setter
    private UsersModel usersModel;

    @Autowired
    private UsersRepository usersRepository;

    @Inject
    private UsersService usersService;

    private String searchUsers;

    public String getSearchUsers() {
        return searchUsers;
    }

    public void setSearchUsers(String searchUsers) {
        this.searchUsers = searchUsers;
    }

// Metodo utilzado para renderizar os dados da model na tabela do index.xhtml
    @PostConstruct
    public List<UsersModel> listarTodos() {
        usersModels = usersRepository.findAll();
        return usersModels;
    }

// Metodo utilizado para criação de novos usuarios.
    @PostConstruct
    public void newBdUsers() {
        usersModel = new UsersModel();
    }
    public void newUsers() {
        usersService.save(usersModel);
        usersModel = new UsersModel();


    }

// Metodo utilizado para realizar a exclusão na tabela.
    public void remove(UUID id) {
        try {
            usersRepository.deleteById(id);
            usersModels = usersRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


//  Metodo utilizado para fazer a busca de registro na tabela.
    public boolean globalFilterFunction(Object value, Object filter, Locale locale) {
        String filterText = (filter == null) ? null : filter.toString().trim().toLowerCase();
        if (filterText == null || filterText.equals("")) {
            return true;
        }
        UsersModel usersModel1 = (UsersModel) value;
        return usersModel1.getName().toLowerCase().contains(filterText);

    }

}



