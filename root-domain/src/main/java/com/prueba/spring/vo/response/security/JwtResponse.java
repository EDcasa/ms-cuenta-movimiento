package com.prueba.spring.vo.response.security;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

/**
 * JwtResponse.
 *
 * @author ecasa on 2024/05/02.
 * @version 1.0.0
 */
@Getter
@AllArgsConstructor
public class JwtResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	private final String token;
}
