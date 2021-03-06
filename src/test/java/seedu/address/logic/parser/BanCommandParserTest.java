package seedu.address.logic.parser;

import static org.junit.Assert.assertEquals;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;

import org.junit.Test;

import seedu.address.logic.CommandTest;
import seedu.address.logic.commands.BanCommand;

//@@author jaivigneshvenugopal
/**
 * As we are only doing white-box testing, our test cases do not cover path variations
 * outside of the BanCommand code. For example, inputs "1" and "1 abc" take the
 * same path through the BanCommand, and therefore we test only one of them.
 * The path variation for those two cases occur inside the ParserUtil, and
 * therefore should be covered by the ParserUtilTest.
 */
public class BanCommandParserTest extends CommandTest {
    private BanCommandParser parser = new BanCommandParser();

    @Test
    public void parse_validArgs_returnsBanCommand() throws Exception {
        assertParseSuccess(parser, "1", new BanCommand(INDEX_FIRST_PERSON));
    }

    @Test
    public void parse_noIndex_returnsBanCommand() throws Exception {
        selectFirstPerson();
        assertEquals(new BanCommand(), new BanCommand(INDEX_FIRST_PERSON));
        assertParseSuccess(parser, "", new BanCommand());
    }

    @Test
    public void parse_invalidArgs_throwsParseException() {
        assertParseFailure(parser, "a", String.format(MESSAGE_INVALID_COMMAND_FORMAT, BanCommand.MESSAGE_USAGE));
    }
}
