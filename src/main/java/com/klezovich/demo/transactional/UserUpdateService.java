package com.klezovich.demo.transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class UserUpdateService {

    private final UserRepository repository;

    // If you remove the @Transactional annotation
    // then 2 users will be updated but the third one will not be
    // updated
    @Transactional
    public Iterable<User> updateUsers() {

        var users = repository.findAll();
        for( var user: users ){

            var version = user.getVersion();
            user.setVersion(++version);

            if( user.getId() == 3L )
                throw new RuntimeException();

            repository.save(user);
        }

        return users;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void performNestedTransaction() {

    }


}
