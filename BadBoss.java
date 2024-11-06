/**
 *               ________________
 *               |                |_____    __
 *               |  I HATE JAVA   |     |__|  |_________
 *               |________________|     |::|  |        /
 *   /\--/\       |                \.____|::|__|      <
 *   ( o_o  )_     |                      \::/  \._______\
 *   (u--u   \_)  |
 *   (||___   )==\
 *   ,dP"/b/=( /P"/b\
 *   |8 || 8\=== || 8
 *   `b,  ,P  `b,  ,P
 *   """`     """`
 */

package BadBoss;

import java.util.ArrayList;

public class BadBoss {
    private static Tree myTree1;
    private static Tree myTree2;

    public static void main(String[] args) {
    	// Method 1
    	myTree1 = new Tree(1, 1);
    	myTree2 = new Tree(2, 2);
    	System.out.println("swapField()\nBefore:\n" + myTree1.toString()
    	+ "\n" + myTree2.toString());
    	swapField();
    	System.out.println("After:\n" + myTree1.toString() + "\n" + myTree2.toString());
    	
    	// Method 2
        short x, y;
        x = 5;
        y = 10;
        System.out.println("Before:\n" + x + "\n" + y);
        short[] paramRes = swapParam(x, y);
        System.out.println("After:\n" + x + "\n" + y);

        // Method 3
        
    }

    public static void swapField() {
        Tree tempTree = myTree1;
        myTree1       = myTree2;
        myTree2       = tempTree;
    }

    public static short[] swapParam(short x, short y) {
        short temp = x;
        x          = y;
        y          = temp;
        short[] myShort = new short[2];
        myShort[0] = x;
        myShort[1] = y;
        return myShort;
    }

    public static Point[] swapLocal() {
        Point x = new Point();
        Point y = new Point();
        Point[] pArr = privSwapParam(x, y);
        return pArr;
    }

    public void swapArray(int a[], int index1, int index2) {
        int i1    = a[index1];
        int i2    = a[index2];
        a[index1] = i2;
        a[index2] = i1;
    }

    public void swapList(ArrayList<Pet> a, int index1, int index2) {
        Pet pet1     = a.get(index1);
        Pet pet2     = a.get(index2);
        Pet tempPet  = pet1;
        pet1         = pet2;
        pet2         = tempPet;

    }

    private Point[] privSwapParam(Point x, Point y) {
        Point tempPoint = x;
        x               = y;
        y               = tempPoint;
        Point[] myPArr = {x, y};
        return myPArr;
    }
}
