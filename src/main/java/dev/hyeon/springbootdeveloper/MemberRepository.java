package dev.hyeon.springbootdeveloper;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    // findALL, findId, save, deleteById, deleteALL, ....
    // select * from member;
    // select * from member where id = ?;
    // insert into ..., update member
    // delete from member where id = ? ;
    // delete from member ;

    // select * from member where name = ?;
    public Optional<Member> findByName(String name) ;
}
