package com.miao.mapper;

import com.miao.domain.Systemlog;
import java.util.List;

public interface SystemlogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Systemlog record);

    Systemlog selectByPrimaryKey(Long id);

    List<Systemlog> selectAll();

    int updateByPrimaryKey(Systemlog record);
}