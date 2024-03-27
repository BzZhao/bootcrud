package com.bootcrud.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bootcrud.mapper.GongcanMapper;
import com.bootcrud.entity.Gongcan;
import com.bootcrud.service.GongcanService;
@Service
public class GongcanServiceImpl extends ServiceImpl<GongcanMapper, Gongcan> implements GongcanService{

}
