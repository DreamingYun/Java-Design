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
        // 判断两组相对边是否相等
        if (d1 != d3 || d2 != d4) {
            return false;
        }

        // 计算向量
        Vector v1v2 = new Vector(v1, v2);  // 向量 v1 -> v2
        Vector v2v3 = new Vector(v2, v3);  // 向量 v2 -> v3
        Vector v3v4 = new Vector(v3, v4);  // 向量 v3 -> v4
        Vector v4v1 = new Vector(v4, v1);  // 向量 v4 -> v1

        // 判断角度是否为直角
        // 通过计算向量的点积，判断相邻的向量是否垂直
        if (v1v2.dotProduct(v2v3) != 0 || v2v3.dotProduct(v3v4) != 0 || v3v4.dotProduct(v4v1) != 0) {
            return false;  // 如果任意一个角不为直角，返回false
        }

        return true;  // 符合构成矩形的条件
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

/**
 * 向量类
 */
class Vector {
    public float x, y;

    public Vector(Vertex start, Vertex end) {
        this.x = end.getx() - start.getx();
        this.y = end.gety() - start.gety();
    }

    public float dotProduct(Vector other) {
        return this.x * other.x + this.y * other.y;
    }
}
