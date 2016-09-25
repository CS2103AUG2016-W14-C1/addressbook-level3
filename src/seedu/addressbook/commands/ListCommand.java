package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.List;


/**
 * Lists all persons in the address book to the user.
 */
public class ListCommand extends Command {

    public static final String COMMAND_WORD = "list";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ":\n" 
            + "Displays all persons in the address book as a list with index numbers.\n\t"
    		+ "Specify option [-sort asc] or [-sort desc] to sort the list by name.\n\t"
            + "If no option is specified, the program does not perform sort operation.\n\t"
            + "Example: " + COMMAND_WORD;
    
    public static final String SORT_OPTION_WORD = "-sort";
    
    public static final String SORT_ASC_WORD = "asc";
    
    public static final String SORT_DESC_WORD = "desc";
    
    public enum SortType { ASC, DESC, NONE };
    
    private SortType sortType;

    public ListCommand (SortType sortType) {
    	this.sortType = sortType;
    }
    
    @Override
    public CommandResult execute() {
        List<ReadOnlyPerson> allPersons = addressBook.getAllPersons(sortType).immutableListView();
        return new CommandResult(getMessageForPersonListShownSummary(allPersons), allPersons);
    }
}
