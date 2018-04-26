package Sign;

public class MockDemoOneImpl implements MockDemoOne{
    @Override
    public String getString(String x) {
        return x + x + x + x;
    }
}
