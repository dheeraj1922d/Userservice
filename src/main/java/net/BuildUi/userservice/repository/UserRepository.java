package net.BuildUi.userservice.repository;

import net.BuildUi.userservice.entity.UserInfoDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserInfoDto , String> {
    UserInfoDto findByUserId(String userId);
}
