package example.demoproject.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import example.demoproject.model.member;
import example.demoproject.service.memberService;

@RestController
@RequestMapping("/members")
public class memberController {

    private final memberService service;

    public memberController(memberService service) {
        this.service = service;
    }

    // GET all members
    @GetMapping
    public List<member> getAllMembers() {
        return service.getAllMembers();
    }

    // GET member by ID
    @GetMapping("/{id}")
    public member getMemberById(@PathVariable Long id) {
        return service.getMemberById(id);
    }

    // POST - create a new member
    @PostMapping
    public member createMember(@RequestBody member member) {
        return service.saveMember(member);
    }

    // PUT - update an existing member
    @PutMapping("/{id}")
    public member updateMember(
            @PathVariable Long id,
            @RequestBody member updatedMember) {

        return service.updateMember(id, updatedMember);
    }

    // DELETE - delete a member
    @DeleteMapping("/{id}")
    public void deleteMember(@PathVariable Long id) {
        service.deleteMember(id);
    }
}