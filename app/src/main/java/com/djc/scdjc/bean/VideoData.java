package com.djc.scdjc.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator
 * on 2018/5/15 星期二.
 */
public class VideoData implements Serializable {


    /**
     * templateName : bigVideo
     * videoList : [{"employee":{"department":null,"roles":[],"columns":[],"departments":[],"newPassword":null,"roleStrs":null,"columnStrs":null,"id":null,"userName":null,"headImg":null,"quickMark":null,"phoneNum":null,"realName":"管理员","passWord":null,"inputTime":null,"readingQuantity":null,"thumbUpQuantity":null,"practiceNum":null,"riskDisclosure":null,"disclaimer":null,"state":null,"employeeDetails":null,"employeeRoles":[]},"column":{"parentColumn":null,"auditMan":null,"childrenColumn":null,"articleList":null,"videoList":null,"nameRemark":null,"id":null,"name":"掘金-双龙出海","checkImgPath":null,"url":null,"imgPath":null,"parentId":null,"auditId":null,"templateName":null,"rank":null,"isTop":null},"auditMan":null,"createTimeStr":"2018-05-21 09:56:39","id":5,"teacherId":1,"title":"地对地导弹多","thumbnailPath":"/upload/image/thumbnail/1986b823-1f48-4f0e-9934-102806d705c11524213647568067671.jpg","videoDuration":"00:11:18","videoPath":"/upload/video/video/b9dc101a-803d-46ac-8aed-3bfbef186fec5265.mp4","videoIntroDetails":"顶顶顶顶","creationTime":1526867799000,"columnId":23,"top":0,"playQuantity":15,"thumbUpQuantity":0,"tag":"sd","auditId":null,"auditRemark":null,"auditTime":null,"state":1}]
     */

    private String templateName;
    private List<VideoListBean> videoList;

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public List<VideoListBean> getVideoList() {
        return videoList;
    }

    public void setVideoList(List<VideoListBean> videoList) {
        this.videoList = videoList;
    }

    public static class VideoListBean implements Serializable {
        /**
         * employee : {"department":null,"roles":[],"columns":[],"departments":[],"newPassword":null,"roleStrs":null,"columnStrs":null,"id":null,"userName":null,"headImg":null,"quickMark":null,"phoneNum":null,"realName":"管理员","passWord":null,"inputTime":null,"readingQuantity":null,"thumbUpQuantity":null,"practiceNum":null,"riskDisclosure":null,"disclaimer":null,"state":null,"employeeDetails":null,"employeeRoles":[]}
         * column : {"parentColumn":null,"auditMan":null,"childrenColumn":null,"articleList":null,"videoList":null,"nameRemark":null,"id":null,"name":"掘金-双龙出海","checkImgPath":null,"url":null,"imgPath":null,"parentId":null,"auditId":null,"templateName":null,"rank":null,"isTop":null}
         * auditMan : null
         * createTimeStr : 2018-05-21 09:56:39
         * id : 5
         * teacherId : 1
         * title : 地对地导弹多
         * thumbnailPath : /upload/image/thumbnail/1986b823-1f48-4f0e-9934-102806d705c11524213647568067671.jpg
         * videoDuration : 00:11:18
         * videoPath : /upload/video/video/b9dc101a-803d-46ac-8aed-3bfbef186fec5265.mp4
         * videoIntroDetails : 顶顶顶顶
         * creationTime : 1526867799000
         * columnId : 23
         * top : 0
         * playQuantity : 15
         * thumbUpQuantity : 0
         * tag : sd
         * auditId : null
         * auditRemark : null
         * auditTime : null
         * state : 1
         */

        private EmployeeBean employee;
        private ColumnBean column;
        private Object auditMan;
        private String createTimeStr;
        private int id;
        private int teacherId;
        private String title;
        private String thumbnailPath;
        private String videoDuration;
        private String videoPath;
        private String videoIntroDetails;
        private long creationTime;
        private int columnId;
        private int top;
        private int playQuantity;
        private int thumbUpQuantity;
        private String tag;
        private Object auditId;
        private Object auditRemark;
        private Object auditTime;
        private int state;

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

        public Object getAuditMan() {
            return auditMan;
        }

        public void setAuditMan(Object auditMan) {
            this.auditMan = auditMan;
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

        public String getThumbnailPath() {
            return thumbnailPath;
        }

        public void setThumbnailPath(String thumbnailPath) {
            this.thumbnailPath = thumbnailPath;
        }

        public String getVideoDuration() {
            return videoDuration;
        }

        public void setVideoDuration(String videoDuration) {
            this.videoDuration = videoDuration;
        }

        public String getVideoPath() {
            return videoPath;
        }

        public void setVideoPath(String videoPath) {
            this.videoPath = videoPath;
        }

        public String getVideoIntroDetails() {
            return videoIntroDetails;
        }

        public void setVideoIntroDetails(String videoIntroDetails) {
            this.videoIntroDetails = videoIntroDetails;
        }

        public long getCreationTime() {
            return creationTime;
        }

        public void setCreationTime(long creationTime) {
            this.creationTime = creationTime;
        }

        public int getColumnId() {
            return columnId;
        }

        public void setColumnId(int columnId) {
            this.columnId = columnId;
        }

        public int getTop() {
            return top;
        }

        public void setTop(int top) {
            this.top = top;
        }

        public int getPlayQuantity() {
            return playQuantity;
        }

        public void setPlayQuantity(int playQuantity) {
            this.playQuantity = playQuantity;
        }

        public int getThumbUpQuantity() {
            return thumbUpQuantity;
        }

        public void setThumbUpQuantity(int thumbUpQuantity) {
            this.thumbUpQuantity = thumbUpQuantity;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public Object getAuditId() {
            return auditId;
        }

        public void setAuditId(Object auditId) {
            this.auditId = auditId;
        }

        public Object getAuditRemark() {
            return auditRemark;
        }

        public void setAuditRemark(Object auditRemark) {
            this.auditRemark = auditRemark;
        }

        public Object getAuditTime() {
            return auditTime;
        }

        public void setAuditTime(Object auditTime) {
            this.auditTime = auditTime;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
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
             * headImg : null
             * quickMark : null
             * phoneNum : null
             * realName : 管理员
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

        public static class ColumnBean {
            /**
             * parentColumn : null
             * auditMan : null
             * childrenColumn : null
             * articleList : null
             * videoList : null
             * nameRemark : null
             * id : null
             * name : 掘金-双龙出海
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
            private Object nameRemark;
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

            public Object getNameRemark() {
                return nameRemark;
            }

            public void setNameRemark(Object nameRemark) {
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
}
