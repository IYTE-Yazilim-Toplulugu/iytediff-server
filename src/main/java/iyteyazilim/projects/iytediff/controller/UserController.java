package iyteyazilim.projects.iytediff.controller;

import iyteyazilim.projects.iytediff.dto.LoginDto;
import iyteyazilim.projects.iytediff.dto.Role;
import iyteyazilim.projects.iytediff.entity.User;
import iyteyazilim.projects.iytediff.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User u = userService.addUser(user);
        return ResponseEntity.ok(u);
    }

    @PostMapping("/addManyUser")
    public String addManyUser(@RequestBody List<User> users) {
        for (User u : users) {
            userService.addUser(u);
        }
        return "Success";
    }

    @GetMapping("/getAllUsers")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody LoginDto user) {
        return ResponseEntity.ok(userService.updateLoginUser(user, id));
    }


    @GetMapping("/getStudents")
    public ResponseEntity<Optional<List<User>>> getStudents() {
        return ResponseEntity.ok(userService.getUsersByUserRole(Role.STUDENT));
    }
    @GetMapping("/getInstructors")
    public ResponseEntity<Optional<List<User>>> getInstructors() {
        return ResponseEntity.ok(userService.getUsersByUserRole(Role.INSTRUCTOR));
    }


    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody LoginDto loginUser) {
        try {
            User user = userService.login(loginUser);
            return ResponseEntity.ok(user);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // 404 response
        }
    }

}
