package com.devjaws.instagramclone.configs.database.dao;

import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommonDao implements ICommonDao{
    private final SqlSession session;

    @Override
    public int getCount(String query, Object search) throws DataAccessException {
        return (int)session.selectOne(query, search);
    }

    @Override
    public <E> List<E> getList(String query, Object search) throws DataAccessException {
        return session.selectList(query,search);
    }

    @Override
    public <E> E getData(String query, Object search) throws DataAccessException {
        return session.selectOne(query, search);
    }

    @Override
    public void insertData(String query, Object model) throws DataAccessException {
        session.insert(query,model);
    }

    @Override
    public void updateData(String query, Object model) throws DataAccessException {
        session.update(query,model);
    }

    @Override
    public int updateData(String query) throws DataAccessException {
        return session.update(query);
    }

    @Override
    public int deleteData(String query, Object search) throws DataAccessException {
        return session.delete(query,search);
    }
}
