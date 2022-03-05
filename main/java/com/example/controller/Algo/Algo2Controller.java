package com.example.controller.Algo;


import com.example.common.lang.Result;
import com.example.service.SysUserService;

import com.example.utils.EasyExcelUtil;
import com.example.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/algo/algo2")
public class Algo2Controller {

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private SysUserService sysUserService;

    @PostMapping("SaveAndComputealgo2/{token}")
    public Result Algo2Main(MultipartFile file,@PathVariable("token") String token) {

        //接收到的数据入口

        return Result.succ(1);
    }

    public String[][] tostring1(Map<String,List<List<String>>> map){
        List<List<String>> lists = map.get("Sheet1");
        String[][] strings = new String[lists.size()][lists.get(0).size()];
        for (int i = 0; i < lists.size(); i++) {
            for (int j = 0; j < lists.get(i).size(); j++) {
                strings[i][j] = lists.get(i).get(j);
            }
        }
        return strings;
    }


}
