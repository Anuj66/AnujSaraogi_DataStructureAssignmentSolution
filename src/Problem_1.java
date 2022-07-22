import java.util.Scanner;
import java.util.Stack;

public class Problem_1 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("enter the total no of floors in the building : ");
    int noOfFloors = sc.nextInt();

    int[] floorSizes = new int[noOfFloors];
    for(int i=0;i<noOfFloors;i++) {
      System.out.println("enter the floor size given on day : " + (i+1));
      floorSizes[i] = sc.nextInt();
    }

    System.out.println("\nOrder of construction is as follows : \n");

    int largestFloor = noOfFloors;
    Stack<Integer> floors = new Stack<>();
    for(int i=0;i<noOfFloors;i++) {
      floors.push(floorSizes[i]);
      System.out.println("Day : " + (i+1));
      while(!floors.empty()) {
        if(floors.peek() != largestFloor) {
          break;
        }
        System.out.print(floors.pop() + " ");
        largestFloor--;
      }
      System.out.println("");
    }
  }
}
