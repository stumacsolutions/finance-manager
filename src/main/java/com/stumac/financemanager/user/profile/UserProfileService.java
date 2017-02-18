package com.stumac.financemanager.user.profile;

import java.util.Optional;

public interface UserProfileService
{
    Optional<UserProfile> get();

    void save(UserProfile userProfile);
}
