package edu.uniupo.coltivazioni.utility;

import edu.uniupo.coltivazioni.exception.NotFoundEntityException;
import edu.uniupo.coltivazioni.service.thrower.ServiceThrower;

import java.util.Optional;

public final class OptionalUnpacker<T extends Optional<R>, R> {

    private final R value;

    private OptionalUnpacker ( T optional ) {
        this.value = optional.orElse( null );
    }

    public static <T extends Optional<R>, R> R unpackerOrThrows ( T optional, String message ) throws NotFoundEntityException {
        ServiceThrower<NotFoundEntityException> serviceThrower = ( notFoundEntityException -> {throw notFoundEntityException;} );
        OptionalUnpacker<T, R> optionalUnpacker = new OptionalUnpacker<>( optional );
        if( optionalUnpacker.value == null ) {
            serviceThrower.thrower( new NotFoundEntityException( optionalUnpacker.getClass().getName(), "unpacker", message ) );
        }
        return optionalUnpacker.value;
    }

    public static <T extends Optional<R>, R> R unpacker ( T optional ) {
        OptionalUnpacker<T, R> optionalUnpacker = new OptionalUnpacker<>( optional );
        return optionalUnpacker.value;
    }
}
