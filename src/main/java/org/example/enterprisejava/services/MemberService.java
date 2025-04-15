package org.example.enterprisejava.services;

import org.example.enterprisejava.entities.Member;
import org.example.enterprisejava.exceptions.ResourceNotFoundException;
import org.example.enterprisejava.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MemberService implements MemberServiceInterface{

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public List<Member> getMembers() {
        return memberRepository.findAll();
    }

    @Override
    public Member getMemberById(Long id) {
        return memberRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Member", "Id", id));
    }

    @Override
    public Member updateMember(Member member) {
        return memberRepository.save(member);
    }


    @Override
    public Member addMember(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public void deleteMember(Long id) {
        memberRepository.deleteById(id);

    }
}
