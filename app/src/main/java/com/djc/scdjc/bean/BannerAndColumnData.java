package com.djc.scdjc.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator
 * on 2018/5/30 星期三.
 */
public class BannerAndColumnData implements Serializable {
    public String templateName;
    public int columnId;
    public List<Advertising> advertisingList;
    public List<Children> childrenColumn;

    public class Advertising implements Serializable {

        public int id;
        public int adType;
        public int sequence;
        public String imgPath;
        public String addPath;
        public String articleIntroDetails;
    }


    public class Children implements Serializable {
        public String parentColumn;
        public String auditMan;
        public String childrenColumn;
        public String articleList;
        public String videoList;
        public String nameRemark;
        public String name;
        public String checkImgPath;
        public String url;
        public String imgPath;
        public String templateName;
        public int id;
        public int parentId;
        public int isTop;
        public int rank;
        public int auditId;
    }

}
