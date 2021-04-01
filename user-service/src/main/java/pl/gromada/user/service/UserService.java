package pl.gromada.user.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.gromada.user.VO.Department;
import pl.gromada.user.VO.ResponseTemplateVO;
import pl.gromada.user.entity.User;
import pl.gromada.user.repository.UserRepository;

@Service
@Slf4j
public class UserService {

    private UserRepository userRepository;

    private RestTemplate restTemplate;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public User saveUser(User user) {
        log.info("Method saveUser inside of UserService");
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        log.info("Method getUserWithDepartment inside of UserService");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findById(userId).orElseThrow(IllegalArgumentException::new);

        Department department = restTemplate.getForObject("http://department-service/departments/" + user.getDepartmentId(),
                Department.class);

        vo.setUser(user);
        vo.setDepartment(department);

        return vo;
    }
}
