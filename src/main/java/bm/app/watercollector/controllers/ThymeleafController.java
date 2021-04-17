package bm.app.watercollector.controllers;

import bm.app.watercollector.service.WaterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ThymeleafController {

    private WaterService waterService;

    public ThymeleafController(WaterService waterService) {
        this.waterService = waterService;
    }

    @GetMapping("/landingpage")
    public String getLandingPage() {
        return "landingpage";
    }

    @PostMapping("/calculate")
    public String getTheCalculations(Model model,
                                     @RequestParam String numbers) {
        numbers = waterService.removeSpaces(numbers);
        int[] arrayMadeOutOfInput = waterService.convertInputToIntArray(numbers);
        int calculationResult = waterService.maxWaterForThymeleafController(arrayMadeOutOfInput);
        model.addAttribute("calculationResult", calculationResult);
        return "result";
    }


}
