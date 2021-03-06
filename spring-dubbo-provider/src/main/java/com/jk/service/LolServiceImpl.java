package com.jk.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.jk.mapper.LolMapper;
import com.jk.model.Lol;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LolServiceImpl implements LolService {
    @Autowired
    private LolMapper lolMapper;
    @Override
    public  List<Lol> queryLol() {
        Integer sum = lolMapper.querySum();
        List<Lol> queryList = lolMapper.queryList();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total",sum);
        map.put("rows",queryList);
        return queryList;
    }

    @Override
    public void addLol(Lol lol) {
        lolMapper.addLol(lol);
    }

    @Override
    public void deleteLol(Integer id) {
        lolMapper.deleteLol(id);
    }

    @Override
    public Lol queryLolById(Integer id) {
        return lolMapper.queryLolById(id);
    }

    @Override
    public void updateLol(Lol lol) {
        lolMapper.updateLol(lol);
    }
}
