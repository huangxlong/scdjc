package com.djc.scdjc.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator
 * on 2018/5/30 星期三.
 */
public class ArticleData implements Serializable {


    private List<ArticleListBean> articleList;

    public List<ArticleListBean> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<ArticleListBean> articleList) {
        this.articleList = articleList;
    }

    public static class ArticleListBean implements Serializable {
        /**
         * employee : {"department":null,"roles":[],"columns":[],"departments":[],"newPassword":null,"roleStrs":null,"columnStrs":null,"id":null,"userName":null,"headImg":null,"quickMark":null,"phoneNum":null,"realName":"唐子汉","passWord":null,"inputTime":null,"readingQuantity":null,"thumbUpQuantity":null,"practiceNum":null,"riskDisclosure":null,"disclaimer":null,"state":null,"employeeDetails":null,"employeeRoles":[]}
         * column : null
         * systemDictionaryItem : null
         * children : []
         * createTimeStr : 2018-04-27 14:49:10
         * id : 386
         * teacherId : 17
         * title : 诊股大师---巨人网络002558
         * titleImg : /upload/image/image/2ccbe06a-b953-42a8-af0f-fa22953b28dcsuo.png
         * tagId : null
         * source : 四川大决策
         * creationTime : 1524811750000
         * updateTime : 1524812476000
         * thumbUpQuantity : 0
         * readingQuantity : 1
         * top : 0
         * parentId : null
         * columnId : 3
         * articleIntro : 002558巨人网络，当前股价下跌趋势中，建议不宜过早加仓买入
         * url :
         * urlTitle :
         * voiceTitle :
         * voicePath :
         * auditId : null
         * auditTime : null
         * auditRemark : null
         * stocks : null
         * state : 0
         * articleIntroDetails : <p style="text-align: justify; line-height: 2em; margin-bottom: 20px;"><span style="color: rgb(25, 31, 37); font-family: ">002558巨人网络，当前股价下跌趋势中，刚刚放量下跌，建议不宜过早加仓买入，静待股价企稳回升再加仓，右侧交易比左侧交易好，有的放矢。（以上内容仅供参考，市场有风险，投资需谨慎。四川大决策投资顾问：唐子汉，执业编号：A1140618030001）</span></p>
         */

        private EmployeeBean employee;
        private Object column;
        private Object systemDictionaryItem;
        private String createTimeStr;
        private int id;
        private int teacherId;
        private String title;
        private String titleImg;
        private Object tagId;
        private String source;
        private long creationTime;
        private long updateTime;
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
        private List<ArticleListData> children;

        public EmployeeBean getEmployee() {
            return employee;
        }

        public void setEmployee(EmployeeBean employee) {
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

        public long getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(long updateTime) {
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

        public List<ArticleListData> getChildren() {
            return children;
        }

        public void setChildren(List<ArticleListData> children) {
            this.children = children;
        }

        public static class EmployeeBean implements Serializable {
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
             * realName : 唐子汉
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

    public static class ArticleListData implements Serializable {
        private ArticleListBean.EmployeeBean employee;
        private Object column;
        private Object systemDictionaryItem;
        private String createTimeStr;
        private int id;
        private int teacherId;
        private String title;
        private String titleImg;
        private Object tagId;
        private String source;
        private long creationTime;
        private long updateTime;
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

        public ArticleListBean.EmployeeBean getEmployee() {
            return employee;
        }

        public void setEmployee(ArticleListBean.EmployeeBean employee) {
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

        public long getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(long updateTime) {
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


        public static class EmployeeBean implements Serializable {
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
             * realName : 唐子汉
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
