package com.systelab.inventory.controller;

import com.systelab.inventory.Constants;
import com.systelab.inventory.config.TokenProvider;
import com.systelab.inventory.model.User;
import com.systelab.inventory.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class UserControllerTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private TokenProvider jwtTokenUtil;

    @Mock
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @InjectMocks
    private UserController userController;

    private User user;
    private Authentication authentication;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        user = new User();
        user.setUsername("testuser");
        user.setPassword("password");

        authentication = new UsernamePasswordAuthenticationToken(user, null);
    }

    @Test
    public void testAuthenticateUser_Success() {
        when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class)))
                .thenReturn(authentication);
        when(userRepository.findByUsername("testuser")).thenReturn(user);
        when(jwtTokenUtil.generateToken(authentication)).thenReturn("testToken");

        ResponseEntity<?> responseEntity = userController.authenticateUser("testuser", "password");

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        HttpHeaders headers = responseEntity.getHeaders();
        assertNotNull(headers.get(Constants.HEADER_STRING));
        assertEquals("Bearer testToken", headers.get(Constants.HEADER_STRING).get(0));
    }

    @Test
    public void testAuthenticateUser_InvalidCredentials() {
        when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class)))
                .thenThrow(new BadCredentialsException("Invalid credentials"));
        try {
            userController.authenticateUser("testuser", "wrongpassword");
        } catch (BadCredentialsException e) {
            System.err.println(e.getMessage());
        }
    }

    @Test
    public void testAuthenticateUser_UserNotFound() {
        when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class)))
                .thenReturn(null);
        when(userRepository.findByUsername("testuser")).thenReturn(null); // Mocking user not found scenario
        ResponseEntity<?> responseEntity = userController.authenticateUser("testuser", "password");
        assertEquals(HttpStatus.UNAUTHORIZED.value(), responseEntity.getStatusCodeValue());
    }

}