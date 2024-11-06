/**
 * Author: Jack Pender, Emma Holt
 * Class:  APCSA
 * Date:   Nov 2024
 * Description: Has multiple swap methods intending to
 * match what a client desires and prints out the results
 * of each method.
 */

package BadBoss;

import java.util.ArrayList;

public class BadBoss {
    private static Tree myTree1;
    private static Tree myTree2;

    public static void main(String[] args) {
        myTree1 = new Tree(1, 1);
        myTree2 = new Tree(2, 2);
        System.out.println("swapField()\nBefore:\n" + myTree1 + "\n" + myTree2);
        swapField();
        System.out.println("After:\n" + myTree1 + "\n" + myTree2);

        short x = 5;
        short y = 10;
        System.out.println("swapParam()\nBefore:\n" + x + "\n" + y);
        short[] paramRes = swapParam(x, y);
        x = paramRes[0];
        y = paramRes[1];
        System.out.println("After:\n" + x + "\n" + y);

        System.out.println("swapLocal()\nBefore:\nQuantity: 1 Price: 1.0\nQuantity: 2 Price: 2.0");
        Point[] pArr = swapLocal();
        System.out.println("After:\n" + pArr[0] + "\n" + pArr[1]);

        int[] numbers = {1, 2};
        System.out.println("swapArray()\nBefore:\n" + numbers[0] + " " + numbers[1]);
        swapArray(numbers, 0, 1);
        System.out.println("After:\n" + numbers[0] + " " + numbers[1]);

        ArrayList<Pet> pets = new ArrayList<>();
        pets.add(new Pet(1, 1));
        pets.add(new Pet(2, 2));
        System.out.println("swapList()\nBefore:\n" + pets.get(0) + "\n" + pets.get(1));
        swapList(pets, 0, 1);
        System.out.println("After:\n" + pets.get(0) + "\n" + pets.get(1));
    }

    public static void swapField() {
        Tree tempTree = myTree1;
        myTree1 = myTree2;
        myTree2 = tempTree;
    }

    public static short[] swapParam(short x, short y) {
        short temp = x;
        x = y;
        y = temp;
        return new short[] {x, y};
    }

    public static Point[] swapLocal() {
        Point x = new Point(1, 1.0);
        Point y = new Point(2, 2.0);
        return privSwapParam(x, y);
    }

    public static void swapArray(int[] a, int index1, int index2) {
        int temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }

    public static void swapList(ArrayList<Pet> a, int index1, int index2) {
        Pet tempPet = a.get(index1);
        a.set(index1, a.get(index2));
        a.set(index2, tempPet);
    }

    private static Point[] privSwapParam(Point x, Point y) {
        int xQuant = x.getPQuantity();
        int yQuant = y.getPQuantity();
        y.setPQuantity(xQuant);
        x.setPQuantity(yQuant);

        double xPrice = x.getPPrice();
        double yPrice = y.getPPrice();
        y.setPPrice(xPrice);
        x.setPPrice(yPrice);

        return new Point[] {x, y};
    }
}
