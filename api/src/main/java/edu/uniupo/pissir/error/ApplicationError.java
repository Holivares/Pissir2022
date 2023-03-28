package edu.uniupo.pissir.error;

import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
public class ApplicationError {
    private ApplicationStatusError status;
    private Collection<String> messages;

    public ApplicationError ( ApplicationStatusError status, Collection<String> messages ) {
        this.status = status;
        this.messages = messages;
    }

}
