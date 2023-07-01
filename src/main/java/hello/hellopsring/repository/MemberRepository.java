package hello.hellopsring.repository;

import hello.hellopsring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {


    Member save(Member member);         //회원을 저장소에 저장
    Optional<Member> findById(Long id); //저장소에서 멤버를 findById로 찾을수 있음
    Optional<Member> findByName(String name);  //저장소에서 멤버를 findByName로 찾을수 있음
    List<Member> findAll();                    // 모든 멤버 리스트를 반환

}
