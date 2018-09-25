package company.bytedance.five;

import java.util.LinkedList;
import java.util.Scanner;

public class Main3 {
    public static String getPath(String url) {
        if (url == null || url.length() == 0) {
            return "/";
        }
        String[] subUrls = url.split("/");
        LinkedList<String> urlList = new LinkedList<>();
        for (String subUrl : subUrls) {
            if (subUrl.length() == 0 || ".".equals(subUrl)) {
                continue;
            }
            if ("..".equals(subUrl)) {
                urlList.pollLast();
                continue;
            }
            urlList.addLast(subUrl);
        }
        String res = "";
        while (urlList.size() > 0) {
            res = res + "/" + urlList.pollFirst();
        }
        return res.length() > 0 ? res : "/";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String url = scanner.next();
        System.out.println(getPath(url));
    }
}