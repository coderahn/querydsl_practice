package study.querydsl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import study.querydsl.entity.Member;

import java.util.List;

//인터페이스는 여러개 상속 가능
//인터페이스가 인터페이스를 필요할때 구현이 아닌 상속
public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryCustom, QuerydslPredicateExecutor<Member> {

    //select m from Member m where m.username =  ?
    List<Member> findByUsername(String username);

}
