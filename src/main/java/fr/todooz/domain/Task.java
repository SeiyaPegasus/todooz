package fr.todooz.domain;
import org.apache.commons.lang.StringUtils;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: bphan-luong
 * Date: 07/11/13
 * Time: 09:38
 * To change this template use File | Settings | File Templates.
 */
public class Task {


    private Date createdAt = new Date();

    private String title;

    private String text;

    private Date date;

    private String tags;

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String[] getTagArray() {
        return StringUtils.split(tags, ",");
    }

}
