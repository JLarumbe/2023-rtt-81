package inheritance;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		Rectangle rect = new Rectangle();

		rect.setName("Rectangle");
		rect.setHeight(10);
		rect.setWidth(15);

		Circle cir = new Circle();

		cir.setName("Circle");
		cir.setDiameter(100);

		Triangle tri = new Triangle();

		tri.setName("Triangle");
		tri.setSideA(3);
		tri.setSideB(5);
		tri.setSideC(8);
		tri.setBase(6);
		tri.setHeight(2);

		List<Shape> shapes = new ArrayList<>();

		shapes.add(rect);
		shapes.add(cir);
		shapes.add(tri);

		for (Shape shape : shapes) {
			System.out.println(shape.getName());
		}
	}
}
