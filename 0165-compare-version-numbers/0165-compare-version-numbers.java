class Solution {
    public int compareVersion(String version1, String version2) {
        // 1.2
        // 1.10 -> .을 기준으로 비교한다. 
        // 1.01 - 1.001 1==1 / 01==001 
        // 1.0 - 1.0.0.0 1==1 / 0==0 / 0==0
        // 1.0.1 - 1.0.0.0 1==1/0==0/1>0/
        // '.' 기준으로 배열을 만든 뒤 두 버전 배열의 인덱스 포인터를 넘겨가며 비교한다. 
        int idx1 = 0, idx2 = 0;
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        while(idx1 < v1.length || idx2 < v2.length) {
            // If one of the version strings has fewer revisions, treat the missing revision values as 0
            // 버전이 없는 위치인 경우 0으로 대체 
            int v1num = (idx1 < v1.length) ? Integer.parseInt(v1[idx1]) : 0;
            int v2num = (idx2 < v2.length) ? Integer.parseInt(v2[idx2]) : 0;

            if(v1num < v2num) return -1;
            else if(v1num > v2num) return 1;

            idx1+=1;
            idx2+=1;
        }
        return 0;
    }
}