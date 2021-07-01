package com.devjaws.instagramclone.configs.database.dao;

import org.springframework.dao.DataAccessException;

import java.util.List;

public interface ICommonDao {
    int getCount(String query, Object search) throws DataAccessException;
    <E> List<E> getList(String query, Object search) throws DataAccessException;
    <E> E getData(String query, Object search) throws DataAccessException;
    void insertData(String query, Object model) throws DataAccessException;
    void updateData(String query, Object model) throws DataAccessException;
    int updateData(String query) throws DataAccessException;
    int deleteData(String query, Object search) throws DataAccessException;
    Integer getPostId(String query, Integer id) throws DataAccessException;
}
