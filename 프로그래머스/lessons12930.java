class Solution {
    public String solution(String s) {
        String answer = new String();
        String[] list = s.split(" ", -1);
        for (int j = 0; j < list.length; j++) {
            String item = list[j];
            for (int i = 0; i < item.length(); i++) {
                if (i % 2 == 0) {
                    answer += Character.toUpperCase(item.charAt(i));
                } else {
                    answer += Character.toLowerCase(item.charAt(i));
                }
            }
            if (j != list.length - 1)
                answer += " ";
        }
        return answer;
    }
}