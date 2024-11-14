package com.jjd;

import org.junit.jupiter.api.Test;
import com.jjd.vertex.Vertex;
import com.jjd.shapes.Circle;
import com.jjd.shapes.Rectangel;
import com.jjd.shapes.Triangle;



import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 数值计算方法单元测试。
 * 通过白盒测试和黑盒测试相结合的方式，覆盖基本路径和等价类。
 * 对各个类的数值计算方法进行功能测试。
 * 创建时间: 2024-11-14 15:35
 * 项目名称: demo
 * 版本: 1.0
 *
 * @author 江金铎
 */
public class ShapeCalculationTest {

    /**
     * 测试 Vertex 类的 calcDistance 方法。
     * 输入顶点 (0,0) 和 (6,8)，预期输出距离 10.0。
     */
    @Test
    public void testVertexCalcDistance() {
        Vertex v1 = new Vertex(0, 0);
        Vertex v2 = new Vertex(6, 8);
        float finalDistance = 10.0f;
        assertEquals(finalDistance, v1.calcDistance(v2), 0.0001, "两点之间的距离计算错误");
    }

    /**
     * 测试 Circle 类的 areaCircle 方法。
     * 输入半径 6，预期输出面积 113.0973。
     */
    @Test
    public void testCircleArea() {
        Circle circle = new Circle(new Vertex(0, 0), 6);
        float finalArea = 113.0973f;
        assertEquals(finalArea, circle.areaCircle(), 0.0001, "圆的面积计算错误");
    }

    /**
     * 测试 Rectangel 类的 calcArea 方法。
     * 输入顶点 (0,0), (6,0), (6,8), (0,8)，预期输出面积 48.0。
     */
    @Test
    public void testRectangleArea() {
        Rectangel rectangle = new Rectangel(new Vertex(0, 0), new Vertex(6, 0), new Vertex(6, 8), new Vertex(0, 8));
        float finalArea = 48.0f;
        assertEquals(finalArea, rectangle.calcArea(), 0.0001, "矩形的面积计算错误");
    }

    /**
     * 测试 Triangle 类的 calcArea 方法。
     * 输入顶点 (0,0), (6,0), (3,8)，预期输出面积 24。
     */
    @Test
    public void testTriangleArea() {
        Triangle triangle = new Triangle(new Vertex(0, 0), new Vertex(6, 0), new Vertex(3, 8));
        float finalArea = 24.0f;
        assertEquals(finalArea, triangle.calcArea(), 0.0001, "三角形的面积计算错误");
    }

    /**
     * 测试 Circle 类的 areaCircle的边界值。
     * 输入半径 0，预期输出面积 0。
     */
    @Test
    public void testCircleAreaBoundary() {
        Circle circle = new Circle(new Vertex(0, 0), 0);
        float expectedArea = 0.0f;
        assertEquals(expectedArea, circle.areaCircle(), 0.0001, "半径为 0 的圆的面积计算有误");
    }

    /**
     * 测试 Triangle 类的 calcArea 方法的特殊值。
     * 输入共线的三点，预期输出面积 0。
     */
    @Test
    public void testTriangleAreaCollinear() {
        Triangle triangle = new Triangle(new Vertex(0, 0), new Vertex(2, 2), new Vertex(4, 4));
        float expectedArea = 0.0f;
        assertEquals(expectedArea, triangle.calcArea(), 0.0001, "三点共线时三角形面积一定是 0");
    }
}
