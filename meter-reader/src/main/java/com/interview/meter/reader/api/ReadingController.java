package com.interview.meter.reader.api;

import com.interview.meter.reader.dto.ClientDto;
import com.interview.meter.reader.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/readings")
@RequiredArgsConstructor
public class ReadingController {

    private final ClientService clientService;

    @GetMapping(value = "/ping/{firstname}")
    public String ping(@PathVariable("firstname") String firstname) {
        ClientDto clientDto = clientService.test(firstname);
        return clientDto.toString();
    }
}
