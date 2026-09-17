package example.demoproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import example.demoproject.model.member;
import example.demoproject.repository.memberRepository;

@Service
public class memberService {

    private final memberRepository repository;

    public memberService(memberRepository repository) {
        this.repository = repository;
    }

    // Get all members
    public List<member> getAllMembers() {
        return repository.findAll();
    }

    // Get member by ID
    public member getMemberById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                    new RuntimeException("Member not found with id: " + id));
    }

    // Save new member
    public member saveMember(member member) {
        return repository.save(member);
    }

    // Delete member
    public void deleteMember(Long id) {
        repository.deleteById(id);
    }

    // Update member
    public member updateMember(Long id, member updatedMember) {

        return repository.findById(id)
                .map(existingMember -> {

                    existingMember.setName(updatedMember.getName());
                    existingMember.setPhone(updatedMember.getPhone());

                    return repository.save(existingMember);
                })
                .orElseThrow(() ->
                    new RuntimeException("Member not found with id: " + id));
    }
}