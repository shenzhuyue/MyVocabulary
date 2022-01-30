//package erii.erii.controller;
//
//import erii.erii.common.SearchFromYoudao;
//import erii.erii.repo.WordRepository;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.tags.Tag;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.bind.annotation.*;
//
//import java.io.IOException;
//import java.util.Map;
//
///**
// * @Classname wordController
// * @Description TODO
// * @Date 2021/11/24 22:07
// * @Created by Administrator
// */
////
////        中文	zh-CHS
////        英文	en
////        日文	ja
//
//@CrossOrigin
//@Configuration
//@Tag(name = "paymentAPI",description = "payment的controller接口。")
//
//@RestController
//
//public class wordController {
//    @Autowired
//    WordRepository wordRepository;
//    public wordController(WordRepository wordRepository){
//        this.wordRepository=wordRepository;
//    }
//    @Operation(method = "POST",description = "查找CH")
//    @PostMapping("/searchCh")
//    public String searchCh(@RequestBody Map<String,String> map) throws IOException {
//        String enToCh= SearchFromYoudao.mySearch(map.get("en"),"en","zh-CHS");
//        return enToCh;
//    }
//
//    @Operation(method = "POST",description = "查找Jp")
//    @PostMapping("/searchJp")
//    public String searchJp(@RequestBody Map<String,String> map) throws IOException {
//        String enToJa= SearchFromYoudao.mySearch(map.get("en"),"en","ja");
//        return enToJa;
//    }
//
//}
