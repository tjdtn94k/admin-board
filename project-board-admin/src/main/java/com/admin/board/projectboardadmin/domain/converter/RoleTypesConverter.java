package com.admin.board.projectboardadmin.domain.converter;

import com.admin.board.projectboardadmin.domain.constant.RoleType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *  클래스는 JPA에서 사용되는 변환기(Converter)이며, Set<RoleType> 객체와 String 값 간의 변환을 수행합니다.
 *
 * 필드:
 *
 * private static final String DELIMITER = ",";: 변환 과정에서 구분자로 사용할 문자열을 정의합니다. (쉼표 ",")
 * 메소드:
 *
 * convertToDatabaseColumn(Set<RoleType> attribute):
 * 매개변수: attribute: Set<RoleType> 객체입니다.
 * 리턴값: 변환된 String 값입니다.
 * 설명:
 * attribute 객체를 스트림으로 변환합니다.
 * 스트림의 각 요소인 RoleType 객체를 name() 메소드를 사용하여 이름 문자열로 변환합니다.
 * 변환된 이름 문자열들을 정렬합니다. (오름차순)
 * 정렬된 이름 문자열들을 DELIMITER (",")로 구분하여 하나의 문자열로 연결합니다.
 * 연결된 문자열을 반환합니다.
 * convertToEntityAttribute(String dbData):
 * 매개변수: dbData: 데이터베이스에서 읽어온 문자열입니다.
 * 리턴값: 변환된 Set<RoleType> 객체입니다.
 * 설명:
 * dbData 문자열을 DELIMITER (",") 기준으로 분리합니다.
 * 분리된 각 문자열을 RoleType.valueOf(String) 메소드를 사용하여 RoleType 객체로 변환합니다.
 * 변환된 RoleType 객체들을 Set<RoleType> 객체로 변환하여 반환합니다.
 */
@Converter
public class RoleTypesConverter implements AttributeConverter<Set<RoleType>,String> {

    private static final String DELIMITER = ",";
    @Override
    public String convertToDatabaseColumn(Set<RoleType> attribute) {
        return attribute.stream().map(RoleType::name).sorted().collect(Collectors.joining(DELIMITER));
    }

    @Override
    public Set<RoleType> convertToEntityAttribute(String dbData) {
        return Arrays.stream(dbData.split(DELIMITER)).map(RoleType::valueOf).collect(Collectors.toSet());
    }
}
