package org.example.expert.domain.user;

import org.example.expert.domain.user.entity.User;
import org.example.expert.domain.user.enums.UserRole;
import org.example.expert.domain.user.repository.UserBulkRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
public class UserBulkInsertTest {

    @Autowired
    private UserBulkRepository userBulkRepository;

    private static final int TOTAL_USERS = 1_000_000;
    private static final int BATCH_SIZE = 10000;

    @Test
    public void bulkInsertTest() {

        for (int i = 0; i < TOTAL_USERS; i += BATCH_SIZE) {
            List<User> users = new ArrayList<>(BATCH_SIZE);

            for (int j = 0; j < BATCH_SIZE; j++) {
                int userNum = i + j;
                String email = String.format("user%d@example.com", userNum);
                String password = String.format("password%d", userNum);
                String nickname = String.format("nickname%d", userNum);

                User user = new User(email, password, nickname, UserRole.ROLE_USER);
                users.add(user);
            }

            userBulkRepository.bulkInsert(users);
        }
    }
}
