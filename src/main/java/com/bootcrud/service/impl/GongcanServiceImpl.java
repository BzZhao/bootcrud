package com.bootcrud.service.impl;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bootcrud.mapper.GongcanMapper;
import com.bootcrud.entity.Gongcan;
import com.bootcrud.service.GongcanService;
@Service
public class GongcanServiceImpl extends ServiceImpl<GongcanMapper, Gongcan> implements GongcanService{
    @Autowired
    GongcanMapper gongcanMapper;
    @Override
    public List<Gongcan> selectpage() {
        PageHelper.startPage(1,5);
        List<Gongcan> data = (List<Gongcan>) gongcanMapper.selectByPage();
        PageInfo<Gongcan> pageInfo = new PageInfo<>(data);
        data = pageInfo.getList();
        return data;
    }
}
