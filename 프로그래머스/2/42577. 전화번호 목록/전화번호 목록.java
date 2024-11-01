import java.util.*;

class Solution {
    public static Set<String> set = new HashSet<>();
    public boolean solution(String[] phone_book) {
        // 모든 폰번호를 해시에 넣어둔다 
        for(String phone : phone_book) {
            set.add(phone);
        }
        // 모든 폰번호에서 
        for(int i=0;i<phone_book.length;i++) {
            String phone = phone_book[i];
            for(int j=0;j<phone.length(); j++) {
                // 폰 번호의 substring이 해시셋에 담겨있는지 확인 
                if(set.contains(phone.substring(0,j))) {
                    return false;
                }
            }
        }
        return true;
    }
}