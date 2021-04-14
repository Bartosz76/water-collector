package bm.app.watercollector.controllers;

import bm.app.watercollector.service.WaterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public int getNumberOfFieldsWaterFills(@RequestParam int[] val) {
        return waterService.maxWater(val);
    }
}
