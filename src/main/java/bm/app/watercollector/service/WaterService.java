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
        int result = 0;
        int left_max = 0, right_max = 0;
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            if (arr[low] < arr[high]) {
                if (arr[low] > left_max)
                    left_max = arr[low];
                else
                    result += left_max - arr[low];
                low++;
            }
            else {
                if (arr[high] > right_max)
                    right_max = arr[high];
                else
                    result += right_max - arr[high];
                high--;
            }
        }
        logger.info("Called water collector counting mechanism for an array of size "
                + arr.length
                + " with the result of "
                + result + ".");
        return result;
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
