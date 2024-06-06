package com.appsdeveloperblog.tutorials.junit.io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    TestEntityManager testEntityManager;

    @Autowired
    UsersRepository usersRepository;

    @Test
    void testFindByEmail_whenGivenCorrectEmail_returnUserEntity(){
        //Arrange
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName("Sergey");
        userEntity.setLastName("Kargopolov");
        userEntity.setEmail("test@test.com");
        userEntity.setEncryptedPassword("12345678");
        testEntityManager.persistAndFlush(userEntity);


        //Act
        UserEntity storedUser= usersRepository.findByEmail(userEntity.getEmail());


        //Assert
        Assertions.assertEquals(userEntity.getEmail(), storedUser.getEmail(),
                "The returned email address does not match the expected value");



        //Assert
    }
}
