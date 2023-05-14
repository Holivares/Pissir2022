package edu.uniupo.pissir.utilitiesTest;

import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class CaptorOfResult implements Answer<Object> {

    private Object result = null;

    public Object getResult () {
        return result;
    }

    @Override
    public Object answer ( InvocationOnMock invocation ) throws Throwable {
        if( invocation.callRealMethod().getClass().isInstance( result ) ) {
            result = result.getClass().cast( invocation.callRealMethod() );
        }
        return result;
    }
}
