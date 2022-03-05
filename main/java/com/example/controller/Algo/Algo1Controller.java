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
@RequestMapping("/algo/algo1")
public class Algo1Controller {

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private SysUserService sysUserService;

    @PostMapping("SaveAndComputealgo1/{token}")
    public Result Algo1Main(MultipartFile file,@PathVariable("token") String token) {



        return Result.succ(1);
    }




//    @GetMapping("ReadHistory/{userId}")
//    public Result Algo1History(@PathVariable String userId){
//
//
//        return Result.succ();
//    }


}
