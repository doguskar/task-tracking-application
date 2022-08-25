package com.doguskar.tasktrackingapplication.facade;

import com.doguskar.tasktrackingapplication.data.UserData;

public interface UserFacade {
    UserData findByUsername(final String username);
}
