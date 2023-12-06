package org.perscholas.springboot.service;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.springboot.database.dao.UserDAO;
import org.perscholas.springboot.database.entity.User;
import org.perscholas.springboot.formbean.RegisterUserFormBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {
    @Autowired
    private UserDAO userDao;

    public User createUser(RegisterUserFormBean form) {
        log.debug("id" + form.getId());
        log.debug("email: " + form.getEmail());
        log.debug("password: " + form.getPassword());
        log.debug("confirm password: " + form.getConfirmPassword());

        User user = userDao.findById(form.getId());

        if (user == null) {
            user = new User();
        }

        user.setEmail(form.getEmail());
        user.setPassword(form.getPassword());

        return userDao.save(user);
    }
}
