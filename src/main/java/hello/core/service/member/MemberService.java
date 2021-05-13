package hello.core.service.member;

import hello.core.domain.member.Member;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);
}
