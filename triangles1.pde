PShape pentagon;
int margin = 50;
int shapeWidth = 300;
int shapeHeight = 462;
int startingAngleDeg = 18;
int xDisplacement = int((shapeWidth/2) * sin(radians(startingAngleDeg)));
int yDisplacement = int((shapeWidth/2) * cos(radians(startingAngleDeg)));

void triangleToRectangle() {
  startingAngleDeg++;
  xDisplacement = int((shapeWidth/2) * sin(radians(startingAngleDeg)));
  yDisplacement = int((shapeWidth/2) * cos(radians(startingAngleDeg)));
}

void rectangleToPentagon() {

}

void makeShape() {
  pentagon = createShape();
  pentagon.beginShape();
  pentagon.vertex(shapeWidth / 2, 0);
  pentagon.vertex(shapeWidth / 2 + xDisplacement, yDisplacement);
  pentagon.vertex(shapeWidth, shapeHeight);
  pentagon.vertex(0, shapeHeight);
  pentagon.vertex(shapeWidth / 2 - xDisplacement, yDisplacement);
  pentagon.endShape(CLOSE);
}

void setup() {
  size(562, 562);
  stroke(255);
  strokeWeight(8);
  noFill();
  frameRate(30);
}

void draw() {
  background(12, 171, 67);
  makeShape();
  shape(pentagon, shapeHeight/2 - shapeWidth/2 + margin, margin);
  if (xDisplacement < (shapeWidth/2)) {
    triangleToRectangle();
  }
  else {
    rectangleToPentagon();
  }
}
