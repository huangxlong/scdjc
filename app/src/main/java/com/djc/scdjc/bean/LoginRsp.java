package com.djc.scdjc.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator
 * on 2018/5/30 星期三.
 */
public class LoginRsp implements Serializable {
    public String templateName;
    public int columnId;
    public List<Column> columnList;


    public class Column implements Serializable {
        public String parentColumn;
        public String auditMan;
        public String articleList;
        public String videoList;
        public String nameRemark;
        public String name;
        public String checkImgPath;
        public String url;
        public String imgPath;
        public String templateName;
        public int id;
        public int rank;
        public int isTop;
        public int parentId;
        public int auditId;
    }

}
