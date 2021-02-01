package web.backtospring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
// import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

// import org.springframework.util.StringUtils;
import web.backtospring.entities.Member;
import web.backtospring.repositories.MemberRepository;
import web.backtospring.services.MemberService;

import javax.validation.Valid;


@Controller
public class memberController {

    // @InitBinder
    // public void initBinder(WebDataBinder dataBinder){
    //     StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
    //     dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    // }

    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @GetMapping("/login")
    public String showLoginForm(){
        return "views/loginForm";
    }

    @GetMapping("/edit/{email}")
    public String showUpdateForm(@PathVariable("email") String email, Model model) {
        Member member = memberRepository.findByEmail(email);
        model.addAttribute("member", member);
        return "views/editform";
    }

    @PostMapping("/update/{email}")
    public String updateUser(@PathVariable("email") String email, @Valid Member member, 
        BindingResult result, Model model, @RequestParam("image") MultipartFile multipartFile) {
        try {
            memberService.updateMember(member, multipartFile);
        } catch(Exception exception) {

        }
        model.addAttribute("members", member);
        return "index1";
    }


    @GetMapping("/register")
    public String registerForm(Model model){
        model.addAttribute("member", new Member());
        return "views/registerForm";
    }
    @PostMapping("/register")
    public String registerMember(@Valid Member member, Model model, @RequestParam("image") MultipartFile multipartFile ){
        // if(bindingResult.hasErrors()){
        //     return "views/registerForm";
        // }
        String email = member.getEmail();
        if (memberRepository.findByEmail(email) != null ){
            model.addAttribute("exist",true);
            return "views/registerForm";
        }
        try {
            memberService.createMember(member, multipartFile);
        } catch(Exception exception) {

        }
        model.addAttribute("success", true);
        return "views/loginForm";
    }
}
