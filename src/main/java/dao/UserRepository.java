package dao;

import models.User;

public interface UserRepository {
    User findById(String id);
}
