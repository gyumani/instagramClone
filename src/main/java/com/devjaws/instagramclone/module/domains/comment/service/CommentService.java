package kr.co.gyusta.module.domains.comment.service;

import kr.co.gyusta.module.common.dao.CommonDao;
import kr.co.gyusta.module.domains.comment.dtos.entities.CommentEntity;
import kr.co.gyusta.module.domains.user.services.UserService;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class CommentService {
    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private CommonDao commonDao;


    @Transactional
    public void insertComment(CommentEntity commentEntity){
        logger.info("==============={}", new Gson().toJson(commentEntity));
        commonDao.insertData("Comment.insertComment",commentEntity);
    }

    @Transactional
    public List<CommentEntity> get(Integer id){
        return commonDao.getList("Comment.readComment",id);
    }


    @Transactional
    public int remove(Integer id){
        return commonDao.deleteData("Comment.delete", id);
    }
}
