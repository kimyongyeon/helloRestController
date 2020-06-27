package com.hello.hellorestcontroller.jpa;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
@Profile("jpa")
// dao => repository
public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
    void delete(long i);
}
