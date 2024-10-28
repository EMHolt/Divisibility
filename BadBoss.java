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

import java.util.Collections;
import java.util.List;

public class BadBoss {
    private int myInt1;
    private int myInt2;

    public static void main(String[] args) {

    }

    public void swapField() {
        int temp = myInt1;
        myInt1   = myInt2;
        myInt2   = temp;
    }

    public void swapLocal() {
        int x;
        int y;
        
        // check if this is right
        swapParam(x, y);
    }

    public void swapArray(int a[], int index1, int index2) {
        int i1 = a[index1];
        int i2 = a[index2];
        a[index1] = i2;
        a[index2] = i1;
    }

    // fix this, List needs to be paramaterized
    public void swapList(List a, int index1, int index2) {
        a.swap(index1, index2);
    }

    // this might not supposed to be private
    private void swapParam(int x, int y) {
        int temp = x;
        x        = y;
        y        = temp;
    }
}
