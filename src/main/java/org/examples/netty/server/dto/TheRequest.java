package org.examples.netty.server.dto;

/**
 * Created by Denis Sitenkov on 14/01/17.
 */
public class TheRequest {
    public int[] some_data;

    public TheRequest() {
    }

    public TheRequest(int[] some_data) {
        this.some_data = some_data;
    }
}
