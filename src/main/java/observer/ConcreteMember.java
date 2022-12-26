package observer;

public class ConcreteMember  implements Member{
    private UndoableStringBuilder undoableStringBuilder =new UndoableStringBuilder();


    /***
     * shallow copy of undoablestringbuilder from the group admin
     * @param usb the stringBuilder of Group admin
     */
    @Override

    public void update(UndoableStringBuilder usb) {

        this.undoableStringBuilder=usb;

    }

    /***
     * For the test we need to get the toString of ConcreteMember,
     because we don't want to change the interface of Member
     we need to override the toString() method of undoableStringBuilder.
     * @return string
     */
    @Override
    public String toString() {
        return undoableStringBuilder.toString();
    }
}
