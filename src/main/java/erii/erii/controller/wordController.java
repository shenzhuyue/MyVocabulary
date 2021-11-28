package erii.erii.controller;

import erii.erii.common.Result;
import erii.erii.entity.word;
import erii.erii.repo.WordRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hibernate.loader.plan.spi.Return;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

/**
 * @Classname wordController
 * @Description TODO
 * @Date 2021/11/24 22:07
 * @Created by Administrator
 */

@CrossOrigin
@Configuration
@Tag(name = "paymentAPI",description = "payment的controller接口。")
@RestController
public class wordController {
    @Autowired
    WordRepository wordRepository;
    public wordController(WordRepository wordRepository){
        this.wordRepository=wordRepository;
    }
    @Operation(method = "GET",description = "查找")
    @PostMapping("/search")
    public Result<?> search(@RequestParam(value = "ch",required = false) String ch,@RequestParam(value = "en",required = false) String en,@RequestParam(value = "jp",required = false) String jp){
        word curWord=wordRepository.findAllByEn(en);
        System.out.println(curWord);
        return Result.ok(curWord);
    }
}
