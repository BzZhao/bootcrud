package com.bootcrud.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bootcrud.entity.Gongcan;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface GongcanService extends IService<Gongcan>{
    List<Gongcan> selectpage();


}
