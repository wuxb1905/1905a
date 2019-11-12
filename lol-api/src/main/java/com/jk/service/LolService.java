package com.jk.service;

import com.jk.model.Lol;

import java.util.List;
import java.util.Map;

public interface LolService {
    List<Lol> queryLol();

    void addLol(Lol lol);

    void deleteLol(Integer id);

    Lol queryLolById(Integer id);

    void updateLol(Lol lol);
}
