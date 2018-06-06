package com.djc.scdjc.bean;

import java.util.List;

/**
 * Created by Administrator
 * on 2018/6/5 星期二.
 */
public class VideoDetailData {

    /**
     * columnId : 31
     * videoList : [{"createTimeStr":"2018-05-08 13:49:15","videoIntroDetails":"大发达","videoPath":"/upload/video/video/bb3a9a6d-758c-41f7-a87b-0a767fe4fbd85265.mp4","employeeVO":null,"id":2,"title":"撒旦说得对的","thumbnailPath":"/upload/image/thumbnail/8a3db581-e426-43ce-9f4a-358071309911blob.jpg","videoDuration":"00:11:18","playQuantity":2085},{"createTimeStr":"2018-04-08 16:05:47","videoIntroDetails":"撒撒撒撒所所所所所所所所所所所所所所所所","videoPath":"/upload/video/video/12e25a0e-74ab-4ffb-b0b3-b0988d04af3271ba3aff-909f-4234-9778-4825af0d25121b023222-32a4-4be4-bf1f-6e5bf4f4d0ff5222.mp4","employeeVO":null,"id":1,"title":"底单","thumbnailPath":"/upload/image/thumbnail/0254bd19-c75b-4343-8b25-b961fb143792blob.jpg","videoDuration":"00:03:27","playQuantity":196},{"createTimeStr":"2018-05-21 09:56:39","videoIntroDetails":"顶顶顶顶","videoPath":"/upload/video/video/b9dc101a-803d-46ac-8aed-3bfbef186fec5265.mp4","employeeVO":null,"id":5,"title":"地对地导弹多","thumbnailPath":"/upload/image/thumbnail/1986b823-1f48-4f0e-9934-102806d705c11524213647568067671.jpg","videoDuration":"00:11:18","playQuantity":20},{"createTimeStr":"2018-05-21 09:38:56","videoIntroDetails":"啥啥啥","videoPath":"/upload/video/video/2762831c-513a-4375-9a23-a340fae32320sss.mp4","employeeVO":null,"id":4,"title":"洒洒的","thumbnailPath":"/upload/image/thumbnail/fc6c78f3-218f-4021-8f8e-7b1803c4211eimg.png","videoDuration":"00:00:04","playQuantity":15},{"createTimeStr":"2018-05-15 15:54:49","videoIntroDetails":"sdd","videoPath":"/upload/video/video/06955372-c471-423d-9a37-9bd819202688152a8765-7b01-41ed-aa41-919cc5d6a36423930250-1-16.mp4","employeeVO":null,"id":3,"title":"sads","thumbnailPath":"/upload/image/thumbnail/b391c81c-af99-4999-a069-de6a8a0914ce0cfcfab1-4141-4780-b2e3-7f37dd47eda01.jpg","videoDuration":"00:03:20","playQuantity":802}]
     * video : {"createTimeStr":"2018-04-08 16:05:47","videoIntroDetails":"撒撒撒撒所所所所所所所所所所所所所所所所","videoPath":"/upload/video/video/12e25a0e-74ab-4ffb-b0b3-b0988d04af3271ba3aff-909f-4234-9778-4825af0d25121b023222-32a4-4be4-bf1f-6e5bf4f4d0ff5222.mp4","employeeVO":{"employeeDetails":"格言：尊重趋势，相机而动，严控风险，方得盈利。\r\n名师介绍：\r\n1.知名私募操盘手导师；\r\n2.股票、期货、外汇、黄金、原油资深分析师；\r\n3.独创布林一技擒牛法，精确抄底逃顶；\r\n4.擅长系统性风险预警，准确把握概念股、题材股炒作；\r\n5.注重上市公司基本面分析与技术面分析的有效契合。\r\n大市研判：\r\n1.2014年7月上旬，沪港通进入倒计时，成功预测牛市开启，并推荐龙头券商中信证券；\r\n2.2015年6月中旬，两市缩量滞涨，沪指5200点关前止步，精确判定牛市见顶，建议投资者离场观望；\r\n3.2017年A股国际化进程加速，多次友情提示投资者在投资过程中注重上市公司基本面研究，价值投资将成为未来的主流趋势。\r\n实战战绩案列：\r\n1.津膜科技\r\n2017年3月底成功潜伏300334津膜科技，该股兼具重组与雄安概念，停牌一月后，复牌连续\u201c一\u201d字涨停，后放量多次涨停，利用独创的布林一技擒牛法，在37.00元上方附近完美离场；\r\n2.鲁西化工\r\n2017年10月下旬，根据基本面估值分析与技术面分析，结合双氧水涨价，给予000830鲁西化工买入评级，参考目标价15.00元，投资者斩获颇多。\r\n3.天业股份\r\n2017年11月6日，360私有化尘埃落定，借壳601313江南嘉捷上市，11月6日通过布林一技擒牛法，果断介入600807天业股份，后于16.00元上方完美离场；","headImg":"/upload/image/image/a7b1bfbf-7036-434a-a945-4423f1639a7btzhan.jpg","practiceNum":"A1140618030001","readingQuantity":"2582","realName":"唐子汉","thumbUpQuantity":"154"},"id":1,"title":"底单","thumbnailPath":"/upload/image/thumbnail/0254bd19-c75b-4343-8b25-b961fb143792blob.jpg","videoDuration":"00:03:27","playQuantity":196}
     * columnName : 掘金
     */

    private int columnId;
    private VideoBean video;
    private String columnName;
    private List<VideoData.VideoListBean> videoList;

    public int getColumnId() {
        return columnId;
    }

    public void setColumnId(int columnId) {
        this.columnId = columnId;
    }

    public VideoBean getVideo() {
        return video;
    }

    public void setVideo(VideoBean video) {
        this.video = video;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public List<VideoData.VideoListBean> getVideoList() {
        return videoList;
    }

    public void setVideoList(List<VideoData.VideoListBean> videoList) {
        this.videoList = videoList;
    }

    public static class VideoBean {
        /**
         * createTimeStr : 2018-04-08 16:05:47
         * videoIntroDetails : 撒撒撒撒所所所所所所所所所所所所所所所所
         * videoPath : /upload/video/video/12e25a0e-74ab-4ffb-b0b3-b0988d04af3271ba3aff-909f-4234-9778-4825af0d25121b023222-32a4-4be4-bf1f-6e5bf4f4d0ff5222.mp4
         * employeeVO : {"employeeDetails":"格言：尊重趋势，相机而动，严控风险，方得盈利。\r\n名师介绍：\r\n1.知名私募操盘手导师；\r\n2.股票、期货、外汇、黄金、原油资深分析师；\r\n3.独创布林一技擒牛法，精确抄底逃顶；\r\n4.擅长系统性风险预警，准确把握概念股、题材股炒作；\r\n5.注重上市公司基本面分析与技术面分析的有效契合。\r\n大市研判：\r\n1.2014年7月上旬，沪港通进入倒计时，成功预测牛市开启，并推荐龙头券商中信证券；\r\n2.2015年6月中旬，两市缩量滞涨，沪指5200点关前止步，精确判定牛市见顶，建议投资者离场观望；\r\n3.2017年A股国际化进程加速，多次友情提示投资者在投资过程中注重上市公司基本面研究，价值投资将成为未来的主流趋势。\r\n实战战绩案列：\r\n1.津膜科技\r\n2017年3月底成功潜伏300334津膜科技，该股兼具重组与雄安概念，停牌一月后，复牌连续\u201c一\u201d字涨停，后放量多次涨停，利用独创的布林一技擒牛法，在37.00元上方附近完美离场；\r\n2.鲁西化工\r\n2017年10月下旬，根据基本面估值分析与技术面分析，结合双氧水涨价，给予000830鲁西化工买入评级，参考目标价15.00元，投资者斩获颇多。\r\n3.天业股份\r\n2017年11月6日，360私有化尘埃落定，借壳601313江南嘉捷上市，11月6日通过布林一技擒牛法，果断介入600807天业股份，后于16.00元上方完美离场；","headImg":"/upload/image/image/a7b1bfbf-7036-434a-a945-4423f1639a7btzhan.jpg","practiceNum":"A1140618030001","readingQuantity":"2582","realName":"唐子汉","thumbUpQuantity":"154"}
         * id : 1
         * title : 底单
         * thumbnailPath : /upload/image/thumbnail/0254bd19-c75b-4343-8b25-b961fb143792blob.jpg
         * videoDuration : 00:03:27
         * playQuantity : 196
         */

        private String createTimeStr;
        private String videoIntroDetails;
        private String videoPath;
        private EmployeeVOBean employeeVO;
        private int id;
        private String title;
        private String thumbnailPath;
        private String videoDuration;
        private int playQuantity;

        public String getCreateTimeStr() {
            return createTimeStr;
        }

        public void setCreateTimeStr(String createTimeStr) {
            this.createTimeStr = createTimeStr;
        }

        public String getVideoIntroDetails() {
            return videoIntroDetails;
        }

        public void setVideoIntroDetails(String videoIntroDetails) {
            this.videoIntroDetails = videoIntroDetails;
        }

        public String getVideoPath() {
            return videoPath;
        }

        public void setVideoPath(String videoPath) {
            this.videoPath = videoPath;
        }

        public EmployeeVOBean getEmployeeVO() {
            return employeeVO;
        }

        public void setEmployeeVO(EmployeeVOBean employeeVO) {
            this.employeeVO = employeeVO;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
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

        public int getPlayQuantity() {
            return playQuantity;
        }

        public void setPlayQuantity(int playQuantity) {
            this.playQuantity = playQuantity;
        }

        public static class EmployeeVOBean {
            /**
             * employeeDetails : 格言：尊重趋势，相机而动，严控风险，方得盈利。
             * 名师介绍：
             * 1.知名私募操盘手导师；
             * 2.股票、期货、外汇、黄金、原油资深分析师；
             * 3.独创布林一技擒牛法，精确抄底逃顶；
             * 4.擅长系统性风险预警，准确把握概念股、题材股炒作；
             * 5.注重上市公司基本面分析与技术面分析的有效契合。
             * 大市研判：
             * 1.2014年7月上旬，沪港通进入倒计时，成功预测牛市开启，并推荐龙头券商中信证券；
             * 2.2015年6月中旬，两市缩量滞涨，沪指5200点关前止步，精确判定牛市见顶，建议投资者离场观望；
             * 3.2017年A股国际化进程加速，多次友情提示投资者在投资过程中注重上市公司基本面研究，价值投资将成为未来的主流趋势。
             * 实战战绩案列：
             * 1.津膜科技
             * 2017年3月底成功潜伏300334津膜科技，该股兼具重组与雄安概念，停牌一月后，复牌连续“一”字涨停，后放量多次涨停，利用独创的布林一技擒牛法，在37.00元上方附近完美离场；
             * 2.鲁西化工
             * 2017年10月下旬，根据基本面估值分析与技术面分析，结合双氧水涨价，给予000830鲁西化工买入评级，参考目标价15.00元，投资者斩获颇多。
             * 3.天业股份
             * 2017年11月6日，360私有化尘埃落定，借壳601313江南嘉捷上市，11月6日通过布林一技擒牛法，果断介入600807天业股份，后于16.00元上方完美离场；
             * headImg : /upload/image/image/a7b1bfbf-7036-434a-a945-4423f1639a7btzhan.jpg
             * practiceNum : A1140618030001
             * readingQuantity : 2582
             * realName : 唐子汉
             * thumbUpQuantity : 154
             */

            private String employeeDetails;
            private String headImg;
            private String practiceNum;
            private String readingQuantity;
            private String realName;
            private String thumbUpQuantity;

            public String getEmployeeDetails() {
                return employeeDetails;
            }

            public void setEmployeeDetails(String employeeDetails) {
                this.employeeDetails = employeeDetails;
            }

            public String getHeadImg() {
                return headImg;
            }

            public void setHeadImg(String headImg) {
                this.headImg = headImg;
            }

            public String getPracticeNum() {
                return practiceNum;
            }

            public void setPracticeNum(String practiceNum) {
                this.practiceNum = practiceNum;
            }

            public String getReadingQuantity() {
                return readingQuantity;
            }

            public void setReadingQuantity(String readingQuantity) {
                this.readingQuantity = readingQuantity;
            }

            public String getRealName() {
                return realName;
            }

            public void setRealName(String realName) {
                this.realName = realName;
            }

            public String getThumbUpQuantity() {
                return thumbUpQuantity;
            }

            public void setThumbUpQuantity(String thumbUpQuantity) {
                this.thumbUpQuantity = thumbUpQuantity;
            }
        }
    }
}
