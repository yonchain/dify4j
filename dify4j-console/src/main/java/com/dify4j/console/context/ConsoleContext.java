package com.dify4j.console.context;

import com.dify4j.api.idm.CurrentUser;

public class ConsoleContext {

    private CurrentUser currentUser;

    public CurrentUser getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(CurrentUser currentUser) {
        this.currentUser = currentUser;
    }
}
