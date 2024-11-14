package com.jjd.adapters;

import com.jjd.shapes.Polygon;
import com.jjd.shapes.Circle;
import com.jjd.vertex.Vertex;

/**
 * 创建时间: 2024-11-14 14:53
 * 项目名称: demo
 * 版本: 1.0
 *
 * @author 江金铎
 */
public class AdapterCircle implements Polygon {
    /**
     * Circle对象
     */
    private Circle circle;

    /**
     * 构造一个适配器圆形
     *
     * @param center 圆形的中心
     * @param radius 圆形的半径
     */
    public AdapterCircle(Vertex center, float radius) {
        this.circle = new Circle(center, radius);
    }

    /**
     * 绘制适配的圆形，调用Circle的绘制方法。
     */
    @Override
    public void draw() {
        circle.drawCircle();
    }

    /**
     * 判断圆形是否可以构成有效的形状。
     *
     * @return 如果圆形有效则返回true；否则返回false
     */
    @Override
    public boolean canForm() {
        return circle != null && circle.areaCircle() > 0;
    }

    /**
     * 计算圆形的面积。
     *
     * @return 返回圆形的面积，类型为float
     */
    @Override
    public float calcArea() {
        return circle.areaCircle();
    }
}
