package erii.erii.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Classname pageController
 * @Description TODO
 * @Date 2021/11/30 23:40
 * @Created by Administrator
 */
@Controller
public class pageController {
    @RequestMapping({"/vocabulary"})
    public String indexVocabulary() {
        return "vocabulary";
    }
}
