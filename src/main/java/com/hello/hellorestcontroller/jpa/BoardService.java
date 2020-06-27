package com.hello.hellorestcontroller.jpa;

import com.hello.hellorestcontroller.model.BoardDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;

@Profile("jpa")
@Service
public class BoardService {

    @Autowired
    BoardRepository repository;

    @Autowired
    EntityManagerFactory emf;

    @Transactional
    public void boardWrite(BoardDTO boardDTO) {

        // batch => 대용량 처리 => delete 1,10,100만건 , insert 1,10,100만건
        // 기본정잭 JPA : auto commit => manual commit
        // 디테일 쪼갠다. => spring batch+Scheduled 대용량 라이브러리, 쿼츠 스케줄링 라이브러리
        // crontab => linux => 스케줄 툴 => Scheduled
        // 새벽 1:00 100만건 delete 걸어났어 => 시스템 장애 => 1:00 안돔 => 정산안됨
        // 새벽 1:00 100만건 스케줄러 + 5분마다 100만건 삭제하는 스케줄러 => 정산 문자 => 비정상 문자 => 회사 출근 / 재택 복구
        // 스케줄러 => 이중화 100만건 스케줄러 본체 + 5분마다 콜해서 확인하는거는 다른서버 ping, health check
        // 쿼츠 => 지가 뒤져도 다시 살아서 아까 못했던 일을 히스토리에서 찾아서 완벽하게 돌려줘요.
        // 스프링 배치를 쓰는 이유 => 청크 기술 사용한다. => 100만건 => 100개씩 쪼개서 커밋을 때려준다.
        System.out.println("백만건 삭제 시작 ");
        // manual commit
        for(long i=0; i<100000000; i++) {
            // memory
            repository.delete(i);
            // db insert 1건 저장해요. X
            // insert => flush X
        }
        // memory 100만건 들어가 있음
        // insert => 100만건 bulk
        // flush
        // auto commit
        System.out.println("백만건 삭제 성공");


//        EntityManager em = emf.createEntityManager();
//        EntityTransaction tx = em.getTransaction();
//        try {
//            // begin
//            tx.begin();
            // select
            BoardEntity boardEntity = repository.findById(0L).get();
            // 값변경
            boardEntity.setId(2L);
            // update && insert
            repository.save(boardEntity);

//            // memory to insert
//            tx.commit();
//
//        } catch (Exception e) {
//            tx.rollback();
//        }
    }
}
