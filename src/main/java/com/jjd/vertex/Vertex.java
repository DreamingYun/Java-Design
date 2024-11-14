package com.jjd.vertex;

/**
 * 创建时间: 2024-11-14 14:55
 * 项目名称: demo
 * 版本: 1.0
 *
 * @author 江金铎
 */
public class Vertex {
    /**
     * x坐标
     */
    private float x;

    /**
     * y坐标
     */
    private float y;

    /**
     * x坐标。
     *
     * @return 返回x坐标，类型为float
     */
    public float getx() {
        return x;
    }

    /**
     * y坐标
     *
     * @return 返回y坐标，类型为float
     */
    public float gety() {
        return y;
    }

    /**
     * 构造顶点坐标
     *
     * @param x x坐标
     * @param y y坐标
     */
    public Vertex(float x, float y) {
        this.x = x;
        this.y = y;
    }

    /**
     * 计算当前顶点与另一个顶点之间的距离
     *
     * @param other 另一个顶点
     * @return 返回两个顶点之间的距离，类型为float
     */
    public float calcDistance(Vertex other) {
        return (float) Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
    }
}
