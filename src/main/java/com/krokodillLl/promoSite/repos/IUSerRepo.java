package com.krokodillLl.promoSite.repos;

import com.krokodillLl.promoSite.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUSerRepo extends JpaRepository<User, Long> {
    User findUserByEmail(String email);
}
