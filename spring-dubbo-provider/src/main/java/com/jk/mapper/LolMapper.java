package com.jk.mapper;

import com.jk.model.Lol;

import java.util.List;

public interface LolMapper {

    Integer querySum();

    List<Lol> queryList();

    void addLol(Lol lol);

    void deleteLol(Integer id);

    Lol queryLolById(Integer id);

    void updateLol(Lol lol);
}
