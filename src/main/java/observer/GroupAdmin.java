package observer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class GroupAdmin implements Sender {

    private UndoableStringBuilder undoableStringBuilder= new UndoableStringBuilder();
    List<Member> registeredMembers= new ArrayList<>();

    /***
     * register for list of members and update this member with the last change before
     his registration.
      * @param obj Given Member object
     *
     */
    @Override
    public void register(Member obj) {
        registeredMembers.add(obj);
        obj.update(undoableStringBuilder);

    }

    /***
     * remove the given obj from the list of members
     * @param obj
     */
    @Override
    public void unregister(Member obj) {
      registeredMembers.remove(obj);
    }


    @Override
    public void insert(int offset, String obj) {

        undoableStringBuilder.insert(offset,obj);
        updateAllMembers();


    }

    @Override
    public void append(String obj) {
        undoableStringBuilder.append(obj);
        updateAllMembers();

    }

    @Override
    public void delete(int start, int end) {
        undoableStringBuilder.delete(start,end);
        updateAllMembers();

    }

    @Override
    public void undo() {
       undoableStringBuilder.undo();
       updateAllMembers();

    }

    public String toString()
    {
         return undoableStringBuilder.toString();
    }

    /***
     * for every change preforms in the group admin update all the members for changes in the
     Undoable Stringbuilder
     */

    private void updateAllMembers()
    {
        for (int i=0; i<registeredMembers.size();i++)
        {
            registeredMembers.get(i).update(undoableStringBuilder);
        }
    }

}
