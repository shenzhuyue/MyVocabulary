package erii.erii.repo;

import erii.erii.entity.word;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Classname WordRepository
 * @Description TODO
 * @Date 2021/11/24 21:58
 * @Created by Administrator
 */
public interface WordRepository extends JpaRepository<word,Long> {
    word findAllById(Long id);
    word findAllByEn(String en);
}
