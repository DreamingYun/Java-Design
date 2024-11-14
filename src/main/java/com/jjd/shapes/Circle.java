package com.jjd.shapes;
import com.jjd.vertex.Vertex;

/**
 * 创建时间: 2024-11-14 14:53
 * 项目名称: demo
 * 版本: 1.0
 *
 * @author 江金铎
 */
public class Circle {
    /**
     * 圆的中心点
     */
    private Vertex center;

    /**
     * 圆的半径
     */
    private float radius;

    /**
     * 构造一个圆形。
     *
     * @param center 圆心顶点
     * @param radius 圆的半径
     */
    public Circle(Vertex center, float radius) {
        this.center = center;
        this.radius = radius;
    }

    /**
     * 绘制圆形的方法，打印圆的中心和半径信息。
     */
    public void drawCircle() {
        System.out.println("绘制一个半径为 " + radius + " 的圆形，其中心是: (" + center.getx() + ", " + center.gety() + ")");
    }

    /**
     * 计算圆的面积。
     * 计算公式：π * 半径^2。
     *
     * @return 返回圆的面积，类型为float
     */
    public float areaCircle() {
        return (float) (Math.PI * radius * radius);
    }
}
