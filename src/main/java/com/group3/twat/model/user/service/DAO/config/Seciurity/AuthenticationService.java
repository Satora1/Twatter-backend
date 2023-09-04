package com.group3.twat.model.user.service.DAO.config.Seciurity;

import com.group3.twat.model.user.Role;
import com.group3.twat.model.user.User;
import com.group3.twat.model.user.service.DAO.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class AuthenticationService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequset requset) {
        var user = User.builder()
                .username(requset.getUsername())
                .email(requset.getEmail())
                .password(passwordEncoder.encode(requset.getPassword()))
                .role(Role.USER)
                .build();
        repository.save(user);
        var jwtToken = jwtService.genrateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequset requset) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        requset.getEmail(),
                        requset.getPassword()
                )
        );
        var user = repository.findByEmail(requset.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.genrateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
