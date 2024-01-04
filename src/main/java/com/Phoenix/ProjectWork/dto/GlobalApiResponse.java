package com.Phoenix.ProjectWork.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GlobalApiResponse {
    private boolean status;
    private String message;
    private String messageNp;
    private Object data;
}
