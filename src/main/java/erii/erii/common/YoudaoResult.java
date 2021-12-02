package erii.erii.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Map;

/**
 * @Classname YoudaoResult
 * @Description TODO
 * @Date 2021/12/1 23:29
 * @Created by Administrator
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class YoudaoResult {
    private String errorCode;
    private String query;
    private String[] translation;
    public YoudaoResult(){
    }
}
