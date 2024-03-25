package com.systelab.inventory.Service;

import com.systelab.inventory.model.Role;
import com.systelab.inventory.model.User;
import com.systelab.inventory.repository.UserRepository;
import com.systelab.inventory.service.AppUserDetailsService;
import com.systelab.inventory.model.User;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

public class AppUserDetailsServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private AppUserDetailsService appUserDetailsService;

    private User user;

    @SuppressWarnings("deprecation")
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        Role role = new Role(null, "ROLE_USER", null);
        List<Role> roles = new ArrayList<>(Arrays.asList(role));
        user = new User(1L, "testuser", "password", "Test", "User", roles);
    }

    @Test
    public void testLoadUserByUsername() {
        when(userRepository.findByUsername("testuser")).thenReturn(user);

        UserDetails userDetails = appUserDetailsService.loadUserByUsername("testuser");

        assertEquals("testuser", userDetails.getUsername());
        assertEquals("password", userDetails.getPassword());
        assertTrue(userDetails.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_USER")));
    }

    @Test(expected = UsernameNotFoundException.class)
    public void testLoadUserByUsernameNotFound() {
        when(userRepository.findByUsername("nonexistentuser")).thenReturn(null);
        appUserDetailsService.loadUserByUsername("nonexistentuser");
    }
}