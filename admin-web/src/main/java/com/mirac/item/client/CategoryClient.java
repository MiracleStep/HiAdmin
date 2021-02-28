package com.mirac.item.client;

import com.mirac.item.api.CategoryApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("admin-service")
public interface CategoryClient extends CategoryApi {
}
