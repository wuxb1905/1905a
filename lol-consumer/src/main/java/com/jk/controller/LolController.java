package com.jk.controller;

import com.jk.model.Lol;
import com.jk.service.LolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class LolController {
    @Autowired
    private LolService lolService;


    @RequestMapping("queryLolList")
    @ResponseBody

    public Map<String,Object> queryLolList(){
        return null;
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









    @RequestMapping("toshow")
    public String toShow(){
        return "show";
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
