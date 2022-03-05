package com.example.controller.Algo;


import com.alibaba.excel.util.StringUtils;
import com.example.common.lang.Result;
import com.example.utils.EasyExcelUtil;
import com.example.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/algo/algochoice")
public class AlgoController {
    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("ChoiceAndCompute/{token}/{value}/{param}")
    public Result Algo1Main(MultipartFile file,
                            @PathVariable("token") String token,
                            @PathVariable("value") String value,
                            @PathVariable("param") String param) {
        Claims claims = jwtUtils.getClaimByToken(token);
        System.out.println(claims);
        String id = claims.getSubject();
        System.out.println(id);
        System.out.println("选择界面接收到");
        ArrayList<HashMap<String, String>> list = new ArrayList<>();
        if(value.equals("选项1")){
            System.out.println("选项1的内容被算法一调用");
            System.out.println("接收到");
            Map<String, List<List<String>>> mapS1=new HashMap<>();
            Map<String, List<List<String>>> mapS2=new HashMap<>();
            Map<String, List<List<String>>> mapS3=new HashMap<>();


            try {
                InputStream in1 = file.getInputStream();
                mapS1 = EasyExcelUtil.readExcelByStringFromInputStream(in1, "Sheet1");
            System.out.println(mapS1);
                InputStream in2 = file.getInputStream();
                mapS2 = EasyExcelUtil.readExcelByStringFromInputStream(in2, "Sheet2");
            System.out.println(mapS2);
                InputStream in3 = file.getInputStream();
                mapS3 = EasyExcelUtil.readExcelByStringFromInputStream(in3, "Sheet3");
            System.out.println(mapS3);
            } catch (Exception e) {
                e.printStackTrace();
            }

            HashMap<String, String> map1 = new HashMap<>();
            HashMap<String, String> map2 = new HashMap<>();

            map2.put("mission","mission1");
            map2.put("server","server1");
            map1.put("conclusion","conclusion");
            map1.put("time","1s");
            list.add(map2);
            list.add(map1);














        } else if(value.equals("选项2")){
            System.out.println("选项2的内容被算法2调用");


        }else{
            return Result.fail("上传出现错误");
        }
        System.out.println(param);

        return Result.succ(list);
    }




}
