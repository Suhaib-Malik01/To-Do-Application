package com.masai.Config;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor 
public class JwtFillter extends OncePerRequestFilter {

    private JwtService jwtService;

    @Override
    protected void doFilterInternal(@NotNull HttpServletRequest request,@NotNull HttpServletResponse response,@NotNull FilterChain filterChain)
            throws ServletException, IOException {
        
                final String authHeader = request.getHeader("Authorization");

                final String jwtToken;

                final String username;

                if(authHeader==null || !authHeader.startsWith("Bearer ")){
                    filterChain.doFilter(request, response);
                    return;
                }

                jwtToken = authHeader.substring(7);
                
                username = jwtService.extractUserName("");

            }
    
}
