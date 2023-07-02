package hello.hellopsring.repository;

import hello.hellopsring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;   //sequence: 0,1,2 .... 키값 생성

    @Override
    public Member save(Member member) {
        member.setId(++sequence);           //store에 넣기 전에 멤버의 id값 세팅, 이름은 넘어온 상태
        store.put(member.getId(), member);  //store에 저장
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {

        return Optional.ofNullable(store.get(id));  // Optional.ofNullable: id가 null일 경우 감싸서 반환

    }

    @Override
    public Optional<Member> findByName(String name) {

       return store.values().stream()                                       //loop로 돌림
                    .filter(member -> member.getName().equals(name))        //member.getname이 파라미터로 넘어온 이름이랑 같은지 비교
                    .findAny();                                             //같은 경우만 필터링
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());             //store.values() : 멤버들
    }

    public void clearStore(){
        store.clear();
    }
}
