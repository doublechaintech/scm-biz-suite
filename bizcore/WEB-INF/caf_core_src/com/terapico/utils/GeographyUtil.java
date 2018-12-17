package com.terapico.utils;

public class GeographyUtil {

    // 地球平均半径
    private static final double EARTH_RADIUS = 6378137.0;

    // 把经纬度转为度（°）
    private static double rad(double d) {
        return d * Math.PI / 180.0;
    }

    /**
     * 根据两点间经纬度坐标（double值），计算两点间距离，单位为米
     * 
     * @param longitudeA
     * @param latitudeA
     * @param longitudeB
     * @param latitudeB
     * @return
     */
    public static double caclDistance(double longitudeA, double latitudeA, Double longitudeB, Double latitudeB) {
    	System.out.println("calculate distance from "+longitudeA+","+latitudeA+" to " +longitudeB+","+latitudeB);
        double radLat1 = rad(latitudeA);
        double radLat2 = rad(latitudeB);
        double a = radLat1 - radLat2;
        double b = rad(longitudeA) - rad(longitudeB);
        double s = 2 * Math.asin(Math.sqrt(
                Math.pow(Math.sin(a / 2), 2) + Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
        s = s * EARTH_RADIUS;
        s = Math.round(s * 10000) / 10000;
        return s;
    }
    
    public static void main(String[] args) {
    	double dis = caclDistance(104.06476, 30.5702, 104.051, 30.528);
    	System.out.println("dis=" + dis);
    }

}
