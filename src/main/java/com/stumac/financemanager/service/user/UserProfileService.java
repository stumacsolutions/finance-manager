package com.stumac.financemanager.service.user;

import java.util.Optional;

public interface UserProfileService
{

    Optional<UserProfile> get();

    void save(UserProfile userProfile);
}
