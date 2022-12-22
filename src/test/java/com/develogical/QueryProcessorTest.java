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
        assertThat(queryProcessor.process("Which of the following numbers is the largest: 96, 4, 92?"), containsString("96"));
    }

    @Test
    public void removeChars() throws Exception {
        assertThat(queryProcessor.removeChars("Which of the following numbers is the largest: 96, 4, 92?"), is("       : 96, 4, 92"));
    }

}
