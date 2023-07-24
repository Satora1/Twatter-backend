package com.group3.twat.model.post;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Twatt {
    private Long id;
    private Long userId;
    private String text;
    private LocalDate date;
}
