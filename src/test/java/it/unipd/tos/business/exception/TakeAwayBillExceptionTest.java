package it.unipd.tos.business.exception;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TakeAwayBillExceptionTest {

    @Test
    public void getMessageTest() {
        TakeAwayBillException example = new TakeAwayBillException("error");
        assertEquals("error", example.getMessage());
    }
} 