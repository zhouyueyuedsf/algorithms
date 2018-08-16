package company.bytedance.two;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static class Point{
        int x;
        int y;
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        Point[] points = new Point[num];

        for (int i = 0; i < num; i++) {
            Point point = new Point();
            point.x = scanner.nextInt();
            point.y = scanner.nextInt();
            points[i] = point;
            scanner.nextLine();
        }

        Arrays.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.x - o2.x;
            }
        });

        int max = -1;
        int maxIndex = -1;
        for (int i = 0; i < num - 1; i++) {
            Point point = points[i];
            boolean flag = false;
            if (point.y < max && i < maxIndex) {
                continue;
            }
            if (i < maxIndex) {
                System.out.println(point.x + " " + point.y);
                continue;
            }
            max = point.y;
            maxIndex = i + 1;
            for (int j = i + 1; j < num; j++) {
                Point readyPoint = points[j];
                if (readyPoint.y > point.y) {
                    flag = true;
                    max = Math.max(max, readyPoint.y);
                    maxIndex = j;
                    break;
                }
            }
            if (!flag) {
                System.out.println(point.x + " " + point.y);
            }
        }
        if (num > 0)
        System.out.println(points[num - 1].x + " " +points[num - 1].y);
    }

}
