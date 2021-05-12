package hello.core.member;


import hello.core.config.AppConfig;
import hello.core.domain.member.Grade;
import hello.core.domain.member.Member;
import hello.core.service.MemberService;
import hello.core.service.MemberServiceImpl;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class MemberServiceTest {
    AppConfig appConfig = new AppConfig();
    MemberService memberService = appConfig.memberService();

    @Test
    void join(){
        //given
        Member member = new Member(1L,"memberA", Grade.VIP);
        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then
        assertThat(findMember).isEqualTo(member);
    }

}
