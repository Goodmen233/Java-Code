package maze;

import java.awt.*;
import java.util.Stack;

public class Maze {
    public static void main(String[] args) {
        // 定义一个二维数组作为mazeMap，其中1表示墙，0表示可达，2表示走过，3表示不可达
        int[][] mazeMap = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 1, 0, 0, 0, 1, 0, 1},
            {1, 0, 0, 1, 0, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 0, 1, 1, 0, 0, 1},
            {1, 0, 1, 1, 1, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 1, 0, 0, 0, 0, 1},
            {1, 0, 1, 0, 0, 0, 1, 0, 0, 1},
            {1, 0, 1, 1, 1, 0, 1, 1, 0, 1},
            {1, 1, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        };
        // 定义一个栈来存放走过的路
        Stack<Point> stack = new Stack();
        // 起点和终点
        Point startP = new Point(1,1);
        Point endP = new Point(1, 8);

        runMaze(stack, mazeMap, startP, endP);

        for(int[] i : mazeMap){
            for(int j : i){
                System.out.print(j + " ");
            }
            System.out.println();
        }

    }
    public static void runMaze(Stack<Point> stack, int[][] mazeMap, Point startP, Point endP){
        Point point = startP;
        stack.push(point);
        mazeMap[point.x][point.y] = 2;
        while(true){
            // 如果起点等于终点
            if(mazeMap[point.x][point.y] == mazeMap[endP.x][endP.y]) return;
            // 起点不等于终点，按照右下左上的顺序检索
            if(mazeMap[point.x + 1][point.y] == 0){
                point = new Point(point.x + 1, point.y);
                mazeMap[point.x][point.y] = 2;
                stack.push(point);
            }else if(mazeMap[point.x][point.y + 1] == 0){
                point = new Point(point.x, point.y + 1);
                mazeMap[point.x][point.y] = 2;
                stack.push(point);
            }else if(mazeMap[point.x - 1][point.y] == 0){
                point = new Point(point.x - 1, point.y);
                mazeMap[point.x][point.y] = 2;
                stack.push(point);
            }else if(mazeMap[point.x][point.y - 1] == 0){
                point = new Point(point.x, point.y - 1);
                mazeMap[point.x][point.y] = 2;
                stack.push(point);
            }else{
                // 该点不可达，标记
                mazeMap[point.x][point.y] = 3;
                stack.pop();
                // 再拿栈顶作为新坐标
                point = stack.peek();
            }
        }
    }
}
