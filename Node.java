import java.awt.Point;

/**A node that contains a Point and references to the previous and next node.
 * @author Adam Reyero*/
public class Node {
    /** The point consisting of the (x,y) integer coordinates of this Node.*/
    public Point point;

    /** A reference to the previous Node.*/
    public Node prev;

    /** A reference to the next Node.*/
    public Node next;

    /**Constructs a node with the specified point.
     * @param point The point of the newly constructed Node.*/
    public Node(Point point){
        this.point = point;
        this.prev = null;
        this.next = null;
    }

    /**Constructs a node with the specified (x,y) coordinates.
     * @param x The x coordinate of the newly constructed Node.
     * @param y The y coordinate of the newly constructed Node.*/
    public Node(int x, int y){
        this.point = new Point(x, y);
        this.prev = null;
        this.next = null;
    }
}
