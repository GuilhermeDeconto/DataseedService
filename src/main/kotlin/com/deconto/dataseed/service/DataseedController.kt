package com.deconto.dataseed.service

import com.netflix.discovery.EurekaClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Lazy
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/test")
class DataseedController {

    @Autowired
    @Lazy
    private val eurekaClient: EurekaClient? = null

    @Value("\${spring.application.name}")
    private val appName: String? = null

    @GetMapping
    fun getHealth(): String? {
        return String.format(
                "Hello from '%s'!", eurekaClient?.getApplication(appName)?.name)
    }
}