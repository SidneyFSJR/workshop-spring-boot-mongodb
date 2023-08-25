package com.sidneyferreira.workshopmongo.services;

import com.sidneyferreira.workshopmongo.domain.User;
import com.sidneyferreira.workshopmongo.repository.UserRepository;
import com.sidneyferreira.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll () {
        return repo.findAll();
    }

    public User findById(String id) {
        Optional<User> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

//** Esse tratamento também dá certo o FindById substituindo o findOne, entretanto, não funciona o ErrorNotFound 404
//    public User findById (String id) {
//
//        Optional<User> optional = repo.findById(id);
//        if (optional == null) {
//            throw new ObjectNotFoundException("Objeto não encontrado");
//        }
//
//        User user = new User();
//
//        user.setId(optional.get().getId());
//        user.setName(optional.get().getName());
//        user.setEmail(optional.get().getEmail());
//
//        return user;
//    }
}
