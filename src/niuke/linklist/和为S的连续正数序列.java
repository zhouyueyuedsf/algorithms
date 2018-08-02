package niuke.linklist;

import java.util.ArrayList;

public class 和为S的连续正数序列 {

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        if (sum <= 0) {
            return null;
        }
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        for (int i = sum - sum / 2 - 1 ; i > 0; i--) {
            int temp1 = (i * (i + 1)) / 2;
            if (sum - temp1 >= 0 ){
                int temp2 = (sum - temp1) % (i + 1);
                if (temp2 != 0) {
                    continue;
                } else {
                    temp2 = (sum - temp1) / (i + 1);
                    if (temp2 != 0) {
                        ArrayList<Integer> arrayList = new ArrayList<>();
                        for (int k = 0; k < i + 1; k++) {
                            arrayList.add(temp2 + k);
                        }
                        arrayLists.add(arrayList);
                    }

                }
            }

        }

        return arrayLists;
    }
    public static void main(String[] args) {
        和为S的连续正数序列 run = new 和为S的连续正数序列();
        System.out.println(run.FindContinuousSequence(15));
    }
}
