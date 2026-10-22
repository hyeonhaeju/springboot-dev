package dev.hyeon.springbootdeveloper;

import org.hibernate.annotations.SQLInsert;
import org.hibernate.annotations.processing.SQL;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Sql("/insert-members.sql")
    @DisplayName("MemberRepository를 통해 member 테이블의 모든 레코드(3개) 가져오기.")
    @Test
    public void getAllMembers() {
        // 준비 given

        // 실행 when
        List<Member> members = memberRepository.findAll(); // select * from member;

        // 검증 then
        assertThat(members.size()).isEqualTo(3);
    }

    @Sql("/insert-members.sql")
    @DisplayName("MemberRepository를 통해 이름이 'C'인 레코드 가져오기")
    @Test
    public void getMemberByName() {
        // 준비 given


        // 실행 when : select * from member where name =?
        Optional<Member> optMember = memberRepository.findByName("C");
        Member member = optMember.get();

        // 검증 then
        assertThat(member.getId()).isEqualTo(3);
    }

    // select * from member where id = ?

    @Sql("/insert-members.sql")
    @DisplayName("MemberRepository를 통해 Id가 2인 레코드 가져오기")
    @Test
    public void getMemberById() {
        // 준비 give

        // 실행 when
        Member member = memberRepository.findById(2L).get();

        // 검증 then
        assertThat(member.getName()).isEqualTo("B");
    }

    @DisplayName("MemberRepository를 통해 이름이 '주현해'인 레코드 추가하기")
    @Test
    public void saveMember() {
        // 준비 given : Member 객체를 생성
        Member member = new Member("주현해");

        // 실행 when
        memberRepository.save(member);

        // 검중 then
        // member 테이블에서 모든 레코드를 select 했을 때 레코드의 수가 1이고
        // 그 레코드의 name 컬럼 값이 '주현해' 인지 확인해 본다.

        List<Member> result = memberRepository.findAll();
        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0).getName()).isEqualTo("주현해");
    }

    @DisplayName("데이블 member 에서 id 3인 레코드 삭제하기")
    @Test
    public void deleteById() {
        // 준비

        // 실행

        // 검증

    }


}