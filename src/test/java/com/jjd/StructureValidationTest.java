package com.jjd;

import com.jjd.shapes.Triangle;
import com.jjd.shapes.Circle;
import com.jjd.shapes.Rectangel;
import com.jjd.shapes.Polygon;
import com.jjd.adapters.AdapterCircle;
import com.jjd.vertex.Vertex;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 通过反射机制验证类的继承、实现和方法重写情况。
 * 创建时间: 2024-11-14 16:02
 * 项目名称: demo
 * 版本: 1.0
 *
 * @author 江金铎
 */
public class StructureValidationTest {
    /**
     * 测试类是否存在。
     */
    @Test
    public void testClassExistence() {
        try {
            Class.forName("com.jjd.vertex.Vertex");
            Class.forName("com.jjd.shapes.Circle");
            Class.forName("com.jjd.shapes.Polygon");
            Class.forName("com.jjd.shapes.Rectangel");
            Class.forName("com.jjd.shapes.Triangle");
            Class.forName("com.jjd.adapters.AdapterCircle");
        } catch (ClassNotFoundException e) {
            assertTrue(false, "指定类不存在：" + e.getMessage());
        }
    }

    /**
     * 检查`Triangle`、`Rectangle`和`Circle`类是否具有预期的属性。
     */
    @Test
    public void testFields() {
        // 检查Triangle的属性
        try {
            Triangle.class.getDeclaredField("v1");
            Triangle.class.getDeclaredField("v2");
            Triangle.class.getDeclaredField("v3");
            System.out.println("Triangle有v1、v2、v3属性");
        } catch (NoSuchFieldException e) {
            System.out.println("Triangle没有v1、v2、v3属性");
        }

        // 检查Rectangle的属性
        try {
            Rectangel.class.getDeclaredField("v1");
            Rectangel.class.getDeclaredField("v2");
            Rectangel.class.getDeclaredField("v3");
            Rectangel.class.getDeclaredField("v4");
            System.out.println("Rectangle有v1、v2、v3、v4属性");
        } catch (NoSuchFieldException e) {
            System.out.println("Rectangle没有v1、v2、v3、v4属性");
        }

        // 检查Circle的属性
        try {
            Circle.class.getDeclaredField("center");
            Circle.class.getDeclaredField("radius");
            System.out.println("Circle有center和radius属性");
        } catch (NoSuchFieldException e) {
            System.out.println("Circle没有center和radius属性");
        }
    }

    /**
     * 测试 Polygon 接口的实现。
     */
    @Test
    public void testPolygonInterfaceImplementation() {
        assertTrue(Polygon.class.isAssignableFrom(Rectangel.class), "Rectangle 实现 Polygon 接口");
        assertTrue(Polygon.class.isAssignableFrom(Triangle.class), "Triangle 实现 Polygon 接口");
        assertTrue(Polygon.class.isAssignableFrom(AdapterCircle.class), "AdapterCircle 实现 Polygon 接口");
    }

    /**
     * 测试类之间的继承和组合关系。
     */
    @Test
    public void testInheritanceAndComposition() {
        boolean hasCircleField = false;
        for (Field field : AdapterCircle.class.getDeclaredFields()) {
            if (field.getType() == Circle.class) {
                hasCircleField = true;
                break;
            }
        }
        assertTrue(hasCircleField, "AdapterCircle 应包含 Circle 类型的成员变量以组合 Circle 类");

        // AdapterCircle 应实现 Polygon 接口
        assertTrue(Polygon.class.isAssignableFrom(AdapterCircle.class), "AdapterCircle 应实现 Polygon 接口");
    }

    /**
     * 测试 Polygon 接口中的方法是否被正确重写。
     */
    @Test
    public void testMethodOverrideInPolygon() {
        checkMethodOverride(Rectangel.class, "draw");
        checkMethodOverride(Rectangel.class, "canForm");
        checkMethodOverride(Rectangel.class, "calcArea");

        checkMethodOverride(Triangle.class, "draw");
        checkMethodOverride(Triangle.class, "canForm");
        checkMethodOverride(Triangle.class, "calcArea");

        checkMethodOverride(AdapterCircle.class, "draw");
        checkMethodOverride(AdapterCircle.class, "canForm");
        checkMethodOverride(AdapterCircle.class, "calcArea");
    }

    /**
     * 测试各类的构造器定义。
     */
    @Test
    public void testConstructorDefinition() {
        checkConstructor(Vertex.class, float.class, float.class);
        checkConstructor(Circle.class, Vertex.class, float.class);
        checkConstructor(Rectangel.class, Vertex.class, Vertex.class, Vertex.class, Vertex.class);
        checkConstructor(Triangle.class, Vertex.class, Vertex.class, Vertex.class);
        checkConstructor(AdapterCircle.class, Vertex.class, float.class);
    }

    /**
     * 检查`Polygon`接口及其实现类（`Triangle`、`Rectangle`、`AdapterCircle`）中的`canForm`方法的返回类型是否为`boolean`。
     */
    @Test
    public void testCanFormMethod() {
        try {
            Method canFormMethod = Polygon.class.getMethod("canForm");
            assertEquals(boolean.class, canFormMethod.getReturnType());
            System.out.println("Polygon类中的canForm方法返回类型为boolean");

            Method triangleCanFormMethod = Triangle.class.getMethod("canForm");
            assertEquals(boolean.class, triangleCanFormMethod.getReturnType());
            System.out.println("Triangle类中的canForm方法返回类型为boolean");

            Method rectangleCanFormMethod = Rectangel.class.getMethod("canForm");
            assertEquals(boolean.class, rectangleCanFormMethod.getReturnType());

            System.out.println("Rectangle类中的canForm方法返回类型为boolean");

            Method adapterCircleCanFormMethod = AdapterCircle.class.getMethod("canForm");
            assertEquals(boolean.class, adapterCircleCanFormMethod.getReturnType());
            System.out.println("AdapterCircle类中的canForm方法返回类型为boolean");
        } catch (NoSuchMethodException e) {
            System.out.println("某个类中没有找到canForm方法: " + e.getMessage());
        }
    }

    /**
     * 辅助方法：检查是否重写了指定方法。
     *
     * @param clazz      检查的类
     * @param methodName 方法名
     */
    private void checkMethodOverride(Class<?> clazz, String methodName) {
        try {
            Method method = clazz.getMethod(methodName);
            assertTrue(Modifier.isPublic(method.getModifiers()), clazz.getSimpleName() + " 类的 " + methodName + " 方法应为 public");
        } catch (NoSuchMethodException e) {
            assertTrue(false, clazz.getSimpleName() + " 重写 Polygon 接口的 " + methodName + " 方法");
        }
    }

    /**
     * 辅助方法：检查类是否定义了指定构造器。
     *
     * @param clazz          检查的类
     * @param parameterTypes 构造器参数类型
     */
    private void checkConstructor(Class<?> clazz, Class<?>... parameterTypes) {
        try {
            Constructor<?> constructor = clazz.getConstructor(parameterTypes);
            assertTrue(Modifier.isPublic(constructor.getModifiers()), clazz.getSimpleName() + " 的构造器应为 public");
        } catch (NoSuchMethodException e) {
            assertTrue(false, clazz.getSimpleName() + " 定义指定的构造器");
        }
    }
}
