package net.wassim.customerservice.learn;

import java.awt.*;

public class Circle implements Shape {

    int radius;

    @Override
    public void render() {
        System.out.println("Circle");
    }

    @Override
    public Shape clone() {
        Circle c = new Circle();
        c.radius = radius;
        return c;
    }

    public boolean equals(Object object2) {
        Circle shape2 = (Circle) object2;
        return shape2.radius == radius;
    }
}
