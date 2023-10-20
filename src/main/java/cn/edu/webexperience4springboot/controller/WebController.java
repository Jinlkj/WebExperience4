package cn.edu.webexperience4springboot.controller;

import cn.edu.webexperience4springboot.pojo.RequestForm;
import cn.edu.webexperience4springboot.pojo.Result;
import cn.edu.webexperience4springboot.pojo.SortArray;
import cn.edu.webexperience4springboot.pojo.SortData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
public class WebController {
    @Autowired
    SortArray sortArray;
    @PostMapping("/sort")
    public Result getArrayOrder(@RequestBody RequestForm requestForm){
        try {
            log.info(requestForm.getArray());
            String res=sortArray.bubbleSort(requestForm.getArray(),requestForm.getOrder());
            LocalDate date= LocalDate.now();
            SortData sortData=new SortData(1,requestForm.getArray(),res,date,requestForm.getOrder(),"冒泡排序");
            sortArray.insertRecord(sortData);
            log.info("Success Insert");
            return Result.success(res);
        }catch (Exception e){
            System.out.println(e);
            return Result.error("排序发生错误");
        }
    }
    @PostMapping("/init")
    public Result getInitPage(){
        List<SortData> res=sortArray.getInitPage();
        boolean flag=res.isEmpty();
        if(flag){
            return Result.success(null);
        }else{
            return Result.success(res);
        }
    }


}
