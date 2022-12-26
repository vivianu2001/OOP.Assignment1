import observer.*;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {
    public static final Logger logger = LoggerFactory.getLogger(Tests.class);
    // stub method to check external dependencies compatibility
    @Test
    public void test(){
        UndoableStringBuilder s1 = new UndoableStringBuilder();
        UndoableStringBuilder s2 = new UndoableStringBuilder();

        s1.append("I LOVE JAVA");
        s2.append("I LOVE OBSERVER");

        logger.info(()->JvmUtilities.objectFootprint(s1));

        logger.info(()->JvmUtilities.objectFootprint(s1,s2));

        logger.info(()->JvmUtilities.objectTotalSize(s1));

        logger.info(() -> JvmUtilities.jvmInfo());
    }

    @Test
    public void deleteMember()
    {
        Sender groupAdmin=new GroupAdmin();
        Member member1=new ConcreteMember();
        Member member2=new ConcreteMember();
        Member member3=new ConcreteMember();
        Member member4=new ConcreteMember();

        groupAdmin.register(member1);
        groupAdmin.register(member2);
        groupAdmin.register(member3);
        groupAdmin.register(member4);
        groupAdmin.append("Hello");

        assert (JvmUtilities.objectTotalSize(member1.toString()).equals(JvmUtilities.objectTotalSize("Hello")));
        assert (JvmUtilities.objectTotalSize(member2.toString()).equals(JvmUtilities.objectTotalSize("Hello")));
        assert (JvmUtilities.objectTotalSize(member3.toString()).equals(JvmUtilities.objectTotalSize("Hello")));
        assert (JvmUtilities.objectTotalSize(member4.toString()).equals(JvmUtilities.objectTotalSize("Hello")));
        groupAdmin.unregister(member3);
        groupAdmin.append(" after change");
        assert (JvmUtilities.objectTotalSize(member1.toString()).equals(JvmUtilities.objectTotalSize("Hello after change")));
        assert (JvmUtilities.objectTotalSize(member2.toString()).equals(JvmUtilities.objectTotalSize("Hello after change")));
        assert (JvmUtilities.objectTotalSize(member4.toString()).equals(JvmUtilities.objectTotalSize("Hello after change")));

    }

@Test
 public void updateMembers_undo()
{
    Sender groupAdmin=new GroupAdmin();
    Member member1=new ConcreteMember();
    Member member2=new ConcreteMember();
    Member member3=new ConcreteMember();
    Member member4=new ConcreteMember();

    groupAdmin.register(member1);
    groupAdmin.register(member2);
    groupAdmin.register(member3);
    groupAdmin.register(member4);
    groupAdmin.append("The weather is cold today");

    assert (JvmUtilities.objectTotalSize(member1.toString()).equals(JvmUtilities.objectTotalSize("The weather is cold today")));
    assert (JvmUtilities.objectTotalSize(member2.toString()).equals(JvmUtilities.objectTotalSize("The weather is cold today")));
    assert (JvmUtilities.objectTotalSize(member3.toString()).equals(JvmUtilities.objectTotalSize("The weather is cold today")));
    assert (JvmUtilities.objectTotalSize(member4.toString()).equals(JvmUtilities.objectTotalSize("The weather is cold today")));
    groupAdmin.insert(19 ," and rainy");

    assert(JvmUtilities.objectTotalSize(member1.toString()).equals(JvmUtilities.objectTotalSize("The weather is cold and rainy today")));
    assert(JvmUtilities.objectTotalSize(member2.toString()).equals(JvmUtilities.objectTotalSize("The weather is cold and rainy today")));
    assert(JvmUtilities.objectTotalSize(member3.toString()).equals(JvmUtilities.objectTotalSize("The weather is cold and rainy today")));
    assert(JvmUtilities.objectTotalSize(member4.toString()).equals(JvmUtilities.objectTotalSize("The weather is cold and rainy today")));

    groupAdmin.undo();
    assert(JvmUtilities.objectTotalSize(member1.toString()).equals(JvmUtilities.objectTotalSize("The weather is cold today")));
    assert(JvmUtilities.objectTotalSize(member2.toString()).equals(JvmUtilities.objectTotalSize("The weather is cold today")));
    assert(JvmUtilities.objectTotalSize(member3.toString()).equals(JvmUtilities.objectTotalSize("The weather is cold today")));
    assert(JvmUtilities.objectTotalSize(member4.toString()).equals(JvmUtilities.objectTotalSize("The weather is cold today")));



}
@Test
    public void test3()
    {
        Sender groupAdmin=new GroupAdmin();
        Member member1=new ConcreteMember();
        Member member2=new ConcreteMember();
        Member member3=new ConcreteMember();
        Member member4=new ConcreteMember();

        groupAdmin.append("Happy Hanukkah our members");

        groupAdmin.register(member1);
        groupAdmin.register(member2);
        groupAdmin.register(member3);
        groupAdmin.register(member4);
        assert (JvmUtilities.objectTotalSize(member1.toString()).equals(JvmUtilities.objectTotalSize("Happy Hanukkah our members")));
        assert (JvmUtilities.objectTotalSize(member2.toString()).equals(JvmUtilities.objectTotalSize("Happy Hanukkah our members")));
        assert (JvmUtilities.objectTotalSize(member3.toString()).equals(JvmUtilities.objectTotalSize("Happy Hanukkah our members")));
        assert (JvmUtilities.objectTotalSize(member4.toString()).equals(JvmUtilities.objectTotalSize("Happy Hanukkah our members")));
        groupAdmin.delete(14,26);

        assert (JvmUtilities.objectTotalSize(member1.toString()).equals(JvmUtilities.objectTotalSize("Happy Hanukkah")));
        assert (JvmUtilities.objectTotalSize(member2.toString()).equals(JvmUtilities.objectTotalSize("Happy Hanukkah")));
        assert (JvmUtilities.objectTotalSize(member3.toString()).equals(JvmUtilities.objectTotalSize("Happy Hanukkah")));
        assert (JvmUtilities.objectTotalSize(member4.toString()).equals(JvmUtilities.objectTotalSize("Happy Hanukkah")));

        Member member5=new ConcreteMember();
        groupAdmin.register(member5);
        assert (JvmUtilities.objectTotalSize(member5.toString()).equals(JvmUtilities.objectTotalSize("Happy Hanukkah")));











    }






}
