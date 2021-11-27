package erii.erii.entity;

import lombok.Data;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @Classname word
 * @Description TODO
 * @Date 2021/11/24 21:53
 * @Created by Administrator
 */

@Data
@Entity
@Getter
@Setter
public class word {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ch;
    private String en;
    private String jp;
}
