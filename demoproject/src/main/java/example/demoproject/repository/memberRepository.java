package example.demoproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import example.demoproject.model.member;

public interface memberRepository extends JpaRepository<member, Long> {

}