package com.jjd.shapes;

/**
 * 创建时间: 2024-11-14 14:54
 * 项目名称: demo
 * 版本: 1.0
 *
 * @author 江金铎
 */
public interface Polygon {
    /**
     * 绘制多边形的抽象方法。
     */
    void draw();

    /**
     * 判断顶点和其他参数是否可以构成有效的多边形。
     *
     * @return 如果构成有效的多边形，返回true；否则返回false
     */
    boolean canForm();

    /**
     * 计算多边形的面积。
     *
     * @return 返回计算好的多边形的面积，类型为float
     */
    float calcArea();
}
