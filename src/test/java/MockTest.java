import Sign.MockDemoOne;
import Sign.MockDemoOneImpl;
import org.junit.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.Mock;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.*;

public class MockTest {
    @Test
    public void test1() {
        MockDemoOne one = mock(MockDemoOne.class);
        when(one.getString("sxc")).thenReturn("test1");
        when(one.getString("dsf")).thenReturn("test2");
        System.out.println(one.getString("sxc"));
        System.out.println(one.getString("dsf"));
        System.out.println(one.getString("sd"));
    }

    @Test
    public void test2() {
        MockDemoOne one = mock(MockDemoOneImpl.class);

        doReturn("sxc").when(one).getString("sxc");
        doReturn("dsf").when(one).getString("dsf");

        System.out.println(one.getString("sxc"));
        System.out.println(one.getString("dsf"));
        System.out.println(one.getString("df"));
    }

    @Test
    public void test3() {
        MockDemoOne one = new MockDemoOneImpl();
        when(one.getString("sxc")).thenReturn("sxc");
        doReturn("def").when(one).getString("def");
        System.out.println(one.getString("sxc"));
        System.out.println(one.getString("def"));
        System.out.println(one.getString("dsc"));
    }

    @Test
    public void test4 () {
        MockDemoOne one = new MockDemoOneImpl();
        System.out.println(one.getString("sd"));
        MockDemoOne spy = spy(one);
        System.out.println(spy.getString("sd"));
        when(spy.getString("sd")).thenReturn("ds");
        System.out.println(spy.getString("sd"));
        System.out.println(one.getString("sd"));
    }

    @Test
    // 验证某些行为
    public void test5( ){
        MockDemoOne one = mock(MockDemoOne.class);
        System.out.println(one.getString("sd"));
        System.out.println(one.getString("ds"));
        verify(one).getString("sd");
        verify(one, times(1)).getString("sd");
    }
    @Test
    // 参数匹配
    public void test6 () {
        MockDemoOne one = mock(MockDemoOne.class);
        when(one.getString(anyString())).thenReturn("ok");
        when(one.getString(argThat(new ArgumentMatcher<String>() {
            @Override
            public boolean matches(String s) {
                return false;
            }
        })));
        when(one.getString(argThat((str) -> {return false;})));
    }

    @Test
    public void test7() {
        MockDemoOne one = mock(MockDemoOne.class);
        when(one.getString("sz")).thenAnswer(x -> {return x.callRealMethod();});
        System.out.println(one.getString("sz"));
    }
}
