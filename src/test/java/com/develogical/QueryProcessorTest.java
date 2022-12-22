package com.develogical;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class QueryProcessorTest {

    QueryProcessor queryProcessor = new QueryProcessor();

    @Test
    public void returnsEmptyStringIfCannotProcessQuery() throws Exception {
        assertThat(queryProcessor.process("test"), is(""));
    }

    @Test
    public void knowsAboutShakespeare() throws Exception {
        assertThat(queryProcessor.process("Shakespeare"), containsString("playwright"));
    }

    @Test
    public void knowsAboutWhatMyNameIs() throws Exception {
        assertThat(queryProcessor.process("What is your name?"), containsString("Rory"));
    }

    @Test
    public void plus() throws Exception {
        assertThat(queryProcessor.process("What is 13 plus 28?"), containsString("41"));
    }

    @Test
    public void largest() throws Exception {
        assertThat(queryProcessor.process("Which of the following numbers is the largest: 96, 4, 92?"), is("96"));
    }

    @Test
    public void removeChars() throws Exception {
        assertThat(queryProcessor.removeChars("Which of the following numbers is the largest: 96, 4, 92?"), is("       : 96, 4, 92"));
    }

    @Test
    public void squareAndCube() throws Exception {
        assertThat(queryProcessor.process("Which of the following numbers is both a square and a cube: 961, 289, 1461, 2313, 2744, 835, 4096?"), containsString("4096"));
    }

    @Test
    public void multiplied() throws Exception {
        assertThat(queryProcessor.process("What is 1 multiplied by 94?"), containsString("94"));
    }

}
