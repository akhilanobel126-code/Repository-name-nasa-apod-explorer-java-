package com.example.apod.controller;

import com.example.apod.dto.ApodDto;
import com.example.apod.service.ApodService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@RestController
@RequestMapping("/api/apod")
public class ApodController {

    private final ApodService service;
    private final int MAX_RANGE_DAYS = 30;

    public ApodController(ApodService service) {
        this.service = service;
    }

    @GetMapping("/today")
    public ResponseEntity<ApodDto> today() {
        return ResponseEntity.ok(service.getToday());
    }

    @GetMapping("/date")
    public ResponseEntity<ApodDto> byDate(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return ResponseEntity.ok(service.getByDate(date.toString()));
    }

    @GetMapping("/range")
    public ResponseEntity<List<ApodDto>> range(
            @RequestParam("start_date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
            @RequestParam("end_date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end) {

        if (start.isAfter(end)) return ResponseEntity.badRequest().build();
        long days = ChronoUnit.DAYS.between(start, end) + 1;
        if (days > MAX_RANGE_DAYS) return ResponseEntity.badRequest().build();

        return ResponseEntity.ok(service.getRange(start.toString(), end.toString()));
    }

    @GetMapping("/_health")
    public ResponseEntity<String> health() { return ResponseEntity.ok("ok"); }
}
