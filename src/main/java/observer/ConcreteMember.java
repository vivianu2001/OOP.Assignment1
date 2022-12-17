package observer;

public class ConcreteMember  implements Member{
    private UndoableStringBuilder undoableStringBuilder =new UndoableStringBuilder();


    /***
     * update the given usb by delete and append the newest one
     (to avoid shallow copy)
     * @param usb
     */
    @Override

    public void update(UndoableStringBuilder usb) {

        this.undoableStringBuilder.delete(0,undoableStringBuilder.toString().length());
        this.undoableStringBuilder.append(usb.toString());
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
