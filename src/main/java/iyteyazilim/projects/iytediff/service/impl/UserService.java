package iyteyazilim.projects.iytediff.service.impl;

import iyteyazilim.projects.iytediff.dto.LoginDto;
import iyteyazilim.projects.iytediff.dto.Role;
import iyteyazilim.projects.iytediff.entity.User;
import iyteyazilim.projects.iytediff.repository.UserRepository;
import iyteyazilim.projects.iytediff.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(Long id) {
        return userRepository.getReferenceById(id);
    }


    public Optional<List<User>> getUsersByUserRole(Role role) {
        return userRepository.findByUserRole(role);
    }

    @Override
    public void updateUser(User user, Long id) {

    }

    public User updateLoginUser(LoginDto loginUser, Long id) {
        return userRepository.findById(id).map(user -> {
            user.setUsername(loginUser.getUsername());
            user.setPassword(loginUser.getPassword());
            return userRepository.save(user);
        }).orElseThrow(() -> new RuntimeException("User not found with id " + id));
    }

    public User login(LoginDto loginUser) {
        return userRepository.findByUsername(loginUser.getUsername())
                .filter(user -> user.getPassword().equals(loginUser.getPassword()))
                .orElseThrow(() -> new RuntimeException("Invalid username or password"));
    }

    @Override
    public void deleteUser(Long id) {

    }
}
