package com.lyq.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public abstract class AuditEntity extends IdEntity {

    private static final long serialVersionUID = 6633484471370993320L;

    private String createBy;

    private LocalDateTime createTime;

    private String lastUpdateBy;

    private LocalDateTime lastUpdateTime;

}
