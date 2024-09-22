package iyteyazilim.projects.iytediff.service;

import iyteyazilim.projects.iytediff.entity.User;

import java.util.List;

public interface IUserService {
    public User addUser(User user);
    public List<User> getUsers();
    public User getUser(Long id);
    public void updateUser(User user, Long id);
    public void deleteUser(Long id);
}
