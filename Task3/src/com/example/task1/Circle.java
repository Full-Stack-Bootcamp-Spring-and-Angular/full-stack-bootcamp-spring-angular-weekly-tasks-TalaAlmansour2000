package com.example.task1;

public class Circle implements Shape{

    private Draw2D draw2D;
    private Draw3D draw3D;
    public Circle(Draw2D draw2D) {
        this.draw2D = draw2D;}
    public void setDraw3D(Draw3D draw3D) {
        this.draw3D = draw3D;
    }


    @Override
    public void drawShape2d() {
        draw2D.draw("circle");
    }

   @Override
   public void drawShape3d() {
        draw3D.draw("circle");


   }
}

