package com.assignment.com.registration.assignment.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * This class represents generic response for all requests
 *
 * @author Vaishnavi Bagal
 * @version 1.0
 */
@Builder
@Data
public class Response {
    private Object data;
    private List<String> errorMessage;
    private List<String> message;
}
