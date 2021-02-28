package com.mirac.item.client;

import com.mirac.item.api.ImagesApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("admin-service")
public interface ImagesClient extends ImagesApi {
}
