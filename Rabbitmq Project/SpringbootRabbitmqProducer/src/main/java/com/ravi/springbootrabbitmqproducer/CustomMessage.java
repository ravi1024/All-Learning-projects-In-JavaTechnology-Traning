package com.ravi.springbootrabbitmqproducer;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomMessage {

    private String messageId;
    private String message;
    private Date messageDate;

}
