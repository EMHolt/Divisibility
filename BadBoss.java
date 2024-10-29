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
    private static Object myObj1;
    private static Object myObj2;

    public static void main(String[] args) {

    }

    public void swapField() {
        Object temp = myObj1;
        myObj1      = myObj2;
        myObj2      = temp;
    }

    public void swapParam(int x, int y) {
        
    }

    public void swapLocal() {
        int x = 1;
        int y = 1;
        privSwapParam(x, y);
    }

    public void swapArray(int a[], int index1, int index2) {
        int i1 = a[index1];
        int i2 = a[index2];
        a[index1] = i2;
        a[index2] = i1;
    }

    // fix this, List needs to be paramaterized
    public void swapList(ArrayList<String> a, int index1, int index2) {
        a.swap(index1, index2);
    }

    private void privSwapParam(int x, int y) {
        int temp = x;
        x = y;
        y = temp;
    }
}
