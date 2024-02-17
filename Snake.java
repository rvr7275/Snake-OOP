import java.awt.Point;
import java.util.HashMap;

/**A four-directional enum to be used for movement*/
enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT
}

/**A snake consisting of a doubly linked list of Nodes and
 * a HashMap of all points the snake occupies.
 * @author Adam Reyero*/
public class Snake {

    /** The first Node of the snake*/
    private Node head;

    /** The final Node of the snake*/
    private Node tail;

    /** The direction of movement for the Snake.*/
    public Direction direction;

    /** Hashmap containing all Points occupied by the snake and the number of Nodes at that Point.*/
    /*Intended to perform collision and fruit spawning stuff in constant time. */
    private HashMap<Point, Integer> nodes;

    /**Constructs a snake of length 2 with the head at the specified coordinates.
     * Initialized facing UP (positive y direction).
     * @param x The x coordinate of the head of the newly constructed snake
     * @param y The y coordinate of the head of the newly constructed snake*/
    public Snake(int x, int y){
        nodes = new HashMap<Point, Integer>();

        head = new Node(x, y);
        addNode(head.point);

        tail = new Node(x, y-1);   /*Initializes the tail one underneath the head so that the snake can start moving 'UP' */
        addNode(tail.point);

        head.next = tail;
        tail.prev = head;

        direction = Direction.UP;
    }

    /**@return Head of this Snake.*/
    public Node getHead(){
        return head;
    }

    /**@return Tail of this Snake.*/
    public Node getTail(){
        return tail;
    }

    /**@return Hash Map of Node occupied points */
    public HashMap<Point, Integer> getNodes() {
        return nodes;
    }

    /**Moves this Snake one coordinate in the Snake's current direction.
     * @see #direction*/
    public void move(){
        /*Tail becomes the new head */
        removeNode(tail.point);
        
        switch(direction){
            case DOWN:
                tail.point = new Point(head.point.x, head.point.y-1);   /*Currently, UP represents the positive y direction and DOWN is the negative y direction */
                break;
            case LEFT:
                tail.point = new Point(head.point.x-1, head.point.y);
                break;
            case RIGHT:
                tail.point = new Point(head.point.x+1, head.point.y);
                break;
            case UP:
                tail.point = new Point(head.point.x, head.point.y+1);
                break;
        }
        head.prev = tail;   /*Do a quick little switcheroo */
        tail.next = head;
        head = tail;
        tail = tail.prev;
        head.prev = null;
        tail.next = null;

        addNode(head.point);
    }

    /**Appends a node to the end of this Snake.
     * <p>The new node and the tail will occupy the same point */
    public void grow(){
        Node newNode = new Node(tail.point);    /*Both nodes occupy the same point */
        addNode(newNode.point);
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    /**@return Whether the Snakes head has run into its own 'body'
     * and is now occupying the same point as another node*/
    public boolean checkSelfCollision(){
        return nodes.get(head.point) >= 2;
    }

    /**A helper function to update the nodes Hash Map at a point
     * @param point */
    private void addNode(Point point){
        if(nodes.get(point) != null){
            nodes.put(point, nodes.get(point) + 1);
        } else{
            nodes.put(point, 1);
        }
    }

    /**A helper function to update the nodes Hash Map at a point
     * @param point */
    private void removeNode(Point point){
        if(nodes.get(point) != null && nodes.get(point) > 1){
            nodes.put(point, nodes.get(point) - 1);
        } else{
            nodes.remove(point);
        }
    }
}