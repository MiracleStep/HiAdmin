package com.mirac.item.client;

import com.mirac.item.api.NewsApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("admin-service")
public interface NewsCLient extends NewsApi {
}
