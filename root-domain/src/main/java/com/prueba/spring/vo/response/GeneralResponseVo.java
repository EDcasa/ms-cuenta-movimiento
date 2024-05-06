package com.prueba.spring.vo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 *
 * @autor ecasa on 2024/05/02.
 * @version 1.0.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeneralResponseVo {
    private String message;
    private Object data;
    private String status;
}
