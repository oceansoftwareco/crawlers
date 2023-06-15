package pro.ivanov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pro.ivanov.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
