package web.backtospring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.propertyeditors.StringTrimmerEditor;
// import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
// import org.springframework.validation.BindingResult;
// import org.springframework.web.bind.WebDataBinder;
//  import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
//  import org.springframework.web.bind.annotation.InitBinder;
// import org.springframework.web.bind.annotation.InitBinder;

import web.backtospring.entities.Member;
import web.backtospring.repositories.MemberRepository;

import java.security.Principal;
// import java.sql.SQLOutput;
import java.util.Date;

// import javax.validation.Valid;

// import javax.validation.Valid;

@Controller
public class IndexController {
    
    // @InitBinder
    // public void initBinder(WebDataBinder dataBinder){
    //     StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
    //     dataBinder.registerCustomEditor(String.class , stringTrimmerEditor);
    // }

    @Autowired
    MemberRepository memberRepository;

    @GetMapping("/")
    public String showIndex(Model model, Principal principal,  Member member ){
        
        // if(bindingResult.hasErrors()){
        //     return "views/loginForm";
        // }

        if(principal == null){
            return "views/loginForm";
        }
        model.addAttribute("message", "Hello everyone, we are go to back to Spring with together");
        model.addAttribute("date", new Date());
        model.addAttribute("members", memberRepository.getOne(principal.getName()));
        return "index1";
    }
}