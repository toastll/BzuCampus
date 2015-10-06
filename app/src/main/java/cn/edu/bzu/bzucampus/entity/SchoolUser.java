package cn.edu.bzu.bzucampus.entity;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.datatype.BmobFile;

/**
 * 用户实体类
 * Created by monster on 2015/10/6.
 * 特别注意：在BmobUser的表中，已经存在账号，密码，手机号，邮箱，所以不必在实体类中重复书写，否则将导致程序出错
 */
public class SchoolUser extends BmobUser{
    private String nick; //昵称
    private BmobFile userPhoto; //头像

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public BmobFile getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(BmobFile userPhoto) {
        this.userPhoto = userPhoto;
    }
}
