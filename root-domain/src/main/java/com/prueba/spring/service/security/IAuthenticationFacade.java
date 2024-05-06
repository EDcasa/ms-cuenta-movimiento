package com.prueba.spring.service.security;

/**
 * IAuthenticationFacade.
 *
 * @author ecasa on 2024/05/02.
 * @version 1.0.0
 */
public interface IAuthenticationFacade {

    /**
     * getAuthenticatedUser.
     *
     * @return
     */
    String getAuthenticatedUser();

    /**
     * getCurrentApplication.
     *
     * @return
     */
    String getCurrentApplication();

    /**
     * getAuthenticatedNombreCompleto.
     *
     * @return
     */
    String getAuthenticatedNombreCompleto();

    /**
     * getCurrentSessionToken.
     *
     * @return
     */
    String getCurrentSessionToken();
}
