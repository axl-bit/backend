package net.practice.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.practice.backend.entity.user;

@Repository
public interface userRepository extends JpaRepository<user, Long> {
}
