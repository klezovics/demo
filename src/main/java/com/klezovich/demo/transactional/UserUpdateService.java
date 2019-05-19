package com.klezovich.demo.transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Slf4j
public class UserUpdateService {

    private final UserRepository repository;

    @Transactional
    public Iterable<User> updateUsers() {

        var users = repository.findAll();
        for( var user: users ){

            var version = user.getVersion();
            user.setVersion(++version);
        }

        log.info("All users updated");
        log.info("Fetched entity state:" + users.toString());
        log.info("Retrieved entity state:" + repository.findAll() );

        performNestedTransaction();
        repository.saveAll(users);

        if( 1 == 1 )
          throw new RuntimeException();

        return users;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void performNestedTransaction() {

    }


}
