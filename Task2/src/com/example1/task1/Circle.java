package com.example1.task1;

public class Circle implements Shape{

    private Draw2D draw2D;
    public Circle(Draw2D draw2D) {
        this.draw2D = draw2D;}


    @Override
    public void drawShape2d() {
        draw2D.draw("circle");
    }

   @Override
   public void drawShape3d() {

   }
}

