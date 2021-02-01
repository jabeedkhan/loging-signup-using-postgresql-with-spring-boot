package web.backtospring.services;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import web.backtospring.entities.Member;
import web.backtospring.entities.Role;
import web.backtospring.repositories.MemberRepository;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public Member createMember(Member member, @RequestParam("image") MultipartFile multipartFile) throws IOException{
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        member.setPassword(encoder.encode(member.getPassword()));
        Role memberRole = new Role("ADMIN");
        List<Role> roles = new ArrayList<>();
        roles.add(memberRole);
        member.setRole(roles);
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        member.setPhoto(fileName);
        // byte [] byteArr=multipartFile.getBytes();
        // InputStream inputStream = new ByteArrayInputStream(byteArr);
        // member.setImagedata(byteArr);
        Member savedUser = memberRepository.save(member);
        String uploadDir = "./user-photos/" + savedUser.getEmail();
        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
        return member;
    }
    public Member updateMember(Member member, @RequestParam("image") MultipartFile multipartFile) throws IOException{
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        member.setPassword(encoder.encode(member.getPassword()));
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        member.setPhoto(fileName);
        Member savedUser = memberRepository.save(member);
        String uploadDir = "./user-photos/" + savedUser.getEmail();
        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
        return member;
    }
}
