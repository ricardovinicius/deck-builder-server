package com.ricardo.deck_builder.auth;

import com.ricardo.deck_builder.user.Role;

import java.util.List;

public record RegisterDTO(String login, String password, List<Role> roles) {}
