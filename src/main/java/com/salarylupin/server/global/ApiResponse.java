package com.salarylupin.server.global;

import java.time.OffsetDateTime;

public record ApiResponse<T>(
    boolean success,
    T data,
    OffsetDateTime timestamp
) {

}
