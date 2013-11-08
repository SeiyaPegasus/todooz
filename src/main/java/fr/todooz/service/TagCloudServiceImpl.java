package fr.todooz.service;

import antlr.StringUtils;
import fr.todooz.domain.Task;
import fr.todooz.util.TagCloud;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: bphan-luong
 * Date: 08/11/13
 * Time: 11:48
 * To change this template use File | Settings | File Templates.
 */
@Service
public class TagCloudServiceImpl implements TagCloudService {
    @Inject
    private SessionFactory sessionFactory;

    @Override
    @Transactional(readOnly = true)
    public TagCloud buildTagCloud(){
        TagCloud  tagCloud = new TagCloud();

        for (String tag : findAllTags()) {
            tagCloud.add(tag.split(","));      // Expression régulière
            //tagCloud.add(StringUtils.split(tag, ","));
        }

        return tagCloud;
    }


    private List<String> findAllTags()  {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("select tags from Task").list();
    }


}
