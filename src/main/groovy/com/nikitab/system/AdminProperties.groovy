package com.nikitab.system

import groovy.transform.Canonical
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@ConfigurationProperties(prefix = "admin")
@Canonical
@Component
class AdminProperties {

	String name = "admin"

	String password = "admin"

	String email = "admin@admin.com"

}
