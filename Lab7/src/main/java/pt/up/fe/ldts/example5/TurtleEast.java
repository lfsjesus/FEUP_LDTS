package pt.up.fe.ldts.example5;

public class TurtleEast extends TurtleState{
    public TurtleEast() { }
    public TurtleEast(Turtle turtle) {
        this.turtle = turtle;
    }
    @Override
    public void moveForward() {
        turtle.setColumn(turtle.getColumn() + 1);
    }
    @Override
    public void rotateRight() {
        turtle.setDirection(new TurtleSouth(turtle));
    }
    @Override
    public void rotateLeft() {
        turtle.setDirection(new TurtleNorth(turtle));
    }
}
