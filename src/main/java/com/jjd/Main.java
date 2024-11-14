package com.jjd;

import com.jjd.shapes.Polygon;
import com.jjd.shapes.Triangle;
import com.jjd.shapes.Rectangel;
import com.jjd.adapters.AdapterCircle;
import com.jjd.vertex.Vertex;

/**
 * 创建时间: 2024-11-14 14:55
 * 项目名称: demo
 * 版本: 1.0
 *
 * @author 江金铎
 */
public class Main {
    /**
     * 多边形数组，包含不同类型的多边形对象
     */
    private Polygon[] polygons;

    /**
     * main方法，程序的入口
     * 初始化多边形数组并测试其功能
     *
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        // 创建Main实例，并初始化多边形数组
        Main mainApp = new Main();
        mainApp.polygons = new Polygon[3];

        // 初始化多边形数组中的元素
        mainApp.polygons[0] = new Triangle(new Vertex(0, 0), new Vertex(6, 0), new Vertex(6, 4));
        mainApp.polygons[1] = new Rectangel(new Vertex(0, 0), new Vertex(6, 0), new Vertex(6, 4), new Vertex(0, 4));
        mainApp.polygons[2] = new AdapterCircle(new Vertex(0, 0), 6);

        // 遍历多边形数组并调用各多边形的方法
        for (Polygon polygon : mainApp.polygons) {
            polygon.draw();
            if (polygon.canForm()) {
                System.out.println("面积为: " + polygon.calcArea());
            } else {
                System.out.println("无法构成该形状。");
            }
        }
    }
}
