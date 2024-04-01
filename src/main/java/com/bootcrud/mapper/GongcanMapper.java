package com.bootcrud.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bootcrud.entity.Gongcan;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GongcanMapper extends BaseMapper<Gongcan> {

    Page<Gongcan> selectByPage();

}