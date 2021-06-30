package com.avansas.UserManagementProject.converter;

import com.avansas.UserManagementProject.model.enums.UserRole;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class UserRoleEnumColumnConverter implements AttributeConverter<UserRole, String> {
    @Override
    public String convertToDatabaseColumn(UserRole userRole) {
        if (userRole == null) {
            return null;
        }

        return userRole.name();
    }

    @Override
    public UserRole convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }

        return Stream.of(UserRole.values())
                .filter(t -> t.name().equals(dbData))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
