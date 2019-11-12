package com.jk.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.model.Lol;
import com.jk.service.LolService;
import com.jk.util.ExportExcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LolController {
    @Reference
    private LolService lolService;

    @RequestMapping("queryLolList")
    @ResponseBody

    public Map<String,Object> queryLolList(){
        Map<String,Object> map = new HashMap<String,Object>();
        List<Lol> lols = lolService.queryLol();
        map.put("rows",lols);
        return map;
    }

    @RequestMapping("addLol")
    @ResponseBody
    public void addLol(Lol lol){
        lolService.addLol(lol);
    }
    @RequestMapping("deleteLol")
    @ResponseBody
    public void deleteLol(Integer id){
        lolService.deleteLol(id);
    }
    @RequestMapping("queryLolById")
    @ResponseBody
    public Lol queryLolById(Integer id){
        return lolService.queryLolById(id);
    }
    @RequestMapping("updateLol")
    @ResponseBody
    public void updateLol(Lol lol){
         lolService.updateLol(lol);
    }



    @RequestMapping("importexcel")
    public void importexcel(String excelId, HttpServletResponse response){
        List<Lol> list= new ArrayList<Lol>();
        try {
            list = lolService.queryLol();

            //定义表格的标题
            String title ="哎";
            //定义列名
            String[] rowName=new String[5];
            //定义工具类要的数据
            List<Object[]> dataList = new ArrayList<Object[]>();

            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            for (Lol lol:list){
                int cc = 1;
                Object[] obj = new Object[rowName.length];
                if(excelId.equals("1")){
                    rowName[0]="编号";
                    rowName[1]="名称";
                    rowName[2]="类型";
                    rowName[3]="日期";
                    rowName[4]="简介";
                    obj[0] = lol.getL_id();
                    obj[1] = lol.getL_name();
                    obj[2] = lol.getL_type();
                    obj[3] = sdf.format(lol.getL_date());
                    obj[4] = lol.getL_info();
                }else{
                        rowName[0]="编号";
                        if(excelId.contains("2")){
                            obj[cc] = lol.getL_name();
                            rowName[cc]="名称";
                            cc++;
                        }
                        if(excelId.contains("3")){
                            obj[cc] = lol.getL_type();
                            rowName[cc]="类型";
                            cc++;
                        }
                        if(excelId.contains("4")){
                            obj[cc] = sdf.format(lol.getL_date());
                            rowName[cc]="日期";
                            cc++;
                        }
                        if(excelId.contains("5")){
                            obj[cc] = lol.getL_info();
                            rowName[cc]="简介";
                            cc++;
                        }
                }
                dataList.add(obj);
            }

            //循环数据把数据存放到 List<Object[]>
            ExportExcel exportExcel=new ExportExcel(title,rowName,dataList,response);
            exportExcel.export();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }





    @RequestMapping("toshow")
    public String toShow(){
        return "show";
    }
    @RequestMapping("tuxing")
    public String tuxing(){
        return "tuxing";
    }
    @RequestMapping("toAdd")
    public String toAdd(){
        return "add";
    }
    @RequestMapping("toUpdateLol")
    public String toUpdateLol(){
        return "update";
    }
}
