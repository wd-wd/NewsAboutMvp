package com.yimeng.dayou.mynewssample.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by 1 on 2017/4/19.
 */

public class NewsBean {
        /**
         * postid : PHOT24LVS000100A
         * hasCover : false
         * hasHead : 1
         * replyCount : 26430
         * hasImg : 1
         * digest :
         * hasIcon : false
         * docid : 9IG74V5H00963VRO_CICDHAMQgengxunaupdateDoc
         * title : 90后女孩辞职做代孕赚20万 供妹妹上学
         * order : 1
         * priority : 354
         * lmodify : 2017-04-19 09:18:34
         * boardid : photoview_bbs
         * ads : [{"title":"男童2岁日抽40支烟震惊世界 今已戒烟","skipID":"00AO0001|2250746","tag":"photoset","imgsrc":"http://cms-bucket.nosdn.127.net/090e0b7c5a8f4731ad94c36a159d837e20170419075415.jpeg","subtitle":"","skipType":"photoset","url":"00AO0001|2250746"},{"title":"人类精子库高校科普宣传 学生羞涩笑对","skipID":"00AP0001|2250734","tag":"photoset","imgsrc":"http://cms-bucket.nosdn.127.net/c1ce8aab08ff4543a84d8c5cc644225e20170419072038.jpeg","subtitle":"","skipType":"photoset","url":"00AP0001|2250734"},{"title":"考古大发现！8具3500年木乃伊墓葬出土","skipID":"00AO0001|2250767","tag":"photoset","imgsrc":"http://cms-bucket.nosdn.127.net/fed9b2b823da46feb4c3e5a74de6994c20170419093125.jpeg","subtitle":"","skipType":"photoset","url":"00AO0001|2250767"},{"title":"美国加州枪击案致3死 嫌犯照片曝光","skipID":"00AO0001|2250735","tag":"photoset","imgsrc":"http://cms-bucket.nosdn.127.net/6b3eb94dcfdf47428dbf4f879fb70a2120170419072428.jpeg","subtitle":"","skipType":"photoset","url":"00AO0001|2250735"},{"title":"车模被强吻心里苦?车展抢镜绝招都有啥","skipID":"5BD20008|191730","tag":"photoset","imgsrc":"http://cms-bucket.nosdn.127.net/a17d11b674494f9f8bd985a1c905844c20170419075406.jpeg","subtitle":"","skipType":"photoset","url":"5BD20008|191730"}]
         * photosetID : 00AP0001|2250748
         * imgsum : 15
         * topic_background : http://img2.cache.netease.com/m/newsapp/reading/cover1/C1348646712614.jpg
         * template : normal1
         * votecount : 24872
         * skipID : 00AP0001|2250748
         * alias : Top News
         * skipType : photoset
         * cid : C1348646712614
         * hasAD : 1
         * imgextra : [{"imgsrc":"http://cms-bucket.nosdn.127.net/8699dcfbd3cf41aeaff0ecbc1889d8a020170419081710.jpeg"},{"imgsrc":"http://cms-bucket.nosdn.127.net/989d6a237b9b4de39eb314e6b404f72820170419081710.jpeg"}]
         * source : 网易综合
         * ename : androidnews
         * tname : 头条
         * imgsrc : http://cms-bucket.nosdn.127.net/f1c7aa7e8c8c4c5dbf12ef61e7f5369e20170419081710.jpeg
         * ptime : 2017-04-19 08:17:45
         * url_3w : http://news.163.com/17/0419/08/CICCN795000189FH.html
         * ltitle : 习近平"4·19"讲话一周年:让互联网更好造福人民
         * url : http://3g.163.com/news/17/0419/08/CICCN795000189FH.html
         * specialID : S1492175771874
         * subtitle :
         * TAGS : 独家
         * TAG : 独家
         */

        @SerializedName("postid")
        public String postid;
        @SerializedName("hasCover")
        public boolean hasCover;
        @SerializedName("hasHead")
        public int hasHead;
        @SerializedName("replyCount")
        public int replyCount;
        @SerializedName("hasImg")
        public int hasImg;
        @SerializedName("digest")
        public String digest;
        @SerializedName("hasIcon")
        public boolean hasIcon;
        @SerializedName("docid")
        public String docid;
        @SerializedName("title")
        public String title;
        @SerializedName("order")
        public int order;
        @SerializedName("priority")
        public int priority;
        @SerializedName("lmodify")
        public String lmodify;
        @SerializedName("boardid")
        public String boardid;
        @SerializedName("photosetID")
        public String photosetID;
        @SerializedName("imgsum")
        public int imgsum;
        @SerializedName("topic_background")
        public String topicBackground;
        @SerializedName("template")
        public String template;
        @SerializedName("votecount")
        public int votecount;
        @SerializedName("skipID")
        public String skipID;
        @SerializedName("alias")
        public String alias;
        @SerializedName("skipType")
        public String skipType;
        @SerializedName("cid")
        public String cid;
        @SerializedName("hasAD")
        public int hasAD;
        @SerializedName("source")
        public String source;
        @SerializedName("ename")
        public String ename;
        @SerializedName("tname")
        public String tname;
        @SerializedName("imgsrc")
        public String imgsrc;
        @SerializedName("ptime")
        public String ptime;
        @SerializedName("url_3w")
        public String url3w;
        @SerializedName("ltitle")
        public String ltitle;
        @SerializedName("url")
        public String url;
        @SerializedName("specialID")
        public String specialID;
        @SerializedName("subtitle")
        public String subtitle;
        @SerializedName("TAGS")
        public String TAGS;
        @SerializedName("TAG")
        public String TAG;
        @SerializedName("ads")
        public List<AdsBean> ads;
        @SerializedName("imgextra")
        public List<ImgextraBean> imgextra;

        public static class AdsBean {
            /**
             * title : 男童2岁日抽40支烟震惊世界 今已戒烟
             * skipID : 00AO0001|2250746
             * tag : photoset
             * imgsrc : http://cms-bucket.nosdn.127.net/090e0b7c5a8f4731ad94c36a159d837e20170419075415.jpeg
             * subtitle :
             * skipType : photoset
             * url : 00AO0001|2250746
             */

            @SerializedName("title")
            public String title;
            @SerializedName("skipID")
            public String skipID;
            @SerializedName("tag")
            public String tag;
            @SerializedName("imgsrc")
            public String imgsrc;
            @SerializedName("subtitle")
            public String subtitle;
            @SerializedName("skipType")
            public String skipType;
            @SerializedName("url")
            public String url;
        }

        public static class ImgextraBean {
            /**
             * imgsrc : http://cms-bucket.nosdn.127.net/8699dcfbd3cf41aeaff0ecbc1889d8a020170419081710.jpeg
             */

            @SerializedName("imgsrc")
            public String imgsrc;
        }
}
