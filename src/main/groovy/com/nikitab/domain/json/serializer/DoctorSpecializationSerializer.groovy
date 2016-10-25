package com.nikitab.domain.json.serializer

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.ser.std.StdSerializer
import com.nikitab.domain.enums.DoctorSpecialization
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.MessageSource
import org.springframework.stereotype.Component

@Component
class DoctorSpecializationSerializer extends StdSerializer<DoctorSpecialization> {

    MessageSource messageSource

    public DoctorSpecializationSerializer() {
        this(DoctorSpecialization.class)
    }

    public DoctorSpecializationSerializer(Class<DoctorSpecialization> t) {
        super(t)
    }

    @Autowired
    public setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource
    }

    @Override
    void serialize(DoctorSpecialization value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject(value)
        gen.writeStringField("title", messageSource.getMessage(value.title, null, Locale.ENGLISH))
        gen.writeStringField("description", messageSource.getMessage(value.description, null, Locale.ENGLISH))
        gen.writeEndObject()
    }
}
