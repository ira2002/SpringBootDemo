package com.example.springBootDemo.service;

import com.example.springBootDemo.entity.Criteria;
import com.example.springBootDemo.entity.UserInfo;
import java.util.List;

/**
 * 用户信息<t_user_info>
 * @author	chdaba
 * @version	1.0.0
 * @date	2018-12-24 10:39:30
 */
public interface UserInfoService {
    /**
	 * 根据条件查询记录总数
	 * @param	example
	 */
    int countByExample(Criteria example);

    /**
	 * 根据主键查询记录
	 * @param	id
	 */
    UserInfo selectByPrimaryKey(Integer id);

    /**
	 * 根据条件查询记录集
	 * @param	example
	 */
    List<UserInfo> selectByExample(Criteria example);

    /**
	 * 根据主键删除记录
	 * @param	id
	 */
    int deleteByPrimaryKey(Integer id);

    /**
	 * 根据主键更新属性不为空的记录
	 * @param	record
	 */
    int updateByPrimaryKeySelective(UserInfo record);

    /**
	 * 根据主键更新记录
	 * @param	record
	 */
    int updateByPrimaryKey(UserInfo record);

    /**
	 * 根据条件删除记录
	 * @param	example
	 */
    int deleteByExample(Criteria example);

    /**
	 * 根据条件更新属性不为空的记录
	 * @param	record
	 * @param	example
	 */
    int updateByExampleSelective(UserInfo record, Criteria example);

    /**
	 * 根据条件更新记录
	 * @param	record
	 * @param	example
	 */
    int updateByExample(UserInfo record, Criteria example);

    /**
	 * 保存记录,不管记录里面的属性是否为空
	 * @param	record
	 */
    int insert(UserInfo record);

    /**
	 * 保存属性不为空的记录
	 * @param	record
	 */
    int insertSelective(UserInfo record);
}