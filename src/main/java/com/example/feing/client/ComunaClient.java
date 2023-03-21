package com.example.feing.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.model.ComunaModel;

@FeignClient(name = "comunas", url = "${comuna.service.url}")
public interface ComunaClient {
    @GetMapping("/comunas")
    List<ComunaModel> getComunas();
}