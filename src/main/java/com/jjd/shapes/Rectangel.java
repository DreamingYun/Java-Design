package com.jjd.shapes;

/**
 * 创建时间: 2024-11-14 14:54
 * 项目名称: demo
 * 版本: 1.0
 *
 * @author 江金铎
 */
public class Rectangel implements Polygon{

    @Override
    public void draw() {

    }

    /**
     * 判断顶点是否可以构成一个有效的矩形。
     *
     * @return 如果可以构成有效的矩形则返回true；否则返回false
     */
    @Override
    public boolean canForm() {
        return false;
    }

    /**
     * 计算矩形的面积。
     *
     * @return 返回矩形的面积，类型为float
     */
    @Override
    public float calcArea() {
        return 0;
    }
}
