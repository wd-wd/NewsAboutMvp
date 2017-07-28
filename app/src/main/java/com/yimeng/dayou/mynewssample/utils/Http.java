package com.yimeng.dayou.mynewssample.utils;

/**
 * @author wangdong
 *         created at
 */

public class Http {
    /**
     * 头条
     * @param
     * @return
     */
    public static String getTopUrl() {
        StringBuffer sb = new StringBuffer();
        sb.append(Urls.TOP_URL);
        return sb.toString();
    }

    /**
     * NBA
     * @param
     * @return
     */
    public static String getNBAUrl() {
        StringBuffer sb = new StringBuffer();
        sb.append(Urls.NBA_URL);
        return sb.toString();
    }
    /**
     * 汽车
     * @param
     * @return
     */
    public static String getCarUrl() {
        StringBuffer sb = new StringBuffer();
        sb.append(Urls.NBA_URL);
        return sb.toString();
    }
    /**
     * 笑话
     * @param
     * @return
     */
    public static String getJokeUrl() {
        StringBuffer sb = new StringBuffer();
        sb.append(Urls.NBA_URL);
        return sb.toString();
    }
}
