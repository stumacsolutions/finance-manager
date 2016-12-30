package com.stumac.financemanager.security;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class User {
    private String avatarUrl;
    private String name;
    private String username;
}
