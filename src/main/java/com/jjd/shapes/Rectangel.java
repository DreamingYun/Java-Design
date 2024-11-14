package com.jjd.shapes;
import com.jjd.vertex.Vertex;

/**
 * 创建时间: 2024-11-14 14:54
 * 项目名称: demo
 * 版本: 1.0
 *
 * @author 江金铎
 */
public class Rectangel implements Polygon{
    /**
     * 矩形的四个顶点
     */
    private Vertex v1, v2, v3, v4;

    /**
     * 构造一个矩形。
     *
     * @param v1 矩形的第一个顶点
     * @param v2 矩形的第二个顶点
     * @param v3 矩形的第三个顶点
     * @param v4 矩形的第四个顶点
     */
    public Rectangel(Vertex v1, Vertex v2, Vertex v3, Vertex v4) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
        this.v4 = v4;
    }

    /**
     * 绘制矩形，打印矩形的顶点信息。
     */
    @Override
    public void draw() {
        System.out.println("绘制一个矩形，其顶点是: (" + v1.getx() + ", " + v1.gety() + "), (" + v2.getx() + ", " + v2.gety() + "), (" + v3.getx() + ", " + v3.gety() + "), (" + v4.getx() + ", " + v4.gety() + ")");
    }

    /**
     * 判断顶点是否可以构成一个有效的矩形。
     *
     * @return 如果可以构成有效的矩形则返回true；否则返回false
     */
    @Override
    public boolean canForm() {
        float d1 = v1.calcDistance(v2);
        float d2 = v2.calcDistance(v3);
        float d3 = v3.calcDistance(v4);
        float d4 = v4.calcDistance(v1);
        return d1 == d3 && d2 == d4;
    }

    /**
     * 计算矩形的面积。
     *
     * @return 返回矩形的面积，类型为float
     */
    @Override
    public float calcArea() {
        float length = v1.calcDistance(v2);
        float width = v2.calcDistance(v3);
        return length * width;
    }
}
