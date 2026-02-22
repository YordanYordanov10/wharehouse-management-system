package com.yordanov.warehouse.Web.Dto;

import java.time.LocalDateTime;

public record ErrorResponse(

        int status,
        String message,
        String path,
        LocalDateTime timestamp)
{ }
