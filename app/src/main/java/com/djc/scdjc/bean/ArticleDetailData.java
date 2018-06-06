package com.djc.scdjc.bean;

import java.util.List;

/**
 * Created by Administrator
 * on 2018/6/1 星期五.
 */
public class ArticleDetailData {


    /**
     * upArticle : null
     * columnId : 3
     * article : {"employee":{"department":null,"roles":[],"columns":[],"departments":[],"newPassword":null,"roleStrs":null,"columnStrs":null,"id":null,"userName":null,"headImg":"/upload/image/image/40c360ea-4bad-45a1-9a97-8071a9e894d5cj.jpg","quickMark":null,"phoneNum":null,"realName":"陈娟","passWord":null,"inputTime":null,"readingQuantity":650,"thumbUpQuantity":46,"practiceNum":"A1140117070001","riskDisclosure":null,"disclaimer":"","state":null,"employeeDetails":"","employeeRoles":[]},"column":{"parentColumn":null,"auditMan":null,"childrenColumn":null,"articleList":null,"videoList":null,"nameRemark":"炼金-谈股论金","id":null,"name":"谈股论金","checkImgPath":null,"url":null,"imgPath":null,"parentId":null,"auditId":null,"templateName":null,"rank":null,"isTop":null},"systemDictionaryItem":null,"children":null,"createTimeStr":null,"id":433,"teacherId":6,"title":"政策叠加机构看好，该板块后续有望延续","titleImg":"/upload/image/image/7e8820d5-0c90-4555-b9c6-4285bcdc4729zhang.png","tagId":null,"source":"四川大决策","creationTime":1527750503000,"updateTime":null,"thumbUpQuantity":100,"readingQuantity":102,"top":0,"parentId":null,"columnId":3,"articleIntro":"截止一季度末，国家队一共持有股票市值为2523.18亿元，权重白马占比较大。","url":"","urlTitle":"","voiceTitle":"","voicePath":"","auditId":null,"auditTime":null,"auditRemark":null,"stocks":null,"state":0,"articleIntroDetails":"dddddddddddddddddddddddddddddd"}
     * columnName : 炼金
     * nextArticle : {"employee":{"department":null,"roles":[],"columns":[],"departments":[],"newPassword":null,"roleStrs":null,"columnStrs":null,"id":null,"userName":null,"headImg":null,"quickMark":null,"phoneNum":null,"realName":"陈娟","passWord":null,"inputTime":null,"readingQuantity":null,"thumbUpQuantity":null,"practiceNum":null,"riskDisclosure":null,"disclaimer":null,"state":null,"employeeDetails":null,"employeeRoles":[]},"column":null,"systemDictionaryItem":null,"children":[],"createTimeStr":null,"id":432,"teacherId":6,"title":"政策叠加机构看好，该板块后续有望延续","titleImg":"/upload/image/image/7e8820d5-0c90-4555-b9c6-4285bcdc4729zhang.png","tagId":null,"source":"四川大决策","creationTime":1527750503000,"updateTime":null,"thumbUpQuantity":100,"readingQuantity":100,"top":0,"parentId":null,"columnId":3,"articleIntro":"截止一季度末，国家队一共持有股票市值为2523.18亿元，权重白马占比较大。","url":"","urlTitle":"","voiceTitle":"","voicePath":"","auditId":null,"auditTime":null,"auditRemark":null,"stocks":null,"state":0,"articleIntroDetails":"dddddddddddddddddddddddddddddd"}
     */

    private ArticleBean upArticle;
    private int columnId;
    private ArticleBean article;
    private String columnName;
    private ArticleBean nextArticle;
    private BannerAndColumnData.Advertising advertising;

    public BannerAndColumnData.Advertising getAdvertising() {
        return advertising;
    }

    public void setAdvertising(BannerAndColumnData.Advertising advertising) {
        this.advertising = advertising;
    }

    public ArticleBean getUpArticle() {
        return upArticle;
    }

    public void setUpArticle(ArticleBean upArticle) {
        this.upArticle = upArticle;
    }

    public int getColumnId() {
        return columnId;
    }

    public void setColumnId(int columnId) {
        this.columnId = columnId;
    }

    public ArticleBean getArticle() {
        return article;
    }

    public void setArticle(ArticleBean article) {
        this.article = article;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public ArticleBean getNextArticle() {
        return nextArticle;
    }

    public void setNextArticle(ArticleBean nextArticle) {
        this.nextArticle = nextArticle;
    }

    public static class ArticleBean {
        /**
         * employee : {"department":null,"roles":[],"columns":[],"departments":[],"newPassword":null,"roleStrs":null,"columnStrs":null,"id":null,"userName":null,"headImg":"/upload/image/image/40c360ea-4bad-45a1-9a97-8071a9e894d5cj.jpg","quickMark":null,"phoneNum":null,"realName":"陈娟","passWord":null,"inputTime":null,"readingQuantity":650,"thumbUpQuantity":46,"practiceNum":"A1140117070001","riskDisclosure":null,"disclaimer":"","state":null,"employeeDetails":"","employeeRoles":[]}
         * column : {"parentColumn":null,"auditMan":null,"childrenColumn":null,"articleList":null,"videoList":null,"nameRemark":"炼金-谈股论金","id":null,"name":"谈股论金","checkImgPath":null,"url":null,"imgPath":null,"parentId":null,"auditId":null,"templateName":null,"rank":null,"isTop":null}
         * systemDictionaryItem : null
         * children : null
         * createTimeStr : null
         * id : 433
         * teacherId : 6
         * title : 政策叠加机构看好，该板块后续有望延续
         * titleImg : /upload/image/image/7e8820d5-0c90-4555-b9c6-4285bcdc4729zhang.png
         * tagId : null
         * source : 四川大决策
         * creationTime : 1527750503000
         * updateTime : null
         * thumbUpQuantity : 100
         * readingQuantity : 102
         * top : 0
         * parentId : null
         * columnId : 3
         * articleIntro : 截止一季度末，国家队一共持有股票市值为2523.18亿元，权重白马占比较大。
         * url :
         * urlTitle :
         * voiceTitle :
         * voicePath :
         * auditId : null
         * auditTime : null
         * auditRemark : null
         * stocks : null
         * state : 0
         * articleIntroDetails : dddddddddddddddddddddddddddddd
         */

        private EmployeeBean employee;
        private ColumnBean column;
        private Object systemDictionaryItem;
        private Object children;
        private String createTimeStr;
        private int id;
        private int teacherId;
        private String title;
        private String titleImg;
        private Object tagId;
        private String source;
        private long creationTime;
        private Object updateTime;
        private int thumbUpQuantity;
        private int readingQuantity;
        private int top;
        private Object parentId;
        private int columnId;
        private String articleIntro;
        private String url;
        private String urlTitle;
        private String voiceTitle;
        private String voicePath;
        private Object auditId;
        private Object auditTime;
        private Object auditRemark;
        private Object stocks;
        private int state;
        private String articleIntroDetails;

        public EmployeeBean getEmployee() {
            return employee;
        }

        public void setEmployee(EmployeeBean employee) {
            this.employee = employee;
        }

        public ColumnBean getColumn() {
            return column;
        }

        public void setColumn(ColumnBean column) {
            this.column = column;
        }

        public Object getSystemDictionaryItem() {
            return systemDictionaryItem;
        }

        public void setSystemDictionaryItem(Object systemDictionaryItem) {
            this.systemDictionaryItem = systemDictionaryItem;
        }

        public Object getChildren() {
            return children;
        }

        public void setChildren(Object children) {
            this.children = children;
        }

        public String getCreateTimeStr() {
            return createTimeStr;
        }

        public void setCreateTimeStr(String createTimeStr) {
            this.createTimeStr = createTimeStr;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getTeacherId() {
            return teacherId;
        }

        public void setTeacherId(int teacherId) {
            this.teacherId = teacherId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTitleImg() {
            return titleImg;
        }

        public void setTitleImg(String titleImg) {
            this.titleImg = titleImg;
        }

        public Object getTagId() {
            return tagId;
        }

        public void setTagId(Object tagId) {
            this.tagId = tagId;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public long getCreationTime() {
            return creationTime;
        }

        public void setCreationTime(long creationTime) {
            this.creationTime = creationTime;
        }

        public Object getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(Object updateTime) {
            this.updateTime = updateTime;
        }

        public int getThumbUpQuantity() {
            return thumbUpQuantity;
        }

        public void setThumbUpQuantity(int thumbUpQuantity) {
            this.thumbUpQuantity = thumbUpQuantity;
        }

        public int getReadingQuantity() {
            return readingQuantity;
        }

        public void setReadingQuantity(int readingQuantity) {
            this.readingQuantity = readingQuantity;
        }

        public int getTop() {
            return top;
        }

        public void setTop(int top) {
            this.top = top;
        }

        public Object getParentId() {
            return parentId;
        }

        public void setParentId(Object parentId) {
            this.parentId = parentId;
        }

        public int getColumnId() {
            return columnId;
        }

        public void setColumnId(int columnId) {
            this.columnId = columnId;
        }

        public String getArticleIntro() {
            return articleIntro;
        }

        public void setArticleIntro(String articleIntro) {
            this.articleIntro = articleIntro;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getUrlTitle() {
            return urlTitle;
        }

        public void setUrlTitle(String urlTitle) {
            this.urlTitle = urlTitle;
        }

        public String getVoiceTitle() {
            return voiceTitle;
        }

        public void setVoiceTitle(String voiceTitle) {
            this.voiceTitle = voiceTitle;
        }

        public String getVoicePath() {
            return voicePath;
        }

        public void setVoicePath(String voicePath) {
            this.voicePath = voicePath;
        }

        public Object getAuditId() {
            return auditId;
        }

        public void setAuditId(Object auditId) {
            this.auditId = auditId;
        }

        public Object getAuditTime() {
            return auditTime;
        }

        public void setAuditTime(Object auditTime) {
            this.auditTime = auditTime;
        }

        public Object getAuditRemark() {
            return auditRemark;
        }

        public void setAuditRemark(Object auditRemark) {
            this.auditRemark = auditRemark;
        }

        public Object getStocks() {
            return stocks;
        }

        public void setStocks(Object stocks) {
            this.stocks = stocks;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public String getArticleIntroDetails() {
            return articleIntroDetails;
        }

        public void setArticleIntroDetails(String articleIntroDetails) {
            this.articleIntroDetails = articleIntroDetails;
        }

        public static class EmployeeBean {
            /**
             * department : null
             * roles : []
             * columns : []
             * departments : []
             * newPassword : null
             * roleStrs : null
             * columnStrs : null
             * id : null
             * userName : null
             * headImg : /upload/image/image/40c360ea-4bad-45a1-9a97-8071a9e894d5cj.jpg
             * quickMark : null
             * phoneNum : null
             * realName : 陈娟
             * passWord : null
             * inputTime : null
             * readingQuantity : 650
             * thumbUpQuantity : 46
             * practiceNum : A1140117070001
             * riskDisclosure : null
             * disclaimer :
             * state : null
             * employeeDetails :
             * employeeRoles : []
             */

            private Object department;
            private Object newPassword;
            private Object roleStrs;
            private Object columnStrs;
            private Object id;
            private Object userName;
            private String headImg;
            private Object quickMark;
            private Object phoneNum;
            private String realName;
            private Object passWord;
            private Object inputTime;
            private int readingQuantity;
            private int thumbUpQuantity;
            private String practiceNum;
            private Object riskDisclosure;
            private String disclaimer;
            private Object state;
            private String employeeDetails;
            private List<?> roles;
            private List<?> columns;
            private List<?> departments;
            private List<?> employeeRoles;

            public Object getDepartment() {
                return department;
            }

            public void setDepartment(Object department) {
                this.department = department;
            }

            public Object getNewPassword() {
                return newPassword;
            }

            public void setNewPassword(Object newPassword) {
                this.newPassword = newPassword;
            }

            public Object getRoleStrs() {
                return roleStrs;
            }

            public void setRoleStrs(Object roleStrs) {
                this.roleStrs = roleStrs;
            }

            public Object getColumnStrs() {
                return columnStrs;
            }

            public void setColumnStrs(Object columnStrs) {
                this.columnStrs = columnStrs;
            }

            public Object getId() {
                return id;
            }

            public void setId(Object id) {
                this.id = id;
            }

            public Object getUserName() {
                return userName;
            }

            public void setUserName(Object userName) {
                this.userName = userName;
            }

            public String getHeadImg() {
                return headImg;
            }

            public void setHeadImg(String headImg) {
                this.headImg = headImg;
            }

            public Object getQuickMark() {
                return quickMark;
            }

            public void setQuickMark(Object quickMark) {
                this.quickMark = quickMark;
            }

            public Object getPhoneNum() {
                return phoneNum;
            }

            public void setPhoneNum(Object phoneNum) {
                this.phoneNum = phoneNum;
            }

            public String getRealName() {
                return realName;
            }

            public void setRealName(String realName) {
                this.realName = realName;
            }

            public Object getPassWord() {
                return passWord;
            }

            public void setPassWord(Object passWord) {
                this.passWord = passWord;
            }

            public Object getInputTime() {
                return inputTime;
            }

            public void setInputTime(Object inputTime) {
                this.inputTime = inputTime;
            }

            public int getReadingQuantity() {
                return readingQuantity;
            }

            public void setReadingQuantity(int readingQuantity) {
                this.readingQuantity = readingQuantity;
            }

            public int getThumbUpQuantity() {
                return thumbUpQuantity;
            }

            public void setThumbUpQuantity(int thumbUpQuantity) {
                this.thumbUpQuantity = thumbUpQuantity;
            }

            public String getPracticeNum() {
                return practiceNum;
            }

            public void setPracticeNum(String practiceNum) {
                this.practiceNum = practiceNum;
            }

            public Object getRiskDisclosure() {
                return riskDisclosure;
            }

            public void setRiskDisclosure(Object riskDisclosure) {
                this.riskDisclosure = riskDisclosure;
            }

            public String getDisclaimer() {
                return disclaimer;
            }

            public void setDisclaimer(String disclaimer) {
                this.disclaimer = disclaimer;
            }

            public Object getState() {
                return state;
            }

            public void setState(Object state) {
                this.state = state;
            }

            public String getEmployeeDetails() {
                return employeeDetails;
            }

            public void setEmployeeDetails(String employeeDetails) {
                this.employeeDetails = employeeDetails;
            }

            public List<?> getRoles() {
                return roles;
            }

            public void setRoles(List<?> roles) {
                this.roles = roles;
            }

            public List<?> getColumns() {
                return columns;
            }

            public void setColumns(List<?> columns) {
                this.columns = columns;
            }

            public List<?> getDepartments() {
                return departments;
            }

            public void setDepartments(List<?> departments) {
                this.departments = departments;
            }

            public List<?> getEmployeeRoles() {
                return employeeRoles;
            }

            public void setEmployeeRoles(List<?> employeeRoles) {
                this.employeeRoles = employeeRoles;
            }
        }

        public static class ColumnBean {
            /**
             * parentColumn : null
             * auditMan : null
             * childrenColumn : null
             * articleList : null
             * videoList : null
             * nameRemark : 炼金-谈股论金
             * id : null
             * name : 谈股论金
             * checkImgPath : null
             * url : null
             * imgPath : null
             * parentId : null
             * auditId : null
             * templateName : null
             * rank : null
             * isTop : null
             */

            private Object parentColumn;
            private Object auditMan;
            private Object childrenColumn;
            private Object articleList;
            private Object videoList;
            private String nameRemark;
            private Object id;
            private String name;
            private Object checkImgPath;
            private Object url;
            private Object imgPath;
            private Object parentId;
            private Object auditId;
            private Object templateName;
            private Object rank;
            private Object isTop;

            public Object getParentColumn() {
                return parentColumn;
            }

            public void setParentColumn(Object parentColumn) {
                this.parentColumn = parentColumn;
            }

            public Object getAuditMan() {
                return auditMan;
            }

            public void setAuditMan(Object auditMan) {
                this.auditMan = auditMan;
            }

            public Object getChildrenColumn() {
                return childrenColumn;
            }

            public void setChildrenColumn(Object childrenColumn) {
                this.childrenColumn = childrenColumn;
            }

            public Object getArticleList() {
                return articleList;
            }

            public void setArticleList(Object articleList) {
                this.articleList = articleList;
            }

            public Object getVideoList() {
                return videoList;
            }

            public void setVideoList(Object videoList) {
                this.videoList = videoList;
            }

            public String getNameRemark() {
                return nameRemark;
            }

            public void setNameRemark(String nameRemark) {
                this.nameRemark = nameRemark;
            }

            public Object getId() {
                return id;
            }

            public void setId(Object id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public Object getCheckImgPath() {
                return checkImgPath;
            }

            public void setCheckImgPath(Object checkImgPath) {
                this.checkImgPath = checkImgPath;
            }

            public Object getUrl() {
                return url;
            }

            public void setUrl(Object url) {
                this.url = url;
            }

            public Object getImgPath() {
                return imgPath;
            }

            public void setImgPath(Object imgPath) {
                this.imgPath = imgPath;
            }

            public Object getParentId() {
                return parentId;
            }

            public void setParentId(Object parentId) {
                this.parentId = parentId;
            }

            public Object getAuditId() {
                return auditId;
            }

            public void setAuditId(Object auditId) {
                this.auditId = auditId;
            }

            public Object getTemplateName() {
                return templateName;
            }

            public void setTemplateName(Object templateName) {
                this.templateName = templateName;
            }

            public Object getRank() {
                return rank;
            }

            public void setRank(Object rank) {
                this.rank = rank;
            }

            public Object getIsTop() {
                return isTop;
            }

            public void setIsTop(Object isTop) {
                this.isTop = isTop;
            }
        }
    }

    public static class NextArticleBean {
        /**
         * employee : {"department":null,"roles":[],"columns":[],"departments":[],"newPassword":null,"roleStrs":null,"columnStrs":null,"id":null,"userName":null,"headImg":null,"quickMark":null,"phoneNum":null,"realName":"陈娟","passWord":null,"inputTime":null,"readingQuantity":null,"thumbUpQuantity":null,"practiceNum":null,"riskDisclosure":null,"disclaimer":null,"state":null,"employeeDetails":null,"employeeRoles":[]}
         * column : null
         * systemDictionaryItem : null
         * children : []
         * createTimeStr : null
         * id : 432
         * teacherId : 6
         * title : 政策叠加机构看好，该板块后续有望延续
         * titleImg : /upload/image/image/7e8820d5-0c90-4555-b9c6-4285bcdc4729zhang.png
         * tagId : null
         * source : 四川大决策
         * creationTime : 1527750503000
         * updateTime : null
         * thumbUpQuantity : 100
         * readingQuantity : 100
         * top : 0
         * parentId : null
         * columnId : 3
         * articleIntro : 截止一季度末，国家队一共持有股票市值为2523.18亿元，权重白马占比较大。
         * url :
         * urlTitle :
         * voiceTitle :
         * voicePath :
         * auditId : null
         * auditTime : null
         * auditRemark : null
         * stocks : null
         * state : 0
         * articleIntroDetails : dddddddddddddddddddddddddddddd
         */

        private EmployeeBeanX employee;
        private Object column;
        private Object systemDictionaryItem;
        private Object createTimeStr;
        private int id;
        private int teacherId;
        private String title;
        private String titleImg;
        private Object tagId;
        private String source;
        private long creationTime;
        private Object updateTime;
        private int thumbUpQuantity;
        private int readingQuantity;
        private int top;
        private Object parentId;
        private int columnId;
        private String articleIntro;
        private String url;
        private String urlTitle;
        private String voiceTitle;
        private String voicePath;
        private Object auditId;
        private Object auditTime;
        private Object auditRemark;
        private Object stocks;
        private int state;
        private String articleIntroDetails;
        private List<?> children;

        public EmployeeBeanX getEmployee() {
            return employee;
        }

        public void setEmployee(EmployeeBeanX employee) {
            this.employee = employee;
        }

        public Object getColumn() {
            return column;
        }

        public void setColumn(Object column) {
            this.column = column;
        }

        public Object getSystemDictionaryItem() {
            return systemDictionaryItem;
        }

        public void setSystemDictionaryItem(Object systemDictionaryItem) {
            this.systemDictionaryItem = systemDictionaryItem;
        }

        public Object getCreateTimeStr() {
            return createTimeStr;
        }

        public void setCreateTimeStr(Object createTimeStr) {
            this.createTimeStr = createTimeStr;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getTeacherId() {
            return teacherId;
        }

        public void setTeacherId(int teacherId) {
            this.teacherId = teacherId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTitleImg() {
            return titleImg;
        }

        public void setTitleImg(String titleImg) {
            this.titleImg = titleImg;
        }

        public Object getTagId() {
            return tagId;
        }

        public void setTagId(Object tagId) {
            this.tagId = tagId;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public long getCreationTime() {
            return creationTime;
        }

        public void setCreationTime(long creationTime) {
            this.creationTime = creationTime;
        }

        public Object getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(Object updateTime) {
            this.updateTime = updateTime;
        }

        public int getThumbUpQuantity() {
            return thumbUpQuantity;
        }

        public void setThumbUpQuantity(int thumbUpQuantity) {
            this.thumbUpQuantity = thumbUpQuantity;
        }

        public int getReadingQuantity() {
            return readingQuantity;
        }

        public void setReadingQuantity(int readingQuantity) {
            this.readingQuantity = readingQuantity;
        }

        public int getTop() {
            return top;
        }

        public void setTop(int top) {
            this.top = top;
        }

        public Object getParentId() {
            return parentId;
        }

        public void setParentId(Object parentId) {
            this.parentId = parentId;
        }

        public int getColumnId() {
            return columnId;
        }

        public void setColumnId(int columnId) {
            this.columnId = columnId;
        }

        public String getArticleIntro() {
            return articleIntro;
        }

        public void setArticleIntro(String articleIntro) {
            this.articleIntro = articleIntro;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getUrlTitle() {
            return urlTitle;
        }

        public void setUrlTitle(String urlTitle) {
            this.urlTitle = urlTitle;
        }

        public String getVoiceTitle() {
            return voiceTitle;
        }

        public void setVoiceTitle(String voiceTitle) {
            this.voiceTitle = voiceTitle;
        }

        public String getVoicePath() {
            return voicePath;
        }

        public void setVoicePath(String voicePath) {
            this.voicePath = voicePath;
        }

        public Object getAuditId() {
            return auditId;
        }

        public void setAuditId(Object auditId) {
            this.auditId = auditId;
        }

        public Object getAuditTime() {
            return auditTime;
        }

        public void setAuditTime(Object auditTime) {
            this.auditTime = auditTime;
        }

        public Object getAuditRemark() {
            return auditRemark;
        }

        public void setAuditRemark(Object auditRemark) {
            this.auditRemark = auditRemark;
        }

        public Object getStocks() {
            return stocks;
        }

        public void setStocks(Object stocks) {
            this.stocks = stocks;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public String getArticleIntroDetails() {
            return articleIntroDetails;
        }

        public void setArticleIntroDetails(String articleIntroDetails) {
            this.articleIntroDetails = articleIntroDetails;
        }

        public List<?> getChildren() {
            return children;
        }

        public void setChildren(List<?> children) {
            this.children = children;
        }

        public static class EmployeeBeanX {
            /**
             * department : null
             * roles : []
             * columns : []
             * departments : []
             * newPassword : null
             * roleStrs : null
             * columnStrs : null
             * id : null
             * userName : null
             * headImg : null
             * quickMark : null
             * phoneNum : null
             * realName : 陈娟
             * passWord : null
             * inputTime : null
             * readingQuantity : null
             * thumbUpQuantity : null
             * practiceNum : null
             * riskDisclosure : null
             * disclaimer : null
             * state : null
             * employeeDetails : null
             * employeeRoles : []
             */

            private Object department;
            private Object newPassword;
            private Object roleStrs;
            private Object columnStrs;
            private Object id;
            private Object userName;
            private Object headImg;
            private Object quickMark;
            private Object phoneNum;
            private String realName;
            private Object passWord;
            private Object inputTime;
            private Object readingQuantity;
            private Object thumbUpQuantity;
            private Object practiceNum;
            private Object riskDisclosure;
            private Object disclaimer;
            private Object state;
            private Object employeeDetails;
            private List<?> roles;
            private List<?> columns;
            private List<?> departments;
            private List<?> employeeRoles;

            public Object getDepartment() {
                return department;
            }

            public void setDepartment(Object department) {
                this.department = department;
            }

            public Object getNewPassword() {
                return newPassword;
            }

            public void setNewPassword(Object newPassword) {
                this.newPassword = newPassword;
            }

            public Object getRoleStrs() {
                return roleStrs;
            }

            public void setRoleStrs(Object roleStrs) {
                this.roleStrs = roleStrs;
            }

            public Object getColumnStrs() {
                return columnStrs;
            }

            public void setColumnStrs(Object columnStrs) {
                this.columnStrs = columnStrs;
            }

            public Object getId() {
                return id;
            }

            public void setId(Object id) {
                this.id = id;
            }

            public Object getUserName() {
                return userName;
            }

            public void setUserName(Object userName) {
                this.userName = userName;
            }

            public Object getHeadImg() {
                return headImg;
            }

            public void setHeadImg(Object headImg) {
                this.headImg = headImg;
            }

            public Object getQuickMark() {
                return quickMark;
            }

            public void setQuickMark(Object quickMark) {
                this.quickMark = quickMark;
            }

            public Object getPhoneNum() {
                return phoneNum;
            }

            public void setPhoneNum(Object phoneNum) {
                this.phoneNum = phoneNum;
            }

            public String getRealName() {
                return realName;
            }

            public void setRealName(String realName) {
                this.realName = realName;
            }

            public Object getPassWord() {
                return passWord;
            }

            public void setPassWord(Object passWord) {
                this.passWord = passWord;
            }

            public Object getInputTime() {
                return inputTime;
            }

            public void setInputTime(Object inputTime) {
                this.inputTime = inputTime;
            }

            public Object getReadingQuantity() {
                return readingQuantity;
            }

            public void setReadingQuantity(Object readingQuantity) {
                this.readingQuantity = readingQuantity;
            }

            public Object getThumbUpQuantity() {
                return thumbUpQuantity;
            }

            public void setThumbUpQuantity(Object thumbUpQuantity) {
                this.thumbUpQuantity = thumbUpQuantity;
            }

            public Object getPracticeNum() {
                return practiceNum;
            }

            public void setPracticeNum(Object practiceNum) {
                this.practiceNum = practiceNum;
            }

            public Object getRiskDisclosure() {
                return riskDisclosure;
            }

            public void setRiskDisclosure(Object riskDisclosure) {
                this.riskDisclosure = riskDisclosure;
            }

            public Object getDisclaimer() {
                return disclaimer;
            }

            public void setDisclaimer(Object disclaimer) {
                this.disclaimer = disclaimer;
            }

            public Object getState() {
                return state;
            }

            public void setState(Object state) {
                this.state = state;
            }

            public Object getEmployeeDetails() {
                return employeeDetails;
            }

            public void setEmployeeDetails(Object employeeDetails) {
                this.employeeDetails = employeeDetails;
            }

            public List<?> getRoles() {
                return roles;
            }

            public void setRoles(List<?> roles) {
                this.roles = roles;
            }

            public List<?> getColumns() {
                return columns;
            }

            public void setColumns(List<?> columns) {
                this.columns = columns;
            }

            public List<?> getDepartments() {
                return departments;
            }

            public void setDepartments(List<?> departments) {
                this.departments = departments;
            }

            public List<?> getEmployeeRoles() {
                return employeeRoles;
            }

            public void setEmployeeRoles(List<?> employeeRoles) {
                this.employeeRoles = employeeRoles;
            }
        }
    }
}
