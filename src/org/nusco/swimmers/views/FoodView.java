package org.nusco.swimmers.views;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.transform.Translate;

import org.nusco.swimmers.pond.Food;
import org.nusco.swimmers.shared.physics.Vector;

class FoodView extends ThingView {

	private final Node circle;

	public FoodView(Food food) {
		super(food);
		circle = createCircle(food);
	}

	public Node toNode() {
		circle.getTransforms().clear();
		circle.getTransforms().add(moveToStartPoint());
		return circle;
	}

	private Node createCircle(Food food) {
		Circle result = new Circle(10);
		Color baseColor = Color.LIMEGREEN;
		result.setFill(new Color(baseColor.getRed(), baseColor.getGreen(), baseColor.getBlue(), 0.8));
		return result;
	}

	private Translate moveToStartPoint() {
		Vector position = getThing().getPosition();
		return new Translate(position.x, position.y);
	}
}