package greedy;

import java.util.ArrayList;

public class PoliceCatchesThieves {
    public static void main(String[] args) {
        char[] arr = {'P', 'T', 'P', 'T', 'T', 'P'};
        int k = 2;
        System.out.println(getMaxCaught2(arr, k));
    }

    private static int getMaxCaught2(char[] arr, int k) {
        ArrayList<Character> police = new ArrayList<>();
        ArrayList<Character> thief = new ArrayList<>();

        for (char c : arr) {
            if (c == 'P')
                police.add(c);
            else
                thief.add(c);
        }
        int tI = 0;
        int pI = 0;
        int caught = 0;
        while(pI < police.size() && tI < thief.size()){
            if(Math.abs(police.get(pI) - thief.get(tI)) > k){
                pI++;
                tI++;
                caught++;
            }
            else if(thief.get(tI) < police.get(pI))
                tI++;
            else
                pI++;
        }
        return caught;
    }

    private static int getMaxCaught(char[] arr, int k) {
        int currP = 0;
        int currT = 0;
        int caught = 0;

        while (currP < arr.length) {
            if (arr[currP] != 'P') {
                currP++;
                continue;
            }
            currT = Math.max(currT, currP - k);
            int maxPoint = Math.min(currP + k, arr.length);
            while (arr[currT] != 'T' && currT < maxPoint)
                currT++;
            if (currT != maxPoint) {
                arr[currT] = 'C';
                caught++;
            }
            currP++;
        }

        return caught;
    }
}
