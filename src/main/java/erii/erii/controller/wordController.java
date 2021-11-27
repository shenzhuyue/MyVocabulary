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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping("/search")
    public Result<?> search(@Parameter String en){
        word curWord=wordRepository.findAllByEn(en);
        return Result.ok(curWord);
    }
}
