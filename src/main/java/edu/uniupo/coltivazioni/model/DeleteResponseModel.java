package edu.uniupo.coltivazioni.model;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class DeleteResponseModel {
    @NotNull( message = "Start time field can't be empty or null" )

    private String message;
    @NotNull( message = "Start time field can't be empty or null" )

    private Boolean status;
}
