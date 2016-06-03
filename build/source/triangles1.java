import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class triangles1 extends PApplet {

PShape pentagon;
int margin = 50;
int shapeWidth = 300;
int shapeHeight = 462;
int startingAngleDeg = 18;
int xDisplacement = PApplet.parseInt((shapeWidth/2) * sin(radians(startingAngleDeg)));
int yDisplacement = PApplet.parseInt((shapeWidth/2) * cos(radians(startingAngleDeg)));

public void triangleToRectange() {
  startingAngleDeg++;
  xDisplacement = PApplet.parseInt((shapeWidth/2) * sin(radians(startingAngleDeg)));
  yDisplacement = PApplet.parseInt((shapeWidth/2) * cos(radians(startingAngleDeg)));
}

public void rectangleToPentagon() {

}

public void makeShape() {
  pentagon = createShape();
  pentagon.beginShape();
  pentagon.vertex(shapeWidth / 2, 0);
  pentagon.vertex(shapeWidth / 2 + xDisplacement, yDisplacement);
  pentagon.vertex(shapeWidth, shapeHeight);
  pentagon.vertex(0, shapeHeight);
  pentagon.vertex(shapeWidth / 2 - xDisplacement, yDisplacement);
  pentagon.endShape(CLOSE);
}

public void setup() {
  
  stroke(255);
  strokeWeight(8);
  noFill();
  frameRate(30);
}

public void draw() {
  background(192, 64, 0);
  makeShape();
  shape(pentagon, shapeHeight/2 - shapeWidth/2 + margin, margin);
  if (xDisplacement < (shapeWidth/2)) {
    triangleToRectange();
  }
  else {
    rectangleToPentagon();
  }
}
  public void settings() {  size(562, 562); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "triangles1" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
