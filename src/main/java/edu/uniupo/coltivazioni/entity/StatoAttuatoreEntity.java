package edu.uniupo.coltivazioni.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class StatoAttuatoreEntity implements Serializable {

    @NotNull
    @NonNull
    @Column( name = "MODE" )
    @Enumerated( EnumType.STRING )
    private AttuatoreModeEntity mode;
    @NotNull
    @NonNull
    @Column( name = "STATUS" )
    @Enumerated( EnumType.STRING )
    private AttuatoreStatoEntity stato;
}
