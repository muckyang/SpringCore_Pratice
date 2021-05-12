package hello.core.repository.member;

import hello.core.domain.member.Member;

public interface MemberRepository {
    void save(Member member);

    Member findById(Long memberId);
}
