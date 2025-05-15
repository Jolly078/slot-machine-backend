package com.jolly.slotweb;

import com.jolly.slotweb.model.SlotResult;
import com.jolly.slotweb.model.SpinRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*") // Allow requests from frontend
public class SlotController {

    @Autowired
    private SlotService slotService;

    @PostMapping("/spin")
    public SlotResult spinSlot(@RequestBody SpinRequest request) {
        return slotService.spin(request.getBalance(), request.getBet());
    }
}
