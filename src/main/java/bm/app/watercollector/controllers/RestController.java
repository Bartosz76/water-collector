package bm.app.watercollector.controllers;

import bm.app.watercollector.exception.ArrayTooSmallException;
import bm.app.watercollector.service.WaterService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api/v1")
public class RestController {

    private WaterService waterService;

    public RestController(WaterService waterService) {
        this.waterService = waterService;
    }

    @GetMapping("/water/fillcount")
    @ApiOperation(value = "Store the rain water.", notes = "API containing the algorithm for counting how much rain water can be stored in a provided array.")
    public int getNumberOfFieldsWaterFills(@RequestParam int[] val) throws ArrayTooSmallException {
        return waterService.maxWaterForRestApi(val);
    }
}
