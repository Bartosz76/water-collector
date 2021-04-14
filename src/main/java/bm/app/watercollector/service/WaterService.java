package bm.app.watercollector.service;

import org.springframework.stereotype.Service;

@Service
public class WaterService {

    public int maxWater(int[] arr) {
        int res = 0;
        for(int i = 1; i < arr.length - 1; i++) {
            int left = arr[i];
            for(int j = 0; j < i; j++) {
                left = Math.max(left, arr[j]);
            }
            int right = arr[i];
            for(int j = i + 1; j < arr.length; j++) {
                right = Math.max(right, arr[j]);
            }
            res += Math.min(left, right) - arr[i];
        }
        return res;
    }
}
