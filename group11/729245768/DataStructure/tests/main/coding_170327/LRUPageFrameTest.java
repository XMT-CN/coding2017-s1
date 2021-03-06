package main.coding_170327;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by peter on 2017/4/19.
 */
public class LRUPageFrameTest extends TestCase {
    @Test
    public void testAccess() throws Exception {
        LRUPageFrame frame = new LRUPageFrame(3);
        frame.access(7);
        frame.access(0);
        frame.access(1);
        Assert.assertEquals("[1, 0, 7]", frame.toString());
        frame.access(2);
        Assert.assertEquals("[2, 1, 0]", frame.toString());
        frame.access(0);
        Assert.assertEquals("[0, 2, 1]", frame.toString());
        frame.access(0);
        Assert.assertEquals("[0, 2, 1]", frame.toString());
        frame.access(3);
        Assert.assertEquals("[3, 0, 2]", frame.toString());
        frame.access(0);
        Assert.assertEquals("[0, 3, 2]", frame.toString());
        frame.access(4);
        Assert.assertEquals("[4, 0, 3]", frame.toString());
        frame.access(5);
        Assert.assertEquals("[5, 4, 0]", frame.toString());
    }


}