package org.example.enterprisejava.repositories;

import org.example.enterprisejava.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository <Member, Long> {
}
