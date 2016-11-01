package com.nikitab.domain.json.module

import com.fasterxml.jackson.core.Version
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.module.SimpleModule
import com.fasterxml.jackson.databind.module.SimpleSerializers
import com.fasterxml.jackson.databind.Module.SetupContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class SerializerRegistererModuleBean extends SimpleModule {

    private List<JsonSerializer> registeredSerializers

    private SerializerRegistererModuleBean() {
        super("DoctorSpecializationModule", new Version(1, 0, 0, "SNAPSHOT"))
    }

    @Autowired
    public setDoctorSpecificationSerializer(List<JsonSerializer> registeredSerializers) {
        this.registeredSerializers = registeredSerializers
    }

    @Override
    void setupModule(SetupContext context) {
        SimpleSerializers serializers = new SimpleSerializers()
		serializers.addSerializers(registeredSerializers)
        context.addSerializers(serializers)
		super.setupModule(context)
    }
}
