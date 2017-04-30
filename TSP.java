/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kyle
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;

public class TSP {
    ArrayList<Integer> cost = new ArrayList<>();
    private int numberOfNodes;
    private Stack<Integer> pathStack;

    public TSP() {
        pathStack = new Stack<Integer>();
    }

    public void tsp(int adjacencyMatrix[][]) {
        cost.clear();
        numberOfNodes = adjacencyMatrix[0].length;
        int[] visitedCities = new int[numberOfNodes];
        visitedCities[0] = 1;
        pathStack.push(0);
        int closestCity = 0;
        boolean minFlag = false;
        System.out.print(0 + " ");
        cost.add(closestCity);
        while (!pathStack.isEmpty()) {
            int currentCity = pathStack.peek();//wasdklghsdhf
            int min = Integer.MAX_VALUE;
            for(int i = 1; i < numberOfNodes; i++){
                if (adjacencyMatrix[currentCity][i] > 0 && visitedCities[i] == 0) {
                    if (adjacencyMatrix[currentCity][i] < min) {
                        min = adjacencyMatrix[currentCity][i];
                        closestCity = i;
                        minFlag = true;
                    }
                }
            }
            if (minFlag) {
                visitedCities[closestCity] = 1;
                pathStack.push(closestCity);
                System.out.print(closestCity + " ");
                cost.add(closestCity);
                minFlag = false;
                continue;
            }
            pathStack.pop();
        }
        System.out.println("Total Cost: " + computeCost(cost, adjacencyMatrix));
        System.out.println();
        System.out.println();
    }

    public static void main(String... arg) throws FileNotFoundException {
        TSP t = new TSP();
        Scanner in12 = new Scanner(new File("tsp12.txt"));
        int[][] adjacency12 = new int[12][12];
        System.out.println("The 12 cities are visited as follows");
        t.populateMatrix(adjacency12, in12, 12);
        t.tsp(adjacency12);
        
        Scanner in13 = new Scanner(new File("tsp13.txt"));
        int[][] adjacency13 = new int[13][13];
        System.out.println("The 13 cities are visited as follows");
        t.populateMatrix(adjacency13, in13, 13);
        t.tsp(adjacency13);
        
        Scanner in14 = new Scanner(new File("tsp14.txt"));
        int[][] adjacency14 = new int[14][14];
        System.out.println("The 14 cities are visited as follows");
        t.populateMatrix(adjacency14, in14, 14);
        t.tsp(adjacency14);
        
        Scanner in15 = new Scanner(new File("tsp15.txt"));
        int[][] adjacency15 = new int[15][15];
        System.out.println("The 15 cities are visited as follows");
        t.populateMatrix(adjacency15, in15, 15);
        t.tsp(adjacency15);
        
        Scanner in16 = new Scanner(new File("tsp16.txt"));
        int[][] adjacency16 = new int[16][16];
        System.out.println("The 16 cities are visited as follows");
        t.populateMatrix(adjacency16, in16, 16);
        t.tsp(adjacency16);
        
        Scanner in19 = new Scanner(new File("tsp19.txt"));
        int[][] adjacency19 = new int[19][19];
        System.out.println("The 19 cities are visited as follows");
        t.populateMatrix(adjacency19, in19, 19);
        t.tsp(adjacency19);
        
        Scanner in29 = new Scanner(new File("tsp29.txt"));
        int[][] adjacency29 = new int[29][29];
        System.out.println("The 29 cities are visited as follows");
        t.populateMatrix(adjacency29, in29, 29);
        t.tsp(adjacency29); 
    }
    
    public void populateMatrix(int[][] adjacency, Scanner input, int CITI) {

        int value, i, j;
        for (i = 0; i < CITI && input.hasNext(); i++) { //CITI is a constant  
            for (j = i; j < CITI && input.hasNext(); j++) {
                if (i == j) {
                    adjacency[i][j] = 0;
                } else {
                    value = input.nextInt();
                    adjacency[i][j] = value;
                    adjacency[j][i] = value;
                }
            }
        }
    }

    public int computeCost(ArrayList<Integer> tour, int[][] adjacency) {
        int totalcost = 0;
            for(int i = 0; i < tour.size() - 1; i++){
                totalcost += adjacency[tour.get(i)][tour.get(i+1)];
            }
        return totalcost;
    }
}
