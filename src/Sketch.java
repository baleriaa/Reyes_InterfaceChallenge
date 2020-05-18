import processing.core.PApplet;
import java.util.ArrayList;
import java.util.Collections;


public class Sketch extends PApplet {

    public void settings(){
        size(800, 800);
    }

    public void setup(){
        background(230, 100, 23);
        ArrayList<Shape> shapes = new ArrayList<Shape>();
        add(shapes);
        System.out.println("Unsorted list ");
        display(shapes);
        Collections.sort(shapes);
        System.out.println();
        System.out.println("Sorted list ");
        display(shapes);
        System.out.println(String.format("The total number of shapes created are: %d", Shape.getNumShapes()));
    }

    public void draw(){
    //Not sure of what to put here.
        gwrgw

    }
    private void add(ArrayList<Shape> shapes) {
        shapes.add(new Circle(new Point(300.0f, 300.0f), 100.0f));
        shapes.add(new Circle(new Point(200.0f, 200.0f), 50.0f));
        shapes.add(new Rectangle(new Point(0.0f, 0.0f), 20.0f, 20.0f));
        shapes.add(new Rectangle(new Point(50.0f, 50.0f), 10.0f, 40.0f));
        shapes.add(new Circle(new Point(20.0f, 170.0f), 12.0f));
        shapes.add(new Circle(new Point(30.0f, 163.0f), 42.0f));
        shapes.add(new Rectangle(new Point(4.0f, 92.3f), 72.0f, 45.7f));
    }

    private static void display(ArrayList<Shape> shapes) {
        for (Shape shape : shapes) {
            System.out.println(shape);
        }
    }


    abstract static class Shape implements Comparable<Shape> {

        private Point position;
        private static int numShapes;
        private int id;

        public Shape(Point position) {
            this.position = position;
            ++numShapes;
            setId(numShapes);
        }

        public Point getPosition() {
            return position;
        }
        public void setPosition(Point position) {
            this.position = position;
        }
        public static int getNumShapes() {
            return numShapes; }
        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
        abstract public float computeArea();
        abstract public float getPerimeter();
        @Override
        public int compareTo(Shape other) {
            if ((this.computeArea() > other.computeArea()) || (this.computeArea() < other.computeArea())) {
                return (int) (this.computeArea() - other.computeArea());
            } else return (int) (this.getPerimeter() - other.getPerimeter());
        }
        public String toString() {
            return String.format("Shape type: %s, ID: %d, Area: %f, Perimeter: %f", getClass().getName(), id, computeArea(), getPerimeter());
        }
    }

    public static class Point{

        private static float x;
        private static float y;

        public Point(float x, float y) {
            this.x = x;
            this.y = y;
        }

        public static float getX() {
            return x;
        }
        public static float getY() {
            return y;
        }
        public void setX(float x) {
            this.x = x;
        }
        public void setY(float y) {
            this.y = y;
        }
    }

    public class Circle extends Shape {

        private float radius;

        public Circle(Point center, float radius) {
            super(center);
            this.radius = radius;
            circle(center.getX(), center.getY(), radius);

        }

        public float computeArea() {
            return (float) (Math.PI * Math.pow(radius, 2));
        }
        public float getPerimeter() {
            return (float) (2 * Math.PI * radius);
        }
    }

    public class Rectangle extends Shape {

        private float length, height;

        Rectangle(Point point, float length, float height) {
            super(point);
            this.length = length;
            this.height = height;
            rect(point.getX(), point.getY(), length, height);
        }

        public float computeArea() {
            return  length*height; }
        public float getPerimeter() {
            return 2*length + 2*height;}

    }
}
