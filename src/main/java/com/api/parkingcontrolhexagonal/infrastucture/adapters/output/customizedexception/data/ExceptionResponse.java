package com.api.parkingcontrolhexagonal.infrastucture.adapters.output.customizedexception.data;


import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponse {

    private LocalDateTime date;

    private String message;

    private List<String> details;
}
