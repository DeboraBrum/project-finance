package com.brum.finance.core.domain.entity;

import java.sql.Timestamp;
import java.util.UUID;

public class Balance {
    private UUID id;
    private UUID personId;
    private Integer month;
    private Double value;
    private Timestamp createdAt;
}
