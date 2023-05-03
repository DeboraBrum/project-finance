package com.brum.finance.core.domain.entity;

import com.brum.finance.core.domain.entity.enums.ExpenseType;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.UUID;

public class Expense {
    // TO DO
    // não fazer a tabela bill por enquanto
    // fazer gastos e receita na mesma tabela
    // incluir categoria
    private UUID id;
    private UUID personId;
    private UUID billID;
    private ExpenseType expenseType;
    private Double value;
    private LocalDate dueDate;
    private Integer month;
    private Boolean isPaid;
    private Timestamp createdAt;
}
