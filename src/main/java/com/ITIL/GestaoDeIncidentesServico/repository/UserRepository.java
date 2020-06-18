package com.ITIL.GestaoDeIncidentesServico.repository;

import com.ITIL.GestaoDeIncidentesServico.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {



    Optional<User> findByLoginAndPassword(String login, String password);

    Optional<String> findByLoginAndActive(String login,Boolean active);

    List<User> findByActive(Boolean active);





}
