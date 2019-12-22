public class Lab3
{
    public static void testLightCandles1()
    {
        Robot.load("candles1.txt");
        Robot.setDelay(0.05);
        lightCandles();
    }

    public static void testLightCandles2()
    {
        Robot.load("candles2.txt");
        Robot.setDelay(0.05);
        lightCandles();
    }

    public static void lightCandles()
    {
        //insert instructions below
        Robot.turnLeft();
        Robot.move();
        Robot.move();
        turnRight();
        lightCandle();
        lightCandle();
        lightCandle();
        lightCandle();
        lightCandle();
        lightCandle();
        lightCandle();
        lightCandle();
        lightCandle();
        lightCandle();
    }

    public static void lightCandle()
    {
        scanColumn();
        Robot.move();
        //Pre: Robot faces east at the top of the world one unit left of the candle
        //Post: Candle is lit and Robot has moved two units right 
    }

    public static void turnRight()
    {
        Robot.turnLeft();
        Robot.turnLeft(); 
        Robot.turnLeft();
        //Pre: Robot faces a direction
        //Post: Robot turns 90 degrees right
    }

    public static void turnAround(){
        turnRight();
        turnRight();
        //Pre: Robot faces a direction
        //Post: Robot turns 180 degrees
    }

    public static void returnToTop(){
        turnAround();
        Robot.move();
        turnRight(); 
        //Pre: Robot is facing down towards the bottom square of a candle
        //Post: Robot is at the top of the candle column and faces right
    }

    public static void scanColumn()
    {
        Robot.move();
        turnRight();
        if(Robot.frontIsClear()){
            Robot.move();
            if(Robot.frontIsClear()){
                returnToTop();
            }
            else {
                Robot.makeDark();
                returnToTop();
            }
        }
        else{
            Robot.makeDark(); 
            Robot.turnLeft();

        }
        //Pre: Candle is unlit
        //Post: Candle is lit
    }
    //Run this method to test completeRoom on map room1.txt
    public static void testCompleteRoom1()
    {
        Robot.load("room1.txt");
        Robot.setDelay(0.05);
        completeRoom();
    }

    //Run this method to test completeRoom on map room2.txt
    public static void testCompleteRoom2()
    {
        Robot.load("room2.txt");
        Robot.setDelay(0.05);
        completeRoom();
    }

    //Complete this method.  You will need to write additional helper methods.
    public static void completeRoom()
    {
        //insert instructions below
        fixFullWall();
        fixFullWall();
        fixFullWall();
        fixFullWall();
    }

    public static void fixFullWall(){
        checkLeftMoveOn();
        checkLeftMoveOn();
        checkLeftMoveOn();
        checkLeftMoveOn();
        checkLeftMoveOnCorner();
        //Pre: Robot faces north with wall on left
        //Pre: Wall is filled in and wall Robot was facing is now on Robot's left
    }

    public static void moveForwardDarken(){
        Robot.move();
        if(!Robot.onDark()){
            Robot.makeDark();
        }
        //Pre: Robot faces a square
        //Post: Robot is on the square and it is dark
    }

    public static void returnFromWall(){
        turnAround();
        Robot.move();
        Robot.turnLeft(); 
        //Pre: Robot is in a gap in the wall facing towards edge of world
        //Post: Robot moves one unit away from the edge towards the middle and turns 90 degrees right
    }

    public static void checkLeftMoveOn(){
        checkLeftClear();
        Robot.move();
        //Pre: Wall is one unit to the Robot's left
        //Post: Robot has filled in a hole in the wall if there is one and has moved one unit forward
    }

    public static void checkLeftMoveOnCorner(){
        checkLeftClear();
        turnRight();
        //Pre: Wall is one unit to the Robot's left and Robot faces a wall in front too
        //Post: Robot has filled in a hole in the left wall if there is one and has turned 90 degrees right
    }

    public static void checkLeftClear()
    {
        Robot.turnLeft();
        if (Robot.frontIsClear()){
            moveForwardDarken();
            returnFromWall();

        }
        else{
            turnRight();

        }
        //Pre: Wall is one unit to the Robot's left
        //Post: Robot has filled in a hole in said wall if there is one, no position change

    }

    //Run this method to test swapAll on map swap1.txt
    public static void testSwapAll1()
    {
        Robot.load("swap1.txt");
        Robot.setDelay(0.05);
        swapAll();
    }

    //Run this method to test swapAll on map swap2.txt
    public static void testSwapAll2()
    {
        Robot.load("swap2.txt");
        Robot.setDelay(0.05);
        swapAll();
    }

    //Complete this method.  You will need to write additional helper methods.
    public static void swapAll()
    {
        //insert instructions below
        swapRowForward();
        swapRowForward();
        swapRowForward();
        swapRowForward();
        swapRowForward();
        swapRowForward();
        swapRowForward();
        swapRowForward();
        swapRowForward();
        swapRowForward();

    }
 
    public static void swapRowForward(){
       swapRow(); 
       if (Robot.frontIsClear()){
            Robot.move(); 
        }
       //Pre: Robot is in the middle square, both sides are either darkened or not
       //Post: Dark/light is swapped between the two sides, Robot is 1 unit up
    }

    public static boolean isLeftDark(){
        Robot.turnLeft();
        Robot.move();
        if(Robot.onDark()){
            turnAround();
            Robot.move();
            Robot.turnLeft();
            return true;
        }
        else{
            turnAround();
            Robot.move();
            Robot.turnLeft();
            return false;
        }
        //Pre: Robot doesn't know the color of left side
        //Post: Robot knows the color of left side
    }

    public static void darkenLeft(){
        Robot.turnLeft();
        Robot.move();
        Robot.makeDark();
        turnAround();
        Robot.move();
        Robot.turnLeft();
        //Pre: Unit left of Robot is light
        //Post: Unit left of Robot is dark
    }

    public static void darkenRight(){
        turnRight();
        Robot.move();
        Robot.makeDark();
        turnAround();
        Robot.move();
        turnRight();
        //Pre: Unit right of Robot is light
        //Post: Unit right of Robot is dark
    }

    public static void lightenLeft(){
        Robot.turnLeft();
        Robot.move();
        Robot.makeLight();
        turnAround();
        Robot.move();
        Robot.turnLeft();
        //Pre: Unit left of Robot is dark
        //post: Unit right of Robot is light
    }

    public static void lightenRight(){
        turnRight();
        Robot.move();
        Robot.makeLight();
        turnAround();
        Robot.move();
        turnRight();
        //Pre: Unit right of Robot is dark
        //Post: Unit right of Robot is light
    }

    public static boolean isRightDark(){
        turnRight(); 
        Robot.move();
        if(Robot.onDark()){
            turnAround();
            Robot.move(); 
            turnRight();
            return true;
        }
        else{
            turnAround();
            Robot.move(); 
            turnRight();
            return false;
        }
        //Pre: Robot doesn't know the color of the right side
        //Post: Robot knows the color of the right side
    }

    public static void swapRow(){
        if(isRightDark() && !isLeftDark()) { 
            darkenLeft();
            lightenRight();  
        }
        else {
            if(!isRightDark() && isLeftDark()){
                lightenLeft();
                darkenRight();
            }
        }
        //Pre: Robot is in the middle square, both sides are either darkened or not
        //Post: Color of sides are swapped
    }
    //Don't run these. I will!
    public static void testLightCandles3()
    {
        Robot.load("candles3.txt");
        Robot.setDelay(0.05);
        lightCandles();
    }

    public static void testLightCandles4()
    {
        Robot.load("candles4.txt");
        Robot.setDelay(0.05);
        lightCandles();
    }

    public static void testCompleteRoom3()
    {
        Robot.load("room3.txt");
        Robot.setDelay(0.05);
        completeRoom();
    }

    public static void testCompleteRoom4()
    {
        Robot.load("room4.txt");
        Robot.setDelay(0.05);
        completeRoom();
    }

    public static void testSwapAll3()
    {
        Robot.load("swap3.txt");
        Robot.setDelay(0.05);
        swapAll();
    }

    //Run this method to test swapAll on map swap2.txt
    public static void testSwapAll4()
    {
        Robot.load("swap4.txt");
        Robot.setDelay(0.05);
        swapAll();
    }
}
