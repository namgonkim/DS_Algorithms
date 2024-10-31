import java.util.*;
class Solution {
    public static List<Integer> q = new ArrayList<>();
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        for(String op : operations) {
            if(op.contains("I ")) {
                String[] data = op.split(" ");
                int num = Integer.parseInt(data[1]);
                if(q.size() == 0) {
                    q.add(num);
                } else {
                    boolean isAdd = false;
                    for(int i=0;i<q.size();i++) {
                        if(num < q.get(i)) {
                            q.add(i, num);
                            isAdd = true;
                            break;
                        }
                    }
                    if(!isAdd) q.add(num);
                }
            } else if(op.contains("D 1")) {
                if(q.size() != 0) q.remove(q.size()-1);
            } else if(op.contains("D -1")) {
                if(q.size() != 0) q.remove(0);
            }
            // for(int log : q) System.out.print(log + " ");
            // System.out.println();
        }
        if(q.size() >= 1) {
            answer[0] = q.get(q.size()-1);
            answer[1] = q.get(0);
        } else {
            answer[0] = 0;
            answer[1] = 0;
        }
        return answer;
    }
}