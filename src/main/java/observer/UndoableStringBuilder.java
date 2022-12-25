import java.util.EmptyStackException;
import java.util.Stack;



public class UndoableStringBuilder  {
    private StringBuilder stringBuilder;
    private Stack<String> undoValues;

    public UndoableStringBuilder()
{
    stringBuilder =new StringBuilder();
    undoValues= new Stack<String>();
}

    /***
     *
     * @return to string for stringBuilder
     */
    public String toString()
{

    return stringBuilder.toString();
}

    /***
     * Appends the specified string to this character sequence also saving the string before
     * the action.
     * @param str given string
     * @return String builder added str
     */
   public UndoableStringBuilder append(String str)
{
    undoValues.push(stringBuilder.toString());
    stringBuilder.append(str);
    return this;
}

    /***
     * Removes the characters in a substring of this sequence. The substring begins at the specified start and extends to the character at index
     * end - 1 or to the end of the sequence if no such character exists.
     * If start is equal to end, no changes are made.
     *
     * @param start the start index of deletion
     * @param end the end index of deletion
     * @return the string  after deletion
     * save the string before the deletion for the undo.
     */
    public UndoableStringBuilder delete(int start, int end)
    {
        undoValues.push(stringBuilder.toString());
        try {
            stringBuilder.delete(start, end);
            return this;
        }
        catch (StringIndexOutOfBoundsException e)
        {
            System.out.println("Index out of bounds has happend");
            undoValues.pop();
            return this;
        }

    }

    /***
     * Inserts the string into this character sequence
     * @param offset the char in index offset replaced by str
     * @param str the char in index offset replaced by str
     *   saving current string in undoValues ,before the action.
     * @return  Inserts the string into this character sequence
     */
    public UndoableStringBuilder insert(int offset, String str)
    {
        undoValues.push(stringBuilder.toString());
        try {
            stringBuilder.insert(offset,str);
            return this;
        }
        catch (StringIndexOutOfBoundsException e)
        {
            System.out.println("Index out of bounds has happend");
            undoValues.pop();
            return this ;
        }

    }

    /***
     *Replaces the characters in a substring of this sequence with characters in the specified String. The substring begins at the specified start and extends to the character at index end - 1 or to the end of the sequence if no such character exists. First the characters in the substring are removed and then the specified String is inserted at start
     (This sequence will be lengthened to accommodate the specified String if necessary).
     * @param start replace from index start
     * @param end replace to index end
     * @param str replace by str
     * @return Replaces the characters in a substring of this sequence with characters in the specified String.
     */
    public UndoableStringBuilder replace(int start, int end, String str) {
        undoValues.push(stringBuilder.toString());
        try {
            stringBuilder.replace(start, end, str);
            return this;
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Index out of bounds has happend");
            undoValues.pop();
            return this;
        }

    }
    /***
     * Causes this character
      sequence to be replaced by the reverse of the sequence.
     * saving current string in undoValues ,before the action
     * @return  sequence replaced by the reverse of the sequence
     */
    public UndoableStringBuilder reverse ()
{
    undoValues.push(stringBuilder.toString());
    stringBuilder.reverse();
    return this;
}

    /***
     * delete the last action on our string
     * when no undo occurs do nothing
     */
    public  void  undo()
{
    try
    {
        String undoValue= undoValues.pop();
        stringBuilder= new StringBuilder(undoValue);

    }
    catch (EmptyStackException e)
    {

    }

}



}
