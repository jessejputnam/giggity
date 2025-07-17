package io.giggity.api.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MockCurrentUser implements CurrentUser {
    private final String userId;

    public MockCurrentUser(@Value("${MOCK_USER_ID}") String userId) {
        this.userId = userId;
    }

    @Override
    public String getUserId() {
        return userId;
    }
}
