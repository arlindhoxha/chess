import com.ah.piece.BishopTest;
import com.ah.piece.KnightTest;
import com.ah.piece.PawnTest;
import com.ah.piece.RookTest;
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
        KnightTest.class
})
public class TestSuite {
}
