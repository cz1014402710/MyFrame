package com.chenz.myframe.bean;

import java.util.List;

/**
 * description: <一句话功能简述>
 *
 * @author Chenz
 * @date 2017/11/8
 */
public class ProductListBean {

    /**
     * msg : 操作成功
     * code : 1000
     * categoryList : [{"name":"自然景观","category":28},{"name":"运动活动","category":29},{"name":"建筑人文","category":31},{"name":"场馆院所","category":32},{"name":"生活休闲","category":33},{"name":"公共沙滩","category":101}]
     * orderList : [{"name":"附近","orderBy":1},{"name":"好评","orderBy":3}]
     * itemList : [{"id":1,"title":"三亚南山旅游度假区（5A）","summary":"南山文化旅游区是我国著名的宗教与福寿文化景区，在这里既能领略阳光、碧海、沙滩、绿树美景，更能获得佛教文化带来的心灵慰籍，体味回归自然的乐趣，还可参观108米高的\u201c南山海上观音\u201d以及游览著名寺庙\u2014\u2014南山寺。 南山，面朝南海，坐落在三亚市的西南20公里处，是中国最南端的山。中国传扬千古的名句\u201c福如东","coverUrl":"http://dimg02.c-ctrip.com/images/100g050000000fs9o223C_C_350_230.jpg","distance":"1707.3","ticket":"138.00","score":"3.5","price":"138.00","praiseRate":null,"carNumber":null,"available":null,"telephone":null,"sort":null,"linkUrl":"http://172.100.20.73/app/api/product/toDetailContent?productType=101&productId=1&longitude=117.210189&latitude=31.853662","productType":101,"monthlySales":null,"ticketLinkValue":1,"ticketLinkUrl":"http://m.i-sanya.com/shop/detail.aspx?wid=34&pid=998","trustId":4,"longitude":"109.214854934772","latitude":"18.298658059094","isStatic":false,"productId":1,"category":null,"staticUrl":null,"requestUrl":null},{"id":76,"title":"海南呀诺达雨林文化旅游区","summary":"熱帯雨林，有花花草草和討人喜愛的動物，好像小鸚鵡和草泥馬，真的很開哦。","coverUrl":"http://pic.lvmama.com//uploads/pc/place2/2016-10-24/78e11087-206c-4ba1-a0c6-bb4a183be63d_480_320.jpg","distance":"1670.3","ticket":"158.00","score":"0.0","price":"158.00","praiseRate":null,"carNumber":null,"available":null,"telephone":null,"sort":null,"linkUrl":"http://172.100.20.73/app/api/product/toDetailContent?productType=101&productId=76&longitude=117.210189&latitude=31.853662","productType":101,"monthlySales":null,"ticketLinkValue":1,"ticketLinkUrl":"http://m.i-sanya.com/shop/detail.aspx?wid=34&pid=1005","trustId":1,"longitude":"109.656962","latitude":"18.464202","isStatic":false,"productId":76,"category":null,"staticUrl":null,"requestUrl":null},{"id":13,"title":"珠江南田温泉","summary":"珠江南田温泉是三亚知名度最高的温泉区，它位于三亚海棠湾南田农场内，属于低温温热矿水，矿化度很高，对人体多种疾病有特殊的辅助疗效。这里依山傍水，温泉分布在天然椰林中，环境非常好。 南田温泉共有34个温泉池，其中不乏一些特色泡池。在飞瀑池，会有水柱敲打脊背，有按摩的感觉；中药池，泡浸十二种中草药，浓","coverUrl":"http://dimg03.c-ctrip.com/images/tg/643/495/089/70fcb8ca31ad4e50b02f658da12aed07_C_350_230.jpg","distance":"1672.6","ticket":null,"score":"0.0","price":null,"praiseRate":null,"carNumber":null,"available":null,"telephone":null,"sort":null,"linkUrl":"http://172.100.20.73/app/api/product/toDetailContent?productType=101&productId=13&longitude=117.210189&latitude=31.853662","productType":101,"monthlySales":null,"ticketLinkValue":0,"ticketLinkUrl":null,"trustId":1,"longitude":"109.729151807597","latitude":"18.409121060196","isStatic":false,"productId":13,"category":null,"staticUrl":null,"requestUrl":null},{"id":100,"title":"槟榔谷","summary":"海南槟榔谷黎苗文化旅游区，中国首家民族文化型4A级景区，创建于1998年，地处北纬18°，位于保亭县与三亚市交界的甘什岭自然保护区境内。景区坐落在万余棵亭亭玉立、婀娜多姿的槟榔林海，并置身于古木参天、藤蔓交织的热带雨林中，规划面积5000余亩，距亚龙湾海岸26公里，距三亚市中心28公里","coverUrl":"http://app.i-sanya.com:8080/upload/scenic/1/1.jpg","distance":"1678.3","ticket":"135.00","score":"0.0","price":"135.00","praiseRate":null,"carNumber":null,"available":null,"telephone":null,"sort":null,"linkUrl":"http://172.100.20.73/app/api/product/toDetailContent?productType=101&productId=100&longitude=117.210189&latitude=31.853662","productType":101,"monthlySales":null,"ticketLinkValue":1,"ticketLinkUrl":"http://m.i-sanya.com/shop/detail.aspx?wid=34&pid=1008","trustId":1,"longitude":"109.677349","latitude":"18.375693","isStatic":false,"productId":100,"category":null,"staticUrl":null,"requestUrl":null},{"id":11,"title":"蜈支洲岛（5A）","summary":"蜈支洲岛的风景很好，岛上一派热带风光。这里海水能见度高，水下世界绚丽多彩，是我国最重要的潜水基地之一。同时，还是进行摩托艇、香蕉船、水上降落伞等水上活动的好地方。 岛上还有景点古迹妈祖庙和岛主别墅、情人桥等，有兴趣的也可以去参观（岛主别墅只能外观），情人桥是上岛后的第一个景点，是一座铁索桥，因为","coverUrl":"http://dimg05.c-ctrip.com/images/fd/tg/g1/M0B/7F/99/CghzfFWw9WKAbGoyABJRTZ3Fifw127_C_350_230.jpg","distance":"1679.8","ticket":"150.00","score":"0.0","price":"150.00","praiseRate":null,"carNumber":null,"available":null,"telephone":null,"sort":null,"linkUrl":"http://172.100.20.73/app/api/product/toDetailContent?productType=101&productId=11&longitude=117.210189&latitude=31.853662","productType":101,"monthlySales":null,"ticketLinkValue":1,"ticketLinkUrl":"http://m.i-sanya.com/shop/detail.aspx?wid=34&pid=997","trustId":3,"longitude":"109.772498256472","latitude":"18.3184295120137","isStatic":false,"productId":11,"category":null,"staticUrl":null,"requestUrl":null},{"id":6,"title":"亚龙湾鸟巢森林公园（4A）","summary":"亚龙湾热带天堂森林公园是电影《非诚勿扰II》在海南的主要取景地，整个环境呈现热带风格，树木繁多茂密，是很原始的热带自然风格。爬到最高峰，可以从上而下俯瞰亚龙湾。 园内有\u201c树中之王\u201d高山榕，还有另类的藤竹等，都是山中不可错过的景观，还能时不时地见到蝴蝶在你身边扑闪而来，极尽野趣。 亚龙湾热带天堂森","coverUrl":"http://dimg06.c-ctrip.com/images/fd/tg/g1/M02/7D/34/CghzfFWwz_uAa1DFABwYw-O18Fg870_C_350_230.jpg","distance":"1691.5","ticket":"150.00","score":"0.0","price":"150.00","praiseRate":null,"carNumber":null,"available":null,"telephone":null,"sort":null,"linkUrl":"http://172.100.20.73/app/api/product/toDetailContent?productType=101&productId=6&longitude=117.210189&latitude=31.853662","productType":101,"monthlySales":null,"ticketLinkValue":1,"ticketLinkUrl":"http://m.i-sanya.com/shop/detail.aspx?wid=34&pid=1021","trustId":36,"longitude":"109.640755492562","latitude":"18.2610111918513","isStatic":false,"productId":6,"category":null,"staticUrl":null,"requestUrl":null},{"id":51,"title":"三亚千古情","summary":"三亚千古情景区包括了三亚千古情主题景区和大型歌舞秀《三亚千古情》两部分。主题景区以丰富的仿古建筑为主，营造了浓郁的民俗风情，不时穿插的小表演极富乐趣，而这里最值得一看的则是震撼人心的歌舞秀。 千古情景区是宋城演艺公司为三亚量身打造的\u201c千古情\u201d系列演艺品牌。表演是千古情景区的重点，景点和表演是在一","coverUrl":"http://dimg09.c-ctrip.com/images/100a0700000020xmg4C78_C_350_230.jpg","distance":"1692.4","ticket":"320.00","score":"0.0","price":"320.00","praiseRate":null,"carNumber":null,"available":null,"telephone":null,"sort":null,"linkUrl":"http://172.100.20.73/app/api/product/toDetailContent?productType=101&productId=51&longitude=117.210189&latitude=31.853662","productType":101,"monthlySales":null,"ticketLinkValue":1,"ticketLinkUrl":"http://m.i-sanya.com/shop/detail.aspx?wid=34&pid=994","trustId":1,"longitude":"109.538705840339","latitude":"18.2975488757929","isStatic":false,"productId":51,"category":null,"staticUrl":null,"requestUrl":null},{"id":35,"title":"亚龙湾海底世界","summary":"亚龙湾海底世界位于亚龙湾海滨，这一带海域拥有种类繁多的珊瑚和藻类植物，以及庞大的鱼群。在这里可乘坐半潜式玻璃船欣赏美丽的海底世界，也可以穿上装备潜入水中近距离欣赏水下的生物。 亚龙湾海底世界是一个进行水上活动及潜水项目的场所，活动项目比如有海底世界远海潜水、西排专业潜水、摩托艇、拖伞、半潜观光船","coverUrl":"http://dimg01.c-ctrip.com/images/100g060000001vndg6B2D_C_350_230.jpg","distance":"1692.8","ticket":"270.00","score":"0.0","price":"270.00","praiseRate":null,"carNumber":null,"available":null,"telephone":null,"sort":null,"linkUrl":"http://172.100.20.73/app/api/product/toDetailContent?productType=101&productId=35&longitude=117.210189&latitude=31.853662","productType":101,"monthlySales":null,"ticketLinkValue":1,"ticketLinkUrl":"http://m.i-sanya.com/shop/detail.aspx?wid=34&pid=1037","trustId":1,"longitude":"109.663971385657","latitude":"18.2371844598796","isStatic":false,"productId":35,"category":null,"staticUrl":null,"requestUrl":null},{"id":27,"title":"亚龙湾爱立方","summary":"亚龙湾爱立方景区将自然资源和现代科技进行了深入的融合和挖掘，形成立体的\u201c海、山、湖、林、谷、滩\u201d联动的动态旅游环线。同时，景区将通过游览景观和文化科普两大主线打造主题园区域：亚龙湾印象区、滨海乐园区、山海联运区、观海休闲区、山顶区、蝴蝶谷区六大休闲娱乐区。 重建后的景区亮点主要有图腾柱广场方圆之","coverUrl":"http://dimg07.c-ctrip.com/images/100a060000001vnepAFF1_C_350_230.jpg","distance":"1693.5","ticket":null,"score":"0.0","price":null,"praiseRate":null,"carNumber":null,"available":null,"telephone":null,"sort":null,"linkUrl":"http://172.100.20.73/app/api/product/toDetailContent?productType=101&productId=27&longitude=117.210189&latitude=31.853662","productType":101,"monthlySales":null,"ticketLinkValue":0,"ticketLinkUrl":null,"trustId":6,"longitude":"109.651805532781","latitude":"18.2362077589866","isStatic":false,"productId":27,"category":null,"staticUrl":null,"requestUrl":null},{"id":74,"title":"京润珍珠博物馆","summary":"京润珍珠博物馆坐落于三亚凤凰机场路口，由海南京润珍珠有限公司投资建造，是目前我国第一家大型珍珠博物馆。 \u201c西珠不如东珠，东珠不如南珠\u201d。三亚珍珠文化馆的建成，使游客体验到浓郁的南国珍珠文化。是国家2A级景区，是中国唯一的大型珍珠博物馆，名列世界三大博物馆之一。 位于三亚市田独镇亨新大道旁，总建筑","coverUrl":"http://dimg06.c-ctrip.com/images/tg/747/601/034/85f948c2d96b41e2961b45d3ad380b3c_C_350_230.jpg","distance":"1695.6","ticket":"0.00","score":"0.0","price":"0.00","praiseRate":null,"carNumber":null,"available":null,"telephone":null,"sort":null,"linkUrl":"http://172.100.20.73/app/api/product/toDetailContent?productType=101&productId=74&longitude=117.210189&latitude=31.853662","productType":101,"monthlySales":null,"ticketLinkValue":0,"ticketLinkUrl":null,"trustId":53,"longitude":"109.446644418723","latitude":"18.3077673392855","isStatic":false,"productId":74,"category":null,"staticUrl":null,"requestUrl":null}]
     * totalRecord : 31
     * rows : 10
     */

    private String msg;
    private int code;
    private int totalRecord;
    private int rows;
    private List<CategoryListBean> categoryList;
    private List<OrderListBean> orderList;
    private List<ItemListBean> itemList;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public List<CategoryListBean> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<CategoryListBean> categoryList) {
        this.categoryList = categoryList;
    }

    public List<OrderListBean> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<OrderListBean> orderList) {
        this.orderList = orderList;
    }

    public List<ItemListBean> getItemList() {
        return itemList;
    }

    public void setItemList(List<ItemListBean> itemList) {
        this.itemList = itemList;
    }

    public static class CategoryListBean {
        /**
         * name : 自然景观
         * category : 28
         */

        private String name;
        private int category;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getCategory() {
            return category;
        }

        public void setCategory(int category) {
            this.category = category;
        }
    }

    public static class OrderListBean {
        /**
         * name : 附近
         * orderBy : 1
         */

        private String name;
        private int orderBy;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getOrderBy() {
            return orderBy;
        }

        public void setOrderBy(int orderBy) {
            this.orderBy = orderBy;
        }
    }

    public static class ItemListBean {
        /**
         * id : 1
         * title : 三亚南山旅游度假区（5A）
         * summary : 南山文化旅游区是我国著名的宗教与福寿文化景区，在这里既能领略阳光、碧海、沙滩、绿树美景，更能获得佛教文化带来的心灵慰籍，体味回归自然的乐趣，还可参观108米高的“南山海上观音”以及游览著名寺庙——南山寺。 南山，面朝南海，坐落在三亚市的西南20公里处，是中国最南端的山。中国传扬千古的名句“福如东
         * coverUrl : http://dimg02.c-ctrip.com/images/100g050000000fs9o223C_C_350_230.jpg
         * distance : 1707.3
         * ticket : 138.00
         * score : 3.5
         * price : 138.00
         * praiseRate : null
         * carNumber : null
         * available : null
         * telephone : null
         * sort : null
         * linkUrl : http://172.100.20.73/app/api/product/toDetailContent?productType=101&productId=1&longitude=117.210189&latitude=31.853662
         * productType : 101
         * monthlySales : null
         * ticketLinkValue : 1
         * ticketLinkUrl : http://m.i-sanya.com/shop/detail.aspx?wid=34&pid=998
         * trustId : 4
         * longitude : 109.214854934772
         * latitude : 18.298658059094
         * isStatic : false
         * productId : 1
         * category : null
         * staticUrl : null
         * requestUrl : null
         */

        private int id;
        private String title;
        private String summary;
        private String coverUrl;
        private String distance;
        private String ticket;
        private String score;
        private String price;
        private Object praiseRate;
        private Object carNumber;
        private Object available;
        private Object telephone;
        private Object sort;
        private String linkUrl;
        private int productType;
        private Object monthlySales;
        private int ticketLinkValue;
        private String ticketLinkUrl;
        private int trustId;
        private String longitude;
        private String latitude;
        private boolean isStatic;
        private int productId;
        private Object category;
        private Object staticUrl;
        private Object requestUrl;

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

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getCoverUrl() {
            return coverUrl;
        }

        public void setCoverUrl(String coverUrl) {
            this.coverUrl = coverUrl;
        }

        public String getDistance() {
            return distance;
        }

        public void setDistance(String distance) {
            this.distance = distance;
        }

        public String getTicket() {
            return ticket;
        }

        public void setTicket(String ticket) {
            this.ticket = ticket;
        }

        public String getScore() {
            return score;
        }

        public void setScore(String score) {
            this.score = score;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public Object getPraiseRate() {
            return praiseRate;
        }

        public void setPraiseRate(Object praiseRate) {
            this.praiseRate = praiseRate;
        }

        public Object getCarNumber() {
            return carNumber;
        }

        public void setCarNumber(Object carNumber) {
            this.carNumber = carNumber;
        }

        public Object getAvailable() {
            return available;
        }

        public void setAvailable(Object available) {
            this.available = available;
        }

        public Object getTelephone() {
            return telephone;
        }

        public void setTelephone(Object telephone) {
            this.telephone = telephone;
        }

        public Object getSort() {
            return sort;
        }

        public void setSort(Object sort) {
            this.sort = sort;
        }

        public String getLinkUrl() {
            return linkUrl;
        }

        public void setLinkUrl(String linkUrl) {
            this.linkUrl = linkUrl;
        }

        public int getProductType() {
            return productType;
        }

        public void setProductType(int productType) {
            this.productType = productType;
        }

        public Object getMonthlySales() {
            return monthlySales;
        }

        public void setMonthlySales(Object monthlySales) {
            this.monthlySales = monthlySales;
        }

        public int getTicketLinkValue() {
            return ticketLinkValue;
        }

        public void setTicketLinkValue(int ticketLinkValue) {
            this.ticketLinkValue = ticketLinkValue;
        }

        public String getTicketLinkUrl() {
            return ticketLinkUrl;
        }

        public void setTicketLinkUrl(String ticketLinkUrl) {
            this.ticketLinkUrl = ticketLinkUrl;
        }

        public int getTrustId() {
            return trustId;
        }

        public void setTrustId(int trustId) {
            this.trustId = trustId;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public boolean isIsStatic() {
            return isStatic;
        }

        public void setIsStatic(boolean isStatic) {
            this.isStatic = isStatic;
        }

        public int getProductId() {
            return productId;
        }

        public void setProductId(int productId) {
            this.productId = productId;
        }

        public Object getCategory() {
            return category;
        }

        public void setCategory(Object category) {
            this.category = category;
        }

        public Object getStaticUrl() {
            return staticUrl;
        }

        public void setStaticUrl(Object staticUrl) {
            this.staticUrl = staticUrl;
        }

        public Object getRequestUrl() {
            return requestUrl;
        }

        public void setRequestUrl(Object requestUrl) {
            this.requestUrl = requestUrl;
        }
    }
}
