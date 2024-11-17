package study.querydsl.controller;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import study.querydsl.entity.Member;
import study.querydsl.entity.Order;
import study.querydsl.entity.Team;
import study.querydsl.repository.MemberRepository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Order 연습용 데이터 추가
 */
@Profile("local")
@Component
@RequiredArgsConstructor
@DependsOn("initMember")
@Slf4j
public class InitOrder {
    private final InitOrderService initOrderService;

    @PostConstruct
    public void init() {
        initOrderService.init();
    }

    @Component
    static class InitOrderService{
        @PersistenceContext
        private EntityManager em;

        //이너클래스는 기본적으로 빈관리 못하기에 아래처럼 사용 불가
        @Autowired
        private MemberRepository memberRepository;

        @Transactional
        public void init() {
            //em으로 멤버를 조회
            //조회한 멤버들을당 주문 2개 or 3개를 넣어줌

//            List<Member> findMember = em.createQuery("select m from Member m", Member.class).getResultList();
            List<Member> findMember = memberRepository.findAll();

            for (int i = 0; i<findMember.size(); i++) {
                Member member = findMember.get(i);
//                log.info("InitOrder's member = {}", member);

                //Order처리
                Order order1 = new Order();
                order1.setProductName("PlayStation" + i);
                order1.setOrderDateTime(LocalDateTime.now());
                order1.setCount(1);

                Order order2 = new Order();
                order2.setProductName("Nintendo" + i);
                order2.setOrderDateTime(LocalDateTime.now());
                order2.setCount(1);

                order1.setMember(member);
                order2.setMember(member);

                em.persist(order1);
                em.persist(order2);
            }
        }
    }
}
