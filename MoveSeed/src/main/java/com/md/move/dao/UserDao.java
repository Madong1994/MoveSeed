package com.md.move.dao;

import com.md.move.entity.User;
import org.apache.ibatis.annotations.Select;

/**
 * @类名: ${CLASS_NAME}
 * @包名: com.md.move.dao
 * @描述: ${TODO}(用一句话描述该文件做什么)
 * @日期: 2018/1/8 10:53
 * @版本: V1.0
 * @创建人：马东
 * @修改人：马东
 */
public interface UserDao {

    @Select("SELECT * FROM user")
    User findAll();
}
