package com.nikitab.domain.json.module

import com.fasterxml.jackson.core.Version
import com.fasterxml.jackson.databind.module.SimpleModule
import com.fasterxml.jackson.databind.Module.SetupContext
import com.fasterxml.jackson.databind.module.SimpleSerializers
import com.nikitab.domain.enums.DoctorSpecialization
import com.nikitab.domain.json.serializer.DoctorSpecializationSerializer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component


@Component
class DoctorSpecializationModule extends SimpleModule {

    DoctorSpecializationSerializer doctorSpecificationSerializer

    private DoctorSpecializationModule() {
        super("DoctorSpecializationModule", new Version(1, 0, 0, "SNAPSHOT"))
    }

    @Autowired
    public setDoctorSpecificationSerializer(DoctorSpecializationSerializer doctorSpecificationSerializer) {
        this.doctorSpecificationSerializer = doctorSpecificationSerializer
    }

    @Override
    void setupModule(SetupContext context) {
        SimpleSerializers serializers = new SimpleSerializers()
        serializers.addSerializer(DoctorSpecialization.class, doctorSpecificationSerializer)
        context.addSerializers(serializers)
    }
}
