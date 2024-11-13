package study.querydsl.dto;

import lombok.Data;

@Data
public class MemberSearchCondition {
    private String username;
    private String teamName;
    private Integer ageLoe;
    private Integer ageGoe;

}
