package com.jjd;

import org.junit.jupiter.api.Test;
import com.jjd.vertex.Vertex;
import com.jjd.shapes.Circle;
import com.jjd.shapes.Rectangel;
import com.jjd.shapes.Triangle;

import static org.junit.jupiter.api.Assertions.*;

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
     * 多种测试用例，调用其`canForm`方法来检查矩形是否能够正确形成
     * 创建了多种不同情况的矩形实例，以尽可能全面地覆盖不同的测试场景。
     */
    @Test
    public void testRectangle() {
        testRectangelByVertex(new Vertex[] {
                new Vertex(0, 0),
                new Vertex(4, 0),
                new Vertex(4, 3),
                new Vertex(0, 3)
        },12);

        testRectangelByVertex(new Vertex[] {
                new Vertex(1, 1),
                new Vertex(5, 1),
                new Vertex(5, 4),
                new Vertex(1, 4)
        },12);

        testRectangelByVertex(new Vertex[] {
                new Vertex(0, 0),
                new Vertex(4, 0),
                new Vertex(5, 3),
                new Vertex(1, 3)
        },0);

        testRectangelByVertex(new Vertex[] {
                new Vertex(2, 2),
                new Vertex(6, 2),
                new Vertex(6, 5),
                new Vertex(2, 5)
        },12);

        testRectangelByVertex(new Vertex[] {
                new Vertex(1, 1),
                new Vertex(1, 1),
                new Vertex(5, 4),
                new Vertex(1, 4)
        },0);

        testRectangelByVertex(new Vertex[] {
                new Vertex(0, 0),
                new Vertex(3, 0),
                new Vertex(3, 2),
                new Vertex(0, 2)
        },6);

    }

    private void testRectangelByVertex(Vertex[] vertexs,float aimArea){
        Vertex v1 = new Vertex(vertexs[0].getx(), vertexs[0].gety());
        Vertex v2 = new Vertex(vertexs[1].getx(), vertexs[1].gety());
        Vertex v3 = new Vertex(vertexs[2].getx(), vertexs[2].gety());
        Vertex v4 = new Vertex(vertexs[3].getx(), vertexs[3].gety());
        Rectangel rectangle = new Rectangel(v1, v2, v3, v4);
        // 输出顶点坐标
        System.out.println("顶点1: (" + v1.getx() + ", " + v1.gety() + ")");
        System.out.println("顶点2: (" + v2.getx() + ", " + v2.gety() + ")");
        System.out.println("顶点3: (" + v3.getx() + ", " + v3.gety() + ")");
        System.out.println("顶点3: (" + v4.getx() + ", " + v4.gety() + ")");

        if(rectangle.canForm()){
            assertEquals(aimArea, rectangle.calcArea(), "矩形面积计算错误");
            System.out.println("顶点可以构成矩形,且计算正确，面积为: " + rectangle.calcArea());
        }else{
            assertTrue(rectangle.canForm(), "这些顶点不能构成矩形");
        }
    }


    /**
     * 测试三角形相关的功能,调用其`canForm`方法来检查三角形是否能够正确形成
     * 创建了多种不同情况的三角形实例，以全面覆盖不同的测试场景
     */
    @Test
    public void testTriangle() {
        testTriangleByVertex(new Vertex[] {
                new Vertex(1, 1),
                new Vertex(4, 1),
                new Vertex(1, 5)
        },6);

        testTriangleByVertex(new Vertex[] {
                new Vertex(2, 3),
                new Vertex(5, 3),
                new Vertex(3, 7)
        },6);

        testTriangleByVertex(new Vertex[] {
                new Vertex(2, 2),
                new Vertex(5, 2),
                new Vertex(8, 2)
        },0);

        testTriangleByVertex(new Vertex[] {
                new Vertex(1, 1),
                new Vertex(3, 3),
                new Vertex(5, 1)
        },4);

        testTriangleByVertex(new Vertex[] {
                new Vertex(0, 0),
                new Vertex(6, 0),
                new Vertex(3, 5)
        },15);

        testTriangleByVertex(new Vertex[] {
                new Vertex(0, 0),
                new Vertex(4, 0),
                new Vertex(3, 3)
        },6);

        testTriangleByVertex(new Vertex[] {
                new Vertex(2, 2),
                new Vertex(2, 2),
                new Vertex(3, 3)
        },0);

        testTriangleByVertex(new Vertex[] {
                new Vertex(1, 1),
                new Vertex(2, 2),
                new Vertex(3, 3)
        },0);
    }

    private void testTriangleByVertex(Vertex[] vertexs,float aimArea){
        Vertex v1 = new Vertex(vertexs[0].getx(), vertexs[0].gety());
        Vertex v2 = new Vertex(vertexs[1].getx(), vertexs[1].gety());
        Vertex v3 = new Vertex(vertexs[2].getx(), vertexs[2].gety());
        Triangle triangle = new Triangle(v1, v2, v3);
        // 输出顶点坐标
        System.out.println("顶点1: (" + v1.getx() + ", " + v1.gety() + ")");
        System.out.println("顶点2: (" + v2.getx() + ", " + v2.gety() + ")");
        System.out.println("顶点3: (" + v3.getx() + ", " + v3.gety() + ")");
        if(triangle.canForm()){
            assertEquals(aimArea, triangle.calcArea(), "三角形面积计算错误");
            System.out.println("顶点可以构成三角形,且计算正确，面积为: " + triangle.calcArea());
        }else{
            assertTrue(triangle.canForm(), "这些顶点不能构成三角形");
        }
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
