import com.ah.piece.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by Arlind Hoxha on 8/5/2018.
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
        PawnTest.class,
        RookTest.class,
        BishopTest.class,
        KnightTest.class,
        KingTest.class
})
public class TestSuite {
}
