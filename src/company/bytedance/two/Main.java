package company.bytedance.two;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

public class Main {
    public static class Point {
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

        Map<Point, Integer> map = new TreeMap<>(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o2.y - o1.y;
            }
        });

        for (int i = 0; i < num; i++) {
            map.put(points[i], i);
        }


        int index = -1;
        for (Map.Entry entry : map.entrySet()) {
            if ((int) entry.getValue() > index) {
                Point point = (Point) entry.getKey();
                System.out.println(point.x + " " + point.y);
                index = (int) entry.getValue();
            }
        }

//        int max = -1;
//        int maxIndex = -1;
//        for (int i = 0; i < num - 1; i++) {
//            for (int j = i; j < num; j++) {
//                Point readyPoint = points[j];
//                if (readyPoint.y > max) {
//                    max = readyPoint.y;
//                    maxIndex = j;
//                }
//            }
//            if (maxIndex != num - 1) {
//                max = -1;
//                System.out.println(points[maxIndex].x + " " + points[maxIndex].y);
//            }
//            i = maxIndex;
//
//        }
//        if (num > 0)
//        System.out.println(points[num - 1].x + " " +points[num - 1].y);
    }

}
