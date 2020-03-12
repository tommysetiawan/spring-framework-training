package com.blibli.test.blogapp.service.impl;

import com.blibli.test.blogapp.dto.UserRequest;
import com.blibli.test.blogapp.entity.User;
import com.blibli.test.blogapp.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Created by tommy.setiawan on 3/12/2020.
 */
class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        initMocks(this);
    }

    @AfterEach
    void tearDown() {
        verifyNoMoreInteractions(userRepository);
    }

    @Test
    void getUsers() {
    }

    @Test
    void addUser() {
        UserRequest request =
                UserRequest.builder()
                    .name("name")
                    .email("email")
                    .age(20)
                    .build();
        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .age(request.getAge())
                .build();
        when(userRepository.save(user)).thenReturn(user);
        userService.addUser(request);
        verify(userRepository).save(user);
    }

    @Test
    void deleteUser_throwError() {
        Long id = 123L;
        when(userRepository.findById(id)).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class,
                () -> userService.deleteUser(id));
        verify(userRepository).findById(id);
    }
}