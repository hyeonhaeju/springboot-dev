package dev.hyeon.springbootdeveloper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class MemberControllerTest {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void clear() {
        memberRepository.deleteAll(); // sql 실행 되면서 처음 삭제
    }

    @DisplayName("회원정보 리스트 요청")
    @Test
    void getAllMembers() throws Exception {
        // 준비 ( given )
        // 회원 등록 ( 리포지토리 이용해 DB 연결 )
        Member m = new Member("H_NEW");
        Member savedMember = memberRepository.save(m);

        // 실행 ( when )
        // 회원 리스트 요청
        final ResultActions result = mockMvc.perform(get("/member")
                .accept(MediaType.APPLICATION_JSON));

        // 검증 ( then )
        // 준비단계에서 등록한 회원 정보가 반환되어야 함
        result.andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(savedMember.getId()))
                .andExpect(jsonPath("$[0].name").value(savedMember.getName()));
}
}