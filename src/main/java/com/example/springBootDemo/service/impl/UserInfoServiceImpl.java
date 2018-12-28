package com.example.springBootDemo.service.impl;

import com.example.springBootDemo.dao.UserInfoDAO;
import com.example.springBootDemo.entity.Criteria;
import com.example.springBootDemo.entity.UserInfo;
import com.example.springBootDemo.service.UserInfoService;

import java.util.List;
import org.apache.log4j.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    private static final Logger logger = Logger.getLogger(UserInfoServiceImpl.class);

    @Autowired
    private UserInfoDAO userInfoDAO;

    @Override
    public int countByExample(Criteria example) {
        return this.userInfoDAO.countByExample(example);
    }

    @Override
    public UserInfo selectByPrimaryKey(Integer id) {
        return this.userInfoDAO.selectByPrimaryKey(id);
    }

    @Override
    public List<UserInfo> selectByExample(Criteria example) {
        return this.userInfoDAO.selectByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return this.userInfoDAO.deleteByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(UserInfo record) {
        return this.userInfoDAO.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UserInfo record) {
        return this.userInfoDAO.updateByPrimaryKey(record);
    }

    @Override
    public int deleteByExample(Criteria example) {
        return this.userInfoDAO.deleteByExample(example);
    }

    @Override
    public int updateByExampleSelective(UserInfo record, Criteria example) {
        return this.userInfoDAO.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(UserInfo record, Criteria example) {
        return this.userInfoDAO.updateByExample(record, example);
    }

    @Override
    public int insert(UserInfo record) {
        return this.userInfoDAO.insert(record);
    }

    @Override
    public int insertSelective(UserInfo record) {
        return this.userInfoDAO.insertSelective(record);
    }
}