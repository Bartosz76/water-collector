package bm.app.watercollector.service;

import bm.app.watercollector.exception.ArrayTooSmallException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class WaterService {

    private static final Logger logger = LoggerFactory.getLogger(WaterService.class);

    public int maxWaterForRestApi(int[] arr) throws ArrayTooSmallException {
        if (arr.length < 2) {
            throw new ArrayTooSmallException("Container requires at least two walls!");
        }
        return maxWater(arr);
    }

    /**
     * The same method for Thymeleaf, without the exception.
     */

    public int maxWaterForThymeleafController(int[] arr) {
        return maxWater(arr);
    }

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
        logger.info("Called water collector counting mechanism for an array of size "
                + arr.length
                + " with the result of "
                + res + ".");
        return res;
    }

    /**
     * Below are support methods for Thymeleaf Controller.
     */

    public
    String removeSpaces(String input) {
        input = input.replaceAll("\\s", "");
        return input;
    }

    public int[] convertInputToIntArray(String input) {
        int[] arrayMadeOutOfInput= Arrays.stream(input.trim().split(",")).mapToInt(Integer::parseInt).toArray();
        return arrayMadeOutOfInput;
    }
}
