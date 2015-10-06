package cn.edu.bzu.bzucampus.entity;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobFile;

/**
 * TopNews实体类
 * Created by monster on 2015/10/6.
 */
public class TopNews extends BmobObject{
    private String title;      //帖子的标题
    private String content;  //帖子的内容

    private SchoolUser author ;//帖子的作者
    private BmobFile newsImg;  //新闻中的图片



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public SchoolUser getAuthor() {
        return author;
    }

    public void setAuthor(SchoolUser author) {
        this.author = author;
    }

    public BmobFile getNewsImg() {
        return newsImg;
    }

    public void setNewsImg(BmobFile newsImg) {
        this.newsImg = newsImg;
    }
}
