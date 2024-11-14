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
