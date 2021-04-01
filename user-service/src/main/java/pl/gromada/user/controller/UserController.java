package pl.gromada.user.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.gromada.user.VO.ResponseTemplateVO;
import pl.gromada.user.entity.User;
import pl.gromada.user.service.UserService;

@RestController
@Slf4j
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/")
    public User saveUser(@RequestBody User user) {
        log.info("Method saveUser inside of UserController");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId) {
        log.info("Method getUserWithDepartment inside of UserController");
        return userService.getUserWithDepartment(userId);
    }

}
