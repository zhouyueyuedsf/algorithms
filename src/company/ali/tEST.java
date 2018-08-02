package company.ali;

import java.util.Scanner;


class zyPoint {
    int mX;
    int mY;
    boolean visited;

    public zyPoint(int mX, int mY) {
        this.mX = mX;
        this.mY = mY;
        this.visited = false;
    }

    public int getLen(zyPoint p) {
        return Math.abs(mX - p.mX) + Math.abs(mY - p.mY);
    }
}

class Yueyue {
    private static final zyPoint BEGIN = new zyPoint(0, 0);
    private static int minPath = Integer.MAX_VALUE;

    private static int helper(zyPoint start, zyPoint[] zyPoints, int sum, int count) {

        if (count == zyPoints.length) {
            minPath = Math.min(minPath, sum + start.getLen(BEGIN));
            return minPath;
        }
        for (zyPoint zyPoint : zyPoints) {
            if (!zyPoint.visited) {
                sum += zyPoint.getLen(start);
                if (sum < minPath) {
                    zyPoint.visited = true;
                    helper(zyPoint, zyPoints, sum, count + 1);
                }
                sum -= zyPoint.getLen(start);
                zyPoint.visited = false;
            }
        }
        return minPath;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String inStr = input.nextLine();
        if (inStr.equals("")) {
            System.out.println(0);
            return;
        }
        int pnum = Integer.parseInt(inStr.trim());
        /**构建点集*/
        zyPoint[] zyPoints = new zyPoint[pnum];
        for (int i = 0; i < pnum; i++) {
            String[] locations = input.nextLine().trim().split(",");
            zyPoints[i] = new zyPoint(Integer.parseInt(locations[0]), Integer.parseInt(locations[1]));
        }
        int min = helper(BEGIN, zyPoints, 0, 0);
        System.out.println(min);
    }
}