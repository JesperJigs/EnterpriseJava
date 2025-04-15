package org.example.enterprisejava.controllers;
import org.example.enterprisejava.entities.Member;
import org.example.enterprisejava.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members")
    @ResponseBody
    public List<Member> getMembers() {
        return memberService.getMembers();

    }

    @GetMapping("/member/{id}")
    @ResponseBody
    public ResponseEntity<Member> getMember(@PathVariable("id") Long id) {
        return new ResponseEntity<>(memberService.getMemberById(id), HttpStatus.OK);
    }
    @PutMapping("/updatemember")
    @ResponseBody
    public ResponseEntity<Member> updateMember(@RequestBody Member member) {
        return new ResponseEntity<>(memberService.updateMember(member), HttpStatus.OK);
    }

    @PostMapping("/addmember")
    @ResponseBody
    public ResponseEntity<Member> addMember(@RequestBody Member member) {
        return new ResponseEntity<>(memberService.addMember(member), HttpStatus.CREATED);
    }

    @DeleteMapping("/deletemember/{id}")
    @ResponseBody
    public void deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
    }

    @GetMapping("/deletemember")
    public String deleteMember(Model model) {
        model.addAttribute("members", memberService.getMembers());
        return "memberpage";
    }
    @PostMapping("/deletemember")
    public String deleteMemberPost(@RequestParam("id") Long id) {
        memberService.deleteMember(id);
        return "redirect:/admin/deletemember";
    }


}
