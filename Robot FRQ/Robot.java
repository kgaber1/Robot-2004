
/**
 * Write a description of class Robot here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Robot
{
    // instance variables - replace the example below with your own
    private int[] hall;
    private int pos;       //current position(tile number) of Robot
    private boolean facingRight; // true means this Robot is facing right

    /**
     * Constructor for objects of class Robot
     */
    public Robot()
    {
      
    }

    /**
     * postcondition: returns true if this Robot has a wall immediately 
     *                in front of it, so that it cannot move forward;
     *                otherwise, returns false
     * 
     */  
    
    private boolean forwardMoveBlocked()
    {
        if (pos == 0 && facingRight == false) {
            return true;
        }
        if (pos == hall.length - 1 && facingRight == true) {
            return true;
        }
        return false;
    }
    
    /** postcondition: one move has been made according to the
     *                 specifications above and the state of this
     *                 Robot has been updated
     */   
    private void move() {
       if (hall[pos] > 0) {
         hall[pos]--;
       }
        if (hall[pos] == 0) {
        if (forwardMoveBlocked())
         facingRight = !facingRight;
        else if (facingRight) {
         pos++;
       }
       else
         pos--;
       }
    }
    
    /** postcondition: no more items remain in the hallway; 
     *                 returns the number of moves made
     */
    public int clearhall() {
        int move = 0;
        while(!hallIsClear()) {
          move();
          move++;
        }
        return move;
    }
    
    /** postcondition: return true if the hallway contains no items;
     *  otherwise, return false
     */
    private boolean hallIsClear() {
        boolean check = true;
        for (int i = 0; i < hall.length - 1; i++) {
          if (hall[i] != 0)
            check = false;
        } 
        return check;
    }
}
