package pl.gromada.department.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.gromada.department.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
